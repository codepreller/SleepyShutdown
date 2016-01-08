package app;
/**
 * User: preller
 * Date: 25.12.2015
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class SleepyShutdownApp extends Application {
    AnchorPane sleepyShutdownGUI;

    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/SleepyShutdownGUI.fxml"));
            sleepyShutdownGUI = loader.load();

            Scene scene = new Scene(sleepyShutdownGUI);
            primaryStage.setTitle("SleepyShutdown");
            primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/giraparksheep.png")));
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}