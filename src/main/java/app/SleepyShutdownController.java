package app;
/**
 * User: preller
 * Date: 25.12.2015
 */

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Spinner;
import logic.SleepyShutdown;
import service.CLIService;

import java.io.IOException;
import java.util.Arrays;

public class SleepyShutdownController {
    SleepyShutdown sleepyShutdown = new SleepyShutdown(new CLIService());

    @FXML Spinner<Integer> hoursSpinner;
    @FXML Spinner<Integer> minutesSpinner;
    @FXML Spinner<Integer> secondsSpinner;

    @FXML
    protected void shutdownButtonClicked() {
        try {
            sleepyShutdown.shutdown(hoursSpinner.getValue(), minutesSpinner.getValue(), secondsSpinner.getValue());
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Fehler");
            alert.setHeaderText("Fehler beim Starten der Shutdownsequenz");
            alert.setContentText(Arrays.toString(e.getStackTrace()));
        }
    }

    @FXML
    protected void stopShutdownButtonClicked() {
        try {
            sleepyShutdown.stopShutdown();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Fehler");
            alert.setHeaderText("Fehler beim Stoppen der Shutdownsequenz");
            alert.setContentText(Arrays.toString(e.getStackTrace()));
        }
    }
}
