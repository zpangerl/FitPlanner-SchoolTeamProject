package main.java.memoranda.ui;

import main.java.memoranda.util.Local;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;

public class StudentPanel extends JPanel {
    BorderLayout borderLayout1 = new BorderLayout();
    JToolBar toolBar = new JToolBar();
    JButton newStudentB = new JButton();
    TrainersTable studentsTable = new TrainersTable();
    JButton removeStudentB = new JButton();
    JScrollPane scrollPane = new JScrollPane();
    JButton refreshB = new JButton();
    JPopupMenu studentPPMenu = new JPopupMenu();
    JMenuItem ppRun = new JMenuItem();
    JMenuItem ppRemoveStudent = new JMenuItem();
    JMenuItem ppNewStudent = new JMenuItem();
    JMenuItem ppRefresh = new JMenuItem();



    public StudentPanel() {
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
        newStudentB.setIcon(
                new ImageIcon(main.java.memoranda.ui.AppFrame.class.getResource("/ui/icons/student_48.png")));
        newStudentB.setEnabled(true);
        newStudentB.setMaximumSize(new Dimension(24, 24));
        newStudentB.setMinimumSize(new Dimension(24, 24));
        newStudentB.setToolTipText(Local.getString("New Student"));
        newStudentB.setRequestFocusEnabled(false);
        newStudentB.setPreferredSize(new Dimension(24, 24));
        newStudentB.setFocusable(false);
        newStudentB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                newStudentB_actionPerformed(e);
            }
        });
        newStudentB.setBorderPainted(false);

        studentsTable.setMaximumSize(new Dimension(32767, 32767));
        studentsTable.setRowHeight(24);

        removeStudentB.setBorderPainted(false);
        removeStudentB.setFocusable(false);
        removeStudentB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                removeStudentB_actionPerformed(e);
            }
        });
        removeStudentB.setPreferredSize(new Dimension(24, 24));
        removeStudentB.setRequestFocusEnabled(false);
        removeStudentB.setToolTipText(Local.getString("Remove Student"));
        removeStudentB.setMinimumSize(new Dimension(24, 24));
        removeStudentB.setMaximumSize(new Dimension(24, 24));
        removeStudentB.setIcon(
                new ImageIcon(
                        main.java.memoranda.ui.AppFrame.class.getResource("/ui/icons/removeresource.png")));
        scrollPane.getViewport().setBackground(Color.white);

        toolBar.addSeparator(new Dimension(8, 24));
        toolBar.addSeparator(new Dimension(8, 24));

        StudentPanel.PopupListener ppListener = new StudentPanel.PopupListener();
        scrollPane.addMouseListener(ppListener);
        studentsTable.addMouseListener(ppListener);
        studentsTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                boolean enbl = (studentsTable.getRowCount() > 0) && (studentsTable.getSelectedRow() > -1);

                removeStudentB.setEnabled(enbl); ppRemoveStudent.setEnabled(enbl);
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
        studentPPMenu.setFont(new java.awt.Font("Dialog", 1, 10));
        ppRun.setFont(new java.awt.Font("Dialog", 1, 11));
        ppRun.setText(Local.getString("Open resource")+"...");
        ppRun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ppRun_actionPerformed(e);
            }
        });
        ppRun.setEnabled(false);

        ppRemoveStudent.setFont(new java.awt.Font("Dialog", 1, 11));
        ppRemoveStudent.setText(Local.getString("Remove Student"));
        ppRemoveStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ppRemoveRes_actionPerformed(e);
            }
        });
        ppRemoveStudent.setIcon(new ImageIcon(main.java.memoranda.ui.AppFrame.class.getResource("/ui/icons/removeresource.png")));
        ppRemoveStudent.setEnabled(false);
        ppNewStudent.setFont(new java.awt.Font("Dialog", 1, 11));
        ppNewStudent.setText(Local.getString("New Student")+"...");
        ppNewStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ppNewStudent_actionPerformed(e);
            }
        });
        ppNewStudent.setIcon(new ImageIcon(main.java.memoranda.ui.AppFrame.class.getResource("/ui/icons/addresource.png")));

        ppRefresh.setFont(new java.awt.Font("Dialog", 1, 11));
        ppRefresh.setText(Local.getString("Refresh"));
        ppRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ppRefresh_actionPerformed(e);
            }
        });
        ppRefresh.setIcon(new ImageIcon(main.java.memoranda.ui.AppFrame.class.getResource("/ui/icons/refreshres.png")));

        toolBar.add(newStudentB, null);
        toolBar.add(removeStudentB, null);
        toolBar.addSeparator();
        toolBar.add(refreshB, null);
        this.add(scrollPane, BorderLayout.CENTER);
        scrollPane.getViewport().add(studentsTable, null);
        this.add(toolBar, BorderLayout.NORTH);
        studentPPMenu.add(ppRun);
        studentPPMenu.addSeparator();
        studentPPMenu.add(ppNewStudent);
        studentPPMenu.add(ppRemoveStudent);
        studentPPMenu.addSeparator();
        studentPPMenu.add(ppRefresh);
        studentsTable.addKeyListener(new KeyListener() {
            public void keyPressed(KeyEvent e){
                if(studentsTable.getSelectedRows().length>0
                        && e.getKeyCode()==KeyEvent.VK_DELETE)
                    ppRemoveRes_actionPerformed(null);
            }
            public void	keyReleased(KeyEvent e){}
            public void keyTyped(KeyEvent e){}
        });
    }
    void newStudentB_actionPerformed(ActionEvent e) {
        System.out.println("[DEBUG] newResB_actionPerformed");
        // TODO: The resources equivalent of this method is in ResourcesPanel.java
    }
    void removeStudentB_actionPerformed(ActionEvent e) {
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
                studentPPMenu.show(e.getComponent(), e.getX(), e.getY());
            }
        }

    }
    void ppRun_actionPerformed(ActionEvent e) {

    }
    void ppRefresh_actionPerformed(ActionEvent e) {
        studentsTable.tableChanged();
    }
    void refreshB_actionPerformed(ActionEvent e) {
        studentsTable.tableChanged();
    }
    void ppRemoveRes_actionPerformed(ActionEvent e) {
        removeStudentB_actionPerformed(e);
    }
    void ppNewStudent_actionPerformed(ActionEvent e) {
        newStudentB_actionPerformed(e);
    }

}
