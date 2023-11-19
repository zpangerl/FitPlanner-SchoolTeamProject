package test;

import java.util.Date;
import main.java.memoranda.BeltRank.Rank;
import main.java.memoranda.GymClass;
import main.java.memoranda.Room.GymRoom;
import main.java.memoranda.Student;
import main.java.memoranda.Trainer;
import org.junit.Test;

import static org.junit.Assert.*;

public class GymClassTest {

    /**
     * Tests to ensure that Room 1 is set properly on creation.
     */
    @Test
    public void testClassInRoom1() {
        Trainer trainer1 = new Trainer("Zach", "Pangerl", Rank.BLACK1, Rank.BLACK2);
        GymClass class1 = new GymClass(new Date(), trainer1);
        class1.setRoom(GymRoom.ROOM1);
        assertEquals(0, class1.getRoom().ordinal());
    }
    
    @Test
    /**
     * Tests to ensure that Room 4 is set properly on creation.
     */
    public void testClassInRoom4() {
        Trainer trainer4 = new Trainer("Zach", "Pangerl", Rank.BLACK1, Rank.BLACK2);
        GymClass class4 = new GymClass(new Date(), trainer4);
        class4.setRoom(GymRoom.ROOM4);
        assertEquals(3, class4.getRoom().ordinal());
    }

    @Test
    /**
     * Test to ensure students can be added to a class.
     */
    public void testAddStudent() {
        Trainer trainer1 = new Trainer("Zach", "Pangerl", Rank.BLACK1, Rank.BLACK2);
        GymClass class1 = new GymClass(new Date(), trainer1);
        class1.setRoom(GymRoom.ROOM1);
        Student student1 = new Student("John", "Doe");
        assertTrue(class1.addStudent(student1));
        assertEquals(1, class1.getStudents().size());
    }

    @Test
    /**
     * Test to ensure students can be removed from a class.
     */
    public void testRemoveStudent() {
        Trainer trainer1 = new Trainer("Zach", "Pangerl", Rank.BLACK1, Rank.BLACK2);
        GymClass class1 = new GymClass(new Date(), trainer1);
        class1.setRoom(GymRoom.ROOM1);
        Student student1 = new Student("John", "Doe");
        assertTrue(class1.addStudent(student1));
        assertEquals(1, class1.getStudents().size());
        assertTrue(class1.removeStudent(student1));
        assertEquals(0, class1.getStudents().size());
    }

    @Test
    /**
     * Test to ensure students cannot be added to a full class.
     */
    public void testClassFull() {
        Trainer trainer1 = new Trainer("Zach", "Pangerl", Rank.BLACK1, Rank.BLACK2);
        GymClass class1 = new GymClass(new Date(), trainer1);
        class1.setRoom(GymRoom.ROOM1);
        for (int i = 0; i < 20; i++) {
            Student student = new Student("John", "Doe");
            assertTrue(class1.addStudent(student));
        }
        assertEquals(20, class1.getStudents().size());
        Student student = new Student("John", "Doe");
        assertFalse(class1.addStudent(student));
        assertEquals(20, class1.getStudents().size());
    }

    @Test
    /**
     * Test to ensure students cannot be removed from a class they are not in.
     */
    public void testRemoveStudentNotInClass() {
        Trainer trainer1 = new Trainer("Zach", "Pangerl", Rank.BLACK1, Rank.BLACK2);
        GymClass class1 = new GymClass(new Date(), trainer1);
        class1.setRoom(GymRoom.ROOM1);
        Student student1 = new Student("John", "Doe");
        assertEquals(0, class1.getStudents().size());
        assertFalse(class1.removeStudent(student1));
        assertEquals(0, class1.getStudents().size());
    }

    @Test
    /**
     * Test to ensure students cannot be added to a class they are already in.
     */
    public void testAddStudentAlreadyInClass() {
        Trainer trainer1 = new Trainer("Zach", "Pangerl", Rank.BLACK1, Rank.BLACK2);
        GymClass class1 = new GymClass(new Date(), trainer1);
        class1.setRoom(GymRoom.ROOM1);
        Student student1 = new Student("John", "Doe");
        assertTrue(class1.addStudent(student1));
        assertEquals(1, class1.getStudents().size());
        assertFalse(class1.addStudent(student1));
        assertEquals(1, class1.getStudents().size());
    }
}
