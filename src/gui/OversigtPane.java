package gui;

import application.Controller;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class OversigtPane extends GridPane {
    private final ListView lvwFade = new ListView();
    private final ListView lvwDestillater = new ListView();
    private final TextArea txaHistorik = new TextArea();
    private final Label lblFade = new Label("Fade");
    private final Label lblDestillater = new Label("Destillater");
    private final Label lblHistorik = new Label("Historik");


    public OversigtPane() {
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(20);

        this.add(lblFade, 0, 0);
        this.add(lvwFade, 0, 1);
        this.add(lblDestillater, 1, 0);
        this.add(lvwDestillater, 1, 1);
        this.add(lblHistorik, 2, 0);
        this.add(txaHistorik, 2, 1);

        lvwFade.setPrefSize(200, 200);
        lvwDestillater.setPrefSize(200, 200);
        txaHistorik.setPrefSize(200, 200);

        lvwFade.getItems().setAll(Controller.getInstance().getFadList());

    }


    public void updateControls() {

    }
}
