package ru.progwards.java1.lessons.io1;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Coder {
	public static void codeFile(String inFileName, String outFileName, char[] code, String logName){
		
		String content = "";
		
		FileInputStream fis = null;
		try {
            fis = new FileInputStream(inFileName);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            int character;
 
            while ((character = isr.read()) != -1) {
                char c = (char)character;
                c = code[(int)c];
                content += c;
            }
            isr.close();
 
        	writeFile(outFileName, content);
        } catch (Exception e) {
        	try {
				writeFile(logName, e.getMessage());
			} catch (IOException e1) {}
        }finally{
			try {
				fis.close();
			} catch (Exception e) {}
		}
	}
	
	private static void writeFile(String fileName, String content) throws IOException{
		
		FileOutputStream fos = null;
		
		try {
            fos = new FileOutputStream(fileName);
            OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
            BufferedWriter bufferedWriter = new BufferedWriter(osw);
            bufferedWriter.write(content);
            bufferedWriter.close();
        }finally
		{
        	try {
				fos.close();
			} catch (Exception e) {}
		}
	}
}
