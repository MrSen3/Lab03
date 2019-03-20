package it.polito.tdp.spellchecker.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Dictionary {

	private List<String> dizionario;
	private String language;
	
	public Dictionary() {
		this.dizionario=new ArrayList<String>();
}
	

	public void loadDictionary(String language) {
		
	try {

		FileReader fr = new FileReader("rsc/" + language + ".txt");
		BufferedReader br = new BufferedReader(fr);
		String word;

		while ((word = br.readLine()) != null) {
			dizionario.add(word.toLowerCase().trim());
		}

		Collections.sort(dizionario);

		br.close();
		System.out.println("Dizionario " + language + " loaded. Found " + dizionario.size() + " words.");
		

	} catch (IOException e) {
		System.err.println("Errore nella lettura del file");
		
}
	
}
	/**
	 * Controlla parola per parola se � corretta o meno e l'aggiunge alla lista delle parole controllate
	 * @param testo lista parole in input
	 * @return lista parole controllate con valori true o false
	 */
	public List<RichWord> spellCheck(List<String> testo){
		List<RichWord> dizionarioRich = new ArrayList();
		for(String s: testo) {
			dizionarioRich.add(new RichWord(s, dizionario.contains(s)));
		}
		//A questo punto restituisce una lista di richword, da cui possiamo capire quali parole sono state scritte nel  testo e di queste quali nel modo corretto e quali no.
		return dizionarioRich;
	} 
	
	public void removeDictionary() {
		this.dizionario.clear();
	}
}
