/*
  File: GymClassListTest.java
  Author: Rhett Harrison
  Version: 2023-11-10

  Description: Provides Unit Tests to ensure that GymClassList class.
*/

import main.java.memoranda.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

/**
 Class: GymClassList

 Description: Tests GymClassList related functions.
 */
public class GymClassListTest {

    @Before
    public void setUp() {
        GymClassList.getGymClasses().clear();

        // Create three trainers to vary beltRank and trainingRank
        Trainer tmpTrainer1 = new Trainer();
        tmpTrainer1.setFirstName("FirstnameTest" + "-1");
        tmpTrainer1.setLastName("LastnameTest" + "-1");
        tmpTrainer1.setTrainingRank(BeltRank.Rank.BLUE);
        tmpTrainer1.setBeltRank(BeltRank.Rank.BLUE_STRIPE);
        TrainerList.addTrainer(tmpTrainer1);

        Trainer tmpTrainer2 = new Trainer();
        tmpTrainer2.setFirstName("FirstnameTest" + "-2");
        tmpTrainer2.setLastName("LastnameTest" + "-2");
        tmpTrainer2.setTrainingRank(BeltRank.Rank.GREEN);
        tmpTrainer2.setBeltRank(BeltRank.Rank.GREEN_STRIPE);
        TrainerList.addTrainer(tmpTrainer2);

        Trainer tmpTrainer3 = new Trainer();
        tmpTrainer3.setFirstName("FirstnameTest" + "-3");
        tmpTrainer3.setLastName("LastnameTest" + "-3");
        tmpTrainer3.setTrainingRank(BeltRank.Rank.BROWN1);
        tmpTrainer3.setBeltRank(BeltRank.Rank.BROWN2);
        TrainerList.addTrainer(tmpTrainer3);

        // Create three gym classes
        GymClass gymClass1 = new GymClass(new Date(), tmpTrainer1);
        GymClass gymClass2 = new GymClass(new Date(), tmpTrainer2);
        GymClass gymClass3 = new GymClass(new Date(), tmpTrainer3);

        GymClassList.addGymClass(gymClass1);
        GymClassList.addGymClass(gymClass2);
        GymClassList.addGymClass(gymClass3);

    }

    /**
     * Test code paths in GymClassList.java
     */
    @Test
    public void trainerListAddGetRemoveGymClasses() {
        /* test trainer returns empty and not null */
        ArrayList<GymClass> gymClasses = GymClassList.getGymClasses();
        assertNotNull(gymClasses);
        assertNotEquals(0, gymClasses.size());

        GymClass gymClass1 = new GymClass(new Date(), TrainerList.getTrainers().get(0));
        GymClass gymClass2 = new GymClass(new Date(), TrainerList.getTrainers().get(1));

        // add gymClass1 to GymClassList
        GymClassList.addGymClass(gymClass1);
        assertThat(GymClassList.getGymClasses(), hasItem(gymClass1));
        assertThat(GymClassList.getGymClasses(), not(hasItem(gymClass2)));

        // add gymClass2 to GymClassList
        GymClassList.addGymClass(gymClass2);
        assertThat(GymClassList.getGymClasses(), hasItem(gymClass2));

        // remove gymClass1
        GymClassList.removeGymClass(gymClass1);
        assertThat(GymClassList.getGymClasses(), not(hasItem(gymClass1)));
        assertThat(GymClassList.getGymClasses(), hasItem(gymClass2));

        // remove gymClassByIndex
        GymClass temporaryGymClass = GymClassList.getGymClasses().get(0);
        GymClassList.removeGymClassByIndex(0);
        assertThat(GymClassList.getGymClasses(), not(hasItem(temporaryGymClass)));
    }
}
