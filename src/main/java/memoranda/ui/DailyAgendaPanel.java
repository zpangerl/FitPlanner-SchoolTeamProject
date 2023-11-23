/**
 * DailyAgendaPanel.java
 * Created on November 20, 2023
 * Author: Zach Pangerl
 */

package main.java.memoranda.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import main.java.memoranda.GymClass;
import main.java.memoranda.GymClassList;
import main.java.memoranda.Room;

public class DailyAgendaPanel extends JPanel {
    private JPanel room1Panel;
    private JPanel room2Panel;
    private JPanel room3Panel;
    private JPanel room4Panel;
    private ArrayList<GymClass> classesData;
    final String[] roomsTableColNames = 
        {"Class Name", "Time", "Trainer"};
    
    /**
     * Default constructor for DailyAgendaPanel.
     * Sets up each of the room panels and
     * their tables
     */
    public DailyAgendaPanel() {
        classesData = GymClassList.getGymClasses();
        this.setLayout(new GridLayout(2, 2));
        room1Panel = createRoomPanel(Room.GymRoom.ROOM1.toString());
        this.add(room1Panel);
        room2Panel = createRoomPanel(Room.GymRoom.ROOM2.toString());
        this.add(room2Panel);
        room3Panel = createRoomPanel(Room.GymRoom.ROOM3.toString());
        this.add(room3Panel);
        room4Panel = createRoomPanel(Room.GymRoom.ROOM4.toString());
        this.add(room4Panel);
    }
    
    /**
     * Creates a panel for a specific room.
     * @param name the name of the room
     * @return the created panel
     */
    public JPanel createRoomPanel(String name) {
        String borderTitle;
        if (name.equals("ROOM1")) {
            borderTitle = "Room 1";
        } else if (name.equals("ROOM2")) {
            borderTitle = "Room 2";
        } else if (name.equals("ROOM3")) {
            borderTitle = "Room 3";
        } else {
            borderTitle = "Room 4";
        }
        JPanel roomPanel = new JPanel(new BorderLayout());
        TitledBorder border = BorderFactory.createTitledBorder(borderTitle);
        border.setTitleJustification(TitledBorder.CENTER);
        roomPanel.setName(name);
        roomPanel.setBorder(border);
        createDailyRoomTable(roomPanel, name);
        this.add(roomPanel);
        return roomPanel;
    }
    
    /**
     * Creates a table for a specific room panel.
     * @param roomPanel the panel that the table will be added to
     * @param name the name of the panel
     */
    private void createDailyRoomTable(JPanel roomPanel, String name) {
        List<GymClass> filtered = filterClasses(classesData, name);
        DefaultTableModel roomTableModel =
                new DefaultTableModel(convertToData(filtered), roomsTableColNames);
        JTable roomTable = new JTable(roomTableModel);
        roomTable.setEnabled(false);
        roomPanel.add(new JScrollPane(roomTable), BorderLayout.CENTER);
    }
    
    /**
     * Filters GymClasses by Room and Date.
     * @param classes the list of GymClasses
     * @param name the name of the Room
     * @return the filtered List
     */
    public List<GymClass> filterClasses(ArrayList<GymClass> classes,
            String name) {
        List<GymClass> filtered = new ArrayList<>();
        Room.GymRoom roomNum;
        Date classDate = new Date();
        if (name.equals("ROOM1")) {
            roomNum = Room.GymRoom.ROOM1;
        } else if (name.equals("ROOM2")) {
            roomNum = Room.GymRoom.ROOM2;
        } else if (name.equals("ROOM3")) {
            roomNum = Room.GymRoom.ROOM3;
        } else { 
            roomNum = Room.GymRoom.ROOM4;
        }
        for (GymClass gc : classes) {
            if (gc.getRoom() == roomNum
                    && gc.getDate().getDate() == classDate.getDate() 
                    && gc.getDate().getMonth() == classDate.getMonth()
                    && gc.getDate().getYear() == classDate.getYear()) {
                filtered.add(gc);
            }
        }
        return filtered;
    }
    
    /**
     * Converts each GymClass into data that can be placed.
     * in the table
     * @param filtered a filtered list of GymClass objects
     * @return the data from each Class in the list
     */
    private Object[][] convertToData(List<GymClass> filtered) {
        Object[][] data = new Object[filtered.size()][3];
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        for (int i = 0; i < filtered.size(); i++) {
            GymClass gymClass = filtered.get(i);
            String formattedTime = dateFormat.format(gymClass.getDate());
            data[i][0] = gymClass.getClassType();
            data[i][1] = formattedTime;
            data[i][2] = gymClass.getTrainer().getName();
        }
        return data;
    }
    
    /**
     * Updates the table in each room panel.
     */
    public void updateTables() {
        for (Component panel : this.getComponents()) {
            if (panel instanceof JPanel) {
                JPanel roomPanel = (JPanel) panel;
                roomPanel.removeAll();
                String roomName = roomPanel.getName();
                createDailyRoomTable(roomPanel, roomName);
            }
        }
    }
}