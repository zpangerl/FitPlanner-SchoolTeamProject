package main.java.memoranda;

import java.util.ArrayList;


public class StudentListImpl implements StudentList {

    private ArrayList<Student> studentList = new ArrayList<Student>();

    public boolean studentExists(Student check_student){
        return studentList.contains(check_student);
    }

    @Override
    public Student getStudent(String lastName, String firstName) {
        for (int i = 0; i < studentList.size(); i++)
            if (studentList.get(i).getFirstName() == firstName && studentList.get(i).getLastName() == lastName)
                return studentList.get(i);
        return null;
    }

    @Override
    public void addStudent(Student student_add) {
        studentList.add(student_add);
    }

    @Override
    public void removeStudent(Student student_remove) {
        studentList.remove(student_remove);
    }

    @Override
    public int getAllStudentCount() {
        return studentList.size();
    }
}
