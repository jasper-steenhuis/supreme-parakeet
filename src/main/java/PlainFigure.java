
import java.awt.Graphics;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author caspe & Jasper
 */
public class PlainFigure extends FigureComponent implements Figure {

    private Strategy strategy;

    public PlainFigure(Strategy strategy, int startX, int startY, int endX, int endY) {
        this.strategy = strategy;
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        selected = false;
    }
    
    public PlainFigure(Strategy strategy) {
        this.strategy = strategy;
    }


    public int getWidth() {
        return endX - startX;
    }

    public int getHeight() {
        return endY - startY;
    }
    
    public Strategy getStrategy() {
        return strategy;
    }

    public String getTypeOfFigure() {
        return strategy.ObjectToString();
    }

    public void displayFigureInfo(int depth) {
        System.out.println(getTypeOfFigure() + " depth: " + depth);
    }

    public void move(int deltaX, int deltaY) {
        startX += deltaX;
        startY += deltaY;
        endX += deltaX;
        endY += deltaY;
    }

    public void resize(int deltaX, int deltaY) {
        endX += deltaX;
        endY += deltaY;
    }

    public void write(PrintWriter buff, int depth) {
        for (int i = 0; i < depth; i++) {
            buff.write("\t");
        }
        buff.write(getTypeOfFigure() + " " + startX + " " + startY + " " + getWidth() + " " + getHeight() + "\n");
    }

    public void draw(Graphics g) {
        strategy.draw(g, getStartX(), getStartY(), getWidth(), getHeight());
    }

    @Override
    public String getDescription() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
