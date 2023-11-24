/*
  File: TestWhiteBoxTrainer.java
  Author: Steven Stovall
  Version: 2023-11-22

  Description: Provides Unit Tests to ensure that Trainer related methods work correctly.
*/

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import main.java.memoranda.BeltRank;
import main.java.memoranda.Trainer;
import main.java.memoranda.TrainerList;
import org.junit.Test;

/**
 Class: TestWhiteBoxTrainer

 Description: Tests Trainer related functions.
 */
public class TestWhiteBoxTrainer {

    /**
     * Test code paths in Trainer.java getter/setters
     */
    @Test
    public void trainerGettersSetters() {
        /* testing values */
        String firstName = "Steven";
        String lastName = "Stovall";
        Trainer trainer = new Trainer();
        assertNotNull(trainer);
        /* set/get name */
        trainer.setFirstName(firstName);
        trainer.setLastName(lastName);
        assertEquals(firstName, trainer.getFirstName());
        assertEquals(lastName, trainer.getLastName());
        assertEquals(firstName + " " + lastName, trainer.getName());
        /* set/get training rank and belt rank */
        BeltRank.Rank beltRank = BeltRank.Rank.BLUE; // testing value
        trainer.setBeltRank(beltRank);
        assertEquals(beltRank, trainer.getBeltRank());
        BeltRank.Rank trainingRank = BeltRank.Rank.YELLOW; // testing value
        trainer.setTrainingRank(trainingRank);
        assertEquals(trainingRank, trainer.getTrainingRank());
    }

    /**
     * Test code paths in Trainer.java constructor
     */
    @Test
    public void trainerConstructor() {
        /* testing values */
        String firstName = "Steven";
        String lastName = "Stovall";
        BeltRank.Rank beltRank = BeltRank.Rank.BLUE;
        BeltRank.Rank trainingRank = BeltRank.Rank.YELLOW;
        /* test constructor that adds everything to trainer at once */
        Trainer trainer = new Trainer(firstName, lastName, trainingRank, beltRank);
        assertNotNull(trainer);
        assertEquals(firstName, trainer.getFirstName());
        assertEquals(lastName, trainer.getLastName());
        assertEquals(firstName + " " + lastName, trainer.getName());
        assertEquals(beltRank, trainer.getBeltRank());
        assertEquals(trainingRank, trainer.getTrainingRank());
    }

    /**
     * Test code paths in TrainerList.java
     */
    @Test
    public void trainerListAddGetRemoveTrainers() {
        /* test trainer returns empty and not null */
        ArrayList<Trainer> trainers = TrainerList.getTrainers();
        assertNotNull(trainers);

        /* testing values */
        // create trainer1, trainer2
        Trainer trainer1 = new Trainer();
        Trainer trainer2 = new Trainer();

        // add trainer1 to TrainerList
        TrainerList.addTrainer(trainer1);
        assertThat(TrainerList.getTrainers(), hasItem(trainer1));
        assertThat(TrainerList.getTrainers(), not(hasItem(trainer2)));
        // add trainer2 to TrainerList
        TrainerList.addTrainer(trainer2);
        assertThat(TrainerList.getTrainers(), hasItem(trainer1));

        // remove trainer1
        TrainerList.removeTrainer(trainer1);
        assertThat(TrainerList.getTrainers(), hasItem(trainer2));
        assertThat(TrainerList.getTrainers(), not(hasItem(trainer1)));

        // test null branch of removeTrainer
        TrainerList.setTrainersNull();
        assertTrue(TrainerList.isTrainersNull());
        TrainerList.removeTrainer(trainer1); // try to remove trainer from null list
    }

    /**
     * Test BeltRank enum to String array conversion in TrainerDialog.
     */
    @Test
    public void trainerDialogConvertBeltRanksToStringArray() {
        String[] rankStrings = BeltRank.getBeltRanks();
        BeltRank.Rank[] ranks = BeltRank.Rank.values();
        assertEquals(ranks.length, rankStrings.length);
        int idx = 0;
        for (BeltRank.Rank rank : BeltRank.Rank.values()) {
            assertEquals(rank.toString(), rankStrings[idx]);
            idx++;
        }
    }

