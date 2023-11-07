package main.java.memoranda;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class GymClass {
    
    private Date date;
    
    private Room.GymRoom room;
    
    /**
     * Creates a new GymClass object in a specific room.
     * @param room the room the class will be held in
     */
    public GymClass(Room.GymRoom room) {
        this.room = room;
    }
    
    /**
     * Retrieves the room that this gym class is being held in.
     * @return Room.GymRoom the room the gym class is being held in
     */
    public Room.GymRoom getRoom(){
        return this.room;
    }
    
    /**
     * Switches the gym class to another room.
     * @param room the room to be switched to
     */
    public void setRoom(Room.GymRoom room) {
        this.room = room;
    }
}