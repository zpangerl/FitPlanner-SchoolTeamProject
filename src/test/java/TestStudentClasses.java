import main.java.memoranda.BeltRank;
import main.java.memoranda.Student;
import main.java.memoranda.StudentListImpl;
import org.junit.Assert;
import org.junit.Test;

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
    public void studentListModification(){
        StudentListImpl testList = new StudentListImpl();
        Student tempStudent_1 = new Student("Mckeighan", "Sean");
        // Check student added is present in list
        testList.addStudent(tempStudent_1);
        Assert.assertTrue(testList.studentExists(tempStudent_1));
        assertEquals(1, testList.getAllStudentCount());
        // Check duplicate student is not added
        testList.addStudent(tempStudent_1);
        Assert.assertEquals(1, testList.getAllStudentCount());
        // Check ability to get existing student
        testList.addStudent(tempStudent_1);
        Assert.assertEquals(testList.getStudentByObject(tempStudent_1), tempStudent_1);
        // Check return on non-existing student get
        Assert.assertEquals(testList.getStudentByName("Sckeighan", "Mean"), null);
        // Check removal of student
        testList.removeStudent(tempStudent_1);
        Assert.assertTrue(!testList.studentExists(tempStudent_1));
        // Check return of empty list count
        assertEquals(0, testList.getAllStudentCount());
        // Check return count of list when multiple student present
        Student tempStudent_2 = new Student("Harrison", "Rhett");
        Student tempStudent_3 = new Student("Stovall", "Steven");
        Student tempStudent_4 = new Student("Pangerl", "Zach");
        Student tempStudent_5 = new Student("NotSure", "Frankie");
        StudentListImpl testList0 = new StudentListImpl();
        testList0.addStudent(tempStudent_1);
        testList0.addStudent(tempStudent_2);
        testList0.addStudent(tempStudent_3);
        testList0.addStudent(tempStudent_4);
        testList0.addStudent(tempStudent_5);
        assertEquals(5, testList0.getAllStudentCount());
    }
}
