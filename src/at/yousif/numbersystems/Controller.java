package at.yousif.numbersystems;

import at.yousif.numbersystems.Utils.AlertBox;
import at.yousif.numbersystems.Utils.SelectorBox;
import at.yousif.numbersystems.Utils.Utils;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.math.BigInteger;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Slider basisSlider;

    @FXML
    private TextArea textarea;

    @FXML
    private TextField numberField;

    @FXML
    private MenuItem menuAbout, menuFontsize, menuClose;

    @FXML
    private VBox mainPane;

    private int currentFontsize = 12;

    private void handleNumberChange() {
        BigInteger basis = new BigInteger(String.valueOf((long) basisSlider.getValue()));
        BigInteger number = new BigInteger(numberField.getText());

        String schema = Utils.outputString(number, basis);
        String result = Utils.convertNumberSystem(number, basis);
        textarea.setText(schema + "\n" + "=> " + result);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        changeFontsize(currentFontsize);
        basisSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (numberField.getLength() != 0) {
                handleNumberChange();
            }
        });

        numberField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                numberField.setText(newValue.replaceAll("[^\\d]", ""));
            } else if (newValue.length() == 0) {
                textarea.setText("");
            } else if (newValue.length() > 2000) {
                numberField.setText(newValue.substring(0, 2000));
            } else {
                handleNumberChange();
            }
        });

        menuFontsize.setOnAction(event -> {
            SelectorBox schriftgröße = new SelectorBox("Schriftgröße", "Wähle eine Schriftgöße aus:", currentFontsize + "pt");
            schriftgröße.addChoice("8pt", "10pt", "12pt", "14pt", "18pt");

            String output = schriftgröße.display();

            if (output != null) {
                currentFontsize = Integer.valueOf(output.replaceAll("pt", ""));
                changeFontsize(currentFontsize);
            }

        });

        menuAbout.setOnAction(event -> new AlertBox("Credits", "by Yousif E. 2016 © \nAll rights reserved.").display());
        menuClose.setOnAction(event -> ((Stage) mainPane.getScene().getWindow()).close());
    }

    private void changeFontsize(int fontsize) {
        DoubleProperty fontSize = new SimpleDoubleProperty(fontsize);
        mainPane.styleProperty().bind(Bindings.format("-fx-font-size: %.2fpt;", fontSize));
    }

}
