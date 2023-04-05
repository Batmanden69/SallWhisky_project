package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;


public class LagerPane extends GridPane {

    private ListView lvwLager;

    public LagerPane() {


        Label titleLabel = new Label("Opret Lager");
        titleLabel.setFont(new Font("Arial", 20));
        add(titleLabel, 0, 0, 2, 1);

        this.add(lvwLager, 0, 1);
        lvwLager = new ListView<>();


    }

    public void updateControls() {
        // TODO Auto-generated method stub
    }


}
