package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.java.memoranda.Room;

public class RoomTest {

    @Test
    public void testRoom0() {
        assertEquals(0, Room.GymRoom.getRooms()[0].getRoomNumber());
    }

    @Test
    public void testRoom3() {
        assertEquals(3, Room.GymRoom.getRooms()[3].getRoomNumber());
    }
}
