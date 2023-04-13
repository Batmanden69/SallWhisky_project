package gui;

import application.Controller;
import application.Fad;
import application.Lager;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class FadPane extends GridPane {

    private TextField størrelseField, fadTypeField, leverandørField;
    private ComboBox lagerCombo;
    private Button opretButton;
    private LagerPane lagerPane = new LagerPane();
    private OversigtPane oversigtPane = new OversigtPane();

    public FadPane() {
        setAlignment(Pos.CENTER);
        setHgap(10);
        setVgap(10);
        setPadding(new Insets(10));

        Label titleLabel = new Label("Opret nyt fad");
        titleLabel.setFont(new Font("Arial", 20));
        add(titleLabel, 0, 0, 2, 1);

        Label størrelseLabel = new Label("Størrelse:");
        add(størrelseLabel, 0, 1);
        størrelseField = new TextField();
        add(størrelseField, 1, 1);

        Label fadtypeLabel = new Label("Fadtype:");
        add(fadtypeLabel, 0, 2);
        fadTypeField = new TextField();
        add(fadTypeField, 1, 2);

        Label leverandørLabel = new Label("Leverandør:");
        add(leverandørLabel, 0, 3);
        leverandørField = new TextField();
        add(leverandørField, 1, 3);

        Label pladsLabel = new Label("Lager:");
        add(pladsLabel, 0, 4);
        lagerCombo = new ComboBox();
        lagerCombo.getItems().addAll(Controller.getInstance().getLagerList());
        add(lagerCombo, 1, 4);

        opretButton = new Button("Opret fad");
        add(opretButton, 0, 5, 2, 1);

        opretButton.setOnAction(event -> opretFadKnap());

    }

    //---------------------------------------#
    //Metoder


    public void opretFadKnap() {
        try {
            double størrelse = Double.parseDouble(størrelseField.getText());
            String fadType = fadTypeField.getText();
            String leverandør = leverandørField.getText();
            Lager lager = (Lager) lagerCombo.getSelectionModel().getSelectedItem();

            if (størrelse <= 0 || fadType.isBlank() || leverandør.isBlank() || lager == null) {
                throw new IllegalArgumentException("Udfyld venligst alle felter korrekt.");
            }

            Fad fad = Controller.getInstance().createFad(størrelse, fadType, leverandør);

            fad.lægPåPlads(lager);

            størrelseField.setText("");
            fadTypeField.setText("");
            leverandørField.setText("");
            lagerCombo.getSelectionModel().clearSelection();

        } catch (NumberFormatException e) {
            // Håndter ugyldig størrelse input
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Fejl");
            alert.setHeaderText(null);
            alert.setContentText("Indtast venligst et gyldigt tal for størrelse.");
            alert.showAndWait();
        } catch (IllegalArgumentException e) {
            // Håndter ugyldig eller manglende input
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Fejl");
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        } catch (Exception e) {
            // Håndter andre ukendte fejl
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Fejl");
            alert.setHeaderText(null);
            alert.setContentText("Der opstod en fejl: " + e.getMessage());
            alert.showAndWait();
        }
    }


    public void updateCombobox() {
        lagerCombo.getItems().setAll(Controller.getInstance().getLagerList());
    }


    public void updateControls() {
        // TODO Auto-generated method stub
    }
}




