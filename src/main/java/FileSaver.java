/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author steen
 */
public class FileSaver
{

    public FileSaver()
    {

    }

    public void Save(List<Figure> figuresToSave) throws IOException
    {
        PrintWriter buff = null;

        try
        {
            buff = new PrintWriter(new FileWriter("src/main/java/coords.txt"));
            for (int i = 0; i < figuresToSave.size(); i++)
            {
                int startX = figuresToSave.get(i).startX;
                int startY = figuresToSave.get(i).startY;
                int endX = figuresToSave.get(i).endX;
                int endY = figuresToSave.get(i).endY;

                buff.write(figuresToSave.get(i).getTypeOfFigure() + " " + i + "\n");
                buff.write("startX: " + startX + "\n");
                buff.write("startY: " + startY + "\n");
                buff.write("endX: " + endX + "\n");
                buff.write("endY: " + endY + "\n");
                buff.write("\n");
            }
        }
        finally
        {
            if (buff != null)
            {
                buff.close();
            }
        }
    }

    private DrawPanel drawpanel;

}
