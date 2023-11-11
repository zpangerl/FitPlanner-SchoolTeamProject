/*
  File: TrainersList.Java
  Author: Steven Stovall (modified: US86, Task117 - simplified code)
  Version: 2023.11.04

  Description: Stores Trainer an associated attributes to be used in TrainersList.java
*/

package main.java.memoranda;

import java.util.ArrayList;
import java.util.Vector;

/**
 Class: Trainer

 Description: Stores Trainer attributes first name, last name, training rank, and belt ranking.
 */
public final class TrainerList {
    // class variables
    private static ArrayList<Trainer> trainers;
    private static final int NUMBER_TRAINER_ATTRIBUTES = 4;

    /* default constructor should not be used for utility class */
    public TrainerList() {
        // https://stackoverflow.com/questions/7766277/why-am-i-getting-this-warning-about-utility-classes-in-java
        throw new AssertionError("Do not instantiate utility class");
    }

    /**
     * Returns an ArrayList of Trainers.
     * @return trainers
     */
    public static ArrayList<Trainer> getTrainers() {
        /* create empty trainers if null. No constructor in utility class */
        if (trainers == null) {
            trainers = new ArrayList<>();
        }

        return trainers;
    }

    /**
     * Returns an String[][] of Trainers (e.g. to use in JTable).
     * @return trainers 2D array
     */
    public static String[][] getTrainersArray() {
        int rows = TrainerList.getTrainers().size();
        String[][] trainers = new String[rows][NUMBER_TRAINER_ATTRIBUTES];
        for (int i = 0; i < rows; i++) {
            Trainer trainer1 = TrainerList.getTrainers().get(i);
            String firstName = trainer1.getFirstName();
            String lastName = trainer1.getLastName();
            String trainingRank = BeltRank.getBeltRankName(trainer1.getTrainingRank());
            String beltRank = BeltRank.getBeltRankName(trainer1.getBeltRank());
            String[] trainer = {firstName, lastName, trainingRank, beltRank};
            trainers[i] = trainer;
        }
        return trainers;
    }

    /**
     * Returns a vector with the fullname of all trainers
     * @return trainerNames Vector<String>
     */
    public static Vector<String> getTrainerNames() {
        Vector<String> trainerNames = new Vector<>();
        for (int i = 0; i < trainers.size(); i++) {
            String fullname = trainers.get(i).getName();
            trainerNames.add(fullname);
        }
        return trainerNames;
    }

    /**
     * Adds a new trainer to trainers.
     * @param trainer trainer to add
     */
    public static void addTrainer(Trainer trainer) {
        if (trainers == null) {
            trainers = new ArrayList<>();
        }
        trainers.add(trainer);
    }

    /**
     * Removes a trainer from trainers.
     * @param trainer trainer to remove
     */
    public static void removeTrainer(Trainer trainer) {
        if (trainers != null) {
            trainers.remove(trainer);
        }
    }

    /**
     * Removes a trainer from trainers by index number.
     * @param idx index number of trainer to remove
     */
    public static void removeTrainerByIndex(int idx) {
        trainers.remove(idx);
    }
}
