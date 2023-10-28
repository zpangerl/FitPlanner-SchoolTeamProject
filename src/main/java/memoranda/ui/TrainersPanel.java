package main.java.memoranda.ui;

import main.java.memoranda.util.Local;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;

public class TrainersPanel extends JPanel {
    BorderLayout borderLayout1 = new BorderLayout();
    JToolBar toolBar = new JToolBar();
    JButton newTrainerB = new JButton();
    TrainersTable trainersTable = new TrainersTable();
    JButton removeTrainerB = new JButton();
    JScrollPane scrollPane = new JScrollPane();
    JButton refreshB = new JButton();
    JPopupMenu trainerPPMenu = new JPopupMenu();
    JMenuItem ppRun = new JMenuItem();
    JMenuItem ppRemoveTrainer = new JMenuItem();
    JMenuItem ppNewTrainer = new JMenuItem();
    JMenuItem ppRefresh = new JMenuItem();



    public TrainersPanel() {
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
        newTrainerB.setIcon(
                new ImageIcon(main.java.memoranda.ui.AppFrame.class.getResource("/ui/icons/addresource.png")));
        newTrainerB.setEnabled(true);
        newTrainerB.setMaximumSize(new Dimension(24, 24));
        newTrainerB.setMinimumSize(new Dimension(24, 24));
        newTrainerB.setToolTipText(Local.getString("New trainer"));
        newTrainerB.setRequestFocusEnabled(false);
        newTrainerB.setPreferredSize(new Dimension(24, 24));
        newTrainerB.setFocusable(false);
        newTrainerB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                newTrainerB_actionPerformed(e);
            }
        });
        newTrainerB.setBorderPainted(false);
        trainersTable.setMaximumSize(new Dimension(32767, 32767));
        trainersTable.setRowHeight(24);
        removeTrainerB.setBorderPainted(false);
        removeTrainerB.setFocusable(false);
        removeTrainerB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                removeTrainerB_actionPerformed(e);
            }
        });
        removeTrainerB.setPreferredSize(new Dimension(24, 24));
        removeTrainerB.setRequestFocusEnabled(false);
        removeTrainerB.setToolTipText(Local.getString("Remove trainer"));
        removeTrainerB.setMinimumSize(new Dimension(24, 24));
        removeTrainerB.setMaximumSize(new Dimension(24, 24));
        removeTrainerB.setIcon(
                new ImageIcon(
                        main.java.memoranda.ui.AppFrame.class.getResource("/ui/icons/removeresource.png")));
        scrollPane.getViewport().setBackground(Color.white);

        toolBar.addSeparator(new Dimension(8, 24));
        toolBar.addSeparator(new Dimension(8, 24));

        PopupListener ppListener = new PopupListener();
        scrollPane.addMouseListener(ppListener);
        trainersTable.addMouseListener(ppListener);
        trainersTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                boolean enbl = (trainersTable.getRowCount() > 0) && (trainersTable.getSelectedRow() > -1);

                removeTrainerB.setEnabled(enbl); ppRemoveTrainer.setEnabled(enbl);
                ppRun.setEnabled(enbl);
            }
        });
        refreshB.setBorderPainted(false);
        refreshB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                refreshB_actionPerformed(e);
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
        trainerPPMenu.setFont(new java.awt.Font("Dialog", 1, 10));
        ppRun.setFont(new java.awt.Font("Dialog", 1, 11));
        ppRun.setText(Local.getString("Open resource")+"...");
        ppRun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ppRun_actionPerformed(e);
            }
        });
        ppRun.setEnabled(false);

        ppRemoveTrainer.setFont(new java.awt.Font("Dialog", 1, 11));
        ppRemoveTrainer.setText(Local.getString("Remove trainer"));
        ppRemoveTrainer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ppRemoveRes_actionPerformed(e);
            }
        });
        ppRemoveTrainer.setIcon(new ImageIcon(main.java.memoranda.ui.AppFrame.class.getResource("/ui/icons/removeresource.png")));
        ppRemoveTrainer.setEnabled(false);
        ppNewTrainer.setFont(new java.awt.Font("Dialog", 1, 11));
        ppNewTrainer.setText(Local.getString("New trainer")+"...");
        ppNewTrainer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ppNewTrainer_actionPerformed(e);
            }
        });
        ppNewTrainer.setIcon(new ImageIcon(main.java.memoranda.ui.AppFrame.class.getResource("/ui/icons/addresource.png")));

        ppRefresh.setFont(new java.awt.Font("Dialog", 1, 11));
        ppRefresh.setText(Local.getString("Refresh"));
        ppRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ppRefresh_actionPerformed(e);
            }
        });
        ppRefresh.setIcon(new ImageIcon(main.java.memoranda.ui.AppFrame.class.getResource("/ui/icons/refreshres.png")));

        toolBar.add(newTrainerB, null);
        toolBar.add(removeTrainerB, null);
        toolBar.addSeparator();
        toolBar.add(refreshB, null);
        this.add(scrollPane, BorderLayout.CENTER);
        scrollPane.getViewport().add(trainersTable, null);
        this.add(toolBar, BorderLayout.NORTH);
        trainerPPMenu.add(ppRun);
        trainerPPMenu.addSeparator();
        trainerPPMenu.add(ppNewTrainer);
        trainerPPMenu.add(ppRemoveTrainer);
        trainerPPMenu.addSeparator();
        trainerPPMenu.add(ppRefresh);
        trainersTable.addKeyListener(new KeyListener() {
            public void keyPressed(KeyEvent e){
                if(trainersTable.getSelectedRows().length>0
                        && e.getKeyCode()==KeyEvent.VK_DELETE)
                    ppRemoveRes_actionPerformed(null);
            }
            public void	keyReleased(KeyEvent e){}
            public void keyTyped(KeyEvent e){}
        });
    }
    void newTrainerB_actionPerformed(ActionEvent e) {
        System.out.println("[DEBUG] newResB_actionPerformed");
        // TODO: The resources equivalent of this method is in ResourcesPanel.java
    }
    void removeTrainerB_actionPerformed(ActionEvent e) {
        System.out.println("[DEBUG] removeResB_actionPerformed");
        // TODO: The resources equivalent of this method is in ResourcesPanel.java
    }
    class PopupListener extends MouseAdapter {

        public void mouseClicked(MouseEvent e) {
            // TODO: Equivalent method in TaskPanel.java
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
                trainerPPMenu.show(e.getComponent(), e.getX(), e.getY());
            }
        }

    }
    void ppRun_actionPerformed(ActionEvent e) {

    }
    void ppRefresh_actionPerformed(ActionEvent e) {
        trainersTable.tableChanged();
    }
    void refreshB_actionPerformed(ActionEvent e) {
        trainersTable.tableChanged();
    }
    void ppRemoveRes_actionPerformed(ActionEvent e) {
        removeTrainerB_actionPerformed(e);
    }
    void ppNewTrainer_actionPerformed(ActionEvent e) {
        newTrainerB_actionPerformed(e);
    }

}
