
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author steen
 */
public class FileGUI implements Command
{

    FileHandler fileHandler;

    public FileGUI(FileHandler fileHandler)
    {
        this.fileHandler = fileHandler;
    }

    @Override
    public void execute()
    {
        try
        {
            fileHandler.createAndShowGUI();
        }
        catch (IOException ex)
        {
            Logger.getLogger(FileGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
