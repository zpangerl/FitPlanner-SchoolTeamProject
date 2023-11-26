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
import java.util.Objects;
import main.java.memoranda.date.CalendarDate;

public class GymClass {

    private CalendarDate date;
    private Room.GymRoom room;
    private Trainer trainer;
    private String classType;
    private final List<Student> students;

    /**
     * Constructor for GymClass.
     *
     * @param date the date for the planned class.
     * @param trainer the trainer assigned to teach the class.
     */
    public GymClass(CalendarDate date, Trainer trainer) {
        this.date = date;
        this.trainer = trainer;
        this.students = new ArrayList<>();
        this.classType = "";
    }

    public void setClassType(String type) {
        this.classType = type;
    }

    public String getClassType() {
        return classType;
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

    /**
     * Return the date of the class in Date format rather than CalendarDate.
     * @return the date of the class.
     */
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GymClass gymClass = (GymClass) o;
        return Objects.equals(date, gymClass.date)
                && room == gymClass.room
                && Objects.equals(trainer, gymClass.trainer)
                && Objects.equals(classType, gymClass.classType)
                && Objects.equals(students, gymClass.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, room, trainer, classType, students);
    }

    @Override
    public String toString() {
        return "GymClass{"
                + "date=" + date
                + ", room=" + room
                + ", trainer=" + trainer
                + ", classType='" + classType + '\''
                + ", students=" + students + '}';
    }
}
