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
            System.out.println("start()");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/SleepyShutdownGUI.fxml"));
            sleepyShutdownGUI = loader.load();

            Scene scene = new Scene(sleepyShutdownGUI);
            primaryStage.setTitle("SleepyShutdown");
            primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/giraparksheep.png")));
            primaryStage.setScene(scene);
            primaryStage.show();
            System.out.println("start() end");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Exception wurde geworfen und nicht vernünftig behandelt");
        }
    }

    public static void main(String[] args) {
        System.out.println("Starting SleepyShutdown");
        launch(args);
        System.out.println("SleepyShutdown gestartet");
    }
}