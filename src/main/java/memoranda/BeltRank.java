package main.java.memoranda;

/**
 * BeltRank
 * Created on November 3, 2023
 * Author: Zach Pangerl
 * 
 * This class is used to represent different belt ranks.
 */
public class BeltRank {
    
    /**
     * This enum represents each belt rank for the gym.
     */
    public enum Rank {
        WHITE,
        YELLOW,
        ORANGE,
        PURPLE,
        BLUE,
        BLUE_STRIPE,
        GREEN,
        GREEN_STRIPE,
        BROWN1,
        BROWN2,
        BROWN3,
        BLACK1,
        BLACK2,
        BLACK3
    }

    /** Return string representation of belt rank */
    public static String getBeltRankName(BeltRank.Rank beltRank) {
        switch(beltRank) {
            case WHITE:
                return "WHITE";
            case YELLOW:
                return "YELLOW";
            case ORANGE:
                return "ORANGE";
            case PURPLE:
                return "PURPLE";
            case BLUE:
                return "BLUE";
            case BLUE_STRIPE:
                return "BLUE_STRIPE";
            case GREEN:
                return "GREEN";
            case GREEN_STRIPE:
                return "GREEN_STRIPE";
            case BROWN1:
                return "BROWN1";
            case BROWN2:
                return "BROWN2";
            case BROWN3:
                return "BROWN3";
            case BLACK1:
                return "BLACK1";
            case BLACK2:
                return "BLACK2";
            case BLACK3:
                return "BLACK3";
            default:
                return ""; // should be unreachable unless bad BeltRank.Rank
        }
    }
}
