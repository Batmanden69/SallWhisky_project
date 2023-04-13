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
        TextField txfBatchId = new TextField();
//        TextField txfMængde = new TextField();
        Label lblBatch = new Label("Batch Id: ");
//        Label lblMængde = new Label("Mængde: ");
        Dialog<Void> dialog = new Dialog<>();

        GridPane inputGrid = new GridPane();
        inputGrid.add(lblBatch, 0, 0);
        inputGrid.add(txfBatchId, 1, 0);
//        inputGrid.add(lblMængde, 0, 1);
//        inputGrid.add(txfMængde, 1, 1);

        Button BtnTilføj = new Button("Tilføj");
        BtnTilføj.setOnAction(event -> {
            Fad selectedFad = lvwFad.getSelectionModel().getSelectedItem();
            String batchId = txfBatchId.getText();
//            String mængde = txfMængde.getText();
            if (batchId.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Manglende input");
                alert.setContentText("Du mangler at angive vigtig input");
                alert.showAndWait();
            } else {
                int batchId2 = Integer.parseInt(batchId);
                double mængde = selectedFad.samletMængde();
                Whisky whisky = controller.createWhisky(batchId2, mængde);
                for (Fad f : lvwFad.getItems()) {
                    for (Destillat d :f.getDestillater()) {
                        whisky.addDestillat(d);
                        
                    }
                }

                selectedFad.tømFad();

                txfBatchId.setText("");
//                txfMængde.setText("");
                updateControls();

                dialog.close();
            }

        });

        GridPane buttonGrid = new GridPane();
        buttonGrid.add(BtnTilføj, 0, 0);

        GridPane dialogGrid = new GridPane();
        dialogGrid.add(inputGrid, 0, 0);
        dialogGrid.add(buttonGrid, 1, 1);

        dialog.getDialogPane().setContent(dialogGrid);
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.CANCEL);
        dialog.showAndWait();

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
