/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patternsCode;

/**
 *
 * @author Jasper
 */
public class Rectangle implements Strategy
{

    private String name = "Rectangle";
    private static Rectangle instance = new Rectangle();

    @Override
    public void draw()
    {

    }

    @Override
    public String ObjectToString()
    {
        return instance.name;
    }

    private Rectangle()
    {

    }

    public static Rectangle getInstance()
    {
        return instance;
    }

}
