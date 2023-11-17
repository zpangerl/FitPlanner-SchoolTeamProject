package main.java.memoranda;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class StudentListImpl {

    private static ArrayList<Student> studentList = new ArrayList<Student>();

    /**
     * Checks if a Student object exists in the StudentList.
     *
     * @param check_student Student object to check for.
     * @return Returns true if student is in list, false otherwise.
     */
    public static boolean studentExists(Student check_student){
        return studentList.contains(check_student);
    }

    /**
     * Returns Student object from StudentList given the students first and last name.
     *
     * @param lastName Students last name.
     * @param firstName Students first name.
     * @return Student object.
     */

    public Student getStudentByName(String lastName, String firstName) {
        for (int i = 0; i < studentList.size(); i++)
            if (studentList.get(i).getFirstName() == firstName && studentList.get(i).getLastName() == lastName)
                return studentList.get(i);
        return null;
    }

    /**
     * Returns a Student object given the students first and last name.
     *
     * @param student Student object to search for.
     * @return Student object.
     */
    public Student getStudentByObject(Student student) {
        if(studentList.contains(student)) {
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
        if(studentList.size() < index) {
            return null;
        }
        return studentList.get(index);
    }

    /**
     * Adds Student object to StudentList.
     *
     * @param student_add Student object to add.
     */
    public static void addStudent(Student student_add) {
        if(studentExists(student_add)) {
            return;
        }
        studentList.add(student_add);
    }

    /**
     * Removes Student object from StudentList.
     *
     * @param student_remove Student object to remove.
     */
    public static void removeStudent(Student student_remove) {
        if (studentExists(student_remove)) {
            studentList.remove(student_remove);
        }
    }

    /**
     * Returns the list of students.
     * @return List of students.
     */
    public static ArrayList<Student> getStudentList() {
        return studentList;
    }

    /**
     * Returns the current count of Students in StudentList.
     *
     * @return Count of current Students.
     */
    public int getAllStudentCount() {
        return studentList.size();
    }
}
