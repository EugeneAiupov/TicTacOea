import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JButton;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TicTacLogicTest {
    private TicTacLogic logic;
    private JButton button;

    @BeforeEach
    public void setUp() {
        logic = new TicTacLogic();
        button = new JButton();
        logic.resetGame(); // сброс состояния игры перед каждым тестом
    }

    @Test
    public void testButtonClicked() {
        button.setText("");
        logic.buttonClicked(button);
        assertEquals("O", button.getText()); // Первый ход - "O"

        button = new JButton();
        logic.buttonClicked(button);
        assertEquals("X", button.getText()); // Второй ход - "X"
    }

    @Test
    public void testGameRulesWinDiagonal() {
        JButton button1 = new JButton("X");
        button1.setName("00");
        JButton button2 = new JButton("X");
        button2.setName("11");
        JButton button3 = new JButton("X");
        button3.setName("22");

        logic.buttonClicked(button1);
        logic.buttonClicked(button2);
        logic.buttonClicked(button3);
        logic.gameRules(button1);
        logic.gameRules(button2);
        logic.gameRules(button3);

        assertFalse(logic.test); // игра должна закончиться
    }

    @Test
    public void testGameRulesDraw() {
        // Заполнение поля без победителей
        String[] moves = { "O", "X", "O", "X", "X", "O", "O", "O", "X" };
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton btn = new JButton(moves[i * 3 + j]);
                btn.setName(i + "" + j);
                logic.buttonClicked(btn);
                logic.gameRules(btn);
            }
        }
        assertTrue(logic.test); // игра должна закончиться
    }
}
