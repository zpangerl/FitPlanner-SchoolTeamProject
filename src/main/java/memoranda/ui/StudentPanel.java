package main.java.memoranda.ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import main.java.memoranda.*;
import main.java.memoranda.util.*;

public class StudentPanel extends JPanel {
    BorderLayout borderLayout1 = new BorderLayout();
    JToolBar toolBar = new JToolBar();
    JButton newStudentB = new JButton();
    //StudentTable studentsTable = new StudentTable();
    JTable studentTable;// = new JTable();
    JButton removeStudentB = new JButton();
    JScrollPane scrollPane = new JScrollPane();
    JButton refreshB = new JButton();
    JPopupMenu studentPopUpMenu = new JPopupMenu();
    JMenuItem popUpRun = new JMenuItem();
    JMenuItem popUpRemoveStudent = new JMenuItem();
    JMenuItem popUpNewStudent = new JMenuItem();
    JMenuItem popUpRefresh = new JMenuItem();
    StudentListImpl studentList = new StudentListImpl();
    int tableIndexSelected = -1;
    Object[][] data = new Object[0][0];
    String[] columnNames = {
        "First Name",
        "Last Name",
        "Age",
        "Belt Rank",
        "Training Rank"
    };
    DefaultTableModel dtm = new DefaultTableModel(data, columnNames);

    /**
     * Student Panel constructor.
     */
    public StudentPanel() {
        try {
            jbInit();
        } catch (Exception ex) {
            new ExceptionDialog(ex);
        }
    }

