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
	 * Controlla parola per parola se è corretta o meno e l'aggiunge alla lista delle parole controllate
	 * @param testo lista parole in input
	 * @return lista richword da controllare con valori true o false
	 */
	public List<RichWord> spellCheck(List<String> testo){
		List<RichWord> dizionarioRich = new ArrayList<RichWord>();
		for(String s: testo) {
			//Aggiunge a dizionariorich una nuova richword composta da s e dall'esito della ricerca della parola all'interno del dizionario
			dizionarioRich.add(new RichWord(s, dizionario.contains(s)));
		}
		//A questo punto restituisce una lista di richword, da cui possiamo capire quali parole sono state scritte nel  testo e di queste quali nel modo corretto e quali no.
		return dizionarioRich;
	} 
	
	public List<RichWord> spellCheckLineare(List<String> testo){
		
		List<RichWord> dizionarioRich = new ArrayList<RichWord>();
		boolean corretta=false;
		
		for(String s: testo) {
			corretta=false;
			//scorro il dizionario a partire dalla prima parola
			for(String d: dizionario) {
				//equalsIgnoreCase confronta le due stringhe senza tener conto del maiuscolo/minuscolo
				if(d.equalsIgnoreCase(s)) {
					corretta=true;
					break;
				}
			}
			
				dizionarioRich.add(new RichWord(s, corretta));
		
		}
		
		return dizionarioRich;
	}
	
	public List<RichWord> spellCheckDicotomico(List<String> testo){
		List<RichWord> dizionarioRich = new ArrayList<RichWord>();
		//List<RichWord> dizionarioRich = new LinkedList<RichWord>();
		int grandezzaDizionario=dizionario.size();
				
		for(String s: testo) {
			//Questa richword viene creata con corretta=false, ma se poi viene trovata all-interno del dizionario bastera' settare con setCorretta=true
			RichWord newWord = new RichWord(s);
			int inizio=0;
			int fine=grandezzaDizionario;
		
				while(inizio!=fine) {
					int meta=inizio+(fine-inizio)/2;
					System.out.println("Inizio: "+inizio+" Metà: "+meta+" Fine: "+fine+"\n");
			
					if(newWord.getWord().compareToIgnoreCase(dizionario.get(meta))<0) {//significa che la parola e' nella prima meta' allora meta diventa la fine
						fine=meta;
					}
				
					if(newWord.getWord().compareToIgnoreCase(dizionario.get(meta))>0) {//significa che la parola e' nella seconda meta' allora meta diventa l'inizio
						inizio=meta+1;
					}
				
					else{//significa che la parola e' stata trovata
						newWord.setCorretta(true);
					}					
				}
			
		dizionarioRich.add(newWord);
		
		}
		//A questo punto restituisce una lista di richword, da cui possiamo capire quali parole sono state scritte nel  testo e di queste quali nel modo corretto e quali no.
		return dizionarioRich;
	}
	
	public void removeDictionary() {
		this.dizionario.clear();
	}

}
