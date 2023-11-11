/*
  File: TrainersListFileStorage.java
  Author: Steven Stovall
  Version: 2023.11.10

  Description: Stores TrainerList persistently when app open/closed
*/

package main.java.memoranda;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import main.java.memoranda.util.Util;

/**
 Class: TrainerListFileStorage

 Description: Stores and loads TrainerList to disk when program is opened and closed.
 */
public class TrainerListFileStorage {
    // Reference: https://www.geeksforgeeks.org/how-to-serialize-arraylist-in-java/
    // Developer Note: considered using FileStorage.JN_DOCPATH ~/.memoranda
    // but decided to use local git directory "FitPlannerData" to make it
    // easier for devs with Windows environment to delete non-hidden data files manually
    // relative path should create a new FitPlannerData dir at the root of git repo
    // and purposely in .gitignore
    public static final String fitPlannerDataDir = "FitPlannerData";
    public static final String trainerListPath = fitPlannerDataDir + "/TrainerList";

    /**
     * default constructor.
     */
    TrainerListFileStorage() {

    }

    /**
     * Load data from disk storage and populate TrainerList.
     */
    public static void loadData() {
        // Start.java (hook app startup)

        // Reference: FileStorage.java
        if (!new File(trainerListPath).exists()) {
            Util.debug("Open trainer list (file does not exist): " + trainerListPath);
        } else {
            //try {
            try (FileInputStream fileInputStream = new FileInputStream(trainerListPath)) {
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                // read TrainerList Object from disk
                ArrayList<Trainer> trainerList =
                        (ArrayList<Trainer>) objectInputStream.readObject();

                // add each trainer to static TrainerList
                for (Trainer trainer : trainerList) {
                    TrainerList.addTrainer(trainer);
                }
                Util.debug("Open trainer list: " + trainerListPath);
            } catch (IOException | ClassNotFoundException e) {
                /* Dangerous to automatically delete TrainerList. Could break other related data
                   structures. Better to throw RuntimeException and fix the bug if this
                   is encountered. */
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * Save data from TrainerList to disk storage.
     */
    public static void saveData() {
        // Call saveData() via AppFrame.java (hook app exit)

        // Reference: https://www.educative.io/answers/how-to-create-a-directory-using-java
        File fitPlannerDataDirFile = new File(fitPlannerDataDir);
        if (!fitPlannerDataDirFile.exists()) {
            if (fitPlannerDataDirFile.mkdir()) {
                Util.debug("FitPlannerDataDir created at: " + fitPlannerDataDir);
            } else {
                Util.debug("ERROR: FitPlanner Data Persistence. Unable to"
                        + "create dir at path: " + fitPlannerDataDirFile);
                return;
            }
        }

        try (FileOutputStream fileOutputStream = new FileOutputStream(trainerListPath)) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            // write TrainerList Object from disk
            objectOutputStream.writeObject(TrainerList.getTrainers());
            Util.debug("Save trainer list: " + trainerListPath);
        } catch (IOException e) {
            Util.debug("Save trainer list: " + trainerListPath + "ERROR: " + e.getMessage());
            /* Developer note: printStackTrace will help to resolve the following issues:
               java.io.NotSerializableException */
            //e.printStackTrace();
        }
    }
}
