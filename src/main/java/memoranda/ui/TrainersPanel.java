/*
  File:	TrainersPanel.java
  Author: Steven Stovall
  Version: 2023.11.04

  Description: Simple Trainers panel to display add button and rows of Trainer(s) from TrainersList.java
*/

package main.java.memoranda.ui;
import main.java.memoranda.TrainerList;
import main.java.memoranda.Trainer;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class TrainersPanel extends JPanel {
    TrainerList trainerList;

    /* default constructor */
    TrainersPanel() {
        // initialize
        trainerList = new TrainerList();

        // TODO: for testing only
        // create 50 trainers
        for(int i = 0; i < 50; i++ ) {
            Trainer tmpTrainer = new Trainer();
            tmpTrainer.setFirstName("FirstnameTest" + i);
            tmpTrainer.setLastName("LastnameTest" + i);
            TrainerList.addTrainer(tmpTrainer);
        }

        // Set layout
        LayoutManager layout = new BorderLayout();
        this.setLayout(layout);

        /* TOP: Trainers title */
        // Reference: https://www.tutorialspoint.com/swingexamples/add_title_to_border_panel.htm
        Border trainersPanelTitle = BorderFactory.createTitledBorder("Manage Trainers");
        this.setBorder(trainersPanelTitle);

        /* TOP: Add new student button */
        // Reference: https://www.geeksforgeeks.org/java-swing-jpanel-with-examples/
        JButton addTrainerButton = new JButton("Add Trainer");
        this.add(addTrainerButton, BorderLayout.NORTH);

        /* BOTTOM: rows of Trainers */
        // Reference: https://www.geeksforgeeks.org/java-swing-jtable/
        //String[] columnNames = {"First Name", "Last Name", "Training Rank", "Belt Rank"};
        String[] columnNames = {"First Name", "Last Name"};
        String[][] data = TrainerList.getTrainersArray();
        JTable trainersTable = new JTable(data, columnNames) {
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
        //trainersTable.setBounds(30, 40, 200, 300);
        this.add(new JScrollPane(trainersTable), BorderLayout.CENTER);


        // Future: Add edit/delete buttons
        // Reference: https://tips4java.wordpress.com/2009/07/12/table-button-column/
    }

}
