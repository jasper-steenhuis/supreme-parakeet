
import java.awt.Graphics;
import java.io.PrintWriter;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author caspe
 */
public abstract class FigureComponent implements Figure {

    int startX;
    int startY;
    int endX;
    int endY;
    public boolean selected;

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }

    public int getEndX() {
        return endX;
    }

    public int getEndY() {
        return endY;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public Strategy getStrategy() {
        throw new UnsupportedOperationException();
    }

    public void draw(Graphics g) {
        throw new UnsupportedOperationException();
    }

    public void add(FigureComponent newFigureComponent) {
        throw new UnsupportedOperationException();
    }

    public void remove(FigureComponent newFigureComponent) {
        throw new UnsupportedOperationException();
    }

    public FigureComponent getComponent(int componentIndex) {
        throw new UnsupportedOperationException();
    }

    public ArrayList getComponents() {
        throw new UnsupportedOperationException();
    }

    public void displayFigureInfo(int depth) {
        throw new UnsupportedOperationException();
    }

    public void move(int deltaX, int deltaY) {
        throw new UnsupportedOperationException();
    }

    public void resize(int deltaX, int deltaY) {
        throw new UnsupportedOperationException();
    }

    public int getWidth() {
        throw new UnsupportedOperationException();
    }

    public int getHeight() {
        throw new UnsupportedOperationException();
    }

    public String getTypeOfFigure() {
        throw new UnsupportedOperationException();
    }

    public int getNumberOfChildren() {
        throw new UnsupportedOperationException();
    }

    public void write(PrintWriter buff, int depth) {
        throw new UnsupportedOperationException();
    }
}
