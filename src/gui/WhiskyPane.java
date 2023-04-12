package gui;

import application.Controller;
import application.Destillat;
import application.Whisky;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class WhiskyPane extends GridPane {
    private ListView<Whisky> lvwWhisky;
    private ListView<Destillat> lvwDestillat;
    private Button sletWhiskyButton;
    private Controller controller;

    public WhiskyPane() {

        controller = Controller.getInstance();
        setAlignment(Pos.CENTER);
        setHgap(10);
        setVgap(10);
        setPadding(new Insets(10));

        // Opret GUI-elementer
        Label titleLabel = new Label("Whisky");
        titleLabel.setFont(new Font("Arial", 20));
        add(titleLabel, 0, 0, 2, 1);

        lvwWhisky = new ListView<>();
        add(lvwWhisky, 0, 1, 1, 3);
        lvwWhisky.getItems().setAll(controller.getWhiskyList());

        ChangeListener<Whisky> listener = (ov, oldWhisky, newWhisky) -> this.selectedwhiskyChanged();
        lvwWhisky.getSelectionModel().selectedItemProperty().addListener(listener);

        Label titleHistorik = new Label("Historik");
        titleHistorik.setFont(new Font("Arial", 20));
        add(titleHistorik, 1, 0, 2, 1);

        lvwDestillat = new ListView<>();
        add(lvwDestillat, 1, 1, 1, 2);


        sletWhiskyButton = new Button("Slet whisky");
        add(sletWhiskyButton, 1, 3);
    }

    //-------------------------------------#
    //Metoder


    private void selectedwhiskyChanged() {
        this.updateControls();
    }

    public void updateFadList() {
        lvwWhisky.getItems().setAll(Controller.getInstance().getWhiskyList());
    }

    public void updateControls() {

        Whisky whisky = (Whisky) lvwWhisky.getSelectionModel().getSelectedItem();
        Destillat destillat = (Destillat) lvwDestillat.getSelectionModel().getSelectedItem();

        if (whisky != null && whisky.getDestillatList() != null) {
            lvwDestillat.getItems().setAll(whisky.getDestillatList());
        } else {
            lvwDestillat.getItems().clear();
        }
    }
}

