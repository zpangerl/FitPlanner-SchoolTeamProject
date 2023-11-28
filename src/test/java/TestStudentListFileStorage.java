import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import main.java.memoranda.BeltRank;
import main.java.memoranda.Student;
import main.java.memoranda.StudentListFileStorage;
import main.java.memoranda.StudentListImpl;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 Class: TestStudentListFileStorage

 Description: Tests that StudentListFileStorage properly loads/saves data to disk.
 */
public class TestStudentListFileStorage {

    /**
     * Before all tests, setup clean environment with no StudentList data on disk.
     */
    @BeforeClass
    public static void setup() {
        /* Rhett's clear solution from GymClassListTest.java
        Make sure StudentListImpl is clear at start. */
        StudentListImpl.getStudentList().clear();
        // Destructive: Intended to only run in dev environment
        // Deletes student data to test with clean environment

        // Reference: https://www.baeldung.com/junit-before-beforeclass-beforeeach-beforeall
        // Prepare clean test environment
        File studentFile = new File(StudentListFileStorage.studentListPath);
        if (studentFile.exists()) {
            studentFile.delete();
        }
        assertFalse(studentFile.exists());
    }
    
    /**
     * After tests, clear all Student data from the disk.
     */
    @AfterClass
    public static void tearDown() {
        // Destructive: Intended to only run in dev environment
        File studentFile = new File(StudentListFileStorage.studentListPath);
        if (studentFile.exists()) {
            boolean deleted = (studentFile.delete());
            assertTrue(deleted);
        }
        assertFalse(studentFile.exists());
    }

    /**
     * Test load program with no file on disk.
     */
    @Test
    public void loadStudentsNoFile() {
        try {
            // load data when file does not exist
            StudentListFileStorage.loadData();
        } catch (Exception e) {
            // Simulates user opening program for the first time with no data
            fail("Should not throw exception when no file exists on disk");
        }
    }

    /**
     * Test load file with student data on disk.
     */
    @Test
    public void loadStudentsFromFile() {
        // prepare
        Student testStudent = new Student(
                "testFirstname",
                "testLastname",
                21,
                BeltRank.Rank.BLUE,
                BeltRank.Rank.GREEN);
        assertEquals(0, StudentListImpl.getStudentList().size());
        StudentListImpl.addStudent(testStudent);
        // save to disk
        StudentListFileStorage.saveData();
        // clear list
        StudentListImpl.removeStudent(testStudent);
        // list should be empty
        assertEquals(0, StudentListImpl.getStudentList().size());
        // load list
        StudentListFileStorage.loadData();
        // list should contain test student
        assertEquals(1, StudentListImpl.getStudentList().size());
        // verify testStudent
        Student testStudentFromDisk;
        testStudentFromDisk = StudentListImpl.getStudentList().get(0);
        assertEquals(testStudent.getFirstName(),testStudentFromDisk.getFirstName());
        assertEquals(testStudent.getLastName(),testStudentFromDisk.getLastName());
        assertEquals(testStudent.getTrainingRank(), testStudentFromDisk.getTrainingRank());
    }

}

