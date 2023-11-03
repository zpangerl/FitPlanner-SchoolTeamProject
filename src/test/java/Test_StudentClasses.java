import main.java.memoranda.Student;
import main.java.memoranda.StudentListImpl;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;

import static org.junit.Assert.assertEquals;

public class Test_StudentClasses {

    @Test
    public void addStudent(){
        StudentListImpl testList = new StudentListImpl();
        Student tempStudent_1 = new Student("Mckeighan", "Sean");
        testList.addStudent(tempStudent_1);
        Assert.assertTrue(testList.studentExists(tempStudent_1));
    }

    @Test
    public void getStudent(){
        StudentListImpl testList = new StudentListImpl();
        Student tempStudent_1 = new Student("Mckeighan", "Sean");
        testList.addStudent(tempStudent_1);
        Assert.assertEquals(testList.getStudent("Mckeighan", "Sean"), tempStudent_1);
    }

    @Test
    public void removeStudent(){
        StudentListImpl testList = new StudentListImpl();
        Student tempStudent_1 = new Student("Mckeighan", "Sean");
        testList.addStudent(tempStudent_1);
        testList.removeStudent(tempStudent_1);
        Assert.assertTrue(!testList.studentExists(tempStudent_1));
    }

    @Test
    public void singleStudentListCount(){
        Student tempStudent = new Student("Mckeighan", "Sean");
        StudentListImpl testList = new StudentListImpl();
        testList.addStudent(tempStudent);
        assertEquals(1, testList.getAllStudentCount());
    }

    @Test
    public void zeroStudentListCount(){
        StudentListImpl testList = new StudentListImpl();
        assertEquals(0, testList.getAllStudentCount());
    }

    @Test
    public void multipleStudentListCount(){
        Student tempStudent_1 = new Student("Mckeighan", "Sean");
        Student tempStudent_2 = new Student("Harrison", "Rhett");
        Student tempStudent_3 = new Student("Stovall", "Steven");
        Student tempStudent_4 = new Student("Pangerl", "Zach");
        Student tempStudent_5 = new Student("NotSure", "Frankie");
        StudentListImpl testList = new StudentListImpl();
        testList.addStudent(tempStudent_1);
        testList.addStudent(tempStudent_2);
        testList.addStudent(tempStudent_3);
        testList.addStudent(tempStudent_4);
        testList.addStudent(tempStudent_5);
        assertEquals(5, testList.getAllStudentCount());
    }

}
