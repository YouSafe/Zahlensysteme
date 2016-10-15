package at.yousif.numbersystems.Utils;

import at.yousif.numbersystems.Main;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

/**
 * Created by YouSafe on 11.10.2016.
 */


public class AlertBox {

    private String title;
    private String message;

    /**
     * @param title   Title of the dialog
     * @param message Message of the dialog
     */
    public AlertBox(String title, String message) {
        this.title = title;
        this.message = message;
    }

    public void display() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        ((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(Main.icon);

        alert.showAndWait();
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }
}
