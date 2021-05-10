
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
import patternsCode.Ellipse;
import patternsCode.Rectangle;
import patternsCode.Strategy;

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
    public List<Figure> figuresToSave = new ArrayList<Figure>();
    JFrame frame = new JFrame("FileHandler");

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

                } catch (IOException ex)
                {
                    Logger.getLogger(FileHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
                log.append("Opening: " + file.getName() + "." + newLine);
            } else
            {
                log.append("cancelled" + newLine);
            }
        } else
        {
            if (e.getSource() == saveButton)
            {
                int returnVal = fc.showSaveDialog(FileHandler.this);
                if (returnVal == JFileChooser.APPROVE_OPTION)
                {
                    try
                    {
                        SaveToFile();
                    }
                    catch (IOException ex)
                    {
                        Logger.getLogger(FileHandler.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else
                {

                    log.append("cancelled" + newLine);
                }

                log.setCaretPosition(log.getDocument().getLength());
            }
        }
    }

    public void createAndShowGUI() throws IOException
    {
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(new FileHandler(drawPanel));
        frame.pack();
        frame.setVisible(true);
    }

    public void SaveToFile() throws IOException
    {
        PrintWriter buff = null;
        File file = fc.getSelectedFile();

        log.append("Saving: " + file.getName() + " to " + file.getPath() + newLine);
        try
        {
            buff = new PrintWriter(new FileWriter(file.getPath() + ".txt"));
            for (int i = 0; i < drawPanel.rootFigureGroup.getComponents().size(); i++)
            {
                int startX = drawPanel.rootFigureGroup.getComponent(i).getStartX();
                int startY = drawPanel.rootFigureGroup.getComponent(i).getStartY();
                int endX = drawPanel.rootFigureGroup.getComponent(i).getEndX();
                int endY = drawPanel.rootFigureGroup.getComponent(i).getEndY();

                buff.write(drawPanel.rootFigureGroup.getComponent(i).getTypeOfFigure() + " " + i + newLine);
                buff.write(startX + newLine);
                buff.write(startY + newLine);
                buff.write(endX + newLine);
                buff.write(endY + newLine);
                buff.write(newLine);
            }
        } catch (IOException ex)
        {
            Logger.getLogger(FileHandler.class.getName()).log(Level.SEVERE, null, ex);
        } finally
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
        try
        {
            in = new BufferedReader(new FileReader(fileToLoad.getPath()));
            String line = in.readLine();
            String stringToPass = null;
            while ((line = in.readLine()) != null)
            {
                if (!line.isEmpty())
                {

                    if (!line.contains("Ellipse") && !line.contains("Rectangle"))
                    {
                        int i = Integer.parseInt(line.replaceAll("[^0-9]", ""));
                        list.add(i);
                    }
                    if (line.contains("Ellipse") || line.contains("Rectangle"))
                    {
                        stringToPass = line.replaceAll("[^A-Za-z]", "");
                    }
                }
                if (stringToPass != null && list.size() >= 4)
                {
                    ConvertToFigure(list, stringToPass);
                    list.clear();

                }

            }

            line = "";
        } catch (IOException ex)
        {

        }
        frame.dispose();
    }

    public void ConvertToFigure(List<Integer> coords, String FigureType)
    {

        if (coords.size() >= 4)
        {
            int startX = coords.get(0);
            int startY = coords.get(1);
            int endX = coords.get(2);
            int endY = coords.get(3);
            switch (FigureType)
            {
                case "Ellipse":
                    Figure ellipse = new Figure(Ellipse.getInstance(), startX, startY, endX, endY);
                    drawPanel.rootFigureGroup.add(ellipse);
                    break;
                case "Rectangle":
                    Figure rectangle = new Figure(Rectangle.getInstance(), startX, startY, endX, endY);
                    drawPanel.rootFigureGroup.add(rectangle);
                    break;

                default:
                    return;
            }

        }

        drawPanel.paintComponent(drawPanel.gc);
        drawPanel.repaint();
    }

}
