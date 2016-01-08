package logic; /**
 * User: preller
 * Date: 25.12.2015
 */

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import service.CLIServiceInterface;
import service.CLIService;

import java.io.IOException;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class SleepyShutdownTest {
    ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
    SleepyShutdown sleepyShutdown;
    CLIServiceInterface cliServiceMock;

    @Before
    public void setUp() {
        cliServiceMock = mock(CLIService.class);
        sleepyShutdown = new SleepyShutdown(cliServiceMock);
    }

    @Test
    public void testShutdown() throws IOException {
        sleepyShutdown.shutdown(0,0,0);
        verify(cliServiceMock, times(1)).execute(argumentCaptor.capture());
        assertEquals("shutdown /s /t 0", argumentCaptor.getValue());

        sleepyShutdown.shutdown(1,1,1);
        verify(cliServiceMock, times(2)).execute(argumentCaptor.capture());
        assertEquals("shutdown /s /t 3661", argumentCaptor.getValue());
    }

    @Test
    public void testStopShutdown() throws IOException {
        sleepyShutdown.stopShutdown();
        verify(cliServiceMock).execute(argumentCaptor.capture());
        assertEquals("shutdown /a", argumentCaptor.getValue());
    }
}