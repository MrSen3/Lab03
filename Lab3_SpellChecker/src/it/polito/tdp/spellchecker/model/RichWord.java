package it.polito.tdp.spellchecker.model;

public class RichWord {
	
	private String word;
	private boolean corretta=false;
	
	public RichWord(String word, boolean corretta) {
		this.word=word;
		this.corretta=corretta;
	}

	public RichWord(String word) {
		// TODO Auto-generated constructor stub
		this.word=word;
		this.corretta=false;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public boolean isCorretta() {
		return corretta;
	}

	public void setCorretta(boolean corretta) {
		this.corretta = corretta;
	}

	@Override
	public String toString() {
		return "word:" + word + ", corretta:" + corretta;
}
	
	
	

}
