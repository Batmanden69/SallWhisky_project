package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class DestilleringPane extends GridPane {

    TextField txfAntalLiter = new TextField();
    TextField txfMaltBatch = new TextField();
    TextField txfKornsort = new TextField();
    TextField txfNewMakeNr = new TextField();
    TextField txfAlkoholProcent = new TextField();
    TextField txfRygematriale = new TextField();
    TextField txfKommentar = new TextField();
    Button btnOpretDestillering = new Button("Opret destillering");

    public DestilleringPane() {

        setAlignment(Pos.CENTER);
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        Label titel = new Label("Opret Destillering");
        this.add(titel,0,0,2,1);

        Label lblAntalLiter = new Label("Antal Liter: ");
        this.add(lblAntalLiter,0,1);
        this.add(txfAntalLiter,1,1);

        Label lblMaltBatch = new Label("MaltBatch: ");
        this.add(lblMaltBatch,0,2);
        this.add(txfMaltBatch,1,2);

        Label lblKornsort = new Label("Kornsort: ");
        this.add(lblKornsort,0,3);
        this.add(txfKornsort,1,3);

        Label lblNewMakeNr = new Label("New make nr: ");
        this.add(lblNewMakeNr,0,4);
        this.add(txfNewMakeNr,1,4);

        Label lblAlkoholprocent = new Label("Alkoholprocent: ");
        this.add(lblAlkoholprocent,0,5);
        this.add(txfAlkoholProcent,1,5);

        Label lblRygematriale = new Label("Rygematriale: ");
        this.add(lblRygematriale,0,6);
        this.add(txfRygematriale,1,6);

        Label lblkommentar = new Label("Kommentar: ");
        this.add(lblkommentar,0,7);
        this.add(txfKommentar,1,7);


        this.add(btnOpretDestillering,2,8);
    }

    //--------------------------------------
    //metoder
    private void opretDestillering(){

    }

    public void updateControls() {
        // TODO Auto-generated method stub
    }
}
