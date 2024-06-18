import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    @Test
    public void testMain() {
        Gui game = new Gui();
        assertNotNull(game);
    }
}
