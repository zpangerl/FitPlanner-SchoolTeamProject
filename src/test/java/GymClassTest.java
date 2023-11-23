import main.java.memoranda.BeltRank.Rank;

import main.java.memoranda.GymClass;
import main.java.memoranda.Room.GymRoom;
import main.java.memoranda.Student;
import main.java.memoranda.Trainer;
import main.java.memoranda.date.CalendarDate;

import org.junit.Assert;
import org.junit.Test;

public class GymClassTest {

    /**
     * Tests to ensure that Room 1 is set properly on creation.
     */
    @Test
    public void testClassInRoom1() {
        Trainer trainer1 = new Trainer("Zach", "Pangerl", Rank.BLACK1, Rank.BLACK2);
        GymClass class1 = new GymClass(new CalendarDate(), trainer1);
        class1.setRoom(GymRoom.ROOM1);
        Assert.assertEquals(0, class1.getRoom().ordinal());
    }

    @Test
    /**
     * Tests to ensure that Room 4 is set properly on creation.
     */
    public void testClassInRoom4() {
        Trainer trainer4 = new Trainer("Zach", "Pangerl", Rank.BLACK1, Rank.BLACK2);
        GymClass class4 = new GymClass(new CalendarDate(), trainer4);
        class4.setRoom(GymRoom.ROOM4);
        Assert.assertEquals(3, class4.getRoom().ordinal());
    }

    /**
     * Test get and set class type.
     */
    @Test
    public void testGetSetClassType() {
        Trainer trainer1 = new Trainer("Zach", "Pangerl", Rank.BLACK1, Rank.BLACK2);
        GymClass class1 = new GymClass(new CalendarDate(), trainer1);
        class1.setClassType("Yoga");
        Assert.assertEquals("Yoga", class1.getClassType());
    }

    /**
     * Test get and set class Trainer.
     */
    @Test
    public void testGetSetClassTrainer() {
        Trainer trainer1 = new Trainer("Zach", "Pangerl", Rank.BLACK1, Rank.BLACK2);
        GymClass class1 = new GymClass(new CalendarDate(), trainer1);
        Trainer trainer2 = new Trainer("Zach", "Pangerl", Rank.BLACK1, Rank.BLACK2);
        class1.setTrainer(trainer2);
        Assert.assertEquals(trainer2, class1.getTrainer());
    }

    /**
     * Test get and set class date.
     */
    @Test
    public void testGetSetClassDate() {
        Trainer trainer1 = new Trainer("Zach", "Pangerl", Rank.BLACK1, Rank.BLACK2);
        GymClass class1 = new GymClass(new CalendarDate(2, 12, 2023), trainer1);
        CalendarDate date2 = new CalendarDate(2, 12, 2023);
        class1.setDate(date2);
        Assert.assertEquals(date2, class1.getDate());
    }

    /**
     * Test get class type if null.
     */
    @Test
    public void testGetClassTypeNull() {
        Trainer trainer1 = new Trainer("Zach", "Pangerl", Rank.BLACK1, Rank.BLACK2);
        GymClass class1 = new GymClass(new CalendarDate(), trainer1);
        Assert.assertEquals("N/A", class1.getClassType());
    }

    @Test
    /**
     * Test to ensure students can be added to a class.
     */
    public void testAddStudent() {
        Trainer trainer1 = new Trainer("Zach", "Pangerl", Rank.BLACK1, Rank.BLACK2);
        GymClass class1 = new GymClass(new CalendarDate(), trainer1);
        class1.setRoom(GymRoom.ROOM1);
        Student student1 = new Student("John", "Doe");
        Assert.assertTrue(class1.addStudent(student1));
        Assert.assertEquals(1, class1.getStudents().size());
    }

    @Test
    /**
     * Test to ensure students can be removed from a class.
     */
    public void testRemoveStudent() {
        Trainer trainer1 = new Trainer("Zach", "Pangerl", Rank.BLACK1, Rank.BLACK2);
        GymClass class1 = new GymClass(new CalendarDate(), trainer1);
        class1.setRoom(GymRoom.ROOM1);
        Student student1 = new Student("John", "Doe");
        Assert.assertTrue(class1.addStudent(student1));
        Assert.assertEquals(1, class1.getStudents().size());
        Assert.assertTrue(class1.removeStudent(student1));
        Assert.assertEquals(0, class1.getStudents().size());
    }

    @Test
    /**
     * Test to ensure students cannot be added to a full class.
     */
    public void testClassFull() {
        Trainer trainer1 = new Trainer("Zach", "Pangerl", Rank.BLACK1, Rank.BLACK2);
        GymClass class1 = new GymClass(new CalendarDate(), trainer1);
        class1.setRoom(GymRoom.ROOM1);
        for (int i = 0; i < 20; i++) {
            Student student = new Student("John", "Doe");
            Assert.assertTrue(class1.addStudent(student));
        }
        Assert.assertEquals(20, class1.getStudents().size());
        Student student = new Student("John", "Doe");
        Assert.assertFalse(class1.addStudent(student));
        Assert.assertEquals(20, class1.getStudents().size());
    }

    @Test
    /**
     * Test to ensure students cannot be removed from a class they are not in.
     */
    public void testRemoveStudentNotInClass() {
        Trainer trainer1 = new Trainer("Zach", "Pangerl", Rank.BLACK1, Rank.BLACK2);
        GymClass class1 = new GymClass(new CalendarDate(), trainer1);
        class1.setRoom(GymRoom.ROOM1);
        Student student1 = new Student("John", "Doe");
        Assert.assertEquals(0, class1.getStudents().size());
        Assert.assertFalse(class1.removeStudent(student1));
        Assert.assertEquals(0, class1.getStudents().size());
    }

    @Test
    /**
     * Test to ensure students cannot be added to a class they are already in.
     */
    public void testAddStudentAlreadyInClass() {
        Trainer trainer1 = new Trainer("Zach", "Pangerl", Rank.BLACK1, Rank.BLACK2);
        GymClass class1 = new GymClass(new CalendarDate(), trainer1);
        class1.setRoom(GymRoom.ROOM1);
        Student student1 = new Student("John", "Doe");
        Assert.assertTrue(class1.addStudent(student1));
        Assert.assertEquals(1, class1.getStudents().size());
        Assert.assertFalse(class1.addStudent(student1));
        Assert.assertEquals(1, class1.getStudents().size());
    }
}
