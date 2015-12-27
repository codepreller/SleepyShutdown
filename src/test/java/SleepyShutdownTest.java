/**
 * User: preller
 * Date: 25.12.2015
 */

import logic.SleepyShutdown;
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
    CLIServiceInterface cliServiceInterfaceMock;

    @Before
    public void setUp() {
        cliServiceInterfaceMock = mock(CLIService.class);
        sleepyShutdown = new SleepyShutdown(cliServiceInterfaceMock);
    }

    @Test
    public void testShutdown() throws IOException {
        sleepyShutdown.shutdown(0,0,0);
        verify(cliServiceInterfaceMock).execute(argumentCaptor.capture());
        assertEquals("shutdown /s /t 0", argumentCaptor.getValue());

        sleepyShutdown.shutdown(1,1,1);
        verify(cliServiceInterfaceMock,times(5)).execute(argumentCaptor.capture());
        assertEquals("shutdown /s /t 3661", argumentCaptor.getValue());
    }

    @Test
    public void testStopShutdown() throws IOException {
        sleepyShutdown.stopShutdown();
        verify(cliServiceInterfaceMock).execute(argumentCaptor.capture());
        assertEquals("shutdown /a", argumentCaptor.getValue());
    }
}