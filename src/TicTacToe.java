import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
public class TicTacToe implements ActionListener{

    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel titlePanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JLabel textField = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean playerXTurn;

    TicTacToe(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
//        frame.setTitle("Tic Tac Toe");
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        textField.setBackground(new Color(25, 25, 25));
        textField.setForeground(new Color(25, 255, 0));
        textField.setFont(new Font("Ink Free", Font.BOLD, 75));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("Tic Tac Toe");
        textField.setOpaque(true);
        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBounds(0, 0, 800, 100);
        buttonPanel.setLayout(new GridLayout(3, 3));
        buttonPanel.setBackground(new Color(150, 150, 150));

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            buttonPanel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            buttons[i].setFocusable(false);
//            buttons[i].setBackground(new Color(25, 25, 25));
//            buttons[i].setForeground(new Color(255, 255, 255));
            buttons[i].addActionListener(this);

        }
        titlePanel.add(textField);
        frame.add(titlePanel, BorderLayout.NORTH);
        frame.add(buttonPanel);
        firstTurn();
    }

    // Handle button click events here
    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i]) {
                if (playerXTurn) {
                    if (buttons[i].getText().equals("")) {
                        buttons[i].setForeground(new Color(255, 0, 0));
                        buttons[i].setText("X");
                        playerXTurn = false;
                        textField.setText("O's Turn");
                        check();
                    }
                }
                else{
                    if (buttons[i].getText().equals("")) {
                        buttons[i].setForeground(new Color(0, 0, 255));
                        buttons[i].setText("O");
                        playerXTurn = true;
                        textField.setText("X's Turn");
                        check();
                    }
                }
            }
        }
        check();
    }

    // Logic for the first turn of the game
    public void firstTurn(){
        try{
            Thread.sleep(2000); // Wait for 2 seconds before starting the game
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (random.nextInt(2) == 0) {
            playerXTurn = true;
            textField.setText("X's Turn");
        } else {
            playerXTurn = false;
            textField.setText("O's Turn");
        }
    }

    public void check(){
        //Check for X win conditions
        if ((buttons[0].getText().equals("X") && buttons[1].getText().equals("X") && buttons[2].getText().equals("X"))) {
            xWins(0, 1, 2);
        }
        if ((buttons[3].getText().equals("X") && buttons[4].getText().equals("X") && buttons[5].getText().equals("X"))) {
            xWins(3, 4, 5);
        }
        if ((buttons[6].getText().equals("X") && buttons[7].getText().equals("X") && buttons[8].getText().equals("X"))) {
            xWins(6, 7, 8);
        }
        if ((buttons[0].getText().equals("X") && buttons[3].getText().equals("X") && buttons[6].getText().equals("X"))) {
            xWins(0, 3, 6);
        }
        if ((buttons[1].getText().equals("X") && buttons[4].getText().equals("X") && buttons[7].getText().equals("X"))) {
            xWins(1, 4, 7);
        }
        if ((buttons[2].getText().equals("X") && buttons[5].getText().equals("X") && buttons[8].getText().equals("X"))) {
            xWins(2, 5, 8);
        }
        if ((buttons[0].getText().equals("X") && buttons[4].getText().equals("X") && buttons[8].getText().equals("X"))) {
            xWins(0, 4, 8);
        }
        if ((buttons[2].getText().equals("X") && buttons[4].getText().equals("X") && buttons[6].getText().equals("X"))) {
            xWins( 2, 4, 6);
        }

//Check for O win conditions
        if ((buttons[0].getText().equals("O") && buttons[1].getText().equals("O") && buttons[2].getText().equals("O"))) {
            oWins(0, 1, 2);
        }
        if ((buttons[3].getText().equals("O") && buttons[4].getText().equals("O") && buttons[5].getText().equals("O"))) {
            oWins(3, 4, 5);
        }
        if ((buttons[6].getText().equals("O") && buttons[7].getText().equals("O") && buttons[8].getText().equals("O"))) {
            oWins(6, 7, 8);
        }
        if ((buttons[0].getText().equals("O") && buttons[3].getText().equals("O") && buttons[6].getText().equals("O"))) {
            oWins(0, 3, 6);
        }
        if ((buttons[1].getText().equals("O") && buttons[4].getText().equals("O") && buttons[7].getText().equals("O"))) {
            oWins(1, 4, 7);
        }
        if ((buttons[2].getText().equals("O") && buttons[5].getText().equals("O") && buttons[8].getText().equals("O"))) {
            oWins(2, 5, 8);
        }
        if ((buttons[0].getText().equals("O") && buttons[4].getText().equals("O") && buttons[8].getText().equals("O"))) {
            oWins(0, 4, 8);
        }
        if ((buttons[2].getText().equals("O") && buttons[4].getText().equals("O") && buttons[6].getText().equals("O"))) {
            oWins( 2, 4, 6);
        }

        // Draw condition
        boolean draw = true;
        for (JButton button : buttons) {
            if (button.getText().equals("")) {
                draw = false;
                break;
            }
        }

        if (draw) {
            textField.setText("It's a Draw!");
            for (JButton button : buttons) {
                button.setEnabled(false);
            }
        }
    }

    public void xWins(int a, int b, int c) {
        // Logic to handle when player X wins
       buttons[a].setBackground(Color.GREEN);
       buttons[b].setBackground(Color.GREEN);
       buttons[c].setBackground(Color.GREEN);

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false); // Disable all buttons
        }
        textField.setText("X wins!");
    }

    public void oWins(int a, int b, int c) {
        // Logic to handle when player O wins
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false); // Disable all buttons
        }
        textField.setText("O wins!");
    }
}
