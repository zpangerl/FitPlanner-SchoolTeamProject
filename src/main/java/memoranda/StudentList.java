package main.java.memoranda;

import nu.xom.Document;

import java.util.Vector;

public interface StudentList {
    Student getStudent(String lastName, String firstName);
    void addStudent(Student student_add);
    void removeStudent(Student student_remove);
    int getAllStudentCount();
}