    /**
     * Test to ensure success and error messages of naming validation
     * when editing trainer. Partially BlackBox due to reliance
     * on validateName to build error messages.
     */
    @Test
    public void trainerEditTrainer() {
        /* initial trainer for tests */
        String firstName = "a";
        String lastName = "b";
        BeltRank.Rank beltRank = BeltRank.Rank.BLUE;
        BeltRank.Rank trainingRank = BeltRank.Rank.YELLOW;
        Trainer trainer = new Trainer(firstName, lastName, trainingRank, beltRank);

        /* 1. Boundary Value analysis:
         *  1.1 name length < 1 - error
         *  1.2 name length 1   - success
         *  1.3 name length 12  - success
         *  1.4 name length > 12 - error
         */
        // 1.1.1 first name length < 1
        String firstNameEdit = "";
        String errorMessage = trainer.editTrainer(firstNameEdit,
                lastName,
                beltRank,
                trainingRank);
        assertEquals("firstName must be between 1-12 characters\n", errorMessage);
        // 1.1.2 last name length < 1
        String lastNameEdit = "";
        errorMessage = trainer.editTrainer(firstName,
                lastNameEdit,
                beltRank,
                trainingRank);
        assertEquals("lastName must be between 1-12 characters\n", errorMessage);
        // 1.1.3 firstName and last name length < 1
        errorMessage = trainer.editTrainer(firstNameEdit,
                lastNameEdit,
                beltRank,
                trainingRank);
        assertEquals("firstName must be between 1-12 characters\n"
                + "lastName must be between 1-12 characters\n",
                errorMessage);
        // 1.2.1 first name length 1
        firstNameEdit = "a";
        errorMessage = trainer.editTrainer(firstNameEdit,
                lastName,
                beltRank,
                trainingRank);
        assertEquals("", errorMessage);
        // 1.2.2 last name length 1
        lastNameEdit = "a";
        errorMessage = trainer.editTrainer(firstName,
                lastNameEdit,
                beltRank,
                trainingRank);
        assertEquals("", errorMessage);
        // 1.2.3 firstName and last name length 1
        errorMessage = trainer.editTrainer(firstNameEdit,
                lastNameEdit,
                beltRank,
                trainingRank);
        assertEquals("", errorMessage);
        // 1.3.1 first name length 12
        firstNameEdit = "abcdabcdabcd";
        assertEquals(12, firstNameEdit.length());
        errorMessage = trainer.editTrainer(firstNameEdit,
                lastName,
                beltRank,
                trainingRank);
        assertEquals("", errorMessage);
        // 1.3.2 last name length 12
        lastNameEdit = "abcdabcdabcd";
        assertEquals(12, lastNameEdit.length());
        errorMessage = trainer.editTrainer(firstName,
                lastNameEdit,
                beltRank,
                trainingRank);
        assertEquals("", errorMessage);
        // 1.3.3 firstName and last name length 12
        errorMessage = trainer.editTrainer(firstNameEdit,
                lastNameEdit,
                beltRank,
                trainingRank);
        assertEquals("", errorMessage);
        // 1.4.1 first name length >12
        firstNameEdit = "abcdabcdabcdz";
        assertEquals(13, firstNameEdit.length());
        errorMessage = trainer.editTrainer(firstNameEdit,
                lastName,
                beltRank,
                trainingRank);
        assertEquals("firstName must be between 1-12 characters\n",
                errorMessage);
        // 1.4.2 last name length >12
        lastNameEdit = "abcdabcdabcdz";
        assertEquals(13, lastNameEdit.length());
        errorMessage = trainer.editTrainer(firstName,
                lastNameEdit,
                beltRank,
                trainingRank);
        assertEquals("lastName must be between 1-12 characters\n",
                errorMessage);
        // 1.4.3 firstName and last name length >12
        errorMessage = trainer.editTrainer(firstNameEdit,
                lastNameEdit,
                beltRank,
                trainingRank);
        assertEquals("firstName must be between 1-12 characters\n"
                + "lastName must be between 1-12 characters\n",
                errorMessage);
    }

    /**
     * Test to ensure success and error messages of naming validation
     * when validating name.
     */
    @Test
    public void trainerValidateName() {
        // trainer to test
        Trainer trainer = new Trainer();
        // equivalent partition: null, non-null
        // 1.1: null
        String testName = null;
        String parameterName = "parameterName";
        String errorMessage = trainer.validateName(testName,
                parameterName);
        assertEquals(parameterName + " must not be null\n", errorMessage);
        // 1.2: non-null (and meet [a-z] and length [1-12])
        testName = "a"; // non-null
        errorMessage = trainer.validateName(testName,
                parameterName);
        assertEquals("", errorMessage);

        // equivalent partition: contains letters, non-letters
        // 2.1 letters (and meet length [1-12])
        testName = "a";
        errorMessage = trainer.validateName(testName,
                parameterName);
        assertEquals("", errorMessage);
        // 2.2 non-letters (and meet length [1-12])
        testName = "1";
        errorMessage = trainer.validateName(testName,
                parameterName);
        assertEquals(parameterName + " must only contain letters\n", errorMessage);
    }

    /**
     * Test getting index of trainer in TrainerList.
     */
    @Test
    public void trainerListGetIndexOfTrainer() {
        TrainerList.clearTrainers();
        /* testing values */
        // create trainer1, trainer2
        Trainer trainer1 = new Trainer();
        Trainer trainer2 = new Trainer();
        // add trainer1 to TrainerList
        TrainerList.addTrainer(trainer1);
        // add trainer2 to TrainerList
        TrainerList.addTrainer(trainer2);
        // get index of trainer1
        int idx = TrainerList.getTrainerIndex(trainer1);
        assertEquals(0, idx);
        // get index of trainer2
        idx = TrainerList.getTrainerIndex(trainer2);
        assertEquals(1, idx);

        Trainer trainer3 = new Trainer();
        idx = TrainerList.getTrainerIndex(trainer3);
        assertEquals(-1, idx);

        TrainerList.removeTrainer(trainer1);
        TrainerList.removeTrainer(trainer2);
    }
}
