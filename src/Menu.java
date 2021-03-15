import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu implements ActionListener {
    private String selectedFigure = "oval";

    public Menu()
    {

    }

    //'builds' and returns the menu
    public JMenuBar getMenu(){
        //buttons
        JRadioButton ovalButton = new JRadioButton("Oval");
        ovalButton.setSelected(true);
        ovalButton.setActionCommand("oval");
        ovalButton.addActionListener(this);

        JRadioButton rectButton = new JRadioButton("Rect");
        rectButton.setSelected(false);
        rectButton.setActionCommand("rect");
        rectButton.addActionListener(this);

        //Makes the group only select one
        ButtonGroup group = new ButtonGroup();
        group.add(ovalButton);
        group.add(rectButton);

        //Makes a bar at the top
        JMenuBar menu = new JMenuBar();
        menu.add(ovalButton);
        menu.add(rectButton);

        return menu;
    }

    //get called if a radio button is clicked
    public void actionPerformed(ActionEvent e) {
        this.selectedFigure = e.getActionCommand();
    }

    public String getSelectedFigure() {
        return this.selectedFigure;
    }
}
