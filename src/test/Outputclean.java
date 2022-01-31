package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Outputclean {

	public static void main(String[] args) throws IOException {
		Scanner clean = new Scanner(
				new File("output.txt"));
		String ligne = "";
		String ok = "";
		FileWriter rez = new FileWriter("output_cleaned.txt");
		while (clean.hasNextLine()) {
			ligne= clean.nextLine();
			String[] tokenC = ligne.split(" ");
			if(tokenC.length>3) {
				ligne+="\n";
				rez.write(ligne);
				rez.flush();
			}
			
		}

		
		
	}

}
