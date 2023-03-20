package it.polito.tdp.libretto;

import it.polito.tdp.libretto.model.Libretto;
import it.polito.tdp.libretto.model.Voto;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {
	
	private Libretto model;

	public void setModel(Libretto model) {
		this.model = model;
		this.txtResult.setText(this.model.toString());
	}
	
	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<Integer> comboPunti;

    @FXML
    private DatePicker selData;

    @FXML
    private TextField txtCorso;

    @FXML
    private TextArea txtResult;

    @FXML
    void doInserisci(ActionEvent event) {
    	
    	String corso = this.txtCorso.getText();
    	Integer punti = this.comboPunti.getValue();
    	LocalDate data = this.selData.getValue();
    	
    	this.model.add(new Voto(corso,punti,data));
    	
    	this.txtResult.setText(this.model.toString());

    }

    @FXML
    void initialize() {
        assert comboPunti != null : "fx:id=\"comboPunti\" was not injected: check your FXML file 'main.fxml'.";
        assert selData != null : "fx:id=\"selData\" was not injected: check your FXML file 'main.fxml'.";
        assert txtCorso != null : "fx:id=\"txtCorso\" was not injected: check your FXML file 'main.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'main.fxml'.";

        for(int p=18;p<=30;p++) {
        	this.comboPunti.getItems().add(p);
        }
        
        
        
    }
	
	

}
