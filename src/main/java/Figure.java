
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import patternsCode.Strategy;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author caspe & Jasper
 */
public class Figure extends FigureComponent {
    private Strategy strategy;

    public Figure(Strategy strategy, int startX, int startY, int endX, int endY) {
        this.strategy = strategy;
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        selected = false;
    }

    public int getWidth() {
        return endX - startX;
    }

    public int getHeight() {
        return endY - startY;
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
}
