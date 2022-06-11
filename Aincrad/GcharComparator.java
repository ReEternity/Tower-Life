import java.util.*;

public class GcharComparator implements Comparator<Gcharacter>{
    public int compare(Gcharacter ch1, Gcharacter ch2){
        if (ch2.Rarity == ch1.Rarity){
            return ch2.Copies - ch1.Copies;
        }else{
            return ch2.Rarity-ch1.Rarity;
        }
    }
}
