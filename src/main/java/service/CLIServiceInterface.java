package service;
/**
 * User: preller
 * Date: 25.12.2015
 */

import java.io.IOException;

public interface CLIServiceInterface {
    void execute(String command) throws IOException;
}
