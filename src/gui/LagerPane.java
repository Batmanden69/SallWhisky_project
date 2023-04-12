package gui;

import application.Controller;
import application.Lager;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

import java.util.ArrayList;

public class LagerPane extends GridPane {

    private ListView<Lager> lvwLager;
    private Controller controller;

    public LagerPane() {
        controller = Controller.getInstance();
        Label titleLabel = new Label("Lager");
        titleLabel.setFont(new Font("Arial", 20));
        add(titleLabel, 0, 0, 2, 1);

        lvwLager = new ListView<>();

        this.add(lvwLager, 0, 1);

        lvwLager.getItems().setAll(controller.getLagerList());

        Button btnOpret = new Button("Opret lager");
        btnOpret.setOnAction(e -> {
            opretLager();
        });

        Button btnSlet = new Button("Slet lager");
        btnSlet.setOnAction(e -> {
            sletLager();
        });

        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.CENTER_LEFT);
        buttonBox.getChildren().addAll(btnOpret, btnSlet);
        add(buttonBox, 0, 2);

        setPadding(new Insets(10));
        setHgap(10);
        setVgap(10);

    }

    private void opretLager() {
        TextField txtNavn = new TextField();
        TextField txtPladser = new TextField();
        Label lblNavn = new Label("Navn:");
        Label lblPladser = new Label("Antal pladser:");

        GridPane inputGrid = new GridPane();
        inputGrid.add(lblNavn, 0, 0);
        inputGrid.add(txtNavn, 1, 0);
        inputGrid.add(lblPladser, 0, 1);
        inputGrid.add(txtPladser, 1, 1);

        Button btnTilføj = new Button("Tilføj");
        btnTilføj.setOnAction(e -> {
            String navn = txtNavn.getText();
            int pladser = Integer.parseInt(txtPladser.getText());
            if (!navn.isEmpty()) {
                Lager lager = Controller.getInstance().createLager(navn, pladser);
                lvwLager.getItems().add(lager);
            }
        });

        GridPane buttonGrid = new GridPane();
        buttonGrid.add(btnTilføj, 0, 0);

        GridPane dialogGrid = new GridPane();
        dialogGrid.add(inputGrid, 0, 0);
        dialogGrid.add(buttonGrid, 0, 1);

        // Opret dialogen og vis den
        Dialog<Void> dialog = new Dialog<>();
        dialog.getDialogPane().setContent(dialogGrid);
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.CANCEL);
        dialog.showAndWait();
    }


    private void sletLager() {
        int selectedIndex = lvwLager.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            lvwLager.getItems().remove(selectedIndex);
        }
    }

    public void updateControls() {
        // TODO Auto-generated method stub
    }
}
