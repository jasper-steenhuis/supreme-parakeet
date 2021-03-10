import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI extends JPanel implements MouseListener {
    Label l;
    public GUI() {
        addMouseListener(this);
        l = new Label();
        l.setBounds(0, 0, 100, 20);
        add(l);
    }

    public void mouseClicked(MouseEvent e) {
        l.setText("Mouse Clicked");
    }

    public void mouseEntered(MouseEvent e) {
        l.setText("Mouse Entered");
    }

    public void mouseExited(MouseEvent e) {
        l.setText("Mouse Exited");
    }

    public void mousePressed(MouseEvent e) {
        l.setText("Mouse Pressed");
    }

    public void mouseReleased(MouseEvent e) {
        l.setText("Mouse Released");
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.drawRect(100,10,30,40);
        g.fillRect(10,10,20,10);
        g.setColor(Color.BLUE);
        g.drawOval(100,100,50,50);
        g.fillOval(100,200,50,50);
        g.setColor(Color.BLACK);
        g.drawLine(10, 10, 30, 70);
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
}