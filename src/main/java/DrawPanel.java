
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.event.TreeModelEvent;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import patternsCode.Ellipse;
import patternsCode.Group;
import patternsCode.Rectangle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in
    private String selectedTool = "Oval";
    int nodeIndex = 0;
    public Graphics gc; the editor.
 */
/**
 *
 * @author caspe & Jasper
 */
public class DrawPanel extends javax.swing.JPanel
{

    private int startX, startY, endX, endY;
    private int oldEndX, oldEndY;
    public List<Figure> figures = new ArrayList<Figure>();
    public DefaultMutableTreeNode root = new DefaultMutableTreeNode("Figures");
    public TreeModel model = new DefaultTreeModel(root);
    public TreeModelEvent t;
    private String selectedTool = "Oval";
    int nodeIndex = 0;
    public Graphics gc;

    /**
     * Creates new form DrawPanel
     */
    public DrawPanel()
    {
        initComponents();

    }

    public void draw(Graphics g, List<Figure> figures)
    {
        for (Figure figure : figures)
        {
            if (figure.selected)
            {
                g.setColor(Color.RED);
                if (selectedTool == "Move")
                {
                    int deltaX = endX - oldEndX;
                    int deltaY = endY - oldEndY;
                    figure.startX += deltaX;
                    figure.startY += deltaY;
                    figure.endX += deltaX;
                    figure.endY += deltaY;
                }
                if (selectedTool == "Resize") 
                {
                    int deltaX = endX - oldEndX;
                    int deltaY = endY - oldEndY;
                    figure.endX += deltaX;
                    figure.endY += deltaY;
                }
            } else
            {
                g.setColor(Color.BLACK);
            }
            switch (figure.getTypeOfFigure())
            {
                case "Ellipse":
                    g.drawOval(figure.startX, figure.startY, figure.getWidth(), figure.getHeight());
                    break;
                case "Rectangle":
                    g.drawRect(figure.startX, figure.startY, figure.getWidth(), figure.getHeight());
                    break;
                case "Group":
                    this.draw(g, figure.figures);
                    break;
                case "Move":
                    System.out.println("Move tool selected");
                    break;
                case "Resize":
                    System.out.println("Resize tool selected");
                    break;
                case "Select":
                    System.out.println("Select tool selected");
                    break;
                default:
                    System.out.println("No tool selected");
            }
            if (this.selectedTool == "Select")
            {
                if (figure.endX < endX && figure.endY < endY && figure.startX > startX && figure.startY > startY)
                {
                    figure.selected = true;
                } else
                {
                    figure.selected = false;
                }
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        gc = g;
        super.paintComponent(gc); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Repaint");
        for (Figure figure : figures)
        {
            System.out.println(figure.getTypeOfFigure());
        }

        draw(gc, figures);

        switch (this.selectedTool)
        {
            case "Ellipse":
                g.drawOval(startX, startY, endX - startX, endY - startY);
                break;
            case "Rectangle":
                g.drawRect(startX, startY, endX - startX, endY - startY);
                break;
            case "Move":
                System.out.println("Move tool selected");
                break;
            case "Resize":
                System.out.println("Resize tool selected");
                break;
            case "Select":
                g.setColor(Color.BLUE);
                g.drawRect(startX, startY, endX - startX, endY - startY);
                break;
            default:
                System.out.println("No tool selected");
        }

        oldEndX = endX;
        oldEndY = endY;
    }

    public void setSelectedTool(String tool)
    {
        this.selectedTool = tool;
    }

    public void group()
    {
        ArrayList<Figure> arrayListGroup = new ArrayList<Figure>();
        int startX = 0, startY = 0, endX = 0, endY = 0;
        for (Iterator<Figure> it = figures.iterator(); it.hasNext();)
        {
            Figure figure = it.next();
            if (figure.selected)
            {
                arrayListGroup.add(figure);
                it.remove();
            }
        }
        Figure figureGroup = new Figure(Group.getInstance(), arrayListGroup);
        figures.add(figureGroup);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        if (selectedTool == "Ellipse" || selectedTool == "Rectangle" || selectedTool == "Select" || selectedTool == "Move" || selectedTool == "Resize")
        {
            endX = evt.getX();
            endY = evt.getY();
            repaint();
        }
    }//GEN-LAST:event_formMouseDragged

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        if (selectedTool == "Ellipse" || selectedTool == "Rectangle" || selectedTool == "Select" || selectedTool == "Move")
        {
            startX = evt.getX();
            startY = evt.getY();
            repaint();
        }
    }//GEN-LAST:event_formMousePressed

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased

        Figure figure = new Figure(null, 0, 0, 0, 0);
        switch (this.selectedTool)
        {
            case "Ellipse":
                figure = new Figure(Ellipse.getInstance(), startX, startY, endX, endY);
                this.figures.add(figure);
                break;
            case "Rectangle":
                figure = new Figure(Rectangle.getInstance(), startX, startY, endX, endY);
                this.figures.add(figure);
                break;
            case "Move":
                System.out.println("Move tool selected");
                break;
            case "Resize":
                System.out.println("Resize tool selected");
                break;
            case "Select":
                System.out.println("Select tool selected");
                break;
            default:
                System.out.println("No tool selected");
        }
        System.out.println(figures.size());
        createNodes(root, figure);

    }//GEN-LAST:event_formMouseReleased

    private void createNodes(DefaultMutableTreeNode top, Figure fig)
    {
        if (fig.getTypeOfFigure() != null)
        {
            DefaultMutableTreeNode child = new DefaultMutableTreeNode(fig.getTypeOfFigure() + " " + nodeIndex);
            top.add(child);
            nodeIndex++;
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
