import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BotTest {
    private Gui gui;
    private JFrame frame;
    private JPanel panel;

    @BeforeEach
    public void setUp() {
        gui = new Gui();
        frame = gui.frame;
        panel = (JPanel) TestUtils.getChildComponent(frame.getContentPane(), JPanel.class);
        gui.getRules().resetGame(); // сброс состояния игры перед каждым тестом
    }

    @Test
    public void testBotMoves() {
        // Имитируем нажатие кнопок, как если бы это делал бот
        for (int i = 0; i < 9; i++) {
            JButton button = (JButton) panel.getComponent(i);
            button.doClick();
        }

        // Проверяем, что игра закончилась
        assertFalse(gui.getRules().test, "Game should end after 9 moves"); // игра должна закончиться после 9 ходов
    }
}
