package chapterOne;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * This class is thread safe.
 */
public class test {
	
	private File file;

	public synchronized void setFile(File f) {
		file = f;
	}

	public synchronized File getFile() {
		return file;
	}

	//changed the way of get content of file in the string 
	
	// OR we can use Array of char in get content of file
	public String getContent() throws IOException {
		FileInputStream i = new FileInputStream(file);
		String output = "";
		//int data;
		while ((i.read()) >= 0) {
			output += i.toString();
		}
		i.close();
		return output;
	}

	
	public String getContentWithoutUnicode() throws IOException {
		FileInputStream i = new FileInputStream(file);
		String output = "";
		int data;
		while ((data = i.read()) > 0) {
			if (data < 0x80) {
				output += (char) data;
			}
		}
		i.close();
		return output;
	}

	// in save content i+=1 changed to i++ for simplest 
	public void saveContent(String content) throws IOException {
		FileOutputStream o = new FileOutputStream(file);
		for (int i = 0; i < content.length(); i ++) {
			o.write(content.charAt(i));
		}
		o.close();
	}

}
