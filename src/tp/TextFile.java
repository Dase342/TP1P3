package tp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TextFile{

	private String[] file;
	
	public TextFile(String path){
		try {
			  String filestring = new Scanner(new File(path)).useDelimiter("\\A").next();
			  file = filestring.split( "\\r\\n" );
			  
		} catch (IOException e) {
			System.out.println( "Introuvable : " + path );
		}
	}
	
	public TextFile(String [] text) {
		this.file = text;
	}
	
	public void save(String path) {
		try {
			String text = "";
			for(String line: file) {
				text+=line;
				text+="\r\n";
			}
			PrintWriter out = new PrintWriter(path);
			
			out.println(text);
			out.close();
		} catch ( FileNotFoundException e ) {
			System.out.println( "TextFile save Error" );
		}
	}
	
	public String[] getText() {
		return file;
	}
	
	

	

}
