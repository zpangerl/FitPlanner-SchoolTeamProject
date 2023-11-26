/*
  File: TestWhiteBoxTrainer.java
  Author: Steven Stovall
  Version: 2023-11-07

  Description: Provides Unit Tests to ensure that Trainer related methods work correctly.
*/

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

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
        // Clear the list
        TrainerList.getTrainers().clear();
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
     * Test getting index of trainer in TrainerList.
     */
    @Test
    public void trainerListGetIndexOfTrainer() {
        TrainerList.getTrainers().clear();
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
