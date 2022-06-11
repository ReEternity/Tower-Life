import java.util.*;
public class Gcharacter{
    public String name;
    public int Rarity;
    public int Copies;
    private static String[][] a = {{"Mona","Hu Tao","Zhongli","Ganyu","Qiqi","Keqing","Eula","Steven","Megumi", "Zero-One"}
                                  ,{"Surtr", "Thorns", "Warfarin", "Skadi", "Ch'en", "Myrtle"}
                                  ,{"Adam","Jimmy","Junjie","Thomas","Sarah","Brian","Eric","Jason"}
                                  ,{"Marques","■■■■", "□□□□","Kurumi","Grid","The Most Ancient Dream"}
                                  ,{"Kam", "God", "Dracula","Saitama","Fragments of the End"}};
    private int stats;
    public Gcharacter(){
        name = getName();
        Copies = 1;
    }
   
    public String getName(){
        Random r = new Random();
        int b = r.nextInt(1001);
        if (b <= 700){
            Rarity = 1;
            return a[0][r.nextInt(a[0].length)];
        }else if (b<=800){
            Rarity = 2;
            return a[1][r.nextInt(a[1].length)];
        }else if (b <=900){
            Rarity = 3;
            return a[2][r.nextInt(a[2].length)];
        }else if (b <=990){
            Rarity = 4;
            return a[3][r.nextInt(a[3].length)];
        }else{
            Rarity = 5;
            return a[4][r.nextInt(a[4].length)];
        }
    }
   
    public String toString(){
        return "(Name: " + name + ", " + "Rarity: " + Rarity + ", " + "Copies: " + Copies + ")";
    }
}

