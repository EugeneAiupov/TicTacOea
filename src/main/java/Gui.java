import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Gui {
    public JFrame frame;
    private TicTacLogic rules;

    public Gui() {
        frame = new JFrame();
        JPanel panel = new JPanel();
        rules = new TicTacLogic();
        panel.setLayout(new java.awt.GridLayout(3, 3));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                final JButton button = new JButton();
                String string = i + "" + j;
                button.setText("");
                button.setName(string);
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        rules.buttonClicked(button);
                        rules.gameRules(button);
                    }
                });
                button.setFont(new Font("Arial", Font.PLAIN, 40));
                button.setBorder(BorderFactory.createLineBorder(Color.GREEN));
                panel.add(button);
            }
        }
        frame.add(panel);
        frame.setSize(400, 400);
        frame.setVisible(true);
    }

    public TicTacLogic getRules() {
        return rules;
    }
}
