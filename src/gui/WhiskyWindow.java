package gui;

import application.Controller;
import application.Destillat;
import application.Fad;
import application.Lagring;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.ArrayList;

public class WhiskyWindow extends Stage {

    public WhiskyWindow() {
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);

        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);

    }

    private ListView<Fad> lvwFad;
    private ListView<Destillat> lvwDestillat;
    private Controller controller;

    private Button opretWhiskyBtn;

    private void initContent(GridPane pane) {
        controller = Controller.getInstance();
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setPadding(new Insets(10));

        Label lblFad = new Label("Fad");
        lblFad.setFont(new Font("Arial", 20));
        pane.add(lblFad, 0, 1);

        lvwFad = new ListView<>();
        pane.add(lvwFad, 0, 2);

        ChangeListener<Fad> listener = (ov, oldFad, newFad) -> this.selectedFadChanged();
        lvwFad.getSelectionModel().selectedItemProperty().addListener(listener);

        Label lblDestillat = new Label("Destillater");
        lblDestillat.setFont(new Font("Arial", 20));
        pane.add(lblDestillat, 1, 1);

        lvwDestillat = new ListView<>();
        pane.add(lvwDestillat, 1, 2);

        opretWhiskyBtn = new Button("Opret whisky");
        pane.add(opretWhiskyBtn, 2, 1);


        updateFadList();
    }

    //---------------------------------------------------------------------
    //metoder

    public void updateFadList() {
        lvwFad.getItems().setAll(controller.getFadList());
    }

    private void selectedFadChanged() {
        this.updateControls();

    }


    private ArrayList<Fad> klarFad() {
        ArrayList<Fad> fads = new ArrayList<>();
        Fad fad = lvwFad.getSelectionModel().getSelectedItem();
        for (Destillat d : fad.getDestillater()) {
            Lagring l = d.getDestillatHistorik().get(0);
            if (l.getLagringsperiode() >= 1095) {
                fads.add(fad);
            }
        }
        return fads;
    }

    private void updateControls() {
        Fad fad = (Fad) lvwFad.getSelectionModel().getSelectedItem();
        Destillat destillat = (Destillat) lvwDestillat.getSelectionModel().getSelectedItem();
        if (fad != null && fad.getDestillater() != null) {
            lvwDestillat.getItems().setAll(fad.getDestillater());
        } else {
            lvwDestillat.getItems().clear();
        }
    }
}
