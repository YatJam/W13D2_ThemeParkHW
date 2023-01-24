import attractions.*;
import org.junit.Before;
import org.junit.Test;
import people.Visitor;
import stalls.*;

import static org.junit.Assert.assertEquals;

public class ThemeParkTest {

    private ThemePark themePark;
    private Dodgems dodgems;
    private Park park;
    private Playground playground;
    private RollerCoaster rollerCoaster;
    private CandyflossStall candyflossStall;
    private IceCreamStall iceCreamStall;
    private TobaccoStall tobaccoStall;

    private Visitor visitor1;
    private Visitor visitor2;

    @Before
    public void before(){
        dodgems = new Dodgems("Bumper Cars", 5);
        park = new Park("Leafy Meadows", 9);
        playground = new Playground("Fun Zone", 7);
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
        candyflossStall = new CandyflossStall("Candy Land", 3, "Harry Belafonte", ParkingSpot.A1);
        iceCreamStall = new IceCreamStall("Dream Cones", 4,"Vanilla Ice", ParkingSpot.A4);
        tobaccoStall = new TobaccoStall("Jacks Drum", 5,"Jack Jarvis", ParkingSpot.B1);
        themePark = new ThemePark();
        visitor1 = new Visitor(103, 209, 100000);
        visitor2 = new Visitor(4, 10, 0.10);
    }

    @Test
    public void holdsAllAttractions(){
        themePark.addAttraction(dodgems);
        themePark.addAttraction(park);
        themePark.addAttraction(playground);
        themePark.addAttraction(rollerCoaster);
        assertEquals(4, themePark.attractionCount());
    }

    @Test
    public void holdsAllStalls(){
        themePark.addStall(candyflossStall);
        themePark.addStall(iceCreamStall);
        themePark.addStall(tobaccoStall);
        assertEquals(3, themePark.stallCount());
    }

    @Test
    public void reviewCount(){
        themePark.addReview(dodgems);
        themePark.addReview(park);
        themePark.addReview(playground);
        themePark.addReview(rollerCoaster);
        themePark.addReview(candyflossStall);
        themePark.addReview(iceCreamStall);
        themePark.addReview(tobaccoStall);
        assertEquals(7, themePark.reviewCount());
    }

    @Test
    public void canUpdateVisitedAttractionListAndVisitCount(){
        themePark.visit(visitor1, dodgems);
        themePark.visit(visitor2, dodgems);
        assertEquals(1, visitor1.visitedAttractionCount());
        assertEquals(1, visitor2.visitedAttractionCount());
        assertEquals(2, dodgems.getVisitCount());
    }

}


