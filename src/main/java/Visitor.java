

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author caspe
 */
public interface Visitor {

    public void visit(Ellipse ellipse);
    public void visit(Rectangle rectangle);
    public void visit(Ornament ornament);
}
