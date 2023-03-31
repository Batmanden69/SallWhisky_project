package gui;

import application.Destillat;
import application.Whisky;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class WhiskyPane extends GridPane {
    private ListView<Whisky> whiskyListView;
    private ListView<Destillat> destillatListView;
    private Button sletWhiskyButton;

    public WhiskyPane() {
        setAlignment(Pos.CENTER);
        setHgap(10);
        setVgap(10);
        setPadding(new Insets(10));

        // Opret GUI-elementer
        Label titleLabel = new Label("Whisky");
        titleLabel.setFont(new Font("Arial", 20));
        add(titleLabel, 0, 0, 2, 1);

        whiskyListView = new ListView<>();
        add(whiskyListView, 0, 1, 1, 3);

        Label titleHistorik = new Label("Historik");
        titleHistorik.setFont(new Font("Arial", 20));
        add(titleHistorik, 1, 0, 2, 1);

        destillatListView = new ListView<>();
        add(destillatListView, 1, 1, 1, 2);

        sletWhiskyButton = new Button("Slet whisky");
        add(sletWhiskyButton, 1, 3);
    }

    public void updateControls() {
        // TODO Auto-generated method stub
    }
}

