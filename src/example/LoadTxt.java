package example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.carrot2.core.Document;

public class LoadTxt {
	static int i = 1;
	public static String readToString(String fileName) {
		String encoding = "UTF8";
		File file = new File(fileName);
		Long filelength = file.length();
		byte[] filecontent = new byte[filelength.intValue()];
		try {
			FileInputStream in = new FileInputStream(file);
			in.read(filecontent);
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			return new String(filecontent, encoding);
		} catch (UnsupportedEncodingException e) {
			System.err.println("The OS does not support " + encoding);
			e.printStackTrace();
			return null;
		}
	}
	public static void load(String filePath, ArrayList<Document> documents){
		File root = new File(filePath);
		for(File file: root.listFiles()){
			if(file.isDirectory()){
				for(File txt: file.listFiles()){
//					txt.renameTo(new File(file.getAbsolutePath()+"\\"+i++ +".txt"));
					documents.add(new Document(txt.getName(), readToString(txt.getAbsolutePath())));
				}
			}
		}
			
	}
	public static void main(String[] args){
		final ArrayList<Document> documents = new ArrayList<Document>();
		load("corpus2", documents);
		System.out.println(documents.size());
		System.out.println(documents.get(0).getTitle());
	}
}
