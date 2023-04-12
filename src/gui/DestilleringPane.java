package gui;

import application.Controller;
import application.Destillering;
import application.Fad;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class DestilleringPane extends GridPane {


    private TextField txfAntalLiter = new TextField();
    private TextField txfMaltBatch = new TextField();
    private TextField txfKornsort = new TextField();
    private TextField txfNewMakeNr = new TextField();
    private TextField txfAlkoholProcent = new TextField();
    private TextField txfRygematriale = new TextField();
    private TextField txfKommentar = new TextField();
    private Button btnOpretDestillering;

    private Button btnHældPåFad;

    private ListView lvwDestilleringer = new ListView<>();
    private Controller controller;

    public DestilleringPane() {
        controller = Controller.getInstance();
        setAlignment(Pos.CENTER);
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        Label titel = new Label("Opret Destillering");
        this.add(titel, 0, 0, 2, 1);

        Label lblAntalLiter = new Label("Antal Liter: ");
        this.add(lblAntalLiter, 0, 1);
        this.add(txfAntalLiter, 1, 1);

        Label lblMaltBatch = new Label("MaltBatch: ");
        this.add(lblMaltBatch, 0, 2);
        this.add(txfMaltBatch, 1, 2);

        Label lblKornsort = new Label("Kornsort: ");
        this.add(lblKornsort, 0, 3);
        this.add(txfKornsort, 1, 3);


        Label lblAlkoholprocent = new Label("Alkoholprocent: ");
        this.add(lblAlkoholprocent, 0, 4);
        this.add(txfAlkoholProcent, 1, 4);

        Label lblRygematriale = new Label("Rygematriale: ");
        this.add(lblRygematriale, 0, 5);
        this.add(txfRygematriale, 1, 5);

        Label lblkommentar = new Label("Kommentar: ");
        this.add(lblkommentar, 0, 6);
        this.add(txfKommentar, 1, 6);

        btnOpretDestillering = new Button("Opret destillering");
        this.add(btnOpretDestillering, 1, 7);
        btnOpretDestillering.setAlignment(Pos.CENTER_LEFT);

        btnOpretDestillering.setOnAction(event -> opretDestillering());


        Label lblDest = new Label("Destilleringer: ");
        add(lblDest, 2, 0);


        add(lvwDestilleringer, 2, 1, 2, 8);
        lvwDestilleringer.getItems().setAll(controller.getDestilleringList());

        btnHældPåFad = new Button("Hæld på fad");
        add(btnHældPåFad, 2, 9);

        btnHældPåFad.setOnAction(event -> hældPåFadAction());

    }

    //--------------------------------------
    //metoder
    private void opretDestillering() {
        int liter = Integer.parseInt(txfAntalLiter.getText());
        int maltbatch = Integer.parseInt(txfMaltBatch.getText());
        String kornsort = txfKornsort.getText();
        double alkoProcent = Double.parseDouble(txfAlkoholProcent.getText());
        String rygeMateriale = txfRygematriale.getText();
        String kommentar = txfKommentar.getText();

        Destillering destillering = Controller.getInstance().createDestillering(liter, maltbatch,
                kornsort, alkoProcent, rygeMateriale, kommentar);

        updateDestilleringListview();

        txfAntalLiter.setText("");
        txfMaltBatch.setText("");
        txfKornsort.setText("");
        txfAlkoholProcent.setText("");
        txfRygematriale.setText("");
        txfKommentar.setText("");
    }

    private void hældPåFadAction() {
        Label lblfade = new Label("Fadeliste: ");
        ListView fade = new ListView<>();
        fade.getItems().setAll(controller.getFadList());
        Label lblMængde = new Label("Mængde: ");
        TextField txfMængde = new TextField();

        Button hældBtn = new Button("Hæld på fad");
        hældBtn.setOnAction(event -> {
            Fad selectedFad = (Fad) fade.getSelectionModel().getSelectedItem();
            Destillering destillering = (Destillering) lvwDestilleringer.getSelectionModel().getSelectedItem();
            if (selectedFad == null) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Vælg et fad");
                alert.setContentText("Du mangler at vælge et fad");
                alert.showAndWait();
            } else {
                destillering.hældPåFad2(selectedFad, Double.parseDouble(txfMængde.getText()));
                updateDestilleringListview();
                txfMængde.setText("");
            }


        });

        GridPane inputGrid = new GridPane();
        inputGrid.add(fade, 0, 1);
        inputGrid.add(lblfade, 0, 0);
        inputGrid.add(lblMængde, 0, 2);
        inputGrid.add(txfMængde, 1, 2);
        inputGrid.add(hældBtn, 2, 3);


        Dialog<Void> dialog = new Dialog<>();
        dialog.getDialogPane().setContent(inputGrid);
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.CANCEL);
        dialog.showAndWait();

    }


    private void updateDestilleringListview() {
        lvwDestilleringer.getItems().setAll(Controller.getInstance().getDestilleringList());
    }


    public void updateControls() {
        // TODO Auto-generated method stub
    }


}
