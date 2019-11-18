package ru.progwards.java1.lessons.io1;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

public class LineCount {

	public static int calc(String fileName){
	
		InputStream is = null;
	    try {
	    	is = new BufferedInputStream(new FileInputStream(fileName));
	        byte[] c = new byte[1024];

	        int readChars = is.read(c);
	        if (readChars == -1) {
	            // bail out if nothing to read
	            return 0;
	        }

	        // make it easy for the optimizer to tune this loop
	        int count = 0;
	        while (readChars == 1024) {
	            for (int i=0; i<1024;) {
	                if (c[i++] == '\n') {
	                    ++count;
	                }
	            }
	            readChars = is.read(c);
	        }

	        // count remaining characters
	        while (readChars != -1) {
	            System.out.println(readChars);
	            for (int i=0; i<readChars; ++i) {
	                if (c[i] == '\n') {
	                    ++count;
	                }
	            }
	            readChars = is.read(c);
	        }

	        return count == 0 ? 1 : count + 1;
	    } catch (Exception e){
	    	return - 1;
	    } finally {
	        try {
				is.close();
			} catch (Exception e) {}
	    }
	}
}
