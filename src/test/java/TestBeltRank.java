

import static org.junit.Assert.*;
import main.java.memoranda.BeltRank;

import org.junit.Test;

public class TestBeltRank {

    @Test
    public void testWhiteBelt() {
        assertEquals(0, BeltRank.Rank.WHITE.ordinal());
    }
    
    @Test
    public void testYellowBelt() {
        assertEquals(1, BeltRank.Rank.YELLOW.ordinal());
    }
    
    @Test
    public void testOrangeBelt() {
        assertEquals(2, BeltRank.Rank.ORANGE.ordinal());
    }
    
    @Test
    public void testPurpleBelt() {
        assertEquals(3, BeltRank.Rank.PURPLE.ordinal());
    }
    
    @Test
    public void testBlueBelt() {
        assertEquals(4, BeltRank.Rank.BLUE.ordinal());
    }
    
    @Test
    public void testBlueStripeBelt() {
        assertEquals(5, BeltRank.Rank.BLUE_STRIPE.ordinal());
    }
    
    @Test
    public void testGreenBelt() {
        assertEquals(6, BeltRank.Rank.GREEN.ordinal());
    }
    
    @Test
    public void testGreenStripeBelt() {
        assertEquals(7, BeltRank.Rank.GREEN_STRIPE.ordinal());
    }
    
    @Test
    public void testBrown1Belt() {
        assertEquals(8, BeltRank.Rank.BROWN1.ordinal());
    }
    
    @Test
    public void testBrown2Belt() {
        assertEquals(9, BeltRank.Rank.BROWN2.ordinal());
    }
    
    @Test
    public void testBrown3Belt() {
        assertEquals(10, BeltRank.Rank.BROWN3.ordinal());
    }
    
    @Test
    public void testBlack1Belt() {
        assertEquals(11, BeltRank.Rank.BLACK1.ordinal());
    }
    
    @Test
    public void testBlack2Belt() {
        assertEquals(12, BeltRank.Rank.BLACK2.ordinal());
    }
    
    @Test
    public void testBlack3Belt() {
        assertEquals(13, BeltRank.Rank.BLACK3.ordinal());
    }
}
