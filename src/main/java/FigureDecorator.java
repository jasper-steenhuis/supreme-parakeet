
import java.awt.Graphics;
import java.io.PrintWriter;
import java.util.Iterator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author caspe
 */
abstract class FigureDecorator extends FigureComponent implements Figure {
    protected FigureComponent tempOrnament;
    
    public FigureDecorator(FigureComponent newOrnament) {
        tempOrnament = newOrnament;
    }
    
    public int getStartX() {
        return tempOrnament.startX;
    }

    public int getStartY() {
        return tempOrnament.startY;
    }
    
    
    public int getWidth() {
        return tempOrnament.endX - tempOrnament.startX;
    }

    public int getHeight() {
        return tempOrnament.endY - tempOrnament.startY;
    }
    
    @Override
    public void displayFigureInfo(int depth) {
        System.out.println(getTypeOfFigure() + " depth: " + depth);
    }   
}
