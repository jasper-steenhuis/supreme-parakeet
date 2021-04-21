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
public class Group implements Strategy
{
    private String name = "Group";
    private static Group instance = new Group();
    @Override
    public void draw()
    {

    }
    @Override
    public String ObjectToString()
    {
        return instance.name;
    }
    private Group()
    {

    }
    public static Group getInstance()
    {
        return instance;
    } 
}
