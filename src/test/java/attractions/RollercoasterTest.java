package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.*;

public class RollercoasterTest {

    RollerCoaster rollerCoaster;
    Visitor visitor1;
    Visitor visitor2;
    Visitor visitor3;

    @Before
    public void setUp() {
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
        visitor1 = new Visitor(14, 122, 23.00);
        visitor2 = new Visitor(12, 145, 9.40);
        visitor3 = new Visitor(19, 201, 42.12);
    }

    @Test
    public void hasName() {
        assertEquals("Blue Ridge", rollerCoaster.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(10, rollerCoaster.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, rollerCoaster.getVisitCount());
    }

    @Test
    public void isOldAndTallEnoughToRideRollercoaster(){
        assertFalse(rollerCoaster.isAllowedTo(visitor1));
        assertTrue(rollerCoaster.isAllowedTo(visitor2));
        assertTrue(rollerCoaster.isAllowedTo(visitor3));
    }

    @Test
    public void provideDefaultPrice(){
        assertEquals(8.40, rollerCoaster.defaultPrice(), 0.0);
    }

    @Test
    public void chargePriceBasedOnHeight(){
        assertEquals(8.40, rollerCoaster.priceFor(visitor2), 0.0);
        assertEquals(16.80, rollerCoaster.priceFor(visitor3), 0.0);
    }

}
