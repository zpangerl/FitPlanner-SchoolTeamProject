/*
  File: TrainersListFileStorage.java
  Author: Steven Stovall
  Version: 2023.11.10

  Description: Stores TrainerList persistently when app open/closed
*/

package main.java.memoranda;

import main.java.memoranda.util.Util;

/**
 Class: TrainerListFileStorage

 Description: Stores and loads TrainerList to disk when program is opened and closed
 */
public class TrainerListFileStorage {

    /**
     * default constructor.
     */
    TrainerListFileStorage() {

    }

    /**
     * Load data from disk storage and populate TrainerList
     */
    public static void loadData() {
        // Start.java
        Util.debug("Open TrainersListFileStorage: TODO - /path/to/file");
    }

    public static void saveData() {
        // AppFrame.java L629-L648
        Util.debug("Save trainers list: TODO - /path/to/file");
    }

}
