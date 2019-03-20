	package it.polito.tdp.spellchecker.controller;

	import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
	import it.polito.tdp.spellchecker.model.*;
	import javafx.event.ActionEvent;
	import javafx.fxml.FXML;
	import javafx.scene.control.Button;
	import javafx.scene.control.ComboBox;
	import javafx.scene.control.Label;
	import javafx.scene.control.TextArea;
	import javafx.scene.control.TextField;

	public class SpellCheckerController {
		
		private Dictionary model;
		
	    @FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;

	    @FXML
	    private ComboBox<String> comboBoxLanguage;
	    
	    @FXML
	    private TextField txtToSpell;

	    @FXML
	    private Button btnSpellCheck;

	    @FXML
	    private TextArea txtWrongWords;

	    @FXML
	    private Label labelErrors;

	    @FXML
	    private Button btnClearText;

	    @FXML
	    private Label labelTimeCheck;

	    @FXML
	    void doClearText(ActionEvent event) {
	    	txtToSpell.clear();
	    	txtWrongWords.clear();
	    	model.removeDictionary();
	    }

	    @FXML
	    void doSpellCheck(ActionEvent event) {
	    	long start = System.nanoTime();
	    	int errori = 0;
	    	
	    	//Primo passo=carico il dizionario scelto
	    	model.loadDictionary(comboBoxLanguage.getValue());
	    	
	    	//Ripulisco la stringa scritta nel textfield e la splitto
	    	String[] parole = txtToSpell.getText().trim().toLowerCase().replaceAll("[.,\\/#!$%\\^&\\*;:{}=\\-_'~()\\[\\]\"]", "").split(" ");
	    	
	    	//CREO UNA LISTA  DI PAROLE/STRING
	    	List<String> listaParole = new ArrayList();
	    	for(String s: parole) {
	    		listaParole.add(s);
	    	}
	    	//LA PASSO AL MODEL LA CICLO E CREO UNA LISTA DI RICHWORD  CON PAROLA-RISULTATO DEL CONTAINS
	    	List <RichWord> listaRichWord=model.spellCheck(listaParole);
	    	List <String> paroleErrate = new ArrayList();
	    	//Dopodichè stampi in wrongwords le parole false
	    	for(RichWord r: listaRichWord) {
	    		if(!r.isCorretta()) {
	    			paroleErrate.add(r.getWord());
	    			errori++;
	    		}
	    	}
	    	txtWrongWords.appendText("Le parole errate sono: \n" +paroleErrate.toString());
	    	
	    	//VALUTAZIONE DEI TEMPI
	    	long time = (System.nanoTime()-start)/1000000000;
	    	labelTimeCheck.setText("Spell check completed in " +time+" seconds");
	    	labelErrors.setText("The text contains " +errori+ " errors");
	    	
	    }

	    @FXML
	    void initialize() {
	        assert comboBoxLanguage != null : "fx:id=\"comboBoxLanguage\" was not injected: check your FXML file 'SpellChecker.fxml'.";
	        assert txtToSpell != null : "fx:id=\"txtToSpell\" was not injected: check your FXML file 'SpellChecker.fxml'.";
	        assert btnSpellCheck != null : "fx:id=\"btnSpellCheck\" was not injected: check your FXML file 'SpellChecker.fxml'.";
	        assert txtWrongWords != null : "fx:id=\"txtWrongWords\" was not injected: check your FXML file 'SpellChecker.fxml'.";
	        assert labelErrors != null : "fx:id=\"labelErrors\" was not injected: check your FXML file 'SpellChecker.fxml'.";
	        assert btnClearText != null : "fx:id=\"btnClearText\" was not injected: check your FXML file 'SpellChecker.fxml'.";
	        assert labelTimeCheck != null : "fx:id=\"labelTimeCheck\" was not injected: check your FXML file 'SpellChecker.fxml'.";

	    }

		public void setModel(Dictionary model) {
			this.model=model;
			comboBoxLanguage.getItems().addAll("English", "Italian");
		}
	}


