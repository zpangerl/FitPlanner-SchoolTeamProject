import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import main.java.memoranda.BeltRank;
import main.java.memoranda.Student;
import main.java.memoranda.StudentListImpl;
import main.java.memoranda.TrainerList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;



public class TestStudentClasses {

    /**
     * Tests the creation of student using last and first name.
     */
    @Test
    public void createStudentJustName() {
        Student tempStudent = new Student("Mckeighan", "Sean");
        assertEquals("Sean", tempStudent.getFirstName());
        assertEquals("Mckeighan", tempStudent.getLastName());
    }

    /**
     * Tests the creation of student using last name, first name, belt color, and training rank.
     */
    @Test
    public void createStudentAllData() {
        BeltRank.Rank belt = BeltRank.Rank.WHITE;
        BeltRank.Rank beltTrain = BeltRank.Rank.YELLOW;
        Student tempStudent = new Student("Mckeighan", "Sean", 20, belt, beltTrain);
        assertEquals("Sean", tempStudent.getFirstName());
        assertEquals("Mckeighan", tempStudent.getLastName());
        assertEquals(20, tempStudent.getAge());
        assertEquals(BeltRank.Rank.WHITE, tempStudent.getBeltRank());
        assertEquals(BeltRank.Rank.YELLOW, tempStudent.getTrainingRank());
    }

    /**
     * Tests the modification of student first and last name.
     */
    @Test
    public void modifyStudentName() {
        Student tempStudent = new Student("mckeighan", "sean");
        tempStudent.setFirstName("Sean");
        tempStudent.setLastName("Mckeighan");
        assertEquals("Sean", tempStudent.getFirstName());
        assertEquals("Mckeighan", tempStudent.getLastName());
    }

    /**
     * Tests the modification of student belt color and training rank.
     */
    @Test
    public void modifyStudentBelt() {
        BeltRank.Rank belt = BeltRank.Rank.WHITE;
        BeltRank.Rank beltTrain = BeltRank.Rank.YELLOW;
        Student tempStudent = new Student("Mckeighan", "Sean", 20, belt, beltTrain);
        tempStudent.setBeltColor(BeltRank.Rank.BLACK1);
        tempStudent.setTrainingRank(BeltRank.Rank.BLACK2);
        assertEquals(BeltRank.Rank.BLACK1, tempStudent.getBeltRank());
        assertEquals(BeltRank.Rank.BLACK2, tempStudent.getTrainingRank());
    }

    /**
     * Tests adding student to a student list.
     */
    @Test
    public void addStudent() {
        StudentListImpl testList = new StudentListImpl();
        Student tempStudent1 = new Student("Mckeighan", "Sean");
        testList.addStudent(tempStudent1);
        assertTrue(testList.studentExists(tempStudent1));
    }

    /**
     * Tests adding student to a student list where that student is already present.
     */
    @Test
    public void addExistingStudent() {
        StudentListImpl testList = new StudentListImpl();
        Student tempStudent1 = new Student("Mckeighan", "Sean");
        testList.addStudent(tempStudent1);
        testList.addStudent(tempStudent1);
        assertEquals(1, testList.getAllStudentCount());
    }

    /**
     * Tests ability to retrieve student from list given last and first name.
     */
    @Test
    public void getExistingStudent() {
        StudentListImpl testList = new StudentListImpl();
        Student tempStudent1 = new Student("Mckeighan", "Sean");
        testList.addStudent(tempStudent1);
        assertEquals(testList.getStudentByObject(tempStudent1), tempStudent1);
    }

    /**
     * Tests ability to return null when given last and first name not in list.
     */
    @Test
    public void getNonExistentStudent() {
        StudentListImpl testList = new StudentListImpl();
        Student tempStudent1 = new Student("Mckeighan", "Sean");
        testList.addStudent(tempStudent1);
        assertNull(testList.getStudentByName("Sckeighan", "Mean"));
    }

    /**
     * Tests the ability to remove a student from a student list.
     */
    @Test
    public void removeStudent() {
        StudentListImpl testList = new StudentListImpl();
        Student tempStudent1 = new Student("Mckeighan", "Sean");
        testList.addStudent(tempStudent1);
        testList.removeStudent(tempStudent1);
        assertFalse(testList.studentExists(tempStudent1));
    }
    
    /**
     * Tests modifying the StudentList.
     */
    @Test
    public void studentListModification() {
        while (StudentListImpl.getStudentList().size() > 0) {
            StudentListImpl.removeStudent(StudentListImpl.getStudentByIndex(0));
        }

        Student tempStudent1 = new Student("Mckeighan", "Sean");
        // Check student added is present in list
        StudentListImpl.addStudent(tempStudent1);
        assertTrue(StudentListImpl.studentExists(tempStudent1));
        // Check duplicate student is not added
        StudentListImpl.addStudent(tempStudent1);
        assertEquals(1, StudentListImpl.getStudentList().size());
        // Check ability to get existing student
        StudentListImpl.addStudent(tempStudent1);
        assertEquals(StudentListImpl.getStudentByObject(tempStudent1), tempStudent1);
        // Check return on non-existing student get
        assertEquals(StudentListImpl.getStudentByName("Sckeighan", "Mean"), null);
        // Check removal of student
        StudentListImpl.removeStudent(tempStudent1);
        assertTrue(!StudentListImpl.studentExists(tempStudent1));
        // Check return of empty list count
        assertEquals(0, StudentListImpl.getStudentList().size());
        // Check return count of list when multiple student present
        Student tempStudent2 = new Student("Harrison", "Rhett");
        Student tempStudent3 = new Student("Stovall", "Steven");
        Student tempStudent4 = new Student("Pangerl", "Zach");
        Student tempStudent5 = new Student("NotSure", "Frankie");
        StudentListImpl.addStudent(tempStudent1);
        StudentListImpl.addStudent(tempStudent2);
        StudentListImpl.addStudent(tempStudent3);
        StudentListImpl.addStudent(tempStudent4);
        StudentListImpl.addStudent(tempStudent5);
        assertEquals(5, StudentListImpl.getStudentList().size());
        while (StudentListImpl.getStudentList().size() > 0) {
            StudentListImpl.removeStudent(StudentListImpl.getStudentByIndex(0));
        }
    }
}
