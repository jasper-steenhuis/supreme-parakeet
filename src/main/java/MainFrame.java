
import java.awt.Component;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author caspe & Jasper
 */
public class MainFrame extends javax.swing.JFrame
{

    private List<Figure> figures = new ArrayList<Figure>();

    /**
     * Creates new form MainFrame
     */
    public MainFrame()
    {
        initComponents();
        drawPanel.setSelectedTool("Ellipse");
        //figures = drawPanel.figureGroup;
        //fileHandler.figuresToSave = drawPanel.figures;

        jTree1.setModel(drawPanel.model);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        toolButtonGroup = new javax.swing.ButtonGroup();
        drawPanel = new DrawPanel();
        moveButton = new javax.swing.JRadioButton();
        jRadioButtonRect = new javax.swing.JRadioButton();
        jRadioButtonOval = new javax.swing.JRadioButton();
        selectButton = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jButtonGroup = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        resizebtn = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout drawPanelLayout = new javax.swing.GroupLayout(drawPanel);
        drawPanel.setLayout(drawPanelLayout);
        drawPanelLayout.setHorizontalGroup(
            drawPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        drawPanelLayout.setVerticalGroup(
            drawPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        toolButtonGroup.add(moveButton);
        moveButton.setLabel("Move");
        moveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Move(evt);
            }
        });

        toolButtonGroup.add(jRadioButtonRect);
        jRadioButtonRect.setText("Rectangle");
        jRadioButtonRect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonRectActionPerformed(evt);
            }
        });

        toolButtonGroup.add(jRadioButtonOval);
        jRadioButtonOval.setSelected(true);
        jRadioButtonOval.setText("Oval");
        jRadioButtonOval.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonOvalActionPerformed(evt);
            }
        });

        toolButtonGroup.add(selectButton);
        selectButton.setText("Select");
        selectButton.setActionCommand("select");
        selectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectButtonActionPerformed(evt);
            }
        });

        jTree1.setExpandsSelectedPaths(false);
        jScrollPane1.setViewportView(jTree1);

        jButtonGroup.setText("Group");
        jButtonGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGroupActionPerformed(evt);
            }
        });

        saveButton.setText("File");
        toolButtonGroup.add(saveButton);
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        toolButtonGroup.add(resizebtn);
        resizebtn.setText("Resize");
        resizebtn.setActionCommand("select");
        resizebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resizebtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(drawPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jRadioButtonOval)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButtonRect)
                        .addGap(18, 18, 18)
                        .addComponent(selectButton)
                        .addGap(18, 18, 18)
                        .addComponent(moveButton)
                        .addGap(14, 14, 14)
                        .addComponent(resizebtn)
                        .addGap(14, 14, 14)
                        .addComponent(jButtonGroup)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(saveButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButtonOval)
                            .addComponent(jRadioButtonRect)
                            .addComponent(jButtonGroup)
                            .addComponent(saveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(resizebtn)
                            .addComponent(selectButton)
                            .addComponent(moveButton))
                        .addGap(30, 30, 30)
                        .addComponent(drawPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButtonOvalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonOvalActionPerformed
        // TODO add your handling code here:
        drawPanel.setSelectedTool("Ellipse");
    }//GEN-LAST:event_jRadioButtonOvalActionPerformed

    private void jRadioButtonRectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonRectActionPerformed
        // TODO add your handling code here:
        drawPanel.setSelectedTool("Rectangle");
    }//GEN-LAST:event_jRadioButtonRectActionPerformed

    private void Move(java.awt.event.ActionEvent evt)//GEN-FIRST:event_Move
    {//GEN-HEADEREND:event_Move
        // TODO add your handling code here:
        drawPanel.setSelectedTool("Move");
    }//GEN-LAST:event_Move

    private void selectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectButtonActionPerformed
        // TODO add your handling code here:
        drawPanel.setSelectedTool("Select");
    }//GEN-LAST:event_selectButtonActionPerformed

    private void jButtonGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGroupActionPerformed
        // TODO add your handling code here:
        drawPanel.group();
    }//GEN-LAST:event_jButtonGroupActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_saveButtonActionPerformed
    {//GEN-HEADEREND:event_saveButtonActionPerformed

        FileGUI fileGUI = new FileGUI(new FileHandler(drawPanel));
        fileGUI.execute();
    }//GEN-LAST:event_saveButtonActionPerformed

    private void resizebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resizebtnActionPerformed
        drawPanel.setSelectedTool("Resize");
    }//GEN-LAST:event_resizebtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private DrawPanel drawPanel;
    private javax.swing.JButton jButtonGroup;
    private javax.swing.JRadioButton jRadioButtonOval;
    private javax.swing.JRadioButton jRadioButtonRect;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTree jTree1;
    private javax.swing.JRadioButton moveButton;
    private javax.swing.JRadioButton resizebtn;
    private javax.swing.JButton saveButton;
    private javax.swing.JRadioButton selectButton;
    private javax.swing.ButtonGroup toolButtonGroup;
    // End of variables declaration//GEN-END:variables
}
