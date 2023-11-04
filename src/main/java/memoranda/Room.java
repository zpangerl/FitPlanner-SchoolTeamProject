package main.java.memoranda;
import java.util.ArrayList;

public class Room {
    
    private static final GymRoom[] gymRooms = new GymRoom[4];
    
    public static class GymRoom {
        //Will need, unless we want to use Vector
        //Waiting on GymClass implementation
        //private ArrayList<GymClass> classes;
        
        private int roomNumber;
        
        static {
            
            for (int i = 0; i < 4; i++) {
                gymRooms[i] = new GymRoom(i);
            }
        }
        
        public GymRoom(int roomNumber) {
            this.roomNumber = roomNumber;
            //this.classes = new ArrayList<>();
        }
        
        public static void loadRooms(int roomNumber) {
            
        }
        
        public static void saveRooms() {
            
        }
        
        public int getRoomNumber() {
            return this.roomNumber;
        }
        
        public static GymRoom[] getRooms() {
            return gymRooms;
        }
    }
}