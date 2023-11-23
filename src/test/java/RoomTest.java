
import static org.junit.Assert.*;

import org.junit.Test;

import main.java.memoranda.Room;

/**
 * RoomTest.java
 * Created on November 3, 2023
 * Author: Zach Pangerl
 * 
 * This test case tests the enum values from Room.
 */
public class RoomTest {
    
    /**
     * Tests the first Room's value.
     */
    @Test
    public void testRoom1() {
        assertEquals(0, Room.GymRoom.ROOM1.ordinal());
    }
    
    /**
     * Tests the second Room's value.
     */
    @Test
    public void testRoom2() {
        assertEquals(1, Room.GymRoom.ROOM2.ordinal());
    }
    
    /**
     * Tests the third Room's value.
     */
    @Test
    public void testRoom3() {
        assertEquals(2, Room.GymRoom.ROOM3.ordinal());
    }
    
    /**
     * Tests the fourth Room's value.
     */
    @Test
    public void testRoom4() {
        assertEquals(3, Room.GymRoom.ROOM4.ordinal());
    }

    /**
     * Tests the getIndexByRoom method.
     */
    @Test
    public void testGetRoomByIndex() {
        assertEquals(Room.GymRoom.ROOM1, Room.GymRoom.getRoomByIndex(0));
        assertEquals(Room.GymRoom.ROOM2, Room.GymRoom.getRoomByIndex(1));
        assertEquals(Room.GymRoom.ROOM3, Room.GymRoom.getRoomByIndex(2));
        assertEquals(Room.GymRoom.ROOM4, Room.GymRoom.getRoomByIndex(3));
    }
}
