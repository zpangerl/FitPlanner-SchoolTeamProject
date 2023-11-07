package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.java.memoranda.Room;

import main.java.memoranda.GymClass;

public class GymClassTest {

    /**
     * Tests to ensure that Room 1 is set properly on creation.
     */
    @Test
    public void testClassInRoom1() {
        GymClass class1 = new GymClass(Room.GymRoom.ROOM1);
        assertEquals(0, class1.getRoom().ordinal());
    }
    
    @Test
    /**
     * Tests to ensure that Room 4 is set properly on creation.
     */
    public void testClassInRoom4() {
        GymClass class4 = new GymClass(Room.GymRoom.ROOM4);
        assertEquals(3, class4.getRoom().ordinal());
    }
}
