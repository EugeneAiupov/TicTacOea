import javax.swing.JButton;
import javax.swing.JOptionPane;

public class TicTacLogic {
    public static int count = 0;
    public static String[][] board = new String[3][3];
    public boolean test = true;

    public void buttonClicked(JButton button) {
        if (test) {
            if (button.getText().equals("")) {
                count++;
                if (count % 2 == 0) {
                    button.setText("X");
                } else {
                    button.setText("O");
                }
            }
        }
    }

    public void gameRules(JButton button) {
        if (test) {
            // X or O
            String string = button.getText();

            // gives coordinates
            int x = Character.getNumericValue(button.getName().charAt(0));
            int y = Character.getNumericValue(button.getName().charAt(1));
            board[x][y] = string;

            if (checkWin(string)) {
                JOptionPane.showMessageDialog(null, string + " won");
                test = false;
            } else if (count == 9) {
                JOptionPane.showMessageDialog(null, " draw");
                test = false;
            }
        }
    }

    private boolean checkWin(String player) {
        // Check diagonals
        if (board[0][0] != null && board[0][0].equals(player) &&
                board[1][1] != null && board[1][1].equals(player) &&
                board[2][2] != null && board[2][2].equals(player)) {
            return true;
        }
        if (board[0][2] != null && board[0][2].equals(player) &&
                board[1][1] != null && board[1][1].equals(player) &&
                board[2][0] != null && board[2][0].equals(player)) {
            return true;
        }
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != null && board[i][0].equals(player) &&
                    board[i][1] != null && board[i][1].equals(player) &&
                    board[i][2] != null && board[i][2].equals(player)) {
                return true;
            }
            if (board[0][i] != null && board[0][i].equals(player) &&
                    board[1][i] != null && board[1][i].equals(player) &&
                    board[2][i] != null && board[2][i].equals(player)) {
                return true;
            }
        }
        return false;
    }

    public void resetGame() {
        count = 0;
        board = new String[3][3];
        test = true;
    }
}
