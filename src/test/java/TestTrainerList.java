/*
  File: TestTrainerList.java
  Author: Steven Stovall
  Version: 2023-11-22

  Description: Provides Unit Tests to ensure that TrainerList related methods work correctly.
*/

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;

import java.util.Arrays;

import main.java.memoranda.BeltRank;
import main.java.memoranda.Trainer;
import main.java.memoranda.TrainerList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 Class: TestTrainerList

 Description: Tests TrainerList related functions.
 */
public class TestTrainerList {

    /**
     * Before all tests, setup clean environment with no TrainerList data on disk.
     * reference: setup, tearDown from TestTRainerListFileStorage
     */
    @BeforeClass
    public static void setup() {
        /* Rhett's clear solution from GymClassListTest.java
           Make sure TrainerList is clear at start, since GymClassListTest
           adds trainers */
        TrainerList.getTrainers().clear();
    }

    /**
     * After all tests, leave a clean environment with no TrainerList data on disk.
     */
    @AfterClass
    public static void tearDown() {
        TrainerList.getTrainers().clear();
        assertEquals(0, TrainerList.getTrainers().size()); // ensure empty
    }

    /**
     * Test getTrainersArray to ensure proper array conversion.
     */
    @Test
    public void getTrainersArray() {
        assertEquals(0, TrainerList.getTrainers().size()); // ensure empty
        Trainer testTrainer1 = new Trainer("first1",
                "last1",
                BeltRank.Rank.BLUE, // training rank
                BeltRank.Rank.BLUE_STRIPE); // belt rank
        Trainer testTrainer2 = new Trainer("first2",
                "last2",
                BeltRank.Rank.GREEN,
                BeltRank.Rank.GREEN_STRIPE);
        TrainerList.addTrainer(testTrainer1);
        TrainerList.addTrainer(testTrainer2);
        // reference: https://www.geeksforgeeks.org/arrays-deeptostring-in-java-with-example/
        String actualTrainersArray = Arrays.deepToString(TrainerList.getTrainersArray());
        String expectedTrainersArray =
                "[[first1, last1, BLUE, BLUE_STRIPE], [first2, last2, GREEN, GREEN_STRIPE]]";
        System.out.println(actualTrainersArray);
        assertEquals(expectedTrainersArray, actualTrainersArray);
    }

    /**
     * Test getTrainers() to ensure handling of null.
     */
    @Test
    public void getTrainers() {
        TrainerList.setTrainersNull();
        assertTrue(TrainerList.isTrainersNull());
        assertNotNull(TrainerList.getTrainers());
        assertFalse(TrainerList.isTrainersNull());
    }

    /**
     * Ensure proper exception throw when utility class instantiated.
     */
    @Test(expected = AssertionError.class)
    public void exceptionInstantiateUtilityTrainerList() {
        // reference: https://www.baeldung.com/junit-assert-exception
        try {
            TrainerList trainerList = new TrainerList();
        } catch (Exception e) {
            assertEquals("Do not instantiate class",e.getMessage());
        }
    }

    /**
     * Test {get|remove}TrainerByIndex to ensure proper index.
     */
    @Test
    public void getRemoveTrainerByIndex() {
        TrainerList.clearTrainers();
        assertEquals(0, TrainerList.getTrainers().size());
        // test trainers
        Trainer testTrainer1 = new Trainer("first1",
                "last1",
                BeltRank.Rank.BLUE, // training rank
                BeltRank.Rank.BLUE_STRIPE); // belt rank
        Trainer testTrainer2 = new Trainer("first2",
                "last2",
                BeltRank.Rank.GREEN,
                BeltRank.Rank.GREEN_STRIPE);
        // get trainers by index
        TrainerList.addTrainer(testTrainer1);
        TrainerList.addTrainer(testTrainer2);
        assertEquals(testTrainer1, TrainerList.getTrainerByIndex(0));
        assertEquals(testTrainer2, TrainerList.getTrainerByIndex(1));
        // remove trainer by index
        assertNotEquals(testTrainer2, TrainerList.getTrainerByIndex(0));
        TrainerList.removeTrainerByIndex(0);
        // after remove, testTrainer2 index goes from 1 to 0
        assertEquals(testTrainer2, TrainerList.getTrainerByIndex(0));
    }

}
