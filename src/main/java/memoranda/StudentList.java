package main.java.memoranda;

public interface StudentList {
    /**
     * Returns a Student object given the students first and last name.
     *
     * @param lastName Students last name.
     * @param firstName Students first name.
     * @return Student object.
     */
    Student getStudentByName(String lastName, String firstName);

    /**
     * Returns a Student object given the students first and last name.
     *
     * @param student Student object to search for.
     * @return Student object.
     */
    Student getStudentByObject(Student student);

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
