package at.yousif.numbersystems;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import javax.swing.*;

public class Main extends Application {

    public static Image icon;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        if (Float.parseFloat(System.getProperty("java.class.version")) > 52F) {
            JOptionPane.showMessageDialog(null, "*** ERROR *** This application requires Java 8 or above to function! Please download and install it!");
            return;
        }
        icon = new Image(getClass().getResourceAsStream("icon.png"));
        Parent root = FXMLLoader.load(getClass().getResource("gui.fxml"));
        primaryStage.setTitle("Zahlensysteme");
        primaryStage.getIcons().add(icon);
        primaryStage.setScene(new Scene(root, 800, 500));
        primaryStage.show();
    }
}
