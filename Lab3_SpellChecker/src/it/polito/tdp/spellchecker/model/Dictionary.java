package it.polito.tdp.spellchecker.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Dictionary {

	private List<String> dizionario;
	private String language;
	
	public Dictionary() {

}
	public boolean loadDictionary(String language) {
		
	try {

		FileReader fr = new FileReader("rsc/" + language + ".txt");
		BufferedReader br = new BufferedReader(fr);
		String word;

		while ((word = br.readLine()) != null) {
			dizionario.add(word.toLowerCase());
		}

		//Collections.sort(dizionario);

		br.close();
		System.out.println("Dizionario " + language + " loaded. Found " + dizionario.size() + " words.");
		
		return true;

	} catch (IOException e) {
		System.err.println("Errore nella lettura del file");
		return false;
}
	
}
}
