package main.java.memoranda;
import java.util.ArrayList;

public class Room {
    
    private ArrayList<Trainer> trainers;
    //private ArrayList<Student> students;
    
    private static final Room[] gymRooms;
    
    public Room() {
        this.trainers = new ArrayList<>();
        //this.students = new ArrayList<>();
    }
    
    static {
        gymRooms = new Room[4];
        
        for (int i = 0; i < 4; i++) {
            gymRooms[i] = new Room();
            gymRooms[i].loadRooms(i);
        }
    }
    
    public void loadRooms(int roomNumber) {
        
    }
    
    public void saveRooms() {
        
    }
    
    public Room[] getRooms() {
        return gymRooms;
    }
}