package service;
/**
 * User: preller
 * Date: 25.12.2015
 */

import java.io.IOException;

public class CLIService implements CLIServiceInterface {

    public void execute(String command) throws IOException {
        Runtime.getRuntime().exec(command);
    }
}
