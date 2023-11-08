import main.java.memoranda.BeltRank;
import main.java.memoranda.Student;
import main.java.memoranda.StudentListImpl;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;

import static org.junit.Assert.assertEquals;

public class TestStudentClasses {

    /**
     * Tests the creation of student using last and first name.
     */
    @Test
    public void createStudentJustName(){
        Student tempStudent = new Student("Mckeighan", "Sean");
        Assert.assertEquals("Sean", tempStudent.getFirstName());
        Assert.assertEquals("Mckeighan", tempStudent.getLastName());
    }

    /**
     * Tests the creation of student using last name, first name, belt color, and training rank.
     */
    @Test
    public void createStudentAllData(){
        BeltRank.Rank belt = BeltRank.Rank.WHITE;
        BeltRank.Rank belt_train = BeltRank.Rank.YELLOW;
        Student tempStudent = new Student("Mckeighan", "Sean", 20, belt, belt_train);
        Assert.assertEquals("Sean", tempStudent.getFirstName());
        Assert.assertEquals("Mckeighan", tempStudent.getLastName());
        Assert.assertEquals(20, tempStudent.getAge());
        Assert.assertEquals(BeltRank.Rank.WHITE, tempStudent.getBeltRank());
        Assert.assertEquals(BeltRank.Rank.YELLOW, tempStudent.getTrainingRank());
    }

    /**
     * Tests the modification of student first and last name.
     */
    @Test
    public void modifyStudentName(){
        Student tempStudent = new Student("mckeighan", "sean");
        tempStudent.setFirstName("Sean");
        tempStudent.setLastName("Mckeighan");
        Assert.assertEquals("Sean", tempStudent.getFirstName());
        Assert.assertEquals("Mckeighan", tempStudent.getLastName());
    }

    /**
     * Tests the modification of student belt color and training rank.
     */
    @Test
    public void modifyStudentBelt(){
        BeltRank.Rank belt = BeltRank.Rank.WHITE;
        BeltRank.Rank belt_train = BeltRank.Rank.YELLOW;
        Student tempStudent = new Student("Mckeighan", "Sean", 20, belt, belt_train);
        tempStudent.setBeltColor(BeltRank.Rank.BLACK1);
        tempStudent.setTrainingRank(BeltRank.Rank.BLACK2);
        Assert.assertEquals(BeltRank.Rank.BLACK1, tempStudent.getBeltRank());
        Assert.assertEquals(BeltRank.Rank.BLACK2, tempStudent.getTrainingRank());
    }

    /**
     * Tests adding student to a student list.
     */
    @Test
    public void addStudent(){
        StudentListImpl testList = new StudentListImpl();
        Student tempStudent_1 = new Student("Mckeighan", "Sean");
        testList.addStudent(tempStudent_1);
        Assert.assertTrue(testList.studentExists(tempStudent_1));
    }

    /**
     * Tests adding student to a student list where that student is already present.
     */
    @Test
    public void addExistingStudent(){
        StudentListImpl testList = new StudentListImpl();
        Student tempStudent_1 = new Student("Mckeighan", "Sean");
        testList.addStudent(tempStudent_1);
        testList.addStudent(tempStudent_1);
        Assert.assertEquals(1, testList.getAllStudentCount());
    }

    /**
     * Tests ability to retrieve student from list given last and first name.
     */
    @Test
    public void getExistingStudent(){
        StudentListImpl testList = new StudentListImpl();
        Student tempStudent_1 = new Student("Mckeighan", "Sean");
        testList.addStudent(tempStudent_1);
        Assert.assertEquals(testList.getStudent("Mckeighan", "Sean"), tempStudent_1);
    }

    /**
     * Tests ability to return null when given last and first name not in list.
     */
    @Test
    public void getNonExistentStudent(){
        StudentListImpl testList = new StudentListImpl();
        Student tempStudent_1 = new Student("Mckeighan", "Sean");
        testList.addStudent(tempStudent_1);
        Assert.assertEquals(testList.getStudent("Sckeighan", "Mean"), null);
    }

    /**
     * Tests the ability to remove a student from a student list.
     */
    @Test
    public void removeStudent(){
        StudentListImpl testList = new StudentListImpl();
        Student tempStudent_1 = new Student("Mckeighan", "Sean");
        testList.addStudent(tempStudent_1);
        testList.removeStudent(tempStudent_1);
        Assert.assertTrue(!testList.studentExists(tempStudent_1));
    }

    /**
     * Tests count with a single student in list.
     */
    @Test
    public void singleStudentListCount(){
        Student tempStudent = new Student("Mckeighan", "Sean");
        StudentListImpl testList = new StudentListImpl();
        testList.addStudent(tempStudent);
        assertEquals(1, testList.getAllStudentCount());
    }

    /**
     * Tests count with no students in list.
     */
    @Test
    public void zeroStudentListCount(){
        StudentListImpl testList = new StudentListImpl();
        assertEquals(0, testList.getAllStudentCount());
    }

    /**
     * Tests count with multiple students in list.
     */
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
