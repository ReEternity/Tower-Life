import java.util.*;
public class Monster{
    private static int[] stats = new int[5];
    private static String[] name = new String[2];
    private static boolean[] type = new boolean[2];
    private int level;
    public static int rare;
    public static int rare2;
    private static Random mr = new Random();
    
    public Monster(){
        Random r = new Random();
        this.level = Tower_Life_client.Floor;
        stats[0] = Tower_Life_client.Floor*10;
        for (int i = 1; i < 5; i++){
            stats[i]= level*(r.nextInt(2)+1) + (r.nextInt(level)+1);
        }
        this.setName();
        this.setRarity();
        this.setType();
        
    }
    
    private void setName(){
        if (Tower_Life_client.Floor<=10){
            String[] Species = {"Enhanced Cow", "Angry Pig", "Big Chicken", "Bandit", "The Goat"};
            name[0] = Species[mr.nextInt(5)];
        }else if (Tower_Life_client.Floor<=20){
            String[] Species = {"Zombie", "Skeleton", "Creeper", "Enderman", "Spider", "Mutated Rat"};
            name[0] = Species[mr.nextInt(6)];
        }else if (Tower_Life_client.Floor<=30){
            String[] Species = {"Goblin", "Ghoul", "Lesser Orc", "Dryad", "Kobold", "Mermaid", "Cyclopes"};
            name[0] = Species[mr.nextInt(7)];
        }else if (Tower_Life_client.Floor<=40){
            String[] Species = {"Giant", "Vampire", "High Nymph", "Troll", "Werewolf", "Ghost", "Drake"};
            name[0] = Species[mr.nextInt(7)];
        }else if (Tower_Life_client.Floor<=50){
            String[] Species = {"Vampire Lord", "The Nameless", "Shadows", "Griffin", "Cockatrice", "Golem", "Minotaur"};
            name[0] = Species[mr.nextInt(7)];
        }else if (Tower_Life_client.Floor<=60){
            String[] Species = {"Corrupted Human", "Dullahan", "Sphinx", "Hellhound", "The Boogeyman", "Wyvern"};
            name[0] = Species[mr.nextInt(6)];
        }else if (Tower_Life_client.Floor<=70){
            String[] Species = {"Demon", "Fallen Angel", "Basilisk", "Lamia", "Chimera Of Unknown"};
            name[0] = Species[mr.nextInt(5)];
        }else if (Tower_Life_client.Floor<=80){
            String[] Species = {"Hydra", "Succubus", "Demi Oni God", "Manticore", "Kraken"};
            name[0] = Species[mr.nextInt(5)];
        }else if (Tower_Life_client.Floor<=90){
            String[] Species = {"Demon Lord", "World Serpent", "Seraph Of The End", "Medusa", "Alter Ego"};
            name[0] = Species[mr.nextInt(5)];
        }else if (Tower_Life_client.Floor>90){
            String[] Species = {"Dragon", "Reaper", "Phoenix", "Fallen God", "The Shapeless", "Leviathan"};
            name[0] = Species[mr.nextInt(6)];
        }
    }
    
    private void setRarity(){
        rare = mr.nextInt(10);
        rare2 = mr.nextInt(10);
        if (rare == rare2 || rare == 9){
            for (int i = 0; i < stats.length; i++){
                stats[i]+=Tower_Life_client.Floor;
            }
            name[0] = "Rare " + name[0];
            rare = mr.nextInt(10);
            rare2 = mr.nextInt(10);
            if (rare == rare2 || (rare2 == 8 && rare >= 8)){
                stats[0]*=3;
                for (int i = 1; i < stats.length; i++){
                    stats[i]*=(mr.nextInt(2)+1);
                }
                name[0] = "Ultra" + name[0];
            }
        }
    }
    
    public void setType(){
        String[] types = {"Physical", "Spiritual"};
        String Mtypes = types[mr.nextInt(2)];
        if (Mtypes.equalsIgnoreCase("Physical")){
            type[0] = true;
            type[1] = false;
        }else {
            type[1] = true;
            type[0] = false;
        }
        rare = mr.nextInt(3);
        rare2 = mr.nextInt(3);
        if (rare == rare2){
            type[0] = false;
            type[1] = false;
            Mtypes = "Non-material";
        }
        name[1] = Mtypes;
    }
    
    public int getLevel(){
        return this.level;
    }
    
    public String getName1(){
        return name[0];
    }
    
    public String getName2(){
        return name[1];
    }
    
    public boolean checkDead(){
        return stats[0]<=0;
    }
    
    public int getHP(){
        return stats[0];
    }
    
    public int getMP(){
        return stats[1];
    }
    
    public int getSPD(){
        return stats[2];
    }
    
    public int getSTR(){
        return stats[3];
    }
    
    public int getDEF(){
        return stats[4];
    }
    
    public void getStatus(){
        for (int i = 0; i < 5; i++){
            System.out.print(Tower_Life_client.statsname[i] + stats[i] + "\t");
        }
    }
    
    public String getAllType(){
        return type[0] + "\t" + type[1];
    }
    
    public boolean getType1(){
        return type[0];
    }
    
    public boolean getType2(){
        return type[1];
    }
    
    public void minusHP(int damage){
        stats[0]-=damage;
    }
    
    public void addHP(int heal){
        stats[0]+=heal;
    }
    
    public void setHP(int amount){
        stats[0]=amount;
    }
}