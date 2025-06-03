package sweigl.view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sweigl.view.*;

public class MastermindLayout extends JPanel {
    private static final int ROWS = 2, COLS = 5;
    private final int[] forms = { FormPanel.CIRCLE, FormPanel.SQUARE, FormPanel.TRIANGLE, FormPanel.SQUARE, FormPanel.CIRCLE };
    private final FormPanel[][] pan = new FormPanel[COLS][ROWS];

    public MastermindLayout() {
        setLayout(new BorderLayout(10, 10));

        JPanel eingabe = new JPanel(new GridLayout(1, 5, 5, 5));
        for (int i = 0; i < 5; i++) {
            JTextField tf = new JTextField();
            tf.setHorizontalAlignment(JTextField.CENTER);
            tf.setFont(new Font("Arial", Font.PLAIN, 20));
            tf.setHorizontalAlignment(JTextField.CENTER);
            eingabe.add(tf);
        }
        add(eingabe, BorderLayout.NORTH);

        JPanel buttons = new JPanel();
        buttons.setLayout(new BoxLayout(buttons, BoxLayout.Y_AXIS));
        JButton button1 = new JButton("Check");
        buttons.add(button1);
        buttons.add(Box.createVerticalStrut(5));
        JButton button2 = new JButton("Neu");
        buttons.add(button2);
        buttons.add(Box.createVerticalStrut(5));
        JButton button3 = new JButton("Lösung");
        buttons.add(button3);
        add(buttons, BorderLayout.EAST);

        JLabel statusLabel = new JLabel("Gewonnen, du hast meine Zahlen erraten!", JLabel.CENTER);
        add(statusLabel, BorderLayout.SOUTH);

        JPanel formsAtScreen = new JPanel(new GridLayout(ROWS, COLS));
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                Color col =(r == 0 ? Color.GREEN : Color.ORANGE);
                boolean filled = (r == 0);
                FormPanel f = new FormPanel(forms[c], col, filled);
                pan[c][r] = f;
                formsAtScreen.add(f);
            }
        }
        add(formsAtScreen, BorderLayout.CENTER);

        class ButtonKlickListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch(e.getActionCommand()) {
                    case "Check" -> {
                        for (int i = 0; i < ROWS; i++) {
                            for (int c = 0; c < COLS; c++) {
                                pan[c][i].clear();
                            }
                        }
                    }
                    case "Neu" -> {
                        for (int i = 0; i < COLS; i++) {
                            pan[i][0].draw();
                        }
                    }
                    case "Lösung" -> {
                        for (int i = 0; i < COLS; i++) {
                            pan[i][1].draw();
                        }
                    }
                }
            }
        }
        ButtonKlickListener listener = new ButtonKlickListener();
        button1.addActionListener(listener);
        button2.addActionListener(listener);
        button3.addActionListener(listener);
    }
}
