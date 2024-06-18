import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class LoadSpeedTest {
    @Test
    public void testLoadSpeed() {
        long startTime = System.currentTimeMillis();
        Gui game = new Gui();
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        assertTrue(duration < 1000, "Load time is too long");
    }
}
