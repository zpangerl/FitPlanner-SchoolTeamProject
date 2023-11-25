package main.java.memoranda.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import main.java.memoranda.GymClass;
import main.java.memoranda.GymClassList;
import main.java.memoranda.Room.GymRoom;
import main.java.memoranda.Trainer;
import main.java.memoranda.TrainerList;
import main.java.memoranda.date.CalendarDate;
import main.java.memoranda.date.CurrentDate;
import main.java.memoranda.util.Local;
/*
 * File: GymClassPanel.java
 * Author: Rhett Harrison
 * Version: 2023.11.09
 * Description: Simple GymClass panel to display add button and rows of GymClass(es)
 */

public class GymClassPanel extends JPanel {
    BorderLayout borderLayout1 = new BorderLayout();
    JToolBar toolBar = new JToolBar();
    JButton newClassB = new JButton();
    GymClassTable gymClassTable = new GymClassTable();
    JButton removeClassB = new JButton();
    JScrollPane scrollPane = new JScrollPane();
    JButton refreshB = new JButton();
    JButton editClassB = new JButton();
    JPopupMenu classPopUpMenu = new JPopupMenu();
    JMenuItem ppRun = new JMenuItem();
    JMenuItem ppRemoveClass = new JMenuItem();
    JMenuItem ppNewClass = new JMenuItem();
    JMenuItem ppRefresh = new JMenuItem();

    // Components for adding a student to a class
    JButton addStudentB = new JButton();
    JMenuItem ppAddStudent = new JMenuItem();

    /**
     * Default constructor.
     */
    public GymClassPanel() {
        try {
            jbInit();
        } catch (Exception ex) {
            new ExceptionDialog(ex);
        }
    }

