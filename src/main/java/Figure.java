
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
public class Figure {

    public int startX;
    public int startY;
    public int endX;
    public int endY;
    public boolean selected;
    public ArrayList<Figure> figures;
    private String typeOfFigure;
    private Strategy strategy;

    public Figure(Strategy strategy, int startX, int startY, int endX, int endY) {
        this.strategy = strategy;
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.selected = false;
    }
    
    public Figure(Strategy strategy, ArrayList<Figure> figures) {
        this.strategy = strategy;
        this.startX = 0;
        this.startY = 0;
        this.endX = 0;
        this.endY = 0;
        this.selected = false;
        this.figures = figures;
    }

    public int getWidth() {
        return this.endX - this.startX;
    }

    public int getHeight() {
        return this.endY - this.startY;
    }

    public String getTypeOfFigure() {
        return strategy.ObjectToString();
    }
    
    
}
