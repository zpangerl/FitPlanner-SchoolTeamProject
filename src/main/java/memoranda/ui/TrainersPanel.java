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

public class TrainersPanel extends JPanel {
    TrainerList trainerList;

    /* default constructor */
    TrainersPanel() {
        // initialize
        trainerList = new TrainerList();

        // TODO: for testing only
        Trainer trainer1 = new Trainer();
        trainer1.setFirstName("First1");
        trainer1.setLastName("Last1");
        Trainer trainer2 = new Trainer();
        trainer2.setFirstName("First2");
        trainer2.setLastName("Last2");
        TrainerList.addTrainer(trainer1);
        TrainerList.addTrainer(trainer2);

        // Set layout
        LayoutManager layout = new BorderLayout();
        this.setLayout(layout);

        /* TOP: Trainers title */
        // Reference: https://www.tutorialspoint.com/swingexamples/add_title_to_border_panel.htm
        Border trainersPanelTitle = BorderFactory.createTitledBorder("Manage Trainers");
        this.setBorder(trainersPanelTitle);

        /* BOTTOM: rows of Trainers */
        // Reference: https://www.geeksforgeeks.org/java-swing-jtable/
        //String[] columnNames = {"First Name", "Last Name", "Training Rank", "Belt Rank"};
        String[] columnNames = {"First Name", "Last Name"};
        String[][] data = TrainerList.getTrainersArray();
        JTable trainersTable = new JTable(data, columnNames);
        //trainersTable.setBounds(30, 40, 200, 300);
        this.add(new JScrollPane(trainersTable), BorderLayout.CENTER);


        // Future: Add edit/delete buttons
        // Reference: https://tips4java.wordpress.com/2009/07/12/table-button-column/
    }

}
