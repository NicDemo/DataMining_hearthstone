package test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class CartesList {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<String, String>();

		try {

			Scanner fScn = new Scanner(new File("src/filename.txt"));
			String data = "";

			while (fScn.hasNextLine()) {
				data = fScn.nextLine();

				String[] token = data.split(" ");
				String carte = token[1];
				map.put(carte, token[0]);
				
		}

			// Afficher le contenu du MAP
			Set listKeys = map.keySet(); // Obtenir la liste des clés
			Iterator iterateur = listKeys.iterator();
			// Parcourir les clés et afficher les entrées de chaque clé;
			while (iterateur.hasNext()) {
				Object key = iterateur.next();
				//System.out.println(key + "=>" + map.get(key));
			}
			
			// Afficher une entrée spécifique
			// System.out.println(^map.get("Lundi"));

			fScn.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
