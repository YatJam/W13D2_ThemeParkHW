import attractions.Attraction;
import behaviours.IReviewed;
import people.Visitor;
import stalls.Stall;

import java.util.ArrayList;

public class ThemePark {

    private ArrayList<Attraction> allAttractions;
    private ArrayList<Stall> allStalls;
    private ArrayList<IReviewed> allReviews;

    public ThemePark(){
        this.allAttractions = new ArrayList<Attraction>();
        this.allStalls = new ArrayList<Stall>();
        this.allReviews = new ArrayList<IReviewed>();

    }

    public int attractionCount(){
        return allAttractions.size();
    }

    public void addAttraction(Attraction attraction){
        allAttractions.add(attraction);
    }

    public int stallCount(){
        return allStalls.size();
    }

    public void addStall(Stall stall){
        allStalls.add(stall);
    }

    public ArrayList<IReviewed> getAllReviewed() {
        return allReviews;
    }

    public int reviewCount(){
        return allReviews.size();
    }

    public void addReview(IReviewed review){
        allReviews.add(review);
    }

    public void visit (Visitor visitor, Attraction attraction){
        visitor.addVisitedAttraction(attraction);
        attraction.updateVisitCountWithVisitor();
    }
}
