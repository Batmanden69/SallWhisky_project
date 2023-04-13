package gui;

import application.*;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
    private TextArea txaDestillat;
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
        lvwFad.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        lvwFad.getItems().setAll(controller.klarFad());

        ChangeListener<Fad> listener = (ov, oldFad, newFad) -> this.selectedFadChanged();
        lvwFad.getSelectionModel().selectedItemProperty().addListener(listener);

        Label lblDestillat = new Label("Destillater");
        lblDestillat.setFont(new Font("Arial", 20));
        pane.add(lblDestillat, 1, 1);

        txaDestillat = new TextArea();
        pane.add(txaDestillat, 1, 2);
        txaDestillat.setEditable(false);

        opretWhiskyBtn = new Button("Opret whisky");
        pane.add(opretWhiskyBtn, 2, 1);

        opretWhiskyBtn.setOnAction(event -> opretWhiskyAction());

    }

    //---------------------------------------------------------------------
    //metoder

    public void updateFadList() {
//        lvwFad.getItems().setAll(controller.getFadList());
    }

    private void selectedFadChanged() {
        this.updateControls();
    }


    private void opretWhiskyAction() {
        Fad selectedFad = lvwFad.getSelectionModel().getSelectedItem();
        if (selectedFad == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Mangler fad");
            alert.setContentText("Du mangler at vælger hvilke fade du vil danne whisky af");
            alert.showAndWait();
        } else {
            double mængde = selectedFad.samletMængde();
            Whisky whisky = controller.createWhisky(mængde);
            for (Destillat d : selectedFad.getDestillater()) {
                whisky.addDestillat(d);
            }
            selectedFad.tømFad();
            updateControls();
        }
    }


    private void updateControls() {
        Fad fad = (Fad) lvwFad.getSelectionModel().getSelectedItem();
//        Destillat destillat = (Destillat) lvwDestillat.getSelectionModel().getSelectedItem();
        if (fad != null && fad.getDestillater() != null) {
            txaDestillat.setText(fad.getDestillater().toString());
            lvwDestillat.getItems().setAll(fad.getDestillater());
        } else {
            txaDestillat.clear();
        }
    }
}
