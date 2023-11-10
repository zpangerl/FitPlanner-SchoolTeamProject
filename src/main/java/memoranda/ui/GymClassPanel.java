package main.java.memoranda.ui;

import main.java.memoranda.util.Local;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import java.awt.*;
import java.awt.event.*;
/*
  File:	GymClassPanel.java
  Author: Rhett Harrison
  Version: 2023.11.09

  Description: Simple GymClass panel to display add button and rows of GymClass(es)
*/


public class GymClassPanel extends JPanel {
    BorderLayout borderLayout1 = new BorderLayout();
    JToolBar toolBar = new JToolBar();
    JButton newClassB = new JButton();
    GymClassTable gymClassTable = new GymClassTable();
    JButton removeResB = new JButton();
    JScrollPane scrollPane = new JScrollPane();
    JButton refreshB = new JButton();
    JPopupMenu classPPMenu = new JPopupMenu();
    JMenuItem ppRun = new JMenuItem();
    JMenuItem ppRemoveClass = new JMenuItem();
    JMenuItem ppNewClass = new JMenuItem();
    JMenuItem ppRefresh = new JMenuItem();

    public GymClassPanel() {
        try {
            jbInit();
        }
        catch (Exception ex) {
            new ExceptionDialog(ex);
        }
    }

    void jbInit() throws Exception {
        toolBar.setFloatable(false);
        this.setLayout(borderLayout1);
        newClassB.setIcon(
                new ImageIcon(main.java.memoranda.ui.AppFrame.class.getResource("/ui/icons/addresource.png")));
        newClassB.setEnabled(true);
        newClassB.setMaximumSize(new Dimension(24, 24));
        newClassB.setMinimumSize(new Dimension(24, 24));
        newClassB.setToolTipText(Local.getString("New class"));
        newClassB.setRequestFocusEnabled(false);
        newClassB.setPreferredSize(new Dimension(24, 24));
        newClassB.setFocusable(false);
        newClassB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                newClassB_actionPerformed(e);
            }
        });
        newClassB.setBorderPainted(false);
        gymClassTable.setMaximumSize(new Dimension(32767, 32767));
        gymClassTable.setRowHeight(24);
        removeResB.setBorderPainted(false);
        removeResB.setFocusable(false);
        removeResB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                removeResB_actionPerformed(e);
            }
        });
        removeResB.setPreferredSize(new Dimension(24, 24));
        removeResB.setRequestFocusEnabled(false);
        removeResB.setToolTipText(Local.getString("Remove class"));
        removeResB.setMinimumSize(new Dimension(24, 24));
        removeResB.setMaximumSize(new Dimension(24, 24));
        removeResB.setIcon(
                new ImageIcon(
                        main.java.memoranda.ui.AppFrame.class.getResource("/ui/icons/removeresource.png")));
        removeResB.setEnabled(false);
        scrollPane.getViewport().setBackground(Color.white);
        toolBar.addSeparator(new Dimension(8, 24));
        toolBar.addSeparator(new Dimension(8, 24));
        PopupListener ppListener = new PopupListener();
        scrollPane.addMouseListener(ppListener);
        gymClassTable.addMouseListener(ppListener);

        gymClassTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                boolean enable = (gymClassTable.getRowCount() > 0) && (gymClassTable.getSelectedRow() > -1);
                removeResB.setEnabled(enable);
                ppRemoveClass.setEnabled(enable);
            }
        });

        refreshB.setBorderPainted(false);
        refreshB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                refreshB_actionPerformed(e);
            }
        });
        refreshB.setFocusable(false);
        refreshB.setPreferredSize(new Dimension(24, 24));
        refreshB.setRequestFocusEnabled(false);
        refreshB.setToolTipText(Local.getString("Refresh"));
        refreshB.setMinimumSize(new Dimension(24, 24));
        refreshB.setMaximumSize(new Dimension(24, 24));
        refreshB.setEnabled(true);
        refreshB.setIcon(
                new ImageIcon(main.java.memoranda.ui.AppFrame.class.getResource("/ui/icons/refreshres.png")));
        classPPMenu.setFont(new java.awt.Font("Dialog", 1, 10));
        ppRun.setFont(new java.awt.Font("Dialog", 1, 11));
        ppRun.setText(Local.getString("Open class")+"...");

        ppRun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ppRun_actionPerformed(e);
            }
        });
        ppRun.setEnabled(false);

        ppRemoveClass.setFont(new java.awt.Font("Dialog", 1, 11));
        ppRemoveClass.setText(Local.getString("Remove class"));

        ppRemoveClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {

                ppRemoveClass_actionPerformed(e);
            }
        });
        ppRemoveClass.setIcon(new ImageIcon(main.java.memoranda.ui.AppFrame.class.getResource("/ui/icons/removeresource.png")));
        ppRemoveClass.setEnabled(false);
        ppNewClass.setFont(new java.awt.Font("Dialog", 1, 11));
        ppNewClass.setText(Local.getString("New class")+"...");

        ppNewClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {

                ppNewClass_actionPerformed(e);
            }
        });
        ppNewClass.setIcon(new ImageIcon(main.java.memoranda.ui.AppFrame.class.getResource("/ui/icons/addresource.png")));

        ppRefresh.setFont(new java.awt.Font("Dialog", 1, 11));
        ppRefresh.setText(Local.getString("Refresh"));
        ppRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {

                ppRefresh_actionPerformed(e);
            }
        });
        ppRefresh.setIcon(new ImageIcon(main.java.memoranda.ui.AppFrame.class.getResource("/ui/icons/refreshres.png")));

        toolBar.add(newClassB, null);
        toolBar.add(removeResB, null);
        toolBar.addSeparator();
        toolBar.add(refreshB, null);
        this.add(scrollPane, BorderLayout.CENTER);
        scrollPane.getViewport().add(gymClassTable, null);
        this.add(toolBar, BorderLayout.NORTH);
        classPPMenu.add(ppRun);
        classPPMenu.addSeparator();
        classPPMenu.add(ppNewClass);
        classPPMenu.add(ppRemoveClass);
        classPPMenu.addSeparator();
        classPPMenu.add(ppRefresh);
        // remove class using the DEL key
        gymClassTable.addKeyListener(new KeyListener() {
            public void keyPressed(KeyEvent e){
                if(gymClassTable.getSelectedRows().length>0
                        && e.getKeyCode()==KeyEvent.VK_DELETE)
                    ppRemoveClass_actionPerformed(null);
            }
            public void	keyReleased(KeyEvent e){}
            public void keyTyped(KeyEvent e){}
        });

        scrollPane.getViewport().setBackground(Color.white);
    }

    private void ppRefresh_actionPerformed(ActionEvent e) {

    }

    private void ppNewClass_actionPerformed(ActionEvent e) {

    }

    private void ppRemoveClass_actionPerformed(Object o) {

    }

    /**
     * Class to handle mouse events
     */

    class PopupListener extends MouseAdapter {

        public void mouseClicked(MouseEvent e) {
            //editTaskB_actionPerformed(null);
        }

        public void mousePressed(MouseEvent e) {
            maybeShowPopup(e);
        }

        public void mouseReleased(MouseEvent e) {
            maybeShowPopup(e);
        }

        private void maybeShowPopup(MouseEvent e) {
            if (e.isPopupTrigger()) {
                classPPMenu.show(e.getComponent(), e.getX(), e.getY());
            }
        }

    }

    /**
     * Refresh the table
     * ? Not sure if this event param is needed yet
     * @param event event to be consumed
     */
    void refreshB_actionPerformed(ActionEvent event) {
        gymClassTable.tableChanged(new TableModelEvent(gymClassTable.getModel()));
    }

    /**
     *
     * @param event event to be consumed
     */
    void ppRun_actionPerformed(ActionEvent event) {

    }

    /**
     * Remove the selected class
     * @param event event to be consumed
     */
    private void removeClassB_actionPerformed(ActionEvent event) {
        // Remove the selected class
    }

}
