package Main;

import java.io.*;

public class FileWorker {
	private static void appendUsingOutputStream(String fileName, String data) {
        OutputStream os = null;
        try {
            os = new FileOutputStream(new File(fileName), true);
            os.write(data.getBytes(), 0, data.length());
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
	
	public static void write(String text) {
	    try {	    	
	        if (!Global.file.exists())
	        	Global.file.createNewFile();
	        appendUsingOutputStream(Global.fileName, text+"\n");
	    } catch(IOException e) {
	        throw new RuntimeException(e);
	    }
	}
}
