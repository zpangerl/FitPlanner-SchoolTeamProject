/*
  File: TestWhiteBoxTrainer.java
  Author: Steven Stovall
  Version: 2023-11-07

  Description: Provides Unit Tests to ensure that Trainer related methods work correctly
*/

import main.java.memoranda.BeltRank;
import main.java.memoranda.Trainer;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 Class: TestWhiteBoxTrainer

 Description: Tests Trainer related functions
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
        BeltRank.Rank beltRank = BeltRank.Rank.BLUE;
        BeltRank.Rank trainingRank = BeltRank.Rank.YELLOW;
        Trainer trainer = new Trainer();
        assertNotNull(trainer);
        /* set/get name */
        trainer.setFirstName(firstName);
        trainer.setLastName(lastName);
        assertEquals(firstName, trainer.getFirstName());
        assertEquals(lastName, trainer.getLastName());
        assertEquals(firstName + " " + lastName, trainer.getName());
        /* set/get training rank and belt rank */
        trainer.setBeltRank(beltRank);
        assertEquals(beltRank, trainer.getBeltRank());
        trainer.setTrainingRank(trainingRank);
        assertEquals(trainingRank, trainer.getTrainingRank());
    }

}