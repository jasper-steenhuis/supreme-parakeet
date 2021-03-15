import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Frame extends JFrame implements MouseListener {
    int startX, startY, endX, endY;

    public void Frame() {
        new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                endX = e.getX();
                endY = e.getY();
                repaint();
            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        };
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.RED);
        g.drawRect(100,10,30,40);
        g.fillRect(10,10,20,10);
        g.setColor(Color.red);
        g.drawLine(100, 100, 200, 300);
        g.drawLine(startX, startY, endX, endY);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        startX = endX = e.getX();
        startY = endY = e.getY();
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
