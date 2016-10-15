package at.yousif.numbersystems.Utils;

import at.yousif.numbersystems.Main;
import javafx.scene.control.ChoiceDialog;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Created by YouSafe on 11.10.2016.
 */
public class SelectorBox {

    private String title;
    private String message;
    private String output;
    private String defaultchoice;
    private List<String> choices = new ArrayList<>();

    /**
     * @param title         Title of the dialog
     * @param message       Message of the dialog
     * @param defaultchoice Default choice of the dialog
     */
    public SelectorBox(String title, String message, String defaultchoice) {
        this.title = title;
        this.message = message;
        this.defaultchoice = defaultchoice;
    }

    /**
     * @param title         Title of the dialog
     * @param message       Message of the dialog
     * @param defaultchoice Default choice of the dialog
     * @param choices       Choices of the dialog
     */
    public SelectorBox(String title, String message, String defaultchoice, List<String> choices) {
        this.title = title;
        this.message = message;
        this.defaultchoice = defaultchoice;
        this.choices = choices;
    }

    public String display() {
        ChoiceDialog<String> dialog = new ChoiceDialog<>(defaultchoice != null ? defaultchoice : "", choices);
        dialog.setHeaderText(null);
        dialog.setTitle(title);
        dialog.setContentText(message);

        ((Stage) dialog.getDialogPane().getScene().getWindow()).getIcons().add(Main.icon);

        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            output = result.get();
        }

        return output;
    }

    public void addChoice(String... input) {
        Collections.addAll(this.choices, input);
    }

    public void removeChoice(String input) {
        if (this.choices.contains(input)) {
            this.choices.remove(input);
        }
    }

    public List<String> getChoices() {
        return choices;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }
}
