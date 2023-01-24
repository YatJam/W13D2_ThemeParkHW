package stalls;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class TobaccoStallTest {

    TobaccoStall tobaccoStall;
    Visitor visitor1;
    Visitor visitor2;

    @Before
    public void setUp() throws Exception {
        tobaccoStall = new TobaccoStall("Jacks Drum", 5,"Jack Jarvis", ParkingSpot.B1);
        visitor1 = new Visitor(12,162,20.00);
        visitor2 = new Visitor(78, 199, 140.01);
    }

    @Test
    public void hasName() {
        assertEquals("Jacks Drum", tobaccoStall.getName());
    }

    @Test
    public void hasRating(){
        assertEquals(5, tobaccoStall.getRating());
    }

    @Test
    public void hasOwner() {
        assertEquals("Jack Jarvis", tobaccoStall.getOwnerName());
    }

    @Test
    public void hasParkingSpot() {
        assertEquals(ParkingSpot.B1, tobaccoStall.getParkingSpot());
    }

    @Test
    public void oldEnoughToPurchaseTobaccoProducts(){
        assertFalse(tobaccoStall.isAllowedTo(visitor1));
        assertTrue(tobaccoStall.isAllowedTo(visitor2));
    }
}
