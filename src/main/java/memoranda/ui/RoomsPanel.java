package main.java.memoranda.ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import main.java.memoranda.BeltRank.Rank;
import main.java.memoranda.GymClass;
import main.java.memoranda.Room;
import main.java.memoranda.Trainer;

public class RoomsPanel extends JPanel {
    private JPanel switchPanel;
    private JPanel room1Panel;
    private JTable room1Table;
    private JPanel room2Panel;
    private JTable room2Table;
    private JPanel room3Panel;
    private JTable room3Table;
    private JPanel room4Panel;
    private JTable room4Table;
    private JPanel buttonPanel;
    private CardLayout cardLayout;
    private ArrayList<GymClass> classesData;
    final String[] roomsTableColNames = 
        {"Class name", "Date", "Trainer"};
    
    public RoomsPanel() {
        Trainer trainer1 = new Trainer("Zach", "Pangerl", Rank.BLACK1, Rank.BLACK2);
        GymClass class1 = new GymClass(new Date(), trainer1);
        class1.setClassType("Weights");
        class1.setRoom(Room.GymRoom.ROOM2);
        classesData = new ArrayList<>();
        classesData.add(class1);
        this.setLayout(new BorderLayout());
        cardLayout = new CardLayout();
        switchPanel = new JPanel(cardLayout);
        room1Panel = createRoomPanel("ROOM1");
        room2Panel = createRoomPanel("ROOM2");
        room3Panel = createRoomPanel("ROOM3");
        room4Panel = createRoomPanel("ROOM4");
        buttonPanel = new JPanel(new GridLayout(1, 4));
        JButton room1Button = new JButton("Room 1");
        JButton room2Button = new JButton("Room 2");
        JButton room3Button = new JButton("Room 3");
        JButton room4Button = new JButton("Room 4");
        room1Button.addActionListener(e -> showRoom(Room.GymRoom.ROOM1));
        room2Button.addActionListener(e -> showRoom(Room.GymRoom.ROOM2));
        room3Button.addActionListener(e -> showRoom(Room.GymRoom.ROOM3));
        room4Button.addActionListener(e -> showRoom(Room.GymRoom.ROOM4));
        buttonPanel.add(room1Button);
        buttonPanel.add(room2Button);
        buttonPanel.add(room3Button);
        buttonPanel.add(room4Button);
        add(switchPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.NORTH);
    }
    
    public JPanel createRoomPanel(String name) {
        String borderTitle;
        if(name.equals("ROOM1")) {
            borderTitle = "Room 1";
        }
        else if(name.equals("ROOM2")) {
            borderTitle = "Room 2";
        }
        else if(name.equals("ROOM3")) {
            borderTitle = "Room 3";
        }
        else {
            borderTitle = "Room 4";
        }
        JPanel roomPanel = new JPanel(new BorderLayout());
        Border border = BorderFactory.createTitledBorder(borderTitle);
        roomPanel.setBorder(border);
        createRoomTable(roomPanel, name);
        switchPanel.add(roomPanel, name);
        return roomPanel;
    }
    
    private void createRoomTable(JPanel roomPanel, String name) {
        List<GymClass> filtered = filterClasses(classesData, name);
        DefaultTableModel roomTableModel = new DefaultTableModel(convertToData(filtered), roomsTableColNames);
        JTable roomTable = new JTable(roomTableModel);
        roomPanel.add(new JScrollPane(roomTable), BorderLayout.CENTER);
    }
    
    private Object[][] convertToData(List<GymClass> filtered){
        Object[][] data = new Object[filtered.size()][3];
        for(int i = 0; i < filtered.size(); i++) {
            GymClass gymClass = filtered.get(i);
            data[i][0] = gymClass.getClassType();
            data[i][1] = gymClass.getDate();
            data[i][2] = gymClass.getTrainer().getName();
        }
        return data;
    }
    
    private List<GymClass> filterClasses(ArrayList<GymClass> classesData, String name){
        List<GymClass> filtered = new ArrayList<>();
        Room.GymRoom roomNum;
        if(name.equals("ROOM1")) {
            roomNum = Room.GymRoom.ROOM1;
        }
        else if(name.equals("ROOM2")) {
            roomNum = Room.GymRoom.ROOM2;
        }
        else if(name.equals("ROOM3")) {
            roomNum = Room.GymRoom.ROOM3;
        }
        else {
            roomNum = Room.GymRoom.ROOM4;
        }
        for(GymClass gc : classesData) {
            if(gc.getRoom() == roomNum) {
                filtered.add(gc);
            }
        }
        return filtered;
    }
    
    public void showRoom(Room.GymRoom room) {
        cardLayout.show(switchPanel, room.name());
    }
}