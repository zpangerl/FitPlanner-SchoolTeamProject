/*
 * File: TestGymClassFileStorage.java
 * Author: Zachary Pangerl, Steven Stovall
 * Version: 11-25-2023
 * 
 * Tests GymClassListFileStorage to ensure that it works correctly.
 * Extremely similar to the Trainer/Student FileStorage unit tests.
 * Major credit to Steven Stovall for figuring out how to save/load.
 */

package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.util.Date;

import main.java.memoranda.BeltRank;
import main.java.memoranda.GymClass;
import main.java.memoranda.GymClassList;
import main.java.memoranda.GymClassListFileStorage;
import main.java.memoranda.Room;
import main.java.memoranda.Trainer;
import main.java.memoranda.date.CalendarDate;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestGymClassListFileStorage {

    /**
     * Set up a clean GymClassList with no GymClasses.
     */
    @BeforeClass
    public static void setup() {
        // Thanks to Rhett for this fix
        GymClassList.getGymClasses().clear();  
        // Destructive: Intended to only run in dev environment
        // Deletes gym class data to test with clean environment
        
        // Reference: https://www.baeldung.com/junit-before-beforeclass-beforeeach-beforeall
        // Prepare clean test environment
        File gymClassFile = new File(GymClassListFileStorage.gymClassListPath);
        if (gymClassFile.exists()) {
            boolean deletedSuccessfully = (gymClassFile.delete());
            assertTrue(deletedSuccessfully);
        }
        assertFalse(gymClassFile.exists());
    }
    
    /**
     * Clear GymClassList after testing.
     */
    @AfterClass
    public static void tearDown() {
        // Destructive: Intended to only run in dev environment
        File gymClassFile = new File(GymClassListFileStorage.gymClassListPath);
        if (gymClassFile.exists()) {
            boolean deleted = (gymClassFile.delete());
            assertTrue(deleted);
        }
        assertFalse(gymClassFile.exists());
    }
    
    /**
     * Test load with no existing file on disk.
     */
    @Test
    public void loadGymClassesNoFile() {
        try {
            // load data when file does not exist
            GymClassListFileStorage.loadData();
        } catch (Exception e) {
            // simulate user opening program for the first time with no data
            fail("Should not throw exception whtn now file exists on disk");
        }
    }
    
    /**
     * Test load file with gym class data on disk.
     */
    @Test
    public void loadGymClassesFromFile() {
        // needed for GymClass
        Trainer testTrainer = new Trainer("Zach", "Pangerl",
                BeltRank.Rank.BLACK2, BeltRank.Rank.BLACK3);
        // create a GymClass for testing
        GymClass testGymClass = new GymClass(
                new CalendarDate(new Date()),
                testTrainer);
        // set room of the GymClass
        testGymClass.setRoom(Room.GymRoom.ROOM1);
        assertEquals(0, GymClassList.getGymClasses().size());
        GymClassList.addGymClass(testGymClass);
        // save to disk
        GymClassListFileStorage.saveData();
        // clear list
        GymClassList.removeGymClass(testGymClass);
        // lis tshould be empty
        assertEquals(0, GymClassList.getGymClasses().size());
        // load data
        GymClassListFileStorage.loadData();
        // list should contain testGymClass
        assertEquals(1, GymClassList.getGymClasses().size());
        // verify testGymClass
        GymClass diskTestGymClass = GymClassList.getGymClasses().get(0);
        assertEquals(testGymClass.getCalendarDate().getMonth(),
                diskTestGymClass.getCalendarDate().getMonth());
        assertEquals(testGymClass.getCalendarDate().getYear(),
                diskTestGymClass.getCalendarDate().getYear());
        assertEquals(testGymClass.getCalendarDate().getDay(),
                diskTestGymClass.getCalendarDate().getDay());
        assertEquals(testGymClass.getClassType(), diskTestGymClass.getClassType());
        assertEquals(testGymClass.getRoom(), diskTestGymClass.getRoom());
        assertEquals(testGymClass.getTrainer().getFirstName(),
                diskTestGymClass.getTrainer().getFirstName());
        assertEquals(testGymClass.getTrainer().getLastName(),
                diskTestGymClass.getTrainer().getLastName());
        assertEquals(testGymClass.getTrainer().getBeltRank(),
                diskTestGymClass.getTrainer().getBeltRank());
        assertEquals(testGymClass.getTrainer().getTrainingRank(),
                diskTestGymClass.getTrainer().getTrainingRank());
    }

}
