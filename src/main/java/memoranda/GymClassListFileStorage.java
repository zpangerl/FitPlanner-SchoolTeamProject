/*
    File: GymClassListFileStorage.java
    Author: Zachary Pangerl
    Version: 11-25-2023

    Stores/loads GymClassList when app is closed/opened
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
    
    public static void loadData() {
        if (!new File(gymClassListPath).exists()) {
            Util.debug("Open gym class list (file does not exist): " + gymClassListPath);
        } else {
            try (FileInputStream fileInput = new FileInputStream(gymClassListPath)) {
                ObjectInputStream objectInput = new ObjectInputStream(fileInput);
                ArrayList<GymClass> gymClassList =
                        (ArrayList<GymClass>) objectInput.readObject();
                for (GymClass gymClass : gymClassList) {
                    GymClassList.addGymClass(gymClass);
                }
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
    
    public static void saveData() {
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
            objectOutput.writeObject(GymClassList.getGymClasses());
            Util.debug("Save gym class list: " + gymClassListPath);
        } catch (IOException e) {
            Util.debug("Save gym class list: " + gymClassListPath + "ERROR: "
                    + e.getMessage());
        }
    }
}