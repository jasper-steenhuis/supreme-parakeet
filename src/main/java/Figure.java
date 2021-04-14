
import java.awt.Graphics;
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
    private String typeOfFigure;
    private Strategy strategy;

    public Figure(Strategy strategy, int startX, int startY, int endX, int endY) {
        this.strategy = strategy;
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
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
