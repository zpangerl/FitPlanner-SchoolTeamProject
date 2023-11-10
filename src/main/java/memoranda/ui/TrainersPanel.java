/*
  File:	TrainersPanel.java
  Author: Steven Stovall
  Version: 2023.11.07

  Description: Simple Trainers panel to display add button and rows of Trainer(s) from TrainersList.java
*/

package main.java.memoranda.ui;
import main.java.memoranda.BeltRank;
import main.java.memoranda.Trainer;
import main.java.memoranda.TrainerList;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class TrainersPanel extends JPanel {
    private JTable trainersTable;
    private DefaultTableModel trainersTableModel;
    String[][] trainersDataArray;
    final String[] trainersTableColumnNames = {"First Name", "Last Name", "Training Rank", "Belt Rank"};

    /* default constructor */
    TrainersPanel() {
        boolean testDataEnabled = true; // TODO: set to false or remove test code below before merge to dev
        if(testDataEnabled) {
            // create some test trainers
            for (int i = 0; i < 1; i++) {
                // Create three trainers to vary beltRank and trainingRank
                Trainer tmpTrainer1 = new Trainer();
                tmpTrainer1.setFirstName("FirstnameTest" + i + "-1");
                tmpTrainer1.setLastName("LastnameTest" + i + "-1");
                tmpTrainer1.setTrainingRank(BeltRank.Rank.BLUE);
                tmpTrainer1.setBeltRank(BeltRank.Rank.BLUE_STRIPE); // STRIPE on belts
                TrainerList.addTrainer(tmpTrainer1);

                Trainer tmpTrainer2 = new Trainer();
                tmpTrainer2.setFirstName("FirstnameTest" + i + "-2");
                tmpTrainer2.setLastName("LastnameTest" + i + "-2");
                tmpTrainer2.setTrainingRank(BeltRank.Rank.GREEN);
                tmpTrainer2.setBeltRank(BeltRank.Rank.GREEN_STRIPE); // STRIPE on belts
                TrainerList.addTrainer(tmpTrainer2);

                Trainer tmpTrainer3 = new Trainer();
                tmpTrainer3.setFirstName("FirstnameTest" + i + "-3");
                tmpTrainer3.setLastName("LastnameTest" + i + "-3");
                tmpTrainer3.setTrainingRank(BeltRank.Rank.BROWN1);
                tmpTrainer3.setBeltRank(BeltRank.Rank.BROWN2);
                TrainerList.addTrainer(tmpTrainer3);
            }
        }

        // Set layout
        this.setLayout(new BorderLayout());

        /* Trainers title */
        // Reference: https://www.tutorialspoint.com/swingexamples/add_title_to_border_panel.htm
        Border trainersPanelTitle = BorderFactory.createTitledBorder("Manage Trainers");
        this.setBorder(trainersPanelTitle);

        JPanel mainPanel = new JPanel(new GridBagLayout());
        JPanel buttonPanelSqueeze = new JPanel();
        JPanel buttonPanel = new JPanel(new GridLayout(3, 1));
        JPanel tablePanel = new JPanel();
        /* Add new trainer button */
        // Reference: https://www.geeksforgeeks.org/java-swing-jpanel-with-examples/
        JButton addTrainerButton = new JButton("Add Trainer");
        buttonPanel.add(addTrainerButton);

        /* Delete trainer button */
        JLabel trainerDeleteLabel = new JLabel();
        trainerDeleteLabel.setText("Select a Trainer row to delete:");
        buttonPanel.add(trainerDeleteLabel);
        JButton deleteTrainerButton = getDeleteTrainerButton();
        buttonPanel.add(deleteTrainerButton);

        buildTrainersTable();
        tablePanel.add(new JScrollPane(trainersTable), BorderLayout.CENTER);

        // Combine JPanel's
        buttonPanelSqueeze.add(buttonPanel, BorderLayout.CENTER);
        // Reference: https://docs.oracle.com/javase/tutorial/uiswing/layout/gridbag.html
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.gridx = 0;
        c.gridy = 0;
        mainPanel.add(buttonPanelSqueeze, c);
        c.gridy = 1;
        mainPanel.add(tablePanel, c);
        this.add(mainPanel, BorderLayout.CENTER);

    }

    /**
     * Create the delete trainer button
     * @return JButton delete trainer button
     */
    private JButton getDeleteTrainerButton() {
        JButton deleteTrainerButton = new JButton("Delete Trainer");
        deleteTrainerButton.addActionListener(e -> {
            final int NO_ROW_SELECTED = -1;
            int rowSelectedIdx = trainersTable.getSelectedRow();
            if(rowSelectedIdx != NO_ROW_SELECTED) {
                TrainerList.removeTrainerByIndex(rowSelectedIdx);
                refreshTrainersTable();
            }
        });
        return deleteTrainerButton;
    }

    /**
     * builds the JTable trainers table and store to member variable trainersTable
     */
    private void buildTrainersTable() {
        // Reference: https://www.geeksforgeeks.org/java-swing-jtable/
        trainersDataArray = TrainerList.getTrainersArray();
        trainersTableModel = new DefaultTableModel(trainersDataArray, trainersTableColumnNames);
        trainersTable = new JTable(trainersTableModel) {
            // Alternate row color. white, light_gray
            // Reference: https://blog.marcnuri.com/jtable-alternate-row-background
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                Component returnComp = super.prepareRenderer(renderer, row, column);
                Color grayColor = Color.LIGHT_GRAY;
                Color whiteColor = Color.WHITE;
                if (!returnComp.getBackground().equals(getSelectionBackground())) {
                    Color bg = (row % 2 == 0 ? whiteColor : grayColor);
                    returnComp.setBackground(bg);
                }
                return returnComp;
            }
        };
        trainersTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // important for delete button
    }

    /**
     * refresh JTable trainersTable after changes
     */
    void refreshTrainersTable() {
        trainersDataArray = TrainerList.getTrainersArray(); // refresh
        trainersTableModel = new DefaultTableModel(trainersDataArray, trainersTableColumnNames);
        trainersTable.setModel(trainersTableModel);
    }

}
