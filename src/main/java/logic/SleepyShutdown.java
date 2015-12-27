package logic;
/**
 * User: preller
 * Date: 25.12.2015
 */

import service.CLIServiceInterface;
import java.io.IOException;

public class SleepyShutdown {
    String SHUTDOWN_COMMAND = "shutdown /s /t";
    String STOP_SHUTDOWN_COMMAND = "shutdown /a";
    CLIServiceInterface cliServiceInterface;

    public SleepyShutdown(CLIServiceInterface service) {
        cliServiceInterface = service;
    }

    private int calculateSeconds(int hours, int minutes, int seconds) {
        return (hours * 3600) + (minutes * 60) + seconds;
    }

    public void shutdown(int hours, int minutes, int seconds) throws IOException {
        cliServiceInterface.execute(SHUTDOWN_COMMAND + " " + calculateSeconds(hours,minutes,seconds));
    }

    public void stopShutdown() throws IOException {
        cliServiceInterface.execute(STOP_SHUTDOWN_COMMAND);
    }
}
