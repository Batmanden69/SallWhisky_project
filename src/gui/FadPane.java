package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class FadPane extends GridPane {

    private TextField idField, størrelseField, literField, fadTypeField, leverandørField, reolNrField, hyldeNrField;
    private ComboBox lagerCombo;
    private Button opretButton;

    public FadPane() {
        setAlignment(Pos.CENTER);
        setHgap(10);
        setVgap(10);
        setPadding(new Insets(10));

        // Opret GUI-elementer
        Label titleLabel = new Label("Opret nyt fad");
        titleLabel.setFont(new Font("Arial", 20));
        add(titleLabel, 0, 0, 2, 1);

        Label idLabel = new Label("ID:");
        add(idLabel, 0, 1);
        idField = new TextField();
        add(idField, 1, 1);

        Label størrelseLabel = new Label("Størrelse:");
        add(størrelseLabel, 0, 2);
        størrelseField = new TextField();
        add(størrelseField, 1, 2);

        Label literLabel = new Label("Antal liter påfyldt:");
        add(literLabel, 0, 3);
        literField = new TextField();
        add(literField, 1, 3);

        Label fadtypeLabel = new Label("Fadtype:");
        add(fadtypeLabel, 0, 4);
        fadTypeField = new TextField();
        add(fadTypeField, 1, 4);

        Label leverandørLabel = new Label("Leverandør:");
        add(leverandørLabel, 0, 5);
        leverandørField = new TextField();
        add(leverandørField, 1, 5);

        Label pladsLabel = new Label("Lager:");
        add(pladsLabel, 0, 6);
        lagerCombo = new ComboBox();
        add(lagerCombo, 1, 6);

        Label reolNrLabel = new Label("Reol nr.:");
        add(reolNrLabel, 0, 7);
        reolNrField = new TextField();
        add(reolNrField, 1, 7);

        Label hyldeNrLabel = new Label("Hylde nr.:");
        add(hyldeNrLabel, 0, 8);
        hyldeNrField = new TextField();
        add(hyldeNrField, 1, 8);

        opretButton = new Button("Opret fad");
        add(opretButton, 0, 9, 2, 1);
    }

    //---------------------------------------#
    //Metoder


    public void updateControls() {
        // TODO Auto-generated method stub
    }
}




