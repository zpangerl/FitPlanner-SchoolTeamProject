import org.junit.Test;

import main.java.memoranda.Room.GymRoom;
import main.java.memoranda.date.CalendarDate;
import main.java.memoranda.BeltRank.Rank;
import main.java.memoranda.GymClass;
import main.java.memoranda.Trainer;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;

public class GymClassTest {

    /**
     * Tests to ensure that Room 1 is set properly on creation.
     */
    @Test
    public void testClassInRoom1() {
        Trainer trainer1 = new Trainer("Zach", "Pangerl", Rank.BLACK1, Rank.BLACK2);
        GymClass class1 = new GymClass(new CalendarDate(), trainer1);
        class1.setRoom(GymRoom.ROOM1);
        Assert.assertEquals(0, class1.getRoom().ordinal());
    }

    @Test
    /**
     * Tests to ensure that Room 4 is set properly on creation.
     */
    public void testClassInRoom4() {
        Trainer trainer4 = new Trainer("Zach", "Pangerl", Rank.BLACK1, Rank.BLACK2);
        GymClass class4 = new GymClass(new CalendarDate(), trainer4);
        class4.setRoom(GymRoom.ROOM4);
        assertEquals(3, class4.getRoom().ordinal());
    }

    /**
     * Test get and set class type.
     */
    @Test
    public void testGetSetClassType() {
        Trainer trainer1 = new Trainer("Zach", "Pangerl", Rank.BLACK1, Rank.BLACK2);
        GymClass class1 = new GymClass(new CalendarDate(), trainer1);
        class1.setClassType("Yoga");
        assertEquals("Yoga", class1.getClassType());
    }

    /**
     * Test get and set class Trainer.
     */
    @Test
    public void testGetSetClassTrainer() {
        Trainer trainer1 = new Trainer("Zach", "Pangerl", Rank.BLACK1, Rank.BLACK2);
        GymClass class1 = new GymClass(new CalendarDate(), trainer1);
        Trainer trainer2 = new Trainer("Zach", "Pangerl", Rank.BLACK1, Rank.BLACK2);
        class1.setTrainer(trainer2);
        assertEquals(trainer2, class1.getTrainer());
    }

    /**
     * Test get and set class date.
     */
    @Test
    public void testGetSetClassDate() {
        Trainer trainer1 = new Trainer("Zach", "Pangerl", Rank.BLACK1, Rank.BLACK2);
        GymClass class1 = new GymClass(new CalendarDate(2, 12, 2023), trainer1);
        CalendarDate date2 = new CalendarDate(2, 12, 2023);
        class1.setDate(date2);
        assertEquals(date2, class1.getDate());
    }

    /**
     * Test get class type if null.
     */
    @Test
    public void testGetClassTypeNull() {
        Trainer trainer1 = new Trainer("Zach", "Pangerl", Rank.BLACK1, Rank.BLACK2);
        GymClass class1 = new GymClass(new CalendarDate(), trainer1);
        assertEquals("N/A", class1.getClassType());
    }
}
