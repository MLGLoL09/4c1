package sweigl.view;
import javax.swing.JFrame;

public class MastermindFrame extends JFrame {
    public MastermindFrame() {
        setTitle("Mastermind");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);

        add(new MastermindLayout());

        setVisible(true);
    }
}
