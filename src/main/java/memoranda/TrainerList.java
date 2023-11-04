/*
  File:	TrainersList.Java
  Author: Steven Stovall (modified: US86, Task117 - simplified code)
  Version: 2023.11.04

  Description: Stores Trainer an associated attributes to be used in TrainersList.java
*/

package main.java.memoranda;
import java.util.ArrayList;
/**
 Class:	Trainer

 Description: Stores Trainer attributes first name, last name, training rank, and belt ranking
 */
public class TrainerList {
    // class variables
    private static ArrayList<Trainer> trainers;
    private static final int NUMBER_TRAINER_ATTRIBUTES = 2;

    /* default constructor */
    public TrainerList() {
        trainers = new ArrayList<Trainer>();
    }

    /**
     * Returns an ArrayList of Trainers
     * @return trainers
     */
    public static ArrayList<Trainer> getTrainers() {
        return trainers;
    }

    /**
     * Returns an String[][] of Trainers (e.g. to use in JTable)
     * @return trainers 2D array
     */
    public static String[][] getTrainersArray() {
        int ROWS = TrainerList.getTrainers().size();
        String[][] trainers = new String[ROWS][NUMBER_TRAINER_ATTRIBUTES];
        for(int i = 0; i < ROWS; i++) {
            Trainer trainer1 = TrainerList.getTrainers().get(i);
            String firstName = trainer1.getFirstName();
            String lastName = trainer1.getLastName();
            String[] trainer = {firstName, lastName};
            trainers[i] = trainer;
        }
        return trainers;
    }

    /**
     * Adds a new trainer to trainers
     * @param trainer
     */
    public static void addTrainer(Trainer trainer) {
        trainers.add(trainer);
    }
}