    void jbInit() throws Exception {
        toolBar.setFloatable(false);
        this.setLayout(borderLayout1);
        newStudentB.setIcon(
                new ImageIcon(
                        main
                                .java
                                .memoranda
                                .ui
                                .AppFrame
                                .class
                                .getResource("/ui/icons/addresource.png")));
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

        // Static demo data for testing.
        // TODO: Implement reading student list from file.

        data = updateStudentTable();
        //studentTable = new JTable(data, columnNames);
        dtm = new DefaultTableModel(data, columnNames);
        JTable studentTable = new JTable(dtm);
        studentTable.setLayout(new GridLayout(2,0));
        //table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        studentTable.setFillsViewportHeight(true);
        studentTable.setMaximumSize(new Dimension(32767, 32767));
        studentTable.setRowHeight(24);
        studentTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                int y = (int) e.getPoint().getY();
                Point point = new Point(20, y);
                int b = studentTable.rowAtPoint(point);
                if (b < 0) {
                    studentTable.clearSelection();
                    studentTable.updateUI();
                    tableIndexSelected = -1;
                } else {
                    tableIndexSelected = b;
                }
            }
        });

        removeStudentB.setBorderPainted(false);
        removeStudentB.setFocusable(false);
        removeStudentB.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (tableIndexSelected < 0) {
                    return;
                }
                JPanel panel = new JPanel();
                panel.setSize(new Dimension(200, 100));
                panel.setLayout(null);
                JLabel label1 = new JLabel("This will permanently remove the student.");
                label1.setVerticalAlignment(SwingConstants.BOTTOM);
                label1.setBounds(20, 20, 260, 30);
                label1.setHorizontalAlignment(SwingConstants.CENTER);
                panel.add(label1);
                JLabel label2 = new JLabel("Do you still want to delete it?");
                label2.setVerticalAlignment(SwingConstants.TOP);
                label2.setHorizontalAlignment(SwingConstants.CENTER);
                label2.setBounds(20, 80, 260, 30);
                panel.add(label2);
                UIManager.put("OptionPane.minimumSize", new Dimension(330, 200));
                int res = JOptionPane.showConfirmDialog(null, panel, "Delete Student",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.PLAIN_MESSAGE);
                if (res == 0) {
                    studentList.removeStudent(studentList.getStudentByIndex(tableIndexSelected));
                    data = updateStudentTable();
                    dtm.setDataVector(data, columnNames);
                    tableIndexSelected = -1;
                }
            }
        });
        removeStudentB.setPreferredSize(new Dimension(24, 24));
        removeStudentB.setRequestFocusEnabled(false);
        removeStudentB.setToolTipText(Local.getString("Remove Student"));
        removeStudentB.setMinimumSize(new Dimension(24, 24));
        removeStudentB.setMaximumSize(new Dimension(24, 24));
        removeStudentB.setIcon(
                new ImageIcon(
                        main
                                .java
                                .memoranda
                                .ui
                                .AppFrame
                                .class
                                .getResource("/ui/icons/removeresource.png")));
        scrollPane.getViewport().setBackground(Color.white);

        toolBar.addSeparator(new Dimension(8, 24));
        toolBar.addSeparator(new Dimension(8, 24));

        StudentPanel.PopupListener ppListener = new StudentPanel.PopupListener();
        scrollPane.getViewport().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
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
                new ImageIcon(main
                        .java
                        .memoranda
                        .ui
                        .AppFrame
                        .class
                        .getResource("/ui/icons/refreshres.png")));
        studentPopUpMenu.setFont(new java.awt.Font("Dialog", 1, 10));
        popUpRun.setFont(new java.awt.Font("Dialog", 1, 11));
        popUpRun.setText(Local.getString("Open resource") + "...");
        popUpRun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ppRun_actionPerformed(e);
            }
        });
        popUpRun.setEnabled(false);

        popUpRemoveStudent.setFont(new java.awt.Font("Dialog", 1, 11));
        popUpRemoveStudent.setText(Local.getString("Remove Student"));
        /*
        ppRemoveStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ppRemoveRes_actionPerformed(e);
            }
        });

         */
        popUpRemoveStudent.setIcon(new ImageIcon(main
                .java
                .memoranda
                .ui
                .AppFrame
                .class
                .getResource("/ui/icons/removeresource.png")));
        popUpRemoveStudent.setEnabled(false);
        popUpNewStudent.setFont(new java.awt.Font("Dialog", 1, 11));
        popUpNewStudent.setText(Local.getString("New Student") + "...");
        popUpNewStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ppNewStudent_actionPerformed(e);
            }
        });
        popUpNewStudent.setIcon(new ImageIcon(main
                .java
                .memoranda
                .ui
                .AppFrame
                .class
                .getResource("/ui/icons/addresource.png")));

        popUpRefresh.setFont(new java.awt.Font("Dialog", 1, 11));
        popUpRefresh.setText(Local.getString("Refresh"));
        popUpRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ppRefresh_actionPerformed(e);
            }
        });
        popUpRefresh.setIcon(new ImageIcon(main
                .java
                .memoranda
                .ui
                .AppFrame
                .class
                .getResource("/ui/icons/refreshres.png")));

        toolBar.add(newStudentB, null);
        toolBar.add(removeStudentB, null);
        toolBar.addSeparator();
        toolBar.add(refreshB, null);
        this.add(scrollPane, BorderLayout.CENTER);
        scrollPane.getViewport().add(studentTable, null);
        this.add(toolBar, BorderLayout.NORTH);
        studentPopUpMenu.add(popUpRun);
        studentPopUpMenu.addSeparator();
        studentPopUpMenu.add(popUpNewStudent);
        studentPopUpMenu.add(popUpRemoveStudent);
        studentPopUpMenu.addSeparator();
        studentPopUpMenu.add(popUpRefresh);
        /*
        studentTable.addKeyListener(new KeyListener() {
            public void keyPressed(KeyEvent e) {
                if (studentTable.getSelectedRows().length > 0
                        && e.getKeyCode() == KeyEvent.VK_DELETE)
                    ppRemoveRes_actionPerformed(null);
            }

            public void keyReleased(KeyEvent e) {
            }

            public void keyTyped(KeyEvent e) {
            }
        });

         */
    }

    /**
     * New student button clicked. Launch add student dialog.
     * @param e New student button click event.
     */
    void newStudentB_actionPerformed(ActionEvent e) {
        AddStudentDialog dlg = new AddStudentDialog(App.getFrame(), Local.getString("New Student"));
        Dimension frmSize = App.getFrame().getSize();
        Point loc = App.getFrame().getLocation();
        dlg.setLocation(
                (frmSize.width - dlg.getSize().width) / 2
                        + loc.x,
                (frmSize.height - dlg.getSize().height) / 2
                        + loc.y);
        dlg.setVisible(true);
        if (dlg.isCanceled) {
            return;
        } else {
            studentList.addStudent(dlg.getStudent());
            data = updateStudentTable();
            dtm.setDataVector(data, columnNames);
            tableIndexSelected = -1;
        }
    }

    /**
     * Update the UI table with current student data.
     * @return Double array of object, student data.
     */
    public Object[][] updateStudentTable() {
        int count = studentList.getAllStudentCount();
        Object[][] data = new Object[count][columnNames.length];
        for (int i = 0; i < count; i++) {
            Student student = studentList.getStudentByIndex(i);
            data[i][0] = student.getFirstName();
            data[i][1] = student.getLastName();
            data[i][2] = student.getAge();
            data[i][3] = student.getBeltRank();
            data[i][4] = student.getTrainingRank();
        }
        return data;
    }

    class PopupListener extends MouseAdapter {

        public void mouseClicked(MouseEvent e) {

        }

        public void mousePressed(MouseEvent e) {
            maybeShowPopup(e);
        }

        public void mouseReleased(MouseEvent e) {
            maybeShowPopup(e);
        }

        private void maybeShowPopup(MouseEvent e) {
            if (e.isPopupTrigger()) {
                studentPopUpMenu.show(e.getComponent(), e.getX(), e.getY());
            }
        }

    }

    void ppRun_actionPerformed(ActionEvent e) {

    }

    void ppRefresh_actionPerformed(ActionEvent e) {
        //studentsTable.tableChanged();
    }

    void refreshB_actionPerformed(ActionEvent e) {
        //studentTable.tableChanged();
    }

    /*
    void ppRemoveRes_actionPerformed(ActionEvent e) {
        removeStudentB_actionPerformed(e);
    }
    */
    void ppNewStudent_actionPerformed(ActionEvent e) {
        newStudentB_actionPerformed(e);
    }
}

