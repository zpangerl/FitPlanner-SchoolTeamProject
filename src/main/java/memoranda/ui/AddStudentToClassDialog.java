package main.java.memoranda.ui;

import java.awt.Dimension;
import java.awt.Frame;

import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.JList;

import main.java.memoranda.Student;
import main.java.memoranda.StudentListImpl;
import main.java.memoranda.util.Local;

import javax.swing.JButton;

public class AddStudentToClassDialog extends JDialog {

    JPanel contentPane = new JPanel(new BorderLayout());
    JPanel mPanel = new JPanel(new BorderLayout());
    JButton addB = new JButton("Add");
    JButton cancelB = new JButton("Cancel");
    boolean cancelled = true;
    JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

    JList<Student> studentList; // Need a vector or array of students from StudentListImpl
    JList<Student> selectedStudentList;

    /**
     * Constructor for the dialog.
     */
    public AddStudentToClassDialog(Frame frame, String title) {
        super(frame, title, true);
        try {
            jbInit();
            pack();
        } catch (Exception e) {
            new ExceptionDialog(e);
        }
    }

    /**
     * Initializes the dialog.
     */
    private void jbInit() throws Exception {
        this.setResizable(false);
        this.setSize(300, 200);

        // Content pane
        // TODO: Add student list

        // TODO: Add selected student list

        // Cancel button
        cancelB.setMaximumSize(new Dimension(100, 26));
        cancelB.setMinimumSize(new Dimension(100, 26));
        cancelB.setPreferredSize(new Dimension(100, 26));
        cancelB.setText(Local.getString("Cancel"));
        cancelB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cancelB_actionPerformed(e);
            }
        });

        // Add button
        addB.setMaximumSize(new Dimension(100, 26));
        addB.setMinimumSize(new Dimension(100, 26));
        addB.setPreferredSize(new Dimension(100, 26));
        addB.setText(Local.getString("Add"));
        addB.setEnabled(false);
        addB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addB_actionPerformed(e);
            }
        });
        this.getRootPane().setDefaultButton(addB);

        // Add components to the dialog
        getContentPane().add(mPanel);
        mPanel.add(contentPane, BorderLayout.CENTER);
        mPanel.add(buttonsPanel, BorderLayout.SOUTH);
        // Buttons panel
        buttonsPanel.add(addB);
        buttonsPanel.add(cancelB);
    }

    void cancelB_actionPerformed(ActionEvent e) {
        this.dispose();
    }

    void addB_actionPerformed(ActionEvent e) {
        cancelled = false;
        this.dispose();
    }
}