    void jbInit() throws Exception {
        toolBar.setFloatable(false);
        this.setLayout(borderLayout1);

        // New Class Button
        newClassB.setIcon(
                new ImageIcon(
                        main.java.memoranda.ui.AppFrame.class
                                .getResource(
                                        "/ui/icons/class_new.png")));
        newClassB.setEnabled(true);
        newClassB.setMaximumSize(new Dimension(24, 24));
        newClassB.setMinimumSize(new Dimension(24, 24));
        newClassB.setToolTipText(Local.getString("New class"));
        newClassB.setRequestFocusEnabled(false);
        newClassB.setPreferredSize(new Dimension(24, 24));
        newClassB.setFocusable(false);
        newClassB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                newClassB_actionPerformed();
            }
        });
        newClassB.setBorderPainted(false);

        gymClassTable.setMaximumSize(new Dimension(32767, 32767));
        gymClassTable.setRowHeight(24);

        // Remove class button
        removeClassB.setBorderPainted(false);
        removeClassB.setFocusable(false);
        removeClassB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                removeClassB_actionPerformed();
            }
        });
        removeClassB.setPreferredSize(new Dimension(24, 24));
        removeClassB.setRequestFocusEnabled(false);
        removeClassB.setToolTipText(Local.getString("Remove class"));
        removeClassB.setMinimumSize(new Dimension(24, 24));
        removeClassB.setMaximumSize(new Dimension(24, 24));
        removeClassB.setIcon(
                new ImageIcon(
                        main.java.memoranda.ui.AppFrame.class
                                .getResource(
                                        "/ui/icons/removeresource.png")));
        removeClassB.setEnabled(false);

        // Add student to class button
        addStudentB.setBorderPainted(false);
        addStudentB.setFocusable(false);
        addStudentB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addStudentB_actionPerformed();
            }
        });
        addStudentB.setPreferredSize(new Dimension(24, 24));
        addStudentB.setRequestFocusEnabled(false);
        addStudentB.setToolTipText(Local.getString("Add student to class"));
        addStudentB.setMinimumSize(new Dimension(24, 24));
        addStudentB.setMaximumSize(new Dimension(24, 24));
        addStudentB.setIcon(
                new ImageIcon(
                        main.java.memoranda.ui.AppFrame.class
                                .getResource(
                                        "/ui/icons/addstudenttoclass.png")));
        addStudentB.setEnabled(false);

        scrollPane.getViewport().setBackground(Color.white);
        toolBar.addSeparator(new Dimension(8, 24));
        toolBar.addSeparator(new Dimension(8, 24));
        PopupListener ppListener = new PopupListener();
        scrollPane.addMouseListener(ppListener);
        gymClassTable.addMouseListener(ppListener);

        gymClassTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                boolean enable = (gymClassTable.getRowCount() > 0)
                        && (gymClassTable.getSelectedRow() > -1);
                removeClassB.setEnabled(enable);
                ppRemoveClass.setEnabled(enable);

                // Enable the add student button if a class is selected
                addStudentB.setEnabled(enable);
            }
        });

        // Refresh data button
        refreshB.setBorderPainted(false);
        refreshB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                refreshB_actionPerformed();
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
                new ImageIcon(main.java.memoranda.ui.AppFrame.class
                        .getResource(
                                "/ui/icons/refreshres.png")));

        // Edit class button
        editClassB.setBorderPainted(false);
        editClassB.setFocusable(false);
        editClassB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                editClassB_actionPerformed();
            }
        });
        editClassB.setPreferredSize(new Dimension(24, 24));
        editClassB.setRequestFocusEnabled(false);
        editClassB.setToolTipText(Local.getString("Edit class"));
        editClassB.setMinimumSize(new Dimension(24, 24));
        editClassB.setMaximumSize(new Dimension(24, 24));
        editClassB.setIcon(
                new ImageIcon(
                        main.java.memoranda.ui.AppFrame.class
                                .getResource(
                                        "/ui/icons/edit_pencil.png")));
        editClassB.setEnabled(true);

        // Remove class menu item
        ppRemoveClass.setFont(new java.awt.Font("Dialog", 1, 11));
        ppRemoveClass.setText(Local.getString("Remove class"));

        ppRemoveClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                removeClassB_actionPerformed();
            }
        });
        ppRemoveClass.setIcon(
                new ImageIcon(
                        main.java.memoranda.ui.AppFrame.class
                                .getResource(
                                        "/ui/icons/removeresource.png")));
        ppRemoveClass.setEnabled(false);

        // New class menu item
        ppNewClass.setFont(new java.awt.Font("Dialog", 1, 11));
        ppNewClass.setText(Local.getString("New class") + "...");

        ppNewClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ppNewClass_actionPerformed(e);
            }
        });
        ppNewClass.setIcon(new ImageIcon(
                main.java.memoranda.ui.AppFrame.class
                        .getResource(
                                "/ui/icons/class_new.png")));

        // Add student to class menu item
        ppAddStudent.setFont(new java.awt.Font("Dialog", 1, 11));
        ppAddStudent.setText(Local.getString("Add student") + "...");
        ppAddStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ppAddStudent_actionPerformed(e);
            }
        });
        ppAddStudent.setIcon(new ImageIcon(
                main.java.memoranda.ui.AppFrame.class
                        .getResource(
                                "/ui/icons/addstudenttoclass.png")));
        ppAddStudent.setEnabled(false);

        // Refresh menu item
        ppRefresh.setFont(new java.awt.Font("Dialog", 1, 11));
        ppRefresh.setText(Local.getString("Refresh"));
        ppRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ppRefresh_actionPerformed(e);
            }
        });
        ppRefresh.setIcon(new ImageIcon(
                main.java.memoranda.ui.AppFrame.class
                        .getResource(
                                "/ui/icons/refreshres.png")));

        toolBar.add(newClassB, null);
        toolBar.add(removeClassB, null);
        toolBar.add(addStudentB, null);
        toolBar.addSeparator();
        toolBar.add(refreshB, null);
        toolBar.add(editClassB, null);
        this.add(scrollPane, BorderLayout.CENTER);
        scrollPane.getViewport().add(gymClassTable, null);
        this.add(toolBar, BorderLayout.NORTH);
        classPopUpMenu.add(ppRun);
        classPopUpMenu.addSeparator();
        classPopUpMenu.add(ppNewClass);
        classPopUpMenu.add(ppRemoveClass);
        classPopUpMenu.add(ppAddStudent);
        classPopUpMenu.addSeparator();
        classPopUpMenu.add(ppRefresh);

        // remove class using the DEL key
        gymClassTable.addKeyListener(new KeyListener() {
            public void keyPressed(KeyEvent e) {
                if (gymClassTable.getSelectedRows().length > 0
                        && e.getKeyCode() == KeyEvent.VK_DELETE) {
                    removeClassB_actionPerformed();
                }
            }

            public void keyReleased(KeyEvent e) {
            }

            public void keyTyped(KeyEvent e) {
            }
        });

        scrollPane.getViewport().setBackground(Color.white);
    }

    private void ppRefresh_actionPerformed(ActionEvent e) {
        refreshB_actionPerformed();
    }

    private void ppNewClass_actionPerformed(ActionEvent e) {
        newClassB_actionPerformed();
    }

    /**
     * Class to handle mouse events.
     */

    class PopupListener extends MouseAdapter {

        public void mouseClicked(MouseEvent e) {
            // editTaskB_actionPerformed(null);
        }

        public void mousePressed(MouseEvent e) {
            maybeShowPopup(e);
        }

        public void mouseReleased(MouseEvent e) {
            maybeShowPopup(e);
        }

        private void maybeShowPopup(MouseEvent e) {
            if (e.isPopupTrigger()) {
                classPopUpMenu.show(e.getComponent(), e.getX(), e.getY());
            }
        }

    }

    /**
     * Refresh the table.
     */
    void refreshB_actionPerformed() {
        gymClassTable.tableChanged(new TableModelEvent(gymClassTable.getModel()));
    }

    /**
     * Remove the selected class.
     */
    private void removeClassB_actionPerformed() {
        // Remove the selected class
        int selectedRowIndex = gymClassTable.getSelectedRow();
        if (selectedRowIndex > -1) {
            GymClassList.removeGymClassByIndex(selectedRowIndex);
            gymClassTable.tableChanged(new TableModelEvent(gymClassTable.getModel()));
        }
    }

    /**
     * Create a new class.
     */
    private void newClassB_actionPerformed() {

        GymClassDialog dlg = new GymClassDialog(App.getFrame(), Local.getString("New Class"));

        Dimension frmSize = App.getFrame().getSize();
        Point loc = App.getFrame().getLocation();
        dlg.startDate.getModel().setValue(CurrentDate.get().getDate());
        dlg.setLocation((frmSize.width - dlg.getSize().width) / 2 + loc.x,
                (frmSize.height - dlg.getSize().height) / 2 + loc.y);
        dlg.setVisible(true);
        if (dlg.canceled) {
            return;
        }

        Trainer trainer = TrainerList.getTrainerByIndex(dlg.jcomboBoxTrainer.getSelectedIndex());
        CalendarDate date = new CalendarDate((Date) dlg.startDate.getModel().getValue());
        GymClass newClass = new GymClass(date, trainer);
        newClass.setClassType(dlg.classNameField.getText());
        newClass.setRoom(GymRoom.getRoomByIndex(dlg.jcomboBoxRoom.getSelectedIndex()));
        GymClassList.addGymClass(newClass);
        gymClassTable.tableChanged(new TableModelEvent(gymClassTable.getModel()));
    }

    /**
     * Edit the selected class.
     */
    private void editClassB_actionPerformed() {
        int selectedRowIndex = gymClassTable.getSelectedRow();
        GymClass gymClass = GymClassList.getGymClasses().get(selectedRowIndex);
        int trainerIndex = TrainerList.getTrainerIndex(gymClass.getTrainer());
        int gymRoomIndex = GymRoom.getIndexByRoom(gymClass.getRoom());

        // Set the fields in the dialog
        GymClassDialog dlg = new GymClassDialog(App.getFrame(), Local.getString("Edit Class"));
        dlg.startDate.getModel().setValue(gymClass.getDate());
        dlg.jcomboBoxTrainer.setSelectedIndex(trainerIndex);
        dlg.jcomboBoxRoom.setSelectedIndex(gymRoomIndex);
        dlg.classNameField.setText(gymClass.getClassType());

        Dimension frmSize = App.getFrame().getSize();
        Point loc = App.getFrame().getLocation();
        dlg.startDate.getModel().setValue(gymClass.getDate());
        dlg.setLocation((frmSize.width - dlg.getSize().width) / 2 + loc.x,
                (frmSize.height - dlg.getSize().height) / 2 + loc.y);
        dlg.setVisible(true);
        if (dlg.canceled) {
            return;
        }

        Trainer trainer = TrainerList.getTrainerByIndex(dlg.jcomboBoxTrainer.getSelectedIndex());
        CalendarDate date = new CalendarDate((Date) dlg.startDate.getModel().getValue());
        gymClass.setTrainer(trainer);
        gymClass.setCalendarDate(date);
        gymClass.setClassType(dlg.classNameField.getText());
        gymClass.setRoom(GymRoom.getRoomByIndex(dlg.jcomboBoxRoom.getSelectedIndex()));
        gymClassTable.tableChanged(new TableModelEvent(gymClassTable.getModel()));
    }

    /**
     * Add a student to the selected class.
     */
    private void addStudentB_actionPerformed() {
        return;
    }

    /**
     * Add a student to the selected class menu item.
     */
    private void ppAddStudent_actionPerformed(ActionEvent e) {
        addStudentB_actionPerformed();
    }

}
