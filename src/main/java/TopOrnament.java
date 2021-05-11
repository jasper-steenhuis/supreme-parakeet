
import java.awt.Graphics;
import java.io.PrintWriter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author caspe
 */
public class TopOrnament extends FigureDecorator {
    public TopOrnament(FigureComponent newOrnament) {
        super(newOrnament);
    }

    @Override
    public String getDescription() {
        return "Ornament top";
    }
    
    @Override
    public void draw(Graphics g) {
        g.drawString(getDescription() + " " + tempOrnament.getTypeOfFigure(), getStartX() + (getWidth() / 2), getStartY() - 10);
    }
    
    @Override
    public void write(PrintWriter buff, int depth) {
        for (int i = 0; i < depth; i++) {
            buff.write("\t");
        }
        buff.write(getDescription() + " \"" + tempOrnament.getTypeOfFigure() + "\"\n");
    }
}
