import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui {
    public Gui(){
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        TicTacLogic rules = new TicTacLogic();
        panel.setLayout(new java.awt.GridLayout(3, 3));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                final JButton button = new JButton();
                String string = i+""+j;
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
        frame.setSize(400,400);
        frame.setVisible(true);
    }
}
