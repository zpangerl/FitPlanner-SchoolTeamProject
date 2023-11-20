/*
  File: TrainerDialogEdit.java
  Author: Steven Stovall
  Version: 2023.11.19

  Description: Trainer dialog to edit a trainer
  Reference: Cloned from TrainerDialog.java (add a trainer)
*/

package main.java.memoranda.ui;

import main.java.memoranda.BeltRank;
import main.java.memoranda.Trainer;
import main.java.memoranda.TrainerList;
import main.java.memoranda.util.Local;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

/**
 * Provides Pop-up dialog box to edit a trainer.
 */
public class TrainerDialogEdit extends JDialog {
    private final TrainersPanel trainersPanel;
    private final JTextField firstNameTextField;
    private final JTextField lastNameTextField;
    private final JComboBox<String> trainingRankCombo;
    private final JComboBox<String> beltRankCombo;
    private final Trainer trainerToEdit;

    /**
     * Constructor
     * @param trainersPanel TrainersPanel panel that has JTable with trainers.
     * @param selectedRowToEditIndex int idx of row selected when edit dialog launched.
     */
    public TrainerDialogEdit(TrainersPanel trainersPanel, int selectedRowToEditIndex) {
        // -------------------------------------------------------------------
        // Reference: TaskDialog.java START
        super(App.getFrame(), "Edit Trainer", true);
        // need trainersPanel to refresh()
        this.trainersPanel = trainersPanel;
        // Find trainer to edit
        trainerToEdit = TrainerList.getTrainerByIndex(selectedRowToEditIndex);

        // ####################################################################
        // header: Edit Trainer and Trainer logo
        JLabel header = new JLabel();
        header.setFont(new Font("Dialog", Font.BOLD, 20));
        // ASU Maroon: 140, 29, 64
        // https://brandguide.asu.edu/brand-elements/design/color
        header.setForeground(new Color(140, 29, 64));
        header.setText(Local.getString("Edit Trainer"));
        // IntelliJ suggested requireNonNull
        // Reference: WorkPanel.java - add the Trainer icon to make it look nice
        header.setIcon(new ImageIcon(
                Objects.requireNonNull(
                        AppFrame.class.getResource("/ui/icons/trainer.png"))));

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
        firstNameTextField.setText(trainerToEdit.getFirstName());

        // ####################################################################
        // Last Name
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        JLabel lastNameLabel = new JLabel("Last Name");
        inputPanel.add(lastNameLabel, gridBagConstraints);
        //gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        lastNameTextField = new JTextField(textColumnWidth);
        inputPanel.add(lastNameTextField, gridBagConstraints);
        lastNameTextField.setText(trainerToEdit.getLastName());

        // ####################################################################
        // Training Rank
        // ####################################################################
        // Reference: https://www.geeksforgeeks.org/java-swing-jcombobox-examples/
        // Reference:
        /* https://stackoverflow.com/questions/20596020/
        / jcombobox-is-a-raw-type-references-to-generic-type-jcomboboxe-should-be-param */
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        JLabel trainingRankLabel = new JLabel("Training Rank");
        inputPanel.add(trainingRankLabel, gridBagConstraints);
        //gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        trainingRankCombo = new JComboBox<>(BeltRank.getBeltRanks());
        inputPanel.add(trainingRankCombo, gridBagConstraints);
        trainingRankCombo.setSelectedIndex(trainerToEdit.getTrainingRank().ordinal());

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
        beltRankCombo.setSelectedIndex(trainerToEdit.getBeltRank().ordinal());

        // ####################################################################
        // Buttons: Save, Cancel
        // https://docs.oracle.com/javase/8/javafx/api/javafx/geometry/Insets.html
        // top, right, bottom, left
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new Insets(10, 10, 0, 5);
        JButton saveButton = getSaveButton();
        inputPanel.add(saveButton, gridBagConstraints);
        //gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
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
            // TODO: update and save trainer
            /*Trainer newTrainer = new Trainer();
            newTrainer.setFirstName(firstNameTextField.getText());
            newTrainer.setLastName(lastNameTextField.getText());
            newTrainer.setBeltRank(BeltRank.Rank.valueOf((String) beltRankCombo.getSelectedItem()));
            newTrainer.setTrainingRank(
                BeltRank.Rank.valueOf((String) trainingRankCombo.getSelectedItem()));
            TrainerList.addTrainer(newTrainer);*/
            trainersPanel.refreshTrainersTable();
            JOptionPane.showMessageDialog(null, "Successfully saved Trainer!");
            dispose(); // close dialog
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
