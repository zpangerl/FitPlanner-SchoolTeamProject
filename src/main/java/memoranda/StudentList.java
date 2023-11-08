package main.java.memoranda;

import nu.xom.Document;

import java.util.Vector;

public interface StudentList {
    /**
     * Returns a Student object given the students first and last name.
     *
     * @param lastName Students last name.
     * @param firstName Students first name.
     * @return Student object.
     */
    Student getStudent(String lastName, String firstName);

    /**
     * Adds a Student object to the StudentList
     *
     * @param student_add Student object to add.
     */
    void addStudent(Student student_add);

    /**
     * Removes a Student object for the StudentList.
     *
     * @param student_remove Student object to remove.
     */
    void removeStudent(Student student_remove);

    /**
     * Returns the current number of Students in the StudentList.
     *
     * @return Student count.
     */
    int getAllStudentCount();
}
