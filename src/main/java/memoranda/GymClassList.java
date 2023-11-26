/*
  File: GymClassList.Java
  Author: Rhett Harrison (modified: US82, Task141) and Steven Stovall
  Version: 2023.11.10

  Description: Stores GymClasses to have CRUDops performed on them.
*/

package main.java.memoranda;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Class: GymClassList
 * Description: Stores GymClass attributes date, room, trainer, and class type.
 * See TrainerList.java for similar implementation.
 */
public final class GymClassList {
    // class variables
    private static ArrayList<GymClass> gymClasses;

    /* default constructor should not be used for utility class */
    public GymClassList() {
        // https://stackoverflow.com/questions/7766277/why-am-i-getting-this-warning-about-utility-classes-in-java
        throw new AssertionError("Do not instantiate utility class");
    }

    /**
     * Returns an ArrayList of GymClasses.
     * 
     * @return gymClasses
     */
    public static ArrayList<GymClass> getGymClasses() {
        /* create empty gymClasses if null. No constructor in utility class */
        if (gymClasses == null) {
            gymClasses = new ArrayList<>();
        }

        return gymClasses;
    }

    /**
     * Adds a new gymClass to gymClasses.
     * 
     * @param gymClass gymClass to add
     */
    public static void addGymClass(GymClass gymClass) {
        if (gymClasses == null) {
            gymClasses = new ArrayList<>();
        }
        gymClasses.add(gymClass);
    }

    /**
     * Removes a gymClass from gymClasses.
     * 
     * @param gymClass gymClass to remove
     */
    public static void removeGymClass(GymClass gymClass) {
        if (gymClasses != null) {
            gymClasses.remove(gymClass);
        }
    }

    /**
     * Removes a gymClass from gymClasses by index number.
     * 
     * @param idx index number of gymClass to remove
     */
    public static void removeGymClassByIndex(int idx) {
        gymClasses.remove(idx);
    }

    /**
     * Sort classes by date ascending.
     */
    public static void sortClassesByDateAscending() {
        gymClasses.sort(Comparator.comparing(GymClass::getDate));
    }

    /**
     * Sort classes by date descending.
     */
    public static void sortClassesByDateDescending() {
        gymClasses.sort(Comparator.comparing(GymClass::getDate).reversed());
    }
}
