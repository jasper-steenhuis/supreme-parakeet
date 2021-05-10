
import java.awt.Graphics;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Jasper
 */
public interface Strategy
{
    void draw(Graphics g, int startX, int startY, int width, int height);
    String ObjectToString();
}
