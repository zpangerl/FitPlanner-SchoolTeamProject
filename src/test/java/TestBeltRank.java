

import static org.junit.Assert.*;
import main.java.memoranda.BeltRank;

import org.junit.Test;

/**
 * TestBeltRank.java
 * Created on November 3, 2023
 * Author: Zach Pangerl
 * <p>
 * This test class tests the enum values from BeltRank.java.
 */
public class TestBeltRank {
    
    /**
     * Tests the value of the WHITE belt rank
     */
    @Test
    public void testWhiteBelt() {
        assertEquals(0, BeltRank.Rank.WHITE.ordinal());
    }
    
    /**
     * Tests the value of the PURPLE belt rank
     */
    @Test
    public void testPurpleBelt() {
        assertEquals(3, BeltRank.Rank.PURPLE.ordinal());
    }
    
    /**
     * Tests the value of the BROWN1 belt rank
     */
    @Test
    public void testBrown1Belt() {
        assertEquals(8, BeltRank.Rank.BROWN1.ordinal());
    }
    
    /**
     * Tests the value of the BLACK3 belt rank
     */
    @Test
    public void testBlack3Belt() {
        assertEquals(13, BeltRank.Rank.BLACK3.ordinal());
    }

    /**
     * Tests returning friendly String name of BeltRank.Rank
     * Author: Steven Stovall
     */
    @Test
    public void testGetBeltRankNames() {
        BeltRank.Rank beltRank;
        // WHITE
        beltRank = BeltRank.Rank.WHITE;
        assertEquals("WHITE",BeltRank.getBeltRankName(beltRank));
        // YELLOW
        beltRank = BeltRank.Rank.YELLOW;
        assertEquals("YELLOW",BeltRank.getBeltRankName(beltRank));
        // ORANGE
        beltRank = BeltRank.Rank.ORANGE;
        assertEquals("ORANGE",BeltRank.getBeltRankName(beltRank));
        // PURPLE
        beltRank = BeltRank.Rank.PURPLE;
        assertEquals("PURPLE",BeltRank.getBeltRankName(beltRank));
        // BLUE
        beltRank = BeltRank.Rank.BLUE;
        assertEquals("BLUE",BeltRank.getBeltRankName(beltRank));
        // BLUE_STRIPE
        beltRank = BeltRank.Rank.BLUE_STRIPE;
        assertEquals("BLUE_STRIPE",BeltRank.getBeltRankName(beltRank));
        // GREEN
        beltRank = BeltRank.Rank.GREEN;
        assertEquals("GREEN",BeltRank.getBeltRankName(beltRank));
        // GREEN_STRIPE
        beltRank = BeltRank.Rank.GREEN_STRIPE;
        assertEquals("GREEN_STRIPE",BeltRank.getBeltRankName(beltRank));
        // BROWN1
        beltRank = BeltRank.Rank.BROWN1;
        assertEquals("BROWN1",BeltRank.getBeltRankName(beltRank));
        // BROWN2
        beltRank = BeltRank.Rank.BROWN2;
        assertEquals("BROWN2",BeltRank.getBeltRankName(beltRank));
        // BROWN3
        beltRank = BeltRank.Rank.BROWN3;
        assertEquals("BROWN3",BeltRank.getBeltRankName(beltRank));
        // BLACK1
        beltRank = BeltRank.Rank.BLACK1;
        assertEquals("BLACK1",BeltRank.getBeltRankName(beltRank));
        // BLACK2
        beltRank = BeltRank.Rank.BLACK2;
        assertEquals("BLACK2",BeltRank.getBeltRankName(beltRank));
        // BLACK3
        beltRank = BeltRank.Rank.BLACK3;
        assertEquals("BLACK3",BeltRank.getBeltRankName(beltRank));
    }
}
