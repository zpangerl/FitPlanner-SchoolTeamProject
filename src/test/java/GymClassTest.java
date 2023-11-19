import static org.junit.Assert.*;

import org.junit.Test;

import main.java.memoranda.Room.GymRoom;
import main.java.memoranda.date.CalendarDate;
import main.java.memoranda.BeltRank.Rank;
import main.java.memoranda.GymClass;
import main.java.memoranda.Trainer;

public class GymClassTest {

    /**
     * Tests to ensure that Room 1 is set properly on creation.
     */
    @Test
    public void testClassInRoom1() {
        Trainer trainer1 = new Trainer("Zach", "Pangerl", Rank.BLACK1, Rank.BLACK2);
        GymClass class1 = new GymClass(new CalendarDate(), trainer1);
        class1.setRoom(GymRoom.ROOM1);
        assertEquals(0, class1.getRoom().ordinal());
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
}
