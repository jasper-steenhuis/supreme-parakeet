import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class GUI extends JPanel implements MouseListener  {
    int startX, startY, endX, endY;

    public GUI() {
        addMouseListener(this);
        MouseMotionListener mouseMotionListener = new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                endX = e.getX();
                endY = e.getY();
                repaint();
                System.out.println(endX + " " + endY);
            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        };
        addMouseMotionListener(mouseMotionListener);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.drawLine(startX, startY, endX, endY);
        g.drawRect(startX, startY,  endX - startX, endY - startY);
        g.drawOval(startX,startY,endX - startX,endY - startY);
    }

    public static void main(String[] arg) {
        GUI panel = new GUI();
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("MyGUI");
        frame.pack();
        frame.setSize(600,400);
        frame.setVisible(true);
        frame.add(panel, BorderLayout.CENTER);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        startX = e.getX();
        startY = e.getY();
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
