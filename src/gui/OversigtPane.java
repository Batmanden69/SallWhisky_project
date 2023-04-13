package gui;

import application.Controller;
import application.Destillat;
import application.Fad;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;

import javax.swing.*;

public class OversigtPane extends GridPane {
    private final ListView lvwFade = new ListView();
    private final ListView lvwDestillater = new ListView();
    private final TextArea txaDestillering = new TextArea();
    private final Label lblFade = new Label("Fade");
    private final Label lblDestillater = new Label("Destillater");
    private final Label lblDestillering = new Label("Destillering");
    private final Label lblLagring = new Label("Destillatets Lagringshistorik");

    private final TextArea txaLagring = new TextArea();
    private Controller controller;


    public OversigtPane() {
        controller = Controller.getInstance();
        setAlignment(Pos.CENTER);
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(20);

        this.add(lblFade, 0, 0);
        this.add(lvwFade, 0, 1);
        this.add(lblDestillater, 1, 0);
        this.add(lvwDestillater, 1, 1);
        this.add(lblDestillering, 2, 0);
        this.add(txaDestillering, 2, 1);
        this.add(lblLagring, 2, 2);
        this.add(txaLagring, 2, 3);

        lvwFade.setPrefSize(200, 200);
        lvwDestillater.setPrefSize(200, 200);
        txaDestillering.setPrefSize(200, 200);
        txaDestillering.setEditable(false);
        txaLagring.setPrefSize(200, 200);
        txaLagring.setEditable(false);


        lvwFade.getItems().setAll(controller.getFadList());
        ChangeListener<Fad> listener = (ov, oldFad, newFad) -> this.selectedFadChanged();
        lvwFade.getSelectionModel().selectedItemProperty().addListener(listener);

        ChangeListener<Destillat> listener2 = (ov, oldDestillat, newDestillat) -> this.selectedDestillatChanged();
        lvwDestillater.getSelectionModel().selectedItemProperty().addListener(listener2);

        Button omhældBtn = new Button("Omhæld fad");
        add(omhældBtn, 0, 2, 2, 1);

        omhældBtn.setOnAction(event -> omhældFadKnap());

    }

    private void selectedDestillatChanged() {
        this.updateControls();
    }

    public ListView getLvwFade() {
        return lvwFade;
    }

    private void selectedFadChanged() {
        this.updateControls();
    }

    public void updateLvwFad() {
        lvwFade.getItems().setAll(controller.getFadList());
    }

    private void omhældFadKnap() {
        Label nytFad = new Label("Vælg nyt fad");
        ListView nyeFade = new ListView<>();
        nyeFade.getItems().addAll(controller.getFadList());
        Fad firstSelectedFad = (Fad) lvwFade.getSelectionModel().getSelectedItem();
        Dialog<Void> dialog = new Dialog<>();


        Button vælgBtn = new Button("Vælg");
        vælgBtn.setOnAction(event -> {
                    Fad selectedFad = (Fad) nyeFade.getSelectionModel().getSelectedItem();
                    if (firstSelectedFad == null) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Fejl");
                        alert.setContentText("Du mangler at vælge et fad du vil omhælde til");
                        alert.showAndWait();
                    } else {
                        firstSelectedFad.omhældFad2(selectedFad);
                        dialog.close();
                        updateControls();
                    }
                }
        );

        GridPane inputGrid = new GridPane();
        inputGrid.add(nyeFade, 0, 1);
        inputGrid.add(nytFad, 0, 0);
        inputGrid.add(vælgBtn, 3, 2);


        dialog.getDialogPane().setContent(inputGrid);
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.CANCEL);
        dialog.showAndWait();

    }

    public void updateControls() {
        Fad fad = (Fad) lvwFade.getSelectionModel().getSelectedItem();
        Destillat destillat = (Destillat) lvwDestillater.getSelectionModel().getSelectedItem();
        if (fad != null && fad.getDestillater() != null) {
            lvwDestillater.getItems().setAll(fad.getDestillater());
        } else {
            lvwDestillater.getItems().clear();
            txaDestillering.clear();
            txaLagring.clear();
        }
        if (destillat != null && destillat.getDestillatHistorik() != null) {
            txaDestillering.setText(destillat.destillatDestilleringOversigt());
            txaLagring.setText(destillat.destillatLagringOversigt());
        } else {
            txaDestillering.clear();
            txaLagring.clear();
        }
    }
}
