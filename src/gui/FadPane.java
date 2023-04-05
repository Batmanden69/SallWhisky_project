package gui;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;

public class FadPane extends GridPane {

    private final ListView lvwFade = new ListView();
    private final ListView lvwDestillater = new ListView();

    public FadPane(){
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(20);

        Label lblFade = new Label("Fade");
        this.add(lblFade, 0, 0);
        this.add(lvwFade, 0, 1);
        Label lblDestillater = new Label("Destillater");
        this.add(lblDestillater, 1, 0);
        this.add(lvwDestillater, 1, 1);

        lvwFade.setPrefSize(200, 200);
        lvwDestillater.setPrefSize(200, 200);
    }

    public void updateControls() {
        // TODO Auto-generated method stub
    }
}
