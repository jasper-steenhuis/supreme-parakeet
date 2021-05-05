
import java.io.*;
import java.io.IOException;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author steen
 */
public class FileHandler extends JPanel implements ActionListener
{

    static private final String newLine = "\n";
    JButton openButton;
    JButton saveButton;
    JTextArea log;
    JFileChooser fc;
    public DrawPanel drawPanel;
    public List<Figure> figuresToSave;

    public FileHandler(DrawPanel drawPanel)
    {
        super(new BorderLayout());
        this.drawPanel = drawPanel;
        log = new JTextArea(5, 20);
        log.setMargin(new Insets(5, 5, 5, 5));
        log.setEditable(false);
        JScrollPane logScrollPane = new JScrollPane(log);

        fc = new JFileChooser();

        openButton = new JButton("Open file");
        openButton.addActionListener(this);

        saveButton = new JButton("Save");
        saveButton.addActionListener(this);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(openButton);
        buttonPanel.add(saveButton);
        add(buttonPanel, BorderLayout.PAGE_START);
        add(logScrollPane, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == openButton)
        {
            int returnVal = fc.showOpenDialog(FileHandler.this);
            if (returnVal == JFileChooser.APPROVE_OPTION)
            {
                File file = fc.getSelectedFile();
                try
                {
                    LoadFromFile(file);
                }
                catch (IOException ex)
                {
                    Logger.getLogger(FileHandler.class.getName()).log(Level.SEVERE, null, ex);
                }

                log.append("Opening: " + file.getName() + "." + newLine);
            }
            else
            {
                log.append("cancelled" + newLine);
            }
        }
        else
        {
            if (e.getSource() == saveButton)
            {
                int returnVal = fc.showSaveDialog(FileHandler.this);
                if (returnVal == JFileChooser.APPROVE_OPTION)
                {
                    try
                    {
                        SaveToFile(figuresToSave);
                    }
                    catch (IOException ex)
                    {
                        Logger.getLogger(FileHandler.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else
                {
                    log.append("cancelled" + newLine);
                }
                log.setCaretPosition(log.getDocument().getLength());
            }
        }
    }

    public void createAndShowGUI() throws IOException
    {
        JFrame frame = new JFrame("FileHandler");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new FileHandler(drawPanel));
        frame.pack();
        frame.setVisible(true);
    }

    public void SaveToFile(List<Figure> figuresToSave) throws IOException
    {
        figuresToSave = drawPanel.figures;
        PrintWriter buff = null;
        File file = fc.getSelectedFile();

        log.append("Saving: " + file.getName() + " to " + file.getPath() + newLine);
        try
        {
            buff = new PrintWriter(new FileWriter(file.getPath() + ".txt"));
            for (int i = 0; i < figuresToSave.size(); i++)
            {
                int startX = figuresToSave.get(i).startX;
                int startY = figuresToSave.get(i).startY;
                int endX = figuresToSave.get(i).endX;
                int endY = figuresToSave.get(i).endY;

                buff.write(figuresToSave.get(i).getTypeOfFigure() + " " + i + "\n");
                buff.write(startX + "\n");
                buff.write(startY + "\n");
                buff.write(endX + "\n");
                buff.write(endY + "\n");
                buff.write("\n");
            }
        }
        catch (IOException ex)
        {
            Logger.getLogger(FileHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            if (buff != null)
            {
                buff.close();
            }
        }
    }

    public void LoadFromFile(File fileToLoad) throws IOException
    {
        //figuresToSave.clear();
        List<Integer> list = new ArrayList<Integer>();
        BufferedReader in = null;
        int startX = 0;
        int startY = 0;
        int endX = 0;
        int endY = 0;

        try
        {
            in = new BufferedReader(new FileReader(fileToLoad.getPath()));
            String line = in.readLine();
            while ((line = in.readLine()) != null)
            {
                if (!line.isEmpty())
                {
                    int i = Integer.parseInt(line.replaceAll("[^0-9]", ""));
                    list.add(i);
                }

            }
        }
        catch (IOException ex)
        {

        }
    }

}
