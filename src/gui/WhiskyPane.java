package gui;

import application.Controller;
import application.Destillat;
import application.Lagring;
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
    private ListView<Lagring> lvwLagring;
    private Button sletWhiskyButton;
    private Button opretWhiskyButton;
    private Controller controller;
    private WhiskyWindow whiskyWindow;

    private Button opdaterWhisky;

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
        add(lvwWhisky, 0, 1);
        lvwWhisky.getItems().setAll(controller.getWhiskyList());

        ChangeListener<Whisky> listener = (ov, oldWhisky, newWhisky) -> this.selectedWhiskyChanged();
        lvwWhisky.getSelectionModel().selectedItemProperty().addListener(listener);

        Label titleHistorik = new Label("Destillater");
        titleHistorik.setFont(new Font("Arial", 20));
        add(titleHistorik, 1, 0, 2, 1);

        lvwDestillat = new ListView<>();
        add(lvwDestillat, 1, 1);

        ChangeListener<Destillat> listener2 = (ov, oldDestillat, newDestillat) -> this.selectedDestillatChanged();
        lvwDestillat.getSelectionModel().selectedItemProperty().addListener(listener2);

        Label lblLagringshistorik = new Label("Lagringshistorik");
        lblLagringshistorik.setFont(new Font("Arial", 20));
        add(lblLagringshistorik, 2, 0, 2, 1);

        lvwLagring = new ListView<>();
        add(lvwLagring, 2, 1);

        sletWhiskyButton = new Button("Slet whisky");
        add(sletWhiskyButton, 0, 2);
        sletWhiskyButton.setOnAction(event -> sletWhiskyKnap());

        opretWhiskyButton = new Button("Opret Whisky");
        add(opretWhiskyButton, 2, 2);
        opretWhiskyButton.setOnAction(event -> opretWhiskyKnap());

        opdaterWhisky = new Button("Opdatér whisky");
        add(opdaterWhisky, 1, 2);

        opdaterWhisky.setOnAction(event -> updateListviews());

    }

    //-------------------------------------#
    //Metoder

    private void sletWhiskyKnap() {
        int selectedIndex = lvwWhisky.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            lvwWhisky.getItems().remove(selectedIndex);
        }
    }

    private void opretWhiskyKnap() {
        WhiskyWindow window = new WhiskyWindow();
        window.showAndWait();

    }

    private void selectedWhiskyChanged() {
        this.updateControls();
    }

    private void selectedDestillatChanged() {
        this.updateControls();
    }

    private void updateListviews() {
        lvwWhisky.getItems().setAll(controller.getWhiskyList());
    }

    public void updateControls() {
        Whisky whisky = (Whisky) lvwWhisky.getSelectionModel().getSelectedItem();
        Destillat destillat = (Destillat) lvwDestillat.getSelectionModel().getSelectedItem();

        if (whisky != null && whisky.getDestillatList() != null) {
            lvwDestillat.getItems().setAll(whisky.getDestillatList());
        } else {
            lvwDestillat.getItems().clear();
        }
        if (destillat != null && destillat.getDestillatHistorik() != null) {
            lvwLagring.getItems().setAll(whisky.lagringHistorik());
        } else {
            lvwLagring.getItems().clear();
        }
    }



}

