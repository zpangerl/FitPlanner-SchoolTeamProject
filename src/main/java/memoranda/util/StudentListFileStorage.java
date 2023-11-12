package main.java.memoranda.util;

import java.io.*;
import java.util.ArrayList;

public class StudentListFileStorage {
    public static final String fitPlannerDataDir = "FitPlannerData";
    public static final String studentListPath = fitPlannerDataDir + "/StudentList";

    public StudentListFileStorage() {

    }

    public static void loadData() {
        // Start.java (hook app startup)

        // Reference: FileStorage.java
        if (!new File(studentListPath).exists()) {
            Util.debug("Open trainer list (file does not exist): " + studentListPath);
        } else {
            //try {
            try (FileInputStream fileInputStream = new FileInputStream(studentListPath)) {
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                // read TrainerList Object from disk
                ArrayList<Student> trainerList =
                        (ArrayList<Student>) objectInputStream.readObject();

                // add each trainer to static TrainerList
                for (Student trainer : trainerList) {
                    StudentList.addTrainer(trainer);
                }
                Util.debug("Open trainer list: " + studentListPath);
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

        try (FileOutputStream fileOutputStream = new FileOutputStream(studentListPath)) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            // write TrainerList Object from disk
            objectOutputStream.writeObject(StudentList.getTrainers());
            Util.debug("Save trainer list: " + studentListPath);
        } catch (IOException e) {
            Util.debug("Save trainer list: " + studentListPath + "ERROR: " + e.getMessage());
            /* Developer note: printStackTrace will help to resolve the following issues:
               java.io.NotSerializableException */
            //e.printStackTrace();
        }
    }
}
