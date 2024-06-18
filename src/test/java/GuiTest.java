import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GuiTest {
    private Gui gui;
    private JFrame frame;

    @BeforeEach
    public void setUp() {
        gui = new Gui();
        frame = gui.frame;
        gui.getRules().resetGame(); // сброс состояния игры перед каждым тестом
    }

    @Test
    public void testGuiInitialization() {
        assertNotNull(frame);
        assertEquals(400, frame.getWidth());
        assertEquals(400, frame.getHeight());
    }

    @Test
    public void testAllButtonsExist() {
        JPanel panel = (JPanel) TestUtils.getChildComponent(frame.getContentPane(), JPanel.class);
        assertNotNull(panel);
        assertEquals(9, panel.getComponentCount());
    }

    @Test
    public void testButtonNamesAndActionListeners() {
        JPanel panel = (JPanel) TestUtils.getChildComponent(frame.getContentPane(), JPanel.class);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton button = (JButton) panel.getComponent(i * 3 + j);
                assertEquals(i + "" + j, button.getName());
                assertNotNull(button.getActionListeners());
                assertEquals(1, button.getActionListeners().length);
            }
        }
    }
}
