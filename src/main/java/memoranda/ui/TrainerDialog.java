/*
  File: TrainerDialog.java
  Author: Steven Stovall
  Version: 2023.11.09

  Description: Trainer dialog to add a trainer
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
import main.java.memoranda.Trainer;
import main.java.memoranda.TrainerList;
import main.java.memoranda.util.Local;

/**
 * Provides Pop-up dialog box to add a trainer.
 */
public class TrainerDialog extends JDialog {
    private final TrainersPanel trainersPanel;
    private final JTextField firstNameTextField;
    private final JTextField lastNameTextField;
    private final JComboBox<String> trainingRankCombo;
    private final JComboBox<String> beltRankCombo;

    /**
     * Default constructor.
     */
    public TrainerDialog(TrainersPanel trainersPanel) {
        // -------------------------------------------------------------------
        // Reference: TaskDialog.java START
        super(App.getFrame(), "Add Trainer", true);
        // need trainersPanel to refresh()
        this.trainersPanel = trainersPanel;

        // ####################################################################
        // header: Add Trainer and Trainer logo
        JLabel header = new JLabel();
        header.setFont(new java.awt.Font("Dialog", Font.BOLD, 20));
        // ASU Maroon: 140, 29, 64
        // https://brandguide.asu.edu/brand-elements/design/color
        header.setForeground(new Color(140, 29, 64));
        header.setText(Local.getString("Add Trainer"));
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

        GridBagConstraints c = new GridBagConstraints();
        // https://docs.oracle.com/javase/tutorial/uiswing/layout/gridbag.html

        // ####################################################################
        // First Name
        // Reference: https://www.geeksforgeeks.org/java-swing-jtextfield/
        c.insets = new Insets(10, 5, 0, 0);
        c.gridx = 0;
        c.gridy = 0;
        JPanel inputPanel = new JPanel(new GridBagLayout()); // Reference: TrainersPanel.java
        JLabel firstNameLabel = new JLabel("First Name");
        inputPanel.add(firstNameLabel, c);
        c.gridx = 1;
        int textColumnWidth = 16;
        firstNameTextField = new JTextField(textColumnWidth);
        inputPanel.add(firstNameTextField, c);

        // ####################################################################
        // Last Name
        c.gridx = 0;
        c.gridy = 1;
        JLabel lastNameLabel = new JLabel("Last Name");
        inputPanel.add(lastNameLabel, c);
        //c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 1;
        lastNameTextField = new JTextField(textColumnWidth);
        inputPanel.add(lastNameTextField, c);

        // ####################################################################
        // Training Rank
        // ####################################################################
        // Reference: https://www.geeksforgeeks.org/java-swing-jcombobox-examples/
        // Reference:
        /* https://stackoverflow.com/questions/20596020/
        / jcombobox-is-a-raw-type-references-to-generic-type-jcomboboxe-should-be-param */
        c.gridx = 0;
        c.gridy = 2;
        JLabel trainingRankLabel = new JLabel("Training Rank");
        inputPanel.add(trainingRankLabel, c);
        //c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 2;
        trainingRankCombo = new JComboBox<>(getBeltRanks());
        inputPanel.add(trainingRankCombo, c);

        // ####################################################################
        // Belt Rank
        // ####################################################################
        c.gridx = 0;
        c.gridy = 3;
        JLabel beltRankLabel = new JLabel("Belt Rank");
        inputPanel.add(beltRankLabel, c);
        //c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 3;
        beltRankCombo = new JComboBox<>(getBeltRanks());
        inputPanel.add(beltRankCombo, c);

        // ####################################################################
        // Buttons: Add, Cancel
        // https://docs.oracle.com/javase/8/javafx/api/javafx/geometry/Insets.html
        // top, right, bottom, left
        c.gridx = 0;
        c.gridy = 4;
        c.insets = new Insets(10, 10, 0, 5);
        JButton addButton = getAddButton();
        inputPanel.add(addButton, c);
        //c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 4;
        c.insets = new Insets(10, 5, 0, 10);
        JButton cancelButton = getCancelButton();
        inputPanel.add(cancelButton, c);

        this.getContentPane().add(inputPanel, BorderLayout.CENTER);
    }

    /**
     * Convert BeltRank.Rank enums to array of Strings for JComboBox.
     * @return String[] of Belt Ranks
     */
    String[] getBeltRanks() {
        BeltRank.Rank[] beltRanks = BeltRank.Rank.values();
        String[] beltRanksStrings = new String[beltRanks.length];
        int i = 0;
        for (BeltRank.Rank beltRank : BeltRank.Rank.values()) {
            beltRanksStrings[i++] = BeltRank.getBeltRankName(beltRank);
        }
        return beltRanksStrings;
    }

    /**
     * Create the Add button.
     * @return JButton Add button
     */
    private JButton getAddButton() {
        JButton addButton = new JButton("Add");
        addButton.addActionListener(e -> {
            Trainer newTrainer = new Trainer();
            newTrainer.setFirstName(firstNameTextField.getText());
            newTrainer.setLastName(lastNameTextField.getText());
            newTrainer.setBeltRank(BeltRank.Rank.valueOf((String) beltRankCombo.getSelectedItem()));
            newTrainer.setTrainingRank(
                BeltRank.Rank.valueOf((String) trainingRankCombo.getSelectedItem()));
            TrainerList.addTrainer(newTrainer);
            trainersPanel.refreshTrainersTable();
            JOptionPane.showMessageDialog(null, "Successfully added Trainer!");
            dispose(); // close dialog
        });
        return addButton;
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
