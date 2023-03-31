package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class DestilleringPane extends GridPane {

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
        TextField txfAntalLiter = new TextField();
        this.add(txfAntalLiter,1,1);

        Label lblMaltBatch = new Label("MaltBatch: ");
        this.add(lblMaltBatch,0,2);
        TextField txfMaltBatch = new TextField();
        this.add(txfMaltBatch,1,2);

        Label lblKornsort = new Label("Kornsort: ");
        this.add(lblKornsort,0,3);
        TextField txfKornsort = new TextField();
        this.add(txfKornsort,1,3);

        Label lblNewMakeNr = new Label("New make nr: ");
        this.add(lblNewMakeNr,0,4);
        TextField txfNewMakeNr = new TextField();
        this.add(txfNewMakeNr,1,4);

        Label lblAlkoholprocent = new Label("Alkoholprocent: ");
        this.add(lblAlkoholprocent,0,5);
        TextField txfAlkoholProcent = new TextField();
        this.add(txfAlkoholProcent,1,5);

        Label lblRygematriale = new Label("Rygematriale: ");
        this.add(lblRygematriale,0,6);
        TextField txfRygematriale = new TextField();
        this.add(txfRygematriale,1,6);

        Label lblkommentar = new Label("Kommentar: ");
        this.add(lblkommentar,0,7);
        TextField txfKommentar = new TextField();
        this.add(txfKommentar,1,7);

        Button btnOpretDestillering = new Button("Opret destillering");
        this.add(btnOpretDestillering,2,8);
    }

    public void updateControls() {
        // TODO Auto-generated method stub
    }
}
