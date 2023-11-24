/**
 * GymClass.java
 * Created: Nov. 2nd, 2023
 * Author: Frank Lin
 *
 * This class is used to represent a gym class.
 */

package main.java.memoranda;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import main.java.memoranda.date.CalendarDate;

public class GymClass {

    private CalendarDate date;
    private Room.GymRoom room;
    private Trainer trainer;
    private ClassType classType;
    private final List<Student> students;

    /**
     * Constructor for GymClass.
     *
     * @param date    the date for the planned class.
     * @param trainer the trainer assigned to teach the class.
     */
    public GymClass(CalendarDate date, Trainer trainer) {
        this.date = date;
        this.trainer = trainer;
        this.students = new ArrayList<>();
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

    public void setCalendarDate(CalendarDate d) {
        date = d;
    }

    public CalendarDate getCalendarDate() {
        return date;
    }

    public Date getDate() {
        return date.getDate();
    }

    public void setRoom(Room.GymRoom r) {
        room = r;
    }

    public Room.GymRoom getRoom() {
        return room;
    }

    /**
     * Returns the list of students in the class.
     * @param student the student to add to the class.
     * @return true if the student was added, false otherwise.
     */
    public boolean addStudent(Student student) {
        if (!students.contains(student) && students.size() < 20) {
            students.add(student);
            return true;
        }
        return false;
    }

    /**
     * Removes a student from the class.
     * @param student the student to remove from the class.
     * @return true if the student was removed, false otherwise.
     */
    public boolean removeStudent(Student student) {
        if (students.contains(student)) {
            students.remove(student);
            return true;
        }
        return false;
    }

    public List<Student> getStudents() {
        return students;
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
