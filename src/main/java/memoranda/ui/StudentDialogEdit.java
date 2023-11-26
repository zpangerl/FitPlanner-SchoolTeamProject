/*
  File: StudentDialogEdit.java
  Author: Steven Stovall
  Version: 2023.11.25

  Description: Student dialog to edit a student
  Reference: Based on TrainerDialogEdit.java (Stovall)
*/

package main.java.memoranda.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Objects;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import main.java.memoranda.BeltRank;
import main.java.memoranda.Student;
import main.java.memoranda.StudentListImpl;
import main.java.memoranda.util.Local;

/**
 * Provides Pop-up dialog box to edit a student.
 */
public class StudentDialogEdit extends JDialog {
    private final JTextField firstNameTextField;
    private final JTextField lastNameTextField;
    private final JTextField ageTextField;
    private final JComboBox<String> trainingRankCombo;
    private final JComboBox<String> beltRankCombo;
    private final Student studentToEdit;

    /**
     * Constructor.
     * @param selectedRowToEditIndex int idx of row selected when edit dialog launched.
     */
    public StudentDialogEdit(int selectedRowToEditIndex) {
        // -------------------------------------------------------------------
        // Reference: TaskDialog.java START
        super(App.getFrame(), "Edit Student", true);
        // Find student to edit
        studentToEdit = StudentListImpl.getStudentByIndex(selectedRowToEditIndex);

        // ####################################################################
        // header: Edit Student and Student logo
        JLabel header = new JLabel();
        header.setFont(new Font("Dialog", Font.BOLD, 20));
        // ASU Maroon: 140, 29, 64
        // https://brandguide.asu.edu/brand-elements/design/color
        header.setForeground(new Color(140, 29, 64));
        header.setText(Local.getString("Edit Student"));
        // IntelliJ suggested requireNonNull
        // Reference: WorkPanel.java - add the Student icon to make it look nice
        // Reference: student_48 from AddStudentDialog.java
        header.setIcon(new ImageIcon(
                Objects.requireNonNull(
                        AppFrame.class.getResource("/ui/icons/student_48.png"))));
        JPanel dialogTitlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        dialogTitlePanel.add(header, null);
        this.getContentPane().add(dialogTitlePanel, BorderLayout.NORTH);
        this.setResizable(false);
        this.setSize(new Dimension(430,300));

        // Reference: TaskDialog.java END
        // -------------------------------------------------------------------

        // Center dialog on screen
        // Reference: https://stackoverflow.com/questions/213266/how-do-i-center-a-jdialog-on-screen
        this.setLocationRelativeTo(null);

        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        // https://docs.oracle.com/javase/tutorial/uiswing/layout/gridbag.html

        // ####################################################################
        // First Name
        // Reference: https://www.geeksforgeeks.org/java-swing-jtextfield/
        gridBagConstraints.insets = new Insets(10, 5, 0, 0);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        JPanel inputPanel = new JPanel(new GridBagLayout()); // Reference: TrainersPanel.java
        JLabel firstNameLabel = new JLabel("First Name");
        inputPanel.add(firstNameLabel, gridBagConstraints);
        gridBagConstraints.gridx = 1;
        int textColumnWidth = 16;
        firstNameTextField = new JTextField(textColumnWidth);
        inputPanel.add(firstNameTextField, gridBagConstraints);
        firstNameTextField.setText(studentToEdit.getFirstName());

        // ####################################################################
        // Last Name
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        JLabel lastNameLabel = new JLabel("Last Name");
        inputPanel.add(lastNameLabel, gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        lastNameTextField = new JTextField(textColumnWidth);
        inputPanel.add(lastNameTextField, gridBagConstraints);
        lastNameTextField.setText(studentToEdit.getLastName());

        // ####################################################################
        // Age
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        JLabel ageLabel = new JLabel("Age");
        inputPanel.add(ageLabel, gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        ageTextField = new JTextField(textColumnWidth);
        inputPanel.add(ageTextField, gridBagConstraints);
        ageTextField.setText(String.valueOf(studentToEdit.getAge()));

        // ####################################################################
        // Belt Rank
        // ####################################################################
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        JLabel beltRankLabel = new JLabel("Belt Rank");
        inputPanel.add(beltRankLabel, gridBagConstraints);
        //gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        beltRankCombo = new JComboBox<>(BeltRank.getBeltRanks());
        inputPanel.add(beltRankCombo, gridBagConstraints);
        beltRankCombo.setSelectedIndex(studentToEdit.getBeltRank().ordinal());

        // ####################################################################
        // Training Rank
        // ####################################################################
        // Reference: https://www.geeksforgeeks.org/java-swing-jcombobox-examples/
        // Reference:
        /* https://stackoverflow.com/questions/20596020/
        / jcombobox-is-a-raw-type-references-to-generic-type-jcomboboxe-should-be-param */
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        JLabel trainingRankLabel = new JLabel("Training Rank");
        inputPanel.add(trainingRankLabel, gridBagConstraints);
        //gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        trainingRankCombo = new JComboBox<>(BeltRank.getBeltRanks());
        inputPanel.add(trainingRankCombo, gridBagConstraints);
        trainingRankCombo.setSelectedIndex(studentToEdit.getTrainingRank().ordinal());
        // ####################################################################
        // Buttons: Save, Cancel
        // https://docs.oracle.com/javase/8/javafx/api/javafx/geometry/Insets.html
        // top, right, bottom, left
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new Insets(10, 10, 0, 5);
        JButton saveButton = getSaveButton();
        inputPanel.add(saveButton, gridBagConstraints);
        //gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new Insets(10, 5, 0, 10);
        JButton cancelButton = getCancelButton();
        inputPanel.add(cancelButton, gridBagConstraints);

        this.getContentPane().add(inputPanel, BorderLayout.CENTER);
    }

    /**
     * Create the Save button.
     * @return JButton Save button
     */
    private JButton getSaveButton() {
        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(e -> {
            String errorMessage = studentToEdit.editStudent(
                    firstNameTextField.getText(),
                    lastNameTextField.getText(),
                    Integer.parseInt(ageTextField.getText()),
                    BeltRank.Rank.valueOf((String) trainingRankCombo.getSelectedItem()),
                    BeltRank.Rank.valueOf((String) beltRankCombo.getSelectedItem()));

            if (errorMessage.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Successfully edited Student!");
                StudentPanel.updateStudentTable();
                dispose(); // close dialog
            } else {
                JOptionPane.showMessageDialog(null,
                        errorMessage,
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });
        return saveButton;
    }

    /**
     * Create the Cancel button.
     * @return JButton Cancel button
     */
    private JButton getCancelButton() {
        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(e -> {
            // Reference: https://stackoverflow.com/questions/7256606/jdialog-setvisiblefalse-vs-dispose
            dispose(); // Close dialog
        });
        return cancelButton;
    }

}
