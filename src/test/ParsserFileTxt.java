package test;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import javax.print.attribute.HashAttributeSet;

/**
 * This program demonstrates how to read characters from a text file.
 * 
 * @author www.codejava.net
 *
 */
public class ParsserFileTxt {

	public static void main(String[] args) {

		HashMap<Integer, String> map = new HashMap<Integer, String>();
		Set<String> cartes = new HashSet<>();
		Set<String> j1 = new HashSet<>();
		try {

			Scanner fScn = new Scanner(
					new File("src/all_absolute+.txt"));
			String data = "";
			FileWriter myWriter = new FileWriter("carteNumber.txt");
			myWriter.write("@CONVERTED_FROM_TEXT" + "\n");
			
			while (fScn.hasNextLine()) {
				data = fScn.nextLine();
				
				String[] token = data.split(" ");
				String carte = token[1];
				cartes.add(carte.substring(1));

			}
		
			Iterator<String> it = cartes.iterator();
			int i = 1;
			
			while (it.hasNext() && i < cartes.size()) {
				String c = it.next();
				if (c.equals("egin")) {
					
				} else {
					myWriter.write("@item=" +i+ "=" + c + "\n");
					i++;
				}

			}

			myWriter.close();
			fScn.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
