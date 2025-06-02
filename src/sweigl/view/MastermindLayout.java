package sweigl.view;
import javax.swing.*;

public class MastermindLayout {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Mastermind Layout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
      
        frame.add(panel);
        frame.setVisible(true);

    }
}
