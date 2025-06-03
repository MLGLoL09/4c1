package sweigl.view;
import javax.swing.*;
import java.awt.*;

public class FormPanel extends JPanel {
    public static final int CIRCLE = 0;
    public static final int SQUARE = 1;
    public static final int TRIANGLE = 2;

    private int form;
    private java.awt.Color color;
    private boolean filled;
    private boolean shape = false;

    public void setForm(int form) { this.form = form; repaint(); }
    public void setColor(Color color) { this.color = color; repaint(); }
    public void setFilled(boolean filled) { this.filled = filled; repaint(); }

    public FormPanel(int form, Color color, boolean filled) {
        setForm(form);
        setColor(color);
        setFilled(filled);
        setBackground(Color.WHITE);
    }

    public void draw() {
        shape = true;
        repaint();
    }

    public void clear() {
        shape = false;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (!shape) return;
        g.setColor(color);

        int w = getWidth(), h = getHeight();
        int size = Math.min(w, h) - 8;
        int x = (w - size) / 2, y = (h - size) / 2;

        switch (form) {
            case CIRCLE -> {
                if (filled) g.fillOval(x, y, size, size);
                else g.drawOval(x, y, size, size);
            }
            case SQUARE -> {
                if (filled) g.fillRect(x, y, size, size);
                else g.drawRect(x, y, size, size);
            }
            case TRIANGLE -> {
                double triangleHeight = Math.sqrt(3) * size / 2;
                int triangleHeightInt = (int) triangleHeight;

                int leftX = (w - size) / 2;
                int baseLineY = (h + triangleHeightInt) / 2;

                int[] xPoints = { leftX + size / 2, leftX, leftX + size };
                int[] yPoints = { baseLineY - triangleHeightInt, baseLineY, baseLineY };

                if (filled) g.fillPolygon(xPoints, yPoints, 3);
                else g.drawPolygon(xPoints, yPoints, 3);

            }
        }
        g.dispose();
    }
}
