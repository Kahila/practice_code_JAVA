package outputFile;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
    	DataOutputStream dataOut = null;
    	
    	try {
    		//Create file output stream in order to implement filtering in the primitive types
    		FileOutputStream fos = new FileOutputStream("binary.dat");
    		
    		//buffered files are more efficient then reading directly from disc memory
    		BufferedOutputStream bufOut = new BufferedOutputStream(fos);
 
    		dataOut = new DataOutputStream(bufOut);
    		
    		//writ the primitive types
    		dataOut.writeUTF("who do u love");//write type String 
    		dataOut.writeDouble(1212.23);//write type Double
    		dataOut.writeInt(10000);
    	}catch(IOException ex) {
    		ex.printStackTrace();
    	}finally {
    		if (dataOut != null) {
    			try {
    				dataOut.close();    				
    			}catch (IOException ex) {
    				ex.printStackTrace();
    			}
    		}
    	}
    	
    	///data input
    	DataInputStream dataIn = null;
    	
    	try {
    		FileInputStream fin = new FileInputStream("binary.dat");
    		BufferedInputStream bin = new BufferedInputStream(fin);
    		dataIn = new DataInputStream(bin);
    		
    		String content = dataIn.readUTF();//read into a string 
    		Double value = dataIn.readDouble();//read into a Double
    		int value2 = dataIn.readInt();//read typed in
    		
    		System.out.printf("UTF Content : %s\nDouble Countent : %f\nInteger Content : %d\n", content, value, value2);
    	}catch(IOException ex) {
    		ex.printStackTrace();
    	}finally {
    		if (dataIn != null) {
    			try {
    				dataIn.close();
    			}catch(IOException ex) {
    				ex.printStackTrace();
    			}
    		}
    	}
    }
}