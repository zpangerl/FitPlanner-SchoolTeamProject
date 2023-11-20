package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import main.java.memoranda.BeltRank.Rank;
import main.java.memoranda.Room.GymRoom;
import main.java.memoranda.GymClass;
import main.java.memoranda.Trainer;
import main.java.memoranda.ui.DailyAgendaPanel;

public class DailyAgendaPanelTest {

    @Test
    public void filterTest() {
        ArrayList<GymClass> classes = new ArrayList<>();
        List<GymClass> filtered = new ArrayList<>();
        Trainer trainer1 = new Trainer("Zach", "Pangerl", Rank.BLACK1, Rank.BLACK2);
        GymClass class1 = new GymClass(new Date(2000, 1, 1), trainer1);
        class1.setRoom(GymRoom.ROOM2);
        classes.add(class1);
        GymClass class2 = new GymClass(new Date(), trainer1);
        class2.setRoom(GymRoom.ROOM1);
        classes.add(class2);
        GymClass class3 = new GymClass(new Date(), trainer1);
        class3.setRoom(GymRoom.ROOM3);
        classes.add(class3);
        GymClass class4 = new GymClass(new Date(2000, 4, 1), trainer1);
        class4.setRoom(GymRoom.ROOM1);
        classes.add(class4);
        DailyAgendaPanel panel = new DailyAgendaPanel();
        filtered = panel.filterClasses(classes, "ROOM1");
        assertEquals(1, filtered.size());
        assertEquals(class2, filtered.get(0));
    }
}
