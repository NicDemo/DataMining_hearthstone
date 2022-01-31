package test;

import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import java.util.List;

public class ItemSets {

	public static void main(String[] args) throws FileNotFoundException {

		
		
		
		
		HashMap<String, String> map = new HashMap<String, String>();
		Set<Set<String>> cartes = new HashSet<>();

		
		Set<String> j1 = new HashSet<>();
		Set<String> j2 = new HashSet<>();
		try {
			
			Scanner fScn = new Scanner(
					new File("src/all_absolute+.txt"));
			Scanner carteNumber = new Scanner(
					new File("src/filename.txt"));

			FileWriter myWriter = new FileWriter("fileLCM_players.txt");
			List<Integer> card_p1 = new ArrayList<>();
			List<Integer> card_p2 = new ArrayList<>();
			String data = "";
			String dataNumber = "";

			while (carteNumber.hasNextLine()) {
				dataNumber = carteNumber.nextLine();
				String[] tokenC = dataNumber.split(" ");
				String carte = tokenC[1];
				map.put(carte, tokenC[0]);
			}
			int heroicpower = -1;
			if(args.length>0) {
				heroicpower = Integer.parseInt(map.get(args[0]));
			}
			
			int i=0;
			String beginner = new String();
			String Second = new String();
			while (fScn.hasNextLine()) { // parcourir les data

				data = fScn.nextLine(); // on recupère chaque ligne
				
				String[] tokenData = data.split(" ");
				String carte = tokenData[1];
				int indice = Integer.parseInt(tokenData[0]);
				char joueur1 = carte.charAt(0);
				
				if (indice !=i) {
					
					if(args.length>0) {
						
						if(card_p1.contains(heroicpower)) {
						
							card_p1.remove("443");
							}
						if(card_p2.contains((heroicpower))) {
						card_p2.remove("443");
							}
					}
					
					Collections.sort(card_p1);
					Collections.sort(card_p2);
					
					for(int x =0;x<card_p1.size();x++) {
						if(card_p1.get(x)!=heroicpower || args.length==0)
						beginner += card_p1.get(x)+" ";
					}
					
					
					for(int y =0;y<card_p2.size();y++) {
						if(card_p2.get(y)!=heroicpower || args.length==0)
						Second += card_p2.get(y)+" ";
					}
					
					if(args.length==0){
						myWriter.write(beginner+"\n");
						myWriter.write(Second+"\n");}
					else if (args.length==1){
						
						if(card_p1.contains(heroicpower)) {
							
							myWriter.write(beginner+"\n");
							myWriter.flush();
							
						}
						if(card_p2.contains(heroicpower)) {
							myWriter.write(Second+"\n");
							myWriter.flush();
						}
						}
					//réinitialisation
					beginner = new String();
					Second = new String ();
					card_p1 = new ArrayList<>();
					card_p2 = new ArrayList<>();
					i++;
					
				}
				else {
					if (joueur1 == 'M') {

						String cJ1 = carte.substring(1);

						if (map.containsKey(cJ1)) {

							j1.add(map.get(cJ1));

							String result = map.get(cJ1);
							if(!card_p1.contains(Integer.parseInt(result))) {
								card_p1.add(Integer.parseInt(result));
							}
						}

					} else if (joueur1 == 'O') {

						String cJ2 = carte.substring(1);

						if (map.containsKey(cJ2)) {

							j2.add(map.get(cJ2));

							String result2 = (String)map.get(cJ2);
							if(!card_p2.contains(Integer.parseInt(result2)) ){
							card_p2.add(Integer.parseInt(result2));
							
							}
						}

					}
				}
			}
			
			carteNumber.close();
			fScn.close();

		}catch(

	IOException e)
	{
		e.printStackTrace();
	}
}}