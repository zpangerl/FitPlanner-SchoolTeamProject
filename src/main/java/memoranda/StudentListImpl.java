package main.java.memoranda;

import java.util.*;


public class StudentListImpl implements StudentList {

    private ArrayList<Student> studentList = new ArrayList<Student>();

    /**
     * Checks if a Student object exists in the StudentList.
     *
     * @param checkStudent Student object to check for.
     * @return Returns true if student is in list, false otherwise.
     */
    public boolean studentExists(Student checkStudent) {
        return studentList.contains(checkStudent);
    }

    /**
     * Returns Student object from StudentList given the students first and last name.
     *
     * @param lastName Students last name.
     * @param firstName Students first name.
     * @return Student object.
     */
    @Override
    public Student getStudentByName(String lastName, String firstName) {
        for (Student student : studentList) {
            if (student.getFirstName() == firstName && student.getLastName() == lastName) {
                return student;
            }
        }
        return null;
    }

    /**
     * Returns a Student object given the students first and last name.
     *
     * @param student Student object to search for.
     * @return Student object.
     */
    @Override
    public Student getStudentByObject(Student student) {
        if (studentList.contains(student)) {
            return studentList.get(studentList.indexOf(student));
        }
        return null;
    }

    /**
     * Returns a Student object given the students index in the arraylist.
     *
     * @param index Index of student.
     * @return Student object.
     */
    public Student getStudentByIndex(int index) {
        if (studentList.size() < index) {
            return null;
        }
        return studentList.get(index);
    }

    /**
     * Adds Student object to StudentList.
     *
     * @param studentAdd Student object to add.
     */
    @Override
    public void addStudent(Student studentAdd) {
        if (studentExists(studentAdd)) {
            return;
        }
        studentList.add(studentAdd);
    }

    /**
     * Removes Student object from StudentList.
     *
     * @param studentRemove Student object to remove.
     */
    @Override
    public void removeStudent(Student studentRemove) {
        if (studentExists(studentRemove)) {
            studentList.remove(studentRemove);
        }
    }

    /**
     * Returns the current count of Students in StudentList.
     *
     * @return Count of current Students.
     */
    @Override
    public int getAllStudentCount() {
        return studentList.size();
    }
}
