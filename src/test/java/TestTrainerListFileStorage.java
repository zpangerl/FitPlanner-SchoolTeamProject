/*
  File: TestTrainerListFileStorage.java
  Author: Steven Stovall
  Version: 2023-11-11

  Description: Provides Unit Tests to ensure that TrainerListFileStorage works correctly
*/

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import java.io.File;
import main.java.memoranda.BeltRank;
import main.java.memoranda.Trainer;
import main.java.memoranda.TrainerList;
import main.java.memoranda.TrainerListFileStorage;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 Class: TestTrainerListFileStorage

 Description: Tests that TrainListFileStorage properly loads/saves data to disk.
 */
public class TestTrainerListFileStorage {

    /**
     * Before all tests, setup clean environment with no TrainerList data on disk.
     */
    @BeforeClass
    public static void setup() {
        // Destructive: Intended to only run in dev environment
        // Deletes trainer data to test with clean environment

        // Reference: https://www.baeldung.com/junit-before-beforeclass-beforeeach-beforeall
        // Prepare clean test environment
        File trainerFile = new File(TrainerListFileStorage.trainerListPath);
        if (trainerFile.exists()) {
            trainerFile.delete();
        }
        assertFalse(trainerFile.exists());
    }

    /**
     * Test load program with no file on disk.
     */
    @Test
    public void loadTrainersNoFile() {
        try {
            // load data when file does not exist
            TrainerListFileStorage.loadData();
        } catch (Exception e) {
            // Simulates user opening program for the first time with no data
            fail("Should not throw exception when no file exists on disk");
        }
    }

    /**
     * Test load file with trainer data on disk.
     */
    @Test
    public void loadTrainersFromFile() {
        // prepare
        Trainer testTrainer = new Trainer(
                "testFirstname",
                "testLastname",
                BeltRank.Rank.BLUE,
                BeltRank.Rank.GREEN);
        assertEquals(0, TrainerList.getTrainers().size());
        TrainerList.addTrainer(testTrainer);
        // save to disk
        TrainerListFileStorage.saveData();
        // clear list
        TrainerList.removeTrainer(testTrainer);
        // list should be empty
        assertEquals(0, TrainerList.getTrainers().size());
        // load list
        TrainerListFileStorage.loadData();
        // list should contain testTrainer
        assertEquals(1, TrainerList.getTrainers().size());
        // verify testTrainer
        Trainer testTrainerFromDisk;
        testTrainerFromDisk = TrainerList.getTrainers().get(0);
        assertEquals(testTrainer.getName(),testTrainerFromDisk.getName());
        assertEquals(testTrainer.getBeltRank(), testTrainerFromDisk.getBeltRank());
        assertEquals(testTrainer.getTrainingRank(), testTrainerFromDisk.getTrainingRank());
    }
}
