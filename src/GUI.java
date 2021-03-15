import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class GUI extends JPanel implements MouseListener  {
    int startX, startY, endX, endY;
    Menu menu = new Menu();
    List<Figure> figures = new ArrayList<Figure>();

    public GUI() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("MyGUI");
        frame.pack();
        frame.setSize(600,400);
        frame.setVisible(true);
        frame.add(this, BorderLayout.CENTER);
        frame.setJMenuBar(menu.getMenu());

        addMouseListener(this);
        MouseMotionListener mouseMotionListener = new MouseMotionListener() {
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
        addMouseMotionListener(mouseMotionListener);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        for (Figure figure : figures) {
            switch (figure.getTypeOfFigure()) {
                case "oval" -> g.drawOval(figure.startX, figure.startY, figure.getWidth(), figure.getHeight());
                case "rect" -> g.drawRect(figure.startX, figure.startY, figure.getWidth(), figure.getHeight());
            }
        }

        switch (menu.getSelectedFigure()) {
            case "oval" -> g.drawOval(startX, startY, endX - startX, endY - startY);
            case "rect" -> g.drawRect(startX, startY, endX - startX, endY - startY);
        }
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
        Figure figure = null;
        switch (menu.getSelectedFigure()) {
            case "oval" -> figure = new Figure("oval", startX, startY, endX, endY);
            case "rect" -> figure = new Figure("rect", startX, startY, endX, endY);
        }
        this.figures.add(figure);
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
