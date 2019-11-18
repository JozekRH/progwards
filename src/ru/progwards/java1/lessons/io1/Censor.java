package ru.progwards.java1.lessons.io1;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Censor {
	
	public static void censorFile(String inFileName, String outFileName, String[] obscene) throws CensorException{

		String content = "";
		FileInputStream fis = null;
		String curFile = inFileName;
		
		try {

			fis = new FileInputStream(inFileName);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            int character;
 
            while ((character = isr.read()) != -1) {
                content += (char)character;
            }
            isr.close();
 
        	content = cense(content, obscene);
            
            curFile = outFileName;
            
        	writeFile(outFileName, content);

		} catch (Exception e) {
			
			CensorException ce = new CensorException(e.getMessage());
			ce.setFileName(curFile);
			throw ce;
			
        }finally{
			try {
				fis.close();
			} catch (Exception e) {}
		}
	}
	
	private static String cense(String content, String[] obscene){
		
		String newContent = "";
		
			String[] words = content.split(" ");
			for (int i = 0; i < words.length; i++){
				for (String s : obscene){
					if (words[i].toLowerCase().equals(s)){
						String ss = "";
						for (int n = 0; n < words[i].length(); n++){
							ss += "*";
						}
						words[i] = ss;
					}
				}
			}
			newContent = join(" ", words);
		
		return newContent;
	}
	
	private static String join(String separator, String[] sa)
	{
		String result = "";
		for (int i = 0; i < sa.length; i++)
		{
			result += sa[i];
			if (i < (sa.length - 1)) result += separator;
		}
		
		return result;
	}

	private static void writeFile(String fileName, String content) throws Exception{
		
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
	
	public static class CensorException extends Exception{
	    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private String fileName = "";

		public CensorException(String message){
	       super(message);
	    }
		
		public void setFileName(String fileName){
			this.fileName = fileName;
		}

		@Override
		public String toString(){
			return this.fileName + ":" + getMessage(); 
		}
	}	
}
