
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
public class Ellipse implements Strategy 
{
    private String name = "Ellipse";
    private static Ellipse instance = new Ellipse();
    @Override
    public void draw(Graphics g, int startX, int startY, int width, int height)
    {
        g.drawOval(startX, startY, width, height);
    }
    @Override
    public String ObjectToString()
    {
        return instance.name;
    }
    private Ellipse()
    {

    }
    public static Ellipse getInstance()
    {
        return instance;
    } 
}
