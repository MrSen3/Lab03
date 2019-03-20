	package it.polito.tdp.spellchecker.controller;

	import java.net.URL;
	import java.util.ResourceBundle;

import it.polito.tdp.spellchecker.model.SpellCheckerModel;
import javafx.event.ActionEvent;
	import javafx.fxml.FXML;
	import javafx.scene.control.Button;
	import javafx.scene.control.ComboBox;
	import javafx.scene.control.Label;
	import javafx.scene.control.TextArea;
	import javafx.scene.control.TextField;

	public class SpellCheckerController {
		
		private SpellCheckerModel model;

		//box.getItems().addAll("English","Italian")
		
	    @FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;

	    @FXML
	    private ComboBox<?> comboBoxLanguage;

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
	    void chooseLanguage(ActionEvent event) {

	    }

	    @FXML
	    void doClearText(ActionEvent event) {

	    }

	    @FXML
	    void doSpellCheck(ActionEvent event) {

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

		public void setModel(SpellCheckerModel model) {
			// TODO Auto-generated method stub
			this.model=model;
			
		}
	}


