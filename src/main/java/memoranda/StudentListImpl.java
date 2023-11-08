package main.java.memoranda;

import java.util.ArrayList;


public class StudentListImpl implements StudentList {

    private ArrayList<Student> studentList = new ArrayList<Student>();

    /**
     * Checks if a Student object exists in the StudentList.
     *
     * @param check_student Student object to check for.
     * @return Returns true if student is in list, false otherwise.
     */
    public boolean studentExists(Student check_student){
        return studentList.contains(check_student);
    }

    /**
     * Returns Student object from StudentLlist given the students
     * first and last name.
     *
     * @param lastName Students last name.
     * @param firstName Students first name.
     * @return Student object.
     */
    @Override
    public Student getStudent(String lastName, String firstName) {
        for (int i = 0; i < studentList.size(); i++)
            if (studentList.get(i).getFirstName() == firstName && studentList.get(i).getLastName() == lastName)
                return studentList.get(i);
        return null;
    }

    /**
     * Adds Student object to StudentList.
     *
     * @param student_add Student object to add.
     */
    @Override
    public void addStudent(Student student_add) {
        studentList.add(student_add);
    }

    /**
     * Removes Student object from StudentList.
     *
     * @param student_remove Student object to remove.
     */
    @Override
    public void removeStudent(Student student_remove) {
        studentList.remove(student_remove);
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
