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

public class GymClass {

    private Date date;

    private Room.GymRoom room;
    private Trainer trainer;
    private ClassType classType;
    private List<Student> students;

    /**
     * Constructor for GymClass
     * 
     * @param date,    the date for the planned class.
     * @param trainer, the trainer assigned to teach the class.
     */
    public GymClass(Date date, Trainer trainer) {
        this.date = date;
        this.trainer = trainer;
        this.students = new ArrayList<Student>();
    }

    public void setClassType(String type) {
        this.classType = new ClassType(type);
    }

    public String getClassType() {
        return classType.toString();
    }

    public void setTrainer(Trainer t) {
        trainer = t;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setDate(Date d) {
        date = d;
    }

    public Date getDate() {
        return date;
    }

    public void setStudents(List<Student> s) {
        students = s;
    }
    public List<Student> getStudents() {
        return students;
    }
    public boolean addStudent(Student s) {
        if (students.size() < 20 && !students.contains(s)) {
            students.add(s);
            return true;
        }
        return false;
    }
    public boolean removeStudent(Student s) {
        if (students.contains(s)) {
            students.remove(s);
            return true;
        }
        return false;
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
