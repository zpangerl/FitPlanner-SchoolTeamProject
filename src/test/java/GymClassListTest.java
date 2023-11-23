/*
  File: GymClassListTest.java
  Author: Rhett Harrison
  Version: 2023-11-10

  Description: Provides Unit Tests to ensure that GymClassList class.
*/

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Date;
import main.java.memoranda.BeltRank;
import main.java.memoranda.GymClass;
import main.java.memoranda.GymClassList;
import main.java.memoranda.Trainer;
import main.java.memoranda.TrainerList;
import main.java.memoranda.date.CalendarDate;

import org.junit.Before;
import org.junit.Test;

/**
 Class: GymClassList

 Description: Tests GymClassList related functions.
 */
public class GymClassListTest {

    /**
     * Set up test data.
     */
    @Before
    public void setUp() {
        GymClassList.getGymClasses().clear();

        // Create three trainers to vary beltRank and trainingRank
        // Borrowed from Trainer implementation to create Trainer test data
        // Required for GymClassList testing
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

        Date today = new Date();
        Date tomorrow = new Date(today.getTime() + (1000 * 60 * 60 * 24));
        Date yesterday = new Date(today.getTime() - (1000 * 60 * 60 * 24));
        // Create three gym classes
        GymClass gymClass1 = new GymClass(new CalendarDate(today), tmpTrainer1);
        GymClass gymClass2 = new GymClass(new CalendarDate(tomorrow), tmpTrainer2);
        GymClass gymClass3 = new GymClass(new CalendarDate(yesterday), tmpTrainer3);

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

        GymClass gymClass1 = new GymClass(new CalendarDate(), TrainerList.getTrainers().get(0));
        GymClass gymClass2 = new GymClass(new CalendarDate(), TrainerList.getTrainers().get(1));

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

    /**
     * Test GymClassList sorted ascending by date.
     */
    @Test
    public void gymClassListSortedByDate() {
        GymClassList.getGymClasses().clear();

        // Create three trainers to vary beltRank and trainingRank
        // Borrowed from Trainer implementation to create Trainer test data
        // Required for GymClassList testing
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

        Date today = new Date();
        Date tomorrow = new Date(today.getTime() + (1000 * 60 * 60 * 24));
        Date yesterday = new Date(today.getTime() - (1000 * 60 * 60 * 24));
        // Create three gym classes
        GymClass gymClass1 = new GymClass(new CalendarDate(today), tmpTrainer1);
        GymClass gymClass2 = new GymClass(new CalendarDate(tomorrow), tmpTrainer2);
        GymClass gymClass3 = new GymClass(new CalendarDate(yesterday), tmpTrainer3);

        GymClassList.addGymClass(gymClass1);
        GymClassList.addGymClass(gymClass2);
        GymClassList.addGymClass(gymClass3);

        GymClassList.sortClassesByDateAscending();
        assertEquals(GymClassList.getGymClasses().get(0), gymClass3);
        assertEquals(GymClassList.getGymClasses().get(1), gymClass1);
        assertEquals(GymClassList.getGymClasses().get(2), gymClass2);
    }

    /**
     * Test GymClassList sorted descending by date.
     */
    @Test
    public void gymClassListSortedByDateDescending() {
        GymClassList.getGymClasses().clear();

        // Create three trainers to vary beltRank and trainingRank
        // Borrowed from Trainer implementation to create Trainer test data
        // Required for GymClassList testing
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

        Date today = new Date();
        Date tomorrow = new Date(today.getTime() + (1000 * 60 * 60 * 24));
        Date yesterday = new Date(today.getTime() - (1000 * 60 * 60 * 24));
        // Create three gym classes
        GymClass gymClass1 = new GymClass(new CalendarDate(today), tmpTrainer1);
        GymClass gymClass2 = new GymClass(new CalendarDate(tomorrow), tmpTrainer2);
        GymClass gymClass3 = new GymClass(new CalendarDate(yesterday), tmpTrainer3);

        GymClassList.addGymClass(gymClass1);
        GymClassList.addGymClass(gymClass2);
        GymClassList.addGymClass(gymClass3);

        GymClassList.sortClassesByDateDescending();
        assertEquals(GymClassList.getGymClasses().get(0), gymClass2);
        assertEquals(GymClassList.getGymClasses().get(1), gymClass1);
        assertEquals(GymClassList.getGymClasses().get(2), gymClass3);
    }
}
