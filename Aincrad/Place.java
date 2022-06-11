import java.io.*;
import java.util.*;
public class Place{
    private String place;
    String[] place1 = {"Forest", "Woodland", "Jungle", "Forestland", "Ravine", "The Temple"};
    String[] place2 = {"Ocean", "The Deep", "The Tower", "The Maze", "The Pit", "Cavern"};
    String[] place3 = {"Village", "Settlement", "The Plains", "The Lands", "Monument"};
    String[] Adj1 = {"The Deep", "The Light", "Ruined", "The Dark", "The Forgotten", "The Destructed", "The Protected"
    , "The Hidden", "The Concealed", "The Invisible", "The Twilight", "The Sky", "The Meteor"};
    public Place(){
        Random r = new Random();
        int r1 = r.nextInt(3);
        if (r1==0){
            int r2 = r.nextInt(place1.length);
            place = place1[r2] + " Of ";
        } else if (r1==1){
            int r2 = r.nextInt(place2.length);
            place = place2[r2] + " Of ";
        } else if (r1==2){
            int r2 = r.nextInt(place3.length);
            place = place3[r2] + " Of ";
        }
        int r3 = r.nextInt(Adj1.length);
        place+= Adj1[r3];

    }
    
    public String toString(){
        return place;
    }
}
