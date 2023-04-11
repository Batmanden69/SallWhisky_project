package gui;

import application.Controller;
import application.Destillat;
import application.Fad;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;

public class OversigtPane extends GridPane {
    private final ListView lvwFade = new ListView();
    private final ListView lvwDestillater = new ListView();
    private final TextArea txaDestillering = new TextArea();

    private final TextArea txaLagring = new TextArea();


    public OversigtPane() {
        Controller controller = Controller.getInstance();
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(20);

        Label lblFade = new Label("Fade");
        this.add(lblFade, 0, 0);
        this.add(lvwFade, 0, 1);
        Label lblDestillater = new Label("Destillater");
        this.add(lblDestillater, 1, 0);
        this.add(lvwDestillater, 1, 1);
        Label lblDestillering = new Label("Destillering");
        this.add(lblDestillering, 2, 0);
        this.add(txaDestillering, 2, 1);
        Label lblLagring = new Label("Destillatets Lagringshistorik");
        this.add(lblLagring, 2, 2);
        this.add(txaLagring, 2, 3);

        lvwFade.setPrefSize(200, 200);
        lvwDestillater.setPrefSize(200, 200);
        txaDestillering.setPrefSize(200, 200);
        txaDestillering.setEditable(false);
        txaLagring.setPrefSize(200, 200);


        lvwFade.getItems().setAll(controller.getFadList());
        ChangeListener<Fad> listener = (ov, oldFad, newFad) -> this.selectedFadChanged();
        lvwFade.getSelectionModel().selectedItemProperty().addListener(listener);

        ChangeListener<Destillat> listener2 = (ov, oldDestillat, newDestillat) -> this.selectedDestillatChanged();
        lvwDestillater.getSelectionModel().selectedItemProperty().addListener(listener2);


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