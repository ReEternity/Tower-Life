import java.util.*;

public class skillList{
    public ArrayList<skill> activeSkills = new ArrayList<>();
    public ArrayList<skill> passiveSkills = new ArrayList<>();
    private static String t = "\n-----------------------------------------------------------------------------------\n";
    public skillList(){
        activeSkills.add(new skill("Power Increase (Common)", "Multiply the next damage by 2.5", 1));
        activeSkills.add(new skill("Power Increase (Uncommon)", "Multiply the next damage by 3", 2));
        activeSkills.add(new skill("Power Increase (Rare)", "Multiply the next damage by 3 for 2 turns", 3));
        activeSkills.add(new skill("Power Increase (Epic)", "Multiply the next damage by 3.5 for 2 turns", 4));
        activeSkills.add(new skill("Power Increase (Legendary)", "Multiply the next damage by 4 for 3 turns", 5));
        activeSkills.add(new skill("Power Increase (Mythical)", "Multiply the next damage by 5 for 4 turns", 6));
        activeSkills.add(new skill("Extra Turn (Epic)", "Gaining 2 extra turns", 4));
        activeSkills.add(new skill("Extra Turn (Legendary)", "Gaining 3 extra turns", 5));
        activeSkills.add(new skill("Extra Turn (Mythical)", "Gaining 4 extra turns", 6));
        activeSkills.add(new skill("Time Stop (EX)", "Gaining 5 extra turns", 7));
        activeSkills.add(new skill("Revival (Mythical)", "Revive 1 time if you receive fatal damage", 6));
        activeSkills.add(new skill("Re-Resurrection (EX)", "Revive 2 time if you receive fatal damage", 7));
        activeSkills.add(new skill("Healing Boost (Common)", "Multiply the next heal by 1.2", 1));
        activeSkills.add(new skill("Healing Boost (Uncommon)", "Multiply the next heal by 1.4", 2));
        activeSkills.add(new skill("Healing Boost (Rare)", "Multiply the next heal by 1.6", 3));
        activeSkills.add(new skill("Healing Boost (Epic)", "Multiply the next heal by 1.8", 4));        
        activeSkills.add(new skill("Healing Boost (Legendary)", "Multiply the next heal by 2", 5));
        activeSkills.add(new skill("Revolve (Mythical)", "Receive half of the opponent’s damage and return the other half of the opponent’s damage", 6));
        activeSkills.add(new skill("Reverse (Ex)", "Complete reverse of the opponent’s damage", 7));
        activeSkills.add(new skill("Absolute Defence (Ex)", "Nullify all damage for 3 turns", 7));
        activeSkills.add(new skill("Piercing (Common)", "If the user’s damage is more than the opponent's defense by 5 times, 100% nullify the opponent’s block. Otherwise, 20% block nullification", 1));
        activeSkills.add(new skill("Piercing (Uncommon)", "If the user’s damage is more than the opponent’s defense by 4.5 times, 100% nullify the opponent’s block. Otherwise, 25% block nullification", 2));
        activeSkills.add(new skill("Piercing (Rare)", "If the user’s damage is more than the opponent’s defense by 4 times, 100% nullify the opponent’s block. Otherwise, 30% block nullification", 3));
        activeSkills.add(new skill("Piercing (Epic)", "If user’s damage is more than the opponent’s defense by 3 times, 100% nullify the opponent’s block. Otherwise, 40% block nullification", 4));
        activeSkills.add(new skill("Piercing (Legendary)", "If the user’s damage is more than the opponent’s defense by 2 times, 100% nullify the opponent's block. Otherwise, 50% block nullification", 5));
        activeSkills.add(new skill("Piercing (Mythical)", "If the user’s damage is more than the opponent’s defense, 100% nullify the opponent's block. Otherwise, 75% block nullification", 6));
        activeSkills.add(new skill("Serious Stab (EX)", "There will be no blocking in front me", 7));
        activeSkills.add(new skill("Retrieve (EX)", "It’s our skills and it’s our items", 7));

        passiveSkills.add(new skill("Death Note (EX)", "I'll solve equations with my RIGHT hand, and write names with my LEFT! I'll take a POTATO chip...AND! EAT IT!", 7));
        passiveSkills.add(new skill("Instant Kill (Mythical)", "1% chance to activate instant kill", 6));
        passiveSkills.add(new skill("Autoing (EX)", "Imagine manually farming", 7));
        passiveSkills.add(new skill("Midas Touch (Mythical)", "Multiple the gold gained by 3 times", 6));
        passiveSkills.add(new skill("Gold Boost (Common)", "Multiple the gold gained by 1.2 times", 1));
        passiveSkills.add(new skill("Gold Boost (Uncommon)", "Multiple the gold gained by 1.4 times", 2));
        passiveSkills.add(new skill("Gold Boost (Rare)", "Multiple the gold gained by 1.6 times", 3));
        passiveSkills.add(new skill("Gold Boost (Epic)", "Multiple the gold gained by 1.8 times", 4));
        passiveSkills.add(new skill("Gold Boost (Legendary)", "Multiple the gold gained by 2 times", 5));
        passiveSkills.add(new skill("Experience Boost (Common)", "Multiple the experience gained by 1.2 times", 1));
        passiveSkills.add(new skill("Experience Boost (Uncommon)", "Multiple the experience gained by 1.4 times", 2));
        passiveSkills.add(new skill("Experience Boost (Rare)", "Multiple the experience gained by 1.6 times", 3));
        passiveSkills.add(new skill("Experience Boost (Epic)", "Multiple the experience gained by 1.8 times", 4));
        passiveSkills.add(new skill("Experience Boost (Legendary)", "Multiple the experience gained by 2 times", 5));
        passiveSkills.add(new skill("No Lifer (Mythical)", "Multiple the experience gained by 3 times", 6));
    }
    
    public class skill{
        public String name;
        public String descriptions;
        public int Rarity;
        public int cooldown;
        public int proficiency;
        //[stats number required in the order of stats name]
        public int[] requirement = new int[5];
        
        public skill(){
            name = "";
            descriptions = "";
            Rarity = 0;
            cooldown = 0;
        }
        //Name, Description, rarity, cooldown(WIP)
        public skill(String a, String b, int c){
            name = a;
            descriptions = b;
            Rarity = c;
            //cooldown = d;
        }

        public String toString(){
            return t + "Name: " + name + "\nDescriptions: " + descriptions + "\n\n\nRarity: " + Rarity + "\nCooldown" + cooldown + t;    
        }
    }
}

