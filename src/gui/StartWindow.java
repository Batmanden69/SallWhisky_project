package gui;

import application.Controller;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.BorderPane;

public class StartWindow extends Application {
    private Controller controller;


    @Override
    public void init() {
        controller = Controller.getInstance();
        controller.getInstance().init();
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Sall Whisky Destilleri");
        BorderPane pane = new BorderPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    private void initContent(BorderPane pane) {
        TabPane tabPane = new TabPane();
        this.initTabPane(tabPane);
        pane.setCenter(tabPane);
    }

    private void initTabPane(TabPane tabPane) {
        tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);

        Tab tabFad = new Tab("Fad");
        tabPane.getTabs().add(tabFad);

        FadPane fadPane = new FadPane();
        tabFad.setContent(fadPane);
        tabFad.setOnSelectionChanged(event -> fadPane.updateControls());

        Tab tabDestillat = new Tab("Destillat");
        tabPane.getTabs().add(tabDestillat);

        LagerPane destillatPane = new LagerPane();
        tabDestillat.setContent(destillatPane);
        tabDestillat.setOnSelectionChanged(event -> destillatPane.updateControls());

        Tab tabDestillering = new Tab("Destillering");
        tabPane.getTabs().add(tabDestillering);

        DestilleringPane destilleringPane = new DestilleringPane();
        tabDestillering.setContent(destilleringPane);
        tabDestillering.setOnSelectionChanged(event -> destillatPane.updateControls());

        Tab tabWhisky = new Tab("Whisky");
        tabPane.getTabs().add(tabWhisky);

        WhiskyPane whiskyPane = new WhiskyPane();
        tabWhisky.setContent(whiskyPane);
        tabWhisky.setOnSelectionChanged(event -> whiskyPane.updateControls());

        Tab tabOversigt = new Tab("Oversigt");
        tabPane.getTabs().add(tabOversigt);

        OversigtPane oversigtPane = new OversigtPane();
        tabOversigt.setContent(oversigtPane);
        tabOversigt.setOnSelectionChanged(event -> oversigtPane.updateControls());

    }
}
