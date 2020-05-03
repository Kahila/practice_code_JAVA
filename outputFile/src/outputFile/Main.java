package outputFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
    	//writing content to the binary files
        FileOutputStream output = null;
        try {
        	output = new FileOutputStream(new File("bin.dat"));
        	for(int i = 0; i < 10; i++) {
        		output.write(i);
        	}
        }catch (IOException ex) {
        	ex.printStackTrace();
        }finally {
        	if (output != null) {
        		try {
        			output.close();        			
        		}catch(IOException ex) {
        			ex.printStackTrace();
        		}
        	}
        }
        
        //reading the content that was written to the binary files
        FileInputStream input = null;
        try {
        	input = new FileInputStream(new File("bin.dat"));
        	int value = -1;//-1 means that there are no more bytes to be read
        	while ((value = input.read()) != -1) {
        		System.out.println(value);
        	}
        }catch (IOException ex) {
        	ex.printStackTrace();
        }finally {
        	if (input != null) {
        		try {
        			input.close();        			
        		}catch (IOException ex) {
        			ex.printStackTrace();
        		}
        	}
        }
    }
}