import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import main.java.memoranda.BeltRank;
import main.java.memoranda.Student;
import main.java.memoranda.StudentListImpl;
import org.junit.BeforeClass;
import org.junit.Test;



public class TestStudentClasses {

    /**
     * Before all tests, setup clean environment.
     */
    @BeforeClass
    public static void setup() {
        /* Rhett's clear solution from GymClassListTest.java
           Make sure StudentListImpl is clear at start. */
        StudentListImpl.getStudentList().clear();
    }

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
        Student tempStudent1 = new Student("Mckeighan", "Sean");
        StudentListImpl.addStudent(tempStudent1);
        assertTrue(StudentListImpl.studentExists(tempStudent1));
    }

    /**
     * Tests adding student to a student list where that student is already present.
     */
    @Test
    public void addExistingStudent() {
        StudentListImpl.getStudentList().clear();
        Student tempStudent1 = new Student("Mckeighan", "Sean");
        StudentListImpl.addStudent(tempStudent1);
        StudentListImpl.addStudent(tempStudent1);
        assertEquals(1, StudentListImpl.getAllStudentCount());
    }

    /**
     * Tests ability to retrieve student from list given last and first name.
     */
    @Test
    public void getExistingStudent() {
        Student tempStudent1 = new Student("Mckeighan", "Sean");
        StudentListImpl.addStudent(tempStudent1);
        assertEquals(StudentListImpl.getStudentByObject(tempStudent1), tempStudent1);
    }

    /**
     * Tests ability to return null when given last and first name not in list.
     */
    @Test
    public void getNonExistentStudent() {
        Student tempStudent1 = new Student("Mckeighan", "Sean");
        StudentListImpl.addStudent(tempStudent1);
        assertNull(StudentListImpl.getStudentByName("Sckeighan", "Mean"));
    }

    /**
     * Tests the ability to remove a student from a student list.
     */
    @Test
    public void removeStudent() {
        Student tempStudent1 = new Student("Mckeighan", "Sean");
        StudentListImpl.addStudent(tempStudent1);
        StudentListImpl.removeStudent(tempStudent1);
        assertFalse(StudentListImpl.studentExists(tempStudent1));
    }
    
    /**
     * Tests count with a single student in list.
     */
    @Test
    public void singleStudentListCount() {
        StudentListImpl.getStudentList().clear();
        Student tempStudent = new Student("Mckeighan", "Sean");
        StudentListImpl.addStudent(tempStudent);
        assertEquals(1, StudentListImpl.getAllStudentCount());
    }
    
    /**
     * Tests zero student list count.
     */
    @Test
    public void zeroStudentListCount() {
        StudentListImpl.getStudentList().clear();
        assertEquals(0, StudentListImpl.getAllStudentCount());
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
        Student tempStudent5 = new Student("Lin", "Frankie");
        StudentListImpl.addStudent(tempStudent1);
        StudentListImpl.addStudent(tempStudent2);
        StudentListImpl.addStudent(tempStudent3);
        StudentListImpl.addStudent(tempStudent4);
        StudentListImpl.addStudent(tempStudent5);
        assertEquals(5, StudentListImpl.getAllStudentCount());
        while (StudentListImpl.getStudentList().size() > 0) {
            StudentListImpl.removeStudent(StudentListImpl.getStudentByIndex(0));
        }
    }

    /**
     * Tests adding student to a student list.
     */
    @Test
    public void studentListModificationTwo() {
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

    /**
     * Test to ensure success and error messages of naming validation
     * when editing student. Partially BlackBox due to reliance
     * on validateName to build error messages.
     * Possible refactor opportunity of similar (not quite duplicate)
     * but Trainer related is in separate branch pending review
     * and running out of time (TestWhiteBoxTrainer.java).
     */
    @Test
    public void studentEditStudent() {
        /* initial student for tests */
        String firstName = "a";
        String lastName = "b";
        int age = 99;
        BeltRank.Rank beltRank = BeltRank.Rank.BLUE;
        BeltRank.Rank trainingRank = BeltRank.Rank.YELLOW;
        Student student = new Student(lastName, firstName, age, beltRank, trainingRank);

        /* 1. Boundary Value analysis:
         *  1.1 name length < 1 - error
         *  1.2 name length 1   - success
         *  1.3 name length 12  - success
         *  1.4 name length > 12 - error
         */
        // 1.1.1 first name length < 1
        String firstNameEdit = "";
        String errorMessage = student.editStudent(firstNameEdit,
                lastName,
                age,
                trainingRank,
                beltRank);
        assertEquals("firstName must be between 1-12 characters\n", errorMessage);
        // 1.1.2 last name length < 1
        String lastNameEdit = "";
        errorMessage = student.editStudent(firstName,
                lastNameEdit,
                age,
                trainingRank,
                beltRank);
        assertEquals("lastName must be between 1-12 characters\n", errorMessage);
        // 1.1.3 firstName and last name length < 1
        errorMessage = student.editStudent(firstNameEdit,
                lastNameEdit,
                age,
                trainingRank,
                beltRank);
        assertEquals("firstName must be between 1-12 characters\n"
                        + "lastName must be between 1-12 characters\n",
                errorMessage);
        // 1.2.1 first name length 1
        firstNameEdit = "a";
        errorMessage = student.editStudent(firstNameEdit,
                lastName,
                age,
                trainingRank,
                beltRank);
        assertEquals("", errorMessage);
        // 1.2.2 last name length 1
        lastNameEdit = "a";
        errorMessage = student.editStudent(firstName,
                lastNameEdit,
                age,
                trainingRank,
                beltRank);
        assertEquals("", errorMessage);
        // 1.2.3 firstName and last name length 1
        errorMessage = student.editStudent(firstNameEdit,
                lastNameEdit,
                age,
                trainingRank,
                beltRank);
        assertEquals("", errorMessage);
        // 1.3.1 first name length 12
        firstNameEdit = "abcdabcdabcd";
        assertEquals(12, firstNameEdit.length());
        errorMessage = student.editStudent(firstNameEdit,
                lastName,
                age,
                trainingRank,
                beltRank);
        assertEquals("", errorMessage);
        // 1.3.2 last name length 12
        lastNameEdit = "abcdabcdabcd";
        assertEquals(12, lastNameEdit.length());
        errorMessage = student.editStudent(firstName,
                lastNameEdit,
                age,
                trainingRank,
                beltRank);
        assertEquals("", errorMessage);
        // 1.3.3 firstName and last name length 12
        errorMessage = student.editStudent(firstNameEdit,
                lastNameEdit,
                age,
                trainingRank,
                beltRank);
        assertEquals("", errorMessage);
        // 1.4.1 first name length >12
        firstNameEdit = "abcdabcdabcdz";
        assertEquals(13, firstNameEdit.length());
        errorMessage = student.editStudent(firstNameEdit,
                lastName,
                age,
                trainingRank,
                beltRank);
        assertEquals("firstName must be between 1-12 characters\n",
                errorMessage);
        // 1.4.2 last name length >12
        lastNameEdit = "abcdabcdabcdz";
        assertEquals(13, lastNameEdit.length());
        errorMessage = student.editStudent(firstName,
                lastNameEdit,
                age,
                trainingRank,
                beltRank);
        assertEquals("lastName must be between 1-12 characters\n",
                errorMessage);
        // 1.4.3 firstName and last name length >12
        errorMessage = student.editStudent(firstNameEdit,
                lastNameEdit,
                age,
                trainingRank,
                beltRank);
        assertEquals("firstName must be between 1-12 characters\n"
                        + "lastName must be between 1-12 characters\n",
                errorMessage);
    }

    /**
     * Test to ensure success and error messages of naming validation
     * when validating name.
     * Possible refactor opportunity of similar (not quite duplicate)
     * but Trainer related is in separate branch pending review
     * and running out of time (TestWhiteBoxTrainer.java).
     */
    @Test
    public void studentValidateName() {
        /* initial student for tests */
        String firstName = "a";
        String lastName = "b";
        int age = 99;
        BeltRank.Rank beltRank = BeltRank.Rank.BLUE;
        BeltRank.Rank trainingRank = BeltRank.Rank.YELLOW;
        Student student = new Student(lastName, firstName, age, beltRank, trainingRank);

        // equivalent partition: null, non-null
        // 1.1: null
        String testName = null;
        String parameterName = "parameterName";
        String errorMessage = student.validateName(testName,
                parameterName);
        assertEquals(parameterName + " must not be null\n", errorMessage);
        // 1.2: non-null (and meet [a-z] and length [1-12])
        testName = "a"; // non-null
        errorMessage = student.validateName(testName,
                parameterName);
        assertEquals("", errorMessage);

        // equivalent partition: contains letters, non-letters
        // 2.1 letters (and meet length [1-12])
        testName = "a";
        errorMessage = student.validateName(testName,
                parameterName);
        assertEquals("", errorMessage);
        // 2.2 non-letters (and meet length [1-12])
        testName = "1";
        errorMessage = student.validateName(testName,
                parameterName);
        assertEquals(parameterName + " must only contain letters\n", errorMessage);
    }

}
