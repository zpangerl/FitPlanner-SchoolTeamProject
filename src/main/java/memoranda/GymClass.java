/**
 * GymClass.java
 * Created: Nov. 2nd, 2023
 * Author: Frank Lin
 *
 *
 * This class is used to represent a gym class.
 */

package main.java.memoranda;

import main.java.memoranda.Room.GymRoom;
import main.java.memoranda.date.CalendarDate;

public class GymClass {

    private CalendarDate date;
    private GymRoom room;
    private Trainer trainer;
    private ClassType classType;
    /**
     * Constructor for GymClass
     *
     * @param date,    the date for the planned class.
     * @param trainer, the trainer assigned to teach the class.
     */
    public GymClass(CalendarDate date, Trainer trainer) {
        this.date = date;
        this.trainer = trainer;
    }



    public void setClassType(String type) {
        this.classType = new ClassType(type);
    }

    public String getClassType() {
        return classType != null ? classType.toString() : "N/A";
    }

    public void setTrainer(Trainer t) {
        trainer = t;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setDate(CalendarDate d) {
        date = d;
    }

    public CalendarDate getDate() {
        return date;
    }

    public void setRoom(Room.GymRoom r) {
        room = r;
    }

    public Room.GymRoom getRoom() {
        return room;
    }

    /**
     * Declares what type the class is.
     */
    public class ClassType {

        String type;

        /*
         * ClassType Contructor
         */
        public ClassType(String type) {
            this.type = type;
        }

        public String toString() {
            return type;
        }
    }
}
