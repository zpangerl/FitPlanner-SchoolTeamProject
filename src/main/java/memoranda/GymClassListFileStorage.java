/*
    File: GymClassListFileStorage.java
    Author: Zachary Pangerl
    Version: 11-25-2023

    Stores/loads GymClassList when app is closed/opened
    Big thanks to Steven Stovall, vast majority of this was
    from his hard work on TrainerListFileStorage
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

public class GymClassListFileStorage {
    public static final String fitPlannerDataDir = "FitPlannerData";
    public static final String gymClassListPath = fitPlannerDataDir + "/GymClassList";
    
    GymClassListFileStorage(){
        
    }
    
    /**
     * Load data from disk into GymClassList.
     */
    public static void loadData() {
        // Start.java (hook app startup)

        // Reference: FileStorage.java
        if (!new File(gymClassListPath).exists()) {
            Util.debug("Open gym class list (file does not exist): " + gymClassListPath);
        } else {
            try (FileInputStream fileInput = new FileInputStream(gymClassListPath)) {
                ObjectInputStream objectInput = new ObjectInputStream(fileInput);
                // read GymClassList Object from disk
                ArrayList<GymClass> gymClassList =
                        (ArrayList<GymClass>) objectInput.readObject();
                // add each GymClass to GymClassList
                for (GymClass gymClass : gymClassList) {
                    GymClassList.addGymClass(gymClass);
                }
                objectInput.close();
                fileInput.close();
            } catch (IOException | ClassNotFoundException e) {
                /* Dangerous to automatically delete StudentList. Could break other related data
                structures. Better to throw RuntimeException and fix the bug if this
                is encountered. */
                throw new RuntimeException(e);
            }
        }
    }
    
    /**
     * Save data from GymClassList onto disk.
     */
    public static void saveData() {
        // Call saveData() via AppFrame.java (hook app exit)

        // Reference: https://www.educative.io/answers/how-to-create-a-directory-using-java
        File fitPlannerData = new File(fitPlannerDataDir);
        if (!fitPlannerData.exists()) {
            if (fitPlannerData.mkdir()) {
                Util.debug("FitPlannerData created at: " + fitPlannerDataDir);
            } else {
                Util.debug("ERROR: FitPlanner Data Persistence. Unable to"
                        + "create dir at path: " + fitPlannerData);
                return;
            }
        }
        try (FileOutputStream fileOutput = new FileOutputStream(gymClassListPath)) {
            ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
            // write GymClass Object to disk
            objectOutput.writeObject(GymClassList.getGymClasses());
            Util.debug("Save gym class list: " + gymClassListPath);
            objectOutput.close();
            fileOutput.close();
        } catch (IOException e) {
            Util.debug("Save gym class list: " + gymClassListPath + "ERROR: "
                    + e.getMessage());
        }
    }
}
