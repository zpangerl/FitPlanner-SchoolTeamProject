

import static org.junit.Assert.*;
import main.java.memoranda.BeltRank;

import org.junit.Test;

/**
 * TestBeltRank.java
 * Created on November 3, 2023
 * Author: Zach Pangerl
 * 
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
}
