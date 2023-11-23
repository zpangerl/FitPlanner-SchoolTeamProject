package main.java.memoranda;

/**
 * Room.java
 * Created on November 3rd, 2023
 * Author: Zach Pangerl
 * 
 * This class is used to represent rooms in a gym.
 */
public class Room {
    
    /**
     * This enum represents the four rooms of the gym.
     */
    public enum GymRoom {
        ROOM1,
        ROOM2,
        ROOM3,
        ROOM4;

        /**
         * Returns the name of the room.
         * @return name of room
         */
        public static GymRoom getRoomByIndex(int selectedIndex) {
            return GymRoom.values()[selectedIndex];
        }

        /**
         * Gets the index of the room.
         */
        public static int getIndexByRoom(GymRoom room) {
            return room.ordinal();
        }
    }
}
