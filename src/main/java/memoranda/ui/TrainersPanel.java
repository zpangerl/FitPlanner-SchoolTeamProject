/*
  File: TrainersPanel.java
  Author: Steven Stovall
  Version: 2023.11.07

  Description: Simple Trainers panel to display add button and rows of Trainer(s) from TrainersList
*/

package main.java.memoranda.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import main.java.memoranda.TrainerList;

public class TrainersPanel extends JPanel {
    private JTable trainersTable;
    private DefaultTableModel trainersTableModel;
    String[][] trainersDataArray;
    final String[] trainersTableColumnNames =
        {"First Name", "Last Name", "Training Rank", "Belt Rank"};

    /**
     * Default constructor.
     */
    public TrainersPanel() {
        // Set layout
        this.setLayout(new BorderLayout());

        /* Trainers title */
        // Reference: https://www.tutorialspoint.com/swingexamples/add_title_to_border_panel.htm
        Border trainersPanelTitle = BorderFactory.createTitledBorder("Manage Trainers");
        this.setBorder(trainersPanelTitle);

        JPanel buttonPanel = new JPanel(new GridLayout(3, 1));
        /* Add new trainer button */
        // Reference: https://www.geeksforgeeks.org/java-swing-jpanel-with-examples/
        JButton addTrainerButton = getAddTrainerButton();
        buttonPanel.add(addTrainerButton);

        /* Delete trainer button */
        JLabel trainerDeleteLabel = new JLabel();
        trainerDeleteLabel.setText("Select a Trainer row to delete:");
        buttonPanel.add(trainerDeleteLabel);
        JButton deleteTrainerButton = getDeleteTrainerButton();
        buttonPanel.add(deleteTrainerButton);

        buildTrainersTable();
        JPanel tablePanel = new JPanel();
        tablePanel.add(new JScrollPane(trainersTable), BorderLayout.CENTER);

        // Combine JPanel's
        JPanel buttonPanelSqueeze = new JPanel();
        buttonPanelSqueeze.add(buttonPanel, BorderLayout.CENTER);
        // Reference: https://docs.oracle.com/javase/tutorial/uiswing/layout/gridbag.html
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.gridx = 0;
        c.gridy = 0;
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.add(buttonPanelSqueeze, c);
        c.gridy = 1;
        mainPanel.add(tablePanel, c);
        this.add(mainPanel, BorderLayout.CENTER);

    }

    /**
     * Create the add trainer button.
     * @return JButton add trainer button
     */
    private JButton getAddTrainerButton() {
        JButton addTrainerButton = new JButton("Add Trainer");
        addTrainerButton.addActionListener(e -> {
            TrainerDialog trainerDialog = new TrainerDialog(this);
            trainerDialog.setVisible(true);
        });
        return addTrainerButton;
    }

    /**
     * Create the delete trainer button.
     * @return JButton delete trainer button
     */
    private JButton getDeleteTrainerButton() {
        JButton deleteTrainerButton = new JButton("Delete Trainer");
        deleteTrainerButton.addActionListener(e -> {
            final int nowRowSelected = -1;
            int rowSelectedIdx = trainersTable.getSelectedRow();
            if (rowSelectedIdx != nowRowSelected) {
                TrainerList.removeTrainerByIndex(rowSelectedIdx);
                refreshTrainersTable();
            }
        });
        return deleteTrainerButton;
    }

    /**
     * builds the JTable trainers table and store to member variable trainersTable.
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
        // important for delete button - only allow to select one row at a time
        trainersTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    /**
     * refresh JTable trainersTable after changes.
     */
    void refreshTrainersTable() {
        trainersDataArray = TrainerList.getTrainersArray(); // refresh
        trainersTableModel = new DefaultTableModel(trainersDataArray, trainersTableColumnNames);
        trainersTable.setModel(trainersTableModel);
    }

}
