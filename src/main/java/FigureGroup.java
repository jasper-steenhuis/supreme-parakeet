/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author caspe
 */
import java.awt.Graphics;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

public class FigureGroup extends FigureComponent {

    ArrayList figureComponents = new ArrayList();
    String groupName;

    public FigureGroup(String newGroupName) {
        groupName = newGroupName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void add(FigureComponent newFigureComponent) {
        int newEndX = newFigureComponent.getEndX();
        int newEndY = newFigureComponent.getEndY();
        int newStartX = newFigureComponent.getStartX();
        int newStartY = newFigureComponent.getStartY();

        endX = endX > newEndX ? newEndX : endX;
        endY = endY > newEndY ? newEndY : endY;
        startX = startX < newStartX ? newStartX : startX;
        startY = startY < newStartY ? newStartY : startY;

        figureComponents.add(newFigureComponent);
    }

    public void remove(FigureComponent newFigureComponent) {
        figureComponents.remove(newFigureComponent);
    }

    public FigureComponent getComponent(int componentIndex) {
        return (FigureComponent) figureComponents.get(componentIndex);
    }

    public ArrayList getComponents() {
        return figureComponents;
    }

    public void displayFigureInfo(int depth) {
        System.out.println(getGroupName() + " depth: " + depth);
        Iterator figureIterator = figureComponents.iterator();
        depth++;
        while (figureIterator.hasNext()) {
            FigureComponent figureInfo = (FigureComponent) figureIterator.next();
            figureInfo.displayFigureInfo(depth);
        }
    }

    public int getNumberOfChildren() {
        return figureComponents.size();
    }

    public String getTypeOfFigure() {
        return "Group";
    }

    public void write(PrintWriter buff, int depth) {
        for (int i = 0; i < depth; i++) {
            buff.write("\t");
        }
        buff.write(getTypeOfFigure() + " " + getNumberOfChildren() + "\n");
        depth++;
        for (int i = 0; i < getComponents().size(); i++) {
            getComponent(i).write(buff, depth);
        }
    }

    public void draw(Graphics g) {
        for (int i = 0; i < getComponents().size(); i++) {
            getComponent(i).draw(g);
        }
    }
}
