package gui;

import application.Controller;
import application.Fad;
import application.Lager;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class FadPane extends GridPane {

    private TextField idField, størrelseField, fadTypeField, leverandørField, reolNrField, hyldeNrField;
    private ComboBox lagerCombo;
    private Button opretButton;

    private LagerPane lagerPane = new LagerPane();

    private OversigtPane oversigtPane = new OversigtPane();

    public FadPane() {
        setAlignment(Pos.CENTER);
        setHgap(10);
        setVgap(10);
        setPadding(new Insets(10));

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

        Label fadtypeLabel = new Label("Fadtype:");
        add(fadtypeLabel, 0, 3);
        fadTypeField = new TextField();
        add(fadTypeField, 1, 3);

        Label leverandørLabel = new Label("Leverandør:");
        add(leverandørLabel, 0, 4);
        leverandørField = new TextField();
        add(leverandørField, 1, 4);

        Label pladsLabel = new Label("Lager:");
        add(pladsLabel, 0, 5);
        lagerCombo = new ComboBox();
        lagerCombo.getItems().addAll(Controller.getInstance().getLagerList());
        add(lagerCombo, 1, 5);

        opretButton = new Button("Opret fad");
        add(opretButton, 0, 6, 2, 1);

        opretButton.setOnAction(event -> opretFadKnap());


    }

    //---------------------------------------#
    //Metoder


    public void opretFadKnap() {
        int id = Integer.parseInt(idField.getText());
        double størrelse = Integer.parseInt(størrelseField.getText());
        String fadType = fadTypeField.getText();
        String leverandør = leverandørField.getText();
        Lager lager = (Lager) lagerCombo.getSelectionModel().getSelectedItem();

        Fad fad = Controller.getInstance().createFad(størrelse, fadType, leverandør);


        fad.lægPåPlads(lager);

        idField.setText("");
        størrelseField.setText("");
        fadTypeField.setText("");
        leverandørField.setText("");
        lagerCombo.getSelectionModel().clearSelection();

    }



    public void updateControls() {
        // TODO Auto-generated method stub
    }
}




