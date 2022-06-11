import java.io.*;
import java.util.*;
public class Tower_Life_client{
    public static String[] statsname = {"Health: ", "Magic: ", "Speed: ", "Strength: ", "Defense: "};
    public static int Floor;
    public Object z = new Object();
    public static void Main(){
        Tower_Life_client a = new Tower_Life_client();
        a.Connect();
        /*
        Note:
        Mob - Complete
        XP - Compete
        Gacha - Complete
        Combat - need to implement armor stats
        Skill points/Stats points - WIP
        Gear - nope
        armor stats - nope
        Boss fight - nope
        Events - nope
        minigames - nope
         */ 
    }

    public void Connect(){
        Floor = 1;
        boolean FloorNFin = true;

        Place place = new Place();
        boolean[] BossNFound = {true, false};
        Random r = new Random();
        boolean[] continu = {true};
        boolean town = false;
        boolean FloorIncomplete = true;
        boolean enterBossRoom = true;

        int i = 1;

        System.out.println("Before you play, you should know this");
        System.out.println("Monster have 3 different types:");
        System.out.println("attack with physical attack for physical mobs is better!");
        System.out.println("attack with spiritual attack for spiritual mobs is better!");
        System.out.println("attack with any attack for non-material mobs!");
        System.out.println();
        System.out.println("spiritual attack uses your magic stats");
        System.out.println("physical attack uses your strength stats");
        System.out.println("healing is based on your magic stats(1:1 ratio), you cannot go over max health");
        System.out.println("Speed determine whether you go first or you go second");
        System.out.println("it also affects your chance of running away");
        System.out.println("defense is your basic static damage nullifer(1 damage = 1 less damage taken)");
        System.out.println();
        System.out.println("You could also find the info in menu -> option 7");
        System.out.println();
        System.out.println();
        System.out.println("For Mr. Marques Playing/Testing this, when you are fighting monsters, you can type \"Marques\" to skip");
        System.out.println();
        Scanner input = new Scanner(System.in);
        System.out.println("What is your name: ");
        String name = input.nextLine();
        Player player = new Player(name);
        System.out.println();
        System.out.println("Welcome to Tower Life, you are trapped in this game until you are able to finish or until you die");
        System.out.println("Good Luck");
        while (FloorNFin){
            place = new Place();
            System.out.println("Welcome to Floor " + Floor + ": " + place);
            System.out.println();
            while(FloorIncomplete){
                while(BossNFound[0] && !town){
                    if(BossNFound[1]){
                        BossNFound[0]=false;
                        BossNFound[1]=false;
                    }
                    
                    player.allHeal();
                    menu(player);

                    FightM(player, BossNFound, continu);

                    if (!continu[0]){
                        town = false;
                        continu[0]=true;
                    }

                    if (player.checkDead()){
                        System.out.println("You lived " + player.getDays() + " days");
                        return;
                    }

                }
                if (!BossNFound[0]){
                    System.out.println("Do you want to enter the boss room? (Type yes or no)");
                    String Enter = input.next();
                    if (Enter.equalsIgnoreCase("Yes")){
                        enterBossRoom = true;
                    } else if (Enter.equalsIgnoreCase("No")){
                        enterBossRoom = false;
                        BossNFound[0]=true;
                        BossNFound[1]=true;
                    }
                    while (enterBossRoom){
                        //FightBoss
                        FloorIncomplete = false;
                        BossNFound[0]=true;
                        enterBossRoom = false;
                    }
                }
                town=false;
            }
            if (Floor==100){//set to 1 to test
                FloorNFin = false;
            }
            Floor++;
            FloorIncomplete = true;
        }
        System.out.println("Congratualtion, you finished the game!");
        System.out.println("It took " + player.getDays() + " days");
    }
    
    public void spacing(){
        System.out.println("\n-----------------------------------------------------------------------------------\n");
    }

    public void menu(Player player){
        boolean exit = true;
        Scanner in = new Scanner(System.in);
        while (exit){
            spacing();
            System.out.println("Menu: ");
            System.out.println("1. Stats points (Type 1 or Stats)");
            System.out.println("2. Skill points (Type 2 or Skill)");
            System.out.println("3. Upgrade Station (Type 3 or Upgrade)");
            System.out.println("4. Shops (Type 4 or Shops)");
            System.out.println("5. Inventory (Type 5 or Inventory)");
            System.out.println("6. Gacha (Type 6 or Gacha)");
            System.out.println("7. Infomation (Type 7 or Info)");
            System.out.println("Exit the menu (Type exit)");
            String input = in.next();
            spacing();
            if (input.equalsIgnoreCase("1") || input.equalsIgnoreCase("Stats")){
                statsUpgrade(player);
            }else if (input.equalsIgnoreCase("2") || input.equalsIgnoreCase("Skill")){
                System.out.println("Work In Progress");
            }else if (input.equalsIgnoreCase("3") || input.equalsIgnoreCase("Upgrade")){
                System.out.println("Work In Progress");
            }else if (input.equalsIgnoreCase("4") || input.equalsIgnoreCase("Shops")){
                System.out.println("Work In Progress");
            }else if (input.equalsIgnoreCase("5") || input.equalsIgnoreCase("Inventory")){
                inventory(player);
            }else if (input.equalsIgnoreCase("6") || input.equalsIgnoreCase("Gacha")){
                gacha(player);
            }else if (input.equalsIgnoreCase("7") || input.equalsIgnoreCase("Info")){
                System.out.println("Monster have 3 different types:");
                System.out.println("attack with physical attack for physical mobs is better!");
                System.out.println("attack with spiritual attack for spiritual mobs is better!");
                System.out.println("attack with any attack for non-material mobs!");
                System.out.println();
                System.out.println("spiritual attack uses your magic stats");
                System.out.println("physical attack uses your strength stats");
                System.out.println("healing is based on your magic stats(1:1 ratio), you cannot go over max health");
                System.out.println("Speed determine whether you go first or you go second");
                System.out.println("it also affects your chance of running away");
                System.out.println("defense is your basic static damage nullifer(1 damage = 1 less damage taken)");

            }else if (input.equalsIgnoreCase("exit")){
                exit = false;
            }
        }
        spacing();
    }

    public void FightM(Player player, boolean[] BossNFound, boolean[] continu){
        Scanner in = new Scanner(System.in);
        boolean[] run = {false};
        boolean[] Mrun = {false};

        while (continu[0]){
            Monster monster = new Monster();
            Random r = new Random();
            while (!player.checkDead() && !monster.checkDead() && !run[0] && !Mrun[0]){
                FightTrueM(player, monster, run, Mrun);
                if (monster.checkDead()){
                    System.out.println("You defeated a lvl " + monster.getLevel() + " " + monster.getName1() +
                        ", congratualtion!");
                    int drop = r.nextInt(2)+1;
                    int chance = r.nextInt(10)+1;
                    if (drop==1 && chance > 8){
                        System.out.println("You got a weapon");
                    } else if (drop==2 && chance > 7){
                        System.out.print("You got a material: ");
                        int tier = r.nextInt(10);
                        int tier2 = r.nextInt(10);
                        if (monster.getName1().substring(0,3).equalsIgnoreCase("Ult")){
                            player.addInv2(tier);
                            player.addInv2(tier2);
                            System.out.println("Tier " + (tier+1) +" and " + (tier2+1) + " material");
                        }else if (monster.getName1().substring(0,3).equalsIgnoreCase("Rar")){
                            player.addInv2(tier);
                            System.out.println("Tier " + (tier+1) + " material");
                        }else{
                            player.addInv2((tier+tier2)/2);
                            System.out.println("Tier " + ((tier+tier2)/2+1) + " material");
                        }
                    }
                    if (monster.getName1().substring(0,3).equalsIgnoreCase("Ult")){
                        int goldG=Floor*(r.nextInt(10)+1)*(r.nextInt(2)+1);
                        player.addGold(goldG);
                        int xpG=Floor*(r.nextInt(5)+1)*player.getDays();
                        player.addXP(xpG);
                        System.out.println("You gained " + goldG + " gold and " + xpG + " experience");
                    }else if (monster.getName1().substring(0,3).equalsIgnoreCase("Rar")){
                        int goldG=Floor*(r.nextInt(2)+1);
                        player.addGold(goldG);
                        int xpG=Floor*(player.getDays()/4);
                        player.addXP(xpG);
                        System.out.println("You gained " + goldG + " gold and " + xpG + " experience");
                    }else{
                        int goldG=Floor*(r.nextInt(Floor)+1);
                        player.addGold(goldG);
                        int xpG=Floor+(r.nextInt(Floor)+1);
                        player.addXP(xpG);
                        System.out.println("You gained " + goldG + " gold and " + xpG + " experience");
                    }

                    while (player.getXP()>=player.getXPLim()){
                        player.minusXP(player.getXPLim());
                        player.addStatP(1);
                        player.addLevel();
                        player.setXPLim(player.getLevel());
                        player.addMHP(2);
                        if (player.getLevel()%5==0){
                            player.addSkillP();
                            System.out.println("You have " + player.getSkillP() + " skill points to spend");
                        }
                        System.out.println("You leveled up, health return to max!");
                        System.out.println("You have " + player.getStatP() + " stats points to spend");
                        System.out.println("You are currently lvl " + player.getLevel());
                        player.setHP(player.getMHP());
                        player.setMP(player.getMMP());
                        player.setSPD(player.getMSPD());
                        player.setSTR(player.getMSTR());
                        player.setDEF(player.getMDEF());
                        System.out.println();
                    }
                    System.out.printf("Experience Bar: %d / %d\n", player.getXP(), player.getXPLim());
                    System.out.println("You have " + player.getGold() + " gold");
                    drop = r.nextInt(8);
                    chance = r.nextInt(8);
                    if ((drop==chance && (drop>=6 || drop<=1)) || player.getLevel()>Floor+(r.nextInt(5)+1)){
                        BossNFound[0]=false;
                        System.out.println();
                        System.out.println();
                        System.out.println("You found the boss room");
                        System.out.println();
                        System.out.println();
                    }
                }
                if (player.checkDead()){
                    System.out.println("You died");
                    return;
                }
            }
            System.out.println("Do you want to continue? (Type yes or no)");
            String answer = in.next();
            if (answer.equalsIgnoreCase("no")){
                continu[0] = false;

            }else if(answer.equalsIgnoreCase("yes")){
                continu[0] = true;
                run[0]=false;
                Mrun[0]=false;
                monster = null;
            }

            spacing();
            
        }
    }

    public void FightTrueM(Player player, Monster monster, boolean[] run, boolean[] Mrun){
        int turn = 0;
        Random r = new Random();
        Scanner input = new Scanner(System.in);
        boolean Block = false;
        boolean MBlock = false;
        int MmaxHP = monster.getHP();
        int[] turnAll = {0};
        int skillCooldown = 0;
        int healCooldown = 0;
        int MskillCooldown = 0;
        int MhealCooldown = 0;

        System.out.printf("Experience Bar: %d / %d\n", player.getXP(), player.getXPLim());
        System.out.println("You encountered a lvl " + monster.getLevel() + " " + monster.getName1() + "(" + monster.getName2()
            + ")");
        System.out.println();

        if (monster.getSPD()<player.getSPD()){
            turn = 0;
        } else{
            turn = 1;
        }

        turn = 0; //(Testing purposes)
        while (!player.checkDead() && !monster.checkDead() && !run[0] && !Mrun[0]){
            System.out.println("lvl " + player.getLevel() + " " + player.getName() + "'s stats: ");
            player.getStatus();
            System.out.println();
            System.out.println("Lvl " + monster.getLevel() + " " + monster.getName1() + "'s stats: " + "("
                + monster.getName2() + ")");
            monster.getStatus();

            System.out.println();
            System.out.println();

            if (turn == 0){
                System.out.println("It's your turn");
                System.out.println("Choose an action: (Type in the number or the action)");
                System.out.println("1. Physical Attack");
                System.out.println("2. Magical Attack");
                System.out.println("3. Block");
                System.out.println("4. Heal");
                System.out.println("5. Run");
                String action = input.nextLine();
                if (action.equalsIgnoreCase("Physical Attack") || action.equalsIgnoreCase("1")){
                    if (!MBlock){
                        if (monster.getType2()==true){

                            if ((player.getSTR()/2-monster.getDEF()) <=0){
                                System.out.println("You dealt 0 physical damage");
                                System.out.println("\t" + player.getSTR()/2 + "\t\t" + monster.getDEF() + "\t" + monster.getAllType());
                            } else{
                                System.out.println("You dealt " + (player.getSTR()/2-monster.getDEF()) + " physical damage");
                                monster.minusHP(player.getSTR()/2-monster.getDEF());
                            }
                        } else if (monster.getType1()==true){

                            if ((player.getSTR()-monster.getDEF()/2) <=0){
                                System.out.println("You dealt 0 physical damage");
                                System.out.println("\t" + player.getSTR() + "\t\t" + monster.getDEF()/2 + "\t" + monster.getAllType());
                            } else{
                                System.out.println("You dealt " + (player.getSTR()-monster.getDEF()/2) + " physical damage");
                                monster.minusHP(player.getSTR()-monster.getDEF()/2);
                            }
                        } else{

                            if ((player.getSTR()-monster.getDEF()) <=0){
                                System.out.println("You dealt 0 physical damage");
                                System.out.println("\t" + player.getSTR() + "\t\t" + monster.getDEF() + "\t" + monster.getAllType());
                            } else{
                                System.out.println("You dealt " + (player.getSTR()-monster.getDEF()) + " physical damage");
                                monster.minusHP(player.getSTR()-monster.getDEF());
                            }
                        }
                    }else {
                        System.out.println(monster.getName1() + " blocked your attack.");
                        MBlock=false;
                    }
                }else if (action.equalsIgnoreCase("Magical Attack") || action.equalsIgnoreCase("2")){
                    if (!MBlock){
                        if (monster.getType1()==true){

                            if ((player.getMP()/2-monster.getDEF()) <=0){
                                System.out.println("You dealt 0 magical damage");
                                System.out.println("\t" + player.getMP()/2 + "\t\t" + monster.getDEF() + "\t" + monster.getAllType());
                            } else{
                                System.out.println("You dealt " + (player.getMP()/2-monster.getDEF()) + " magical damage");
                                monster.minusHP(player.getMP()/2-monster.getDEF());

                            }
                        } else if (monster.getType2()==true){

                            if ((player.getMP()-monster.getDEF()/2) <=0){
                                System.out.println("You dealt 0 magical damage");
                                System.out.println("\t" + player.getMP() + "\t\t" + monster.getDEF()/2 + "\t" + monster.getAllType());
                            } else{
                                System.out.println("You dealt " + (player.getMP()-monster.getDEF()/2) + " magical damage");
                                monster.minusHP(player.getMP()-monster.getDEF()/2);

                            }
                        }else {

                            if ((player.getMP()-monster.getDEF()) <=0){
                                System.out.println("You dealt 0 magical damage");
                                System.out.println("/t" + player.getMP() + "\t\t" + monster.getDEF() + "\t" + monster.getAllType());
                            } else{
                                System.out.println("You dealt " + (player.getMP()-monster.getDEF()) + " magical damage");
                                monster.minusHP(player.getMP()-monster.getDEF());
                            }
                        }
                    }else {
                        System.out.println(monster.getName1() + " blocked your attack.");
                        MBlock=false;
                    }
                }else if (action.equalsIgnoreCase("Block") || action.equalsIgnoreCase("3")){
                    Block = true;
                }else if (action.equalsIgnoreCase("Heal") || action.equalsIgnoreCase("4")){
                    player.addHP(player.getMP());
                    //player.allHeal(); //Testing Refreshes
                    System.out.println("You healed yourself");
                    if (player.getHP()>player.getMHP()){
                        player.setHP(player.getMHP());
                    }
                    healCooldown=4;
                }else if (action.equalsIgnoreCase("Run") || action.equalsIgnoreCase("5")){
                    if (player.getSPD()>=monster.getSPD()){
                        int run1 = r.nextInt(2)+1;
                        if (run1==1){
                            run[0]=true;
                            System.out.println("You ran away");
                        }else{
                            System.out.println("You failed to run away");
                        }
                    }else {
                        int run1 = r.nextInt(10)+1;
                        if (run1 >= 7){
                            run[0] = true;
                            System.out.println("You ran away");
                        }else{
                            System.out.println("You failed to run away");
                        }
                    }
                }
                if (action.equalsIgnoreCase("end")){//Just in case...
                    monster.setHP(0);
                    Block = true;
                    player.allHeal();
                }
                skillCooldown--;
                healCooldown--;
                turn++;
            } else{
                
                System.out.println("It's " + monster.getName1() + " turn");
                int MAction = r.nextInt(4)+1;
                boolean go = true;
                while (go){
                    if (MAction == 4){
                        if (MhealCooldown!=0){
                            MAction = r.nextInt(4)+1;
                        }else{
                            go = false;
                        }
                    }else{
                        go = false;
                    }
                }
                if (MAction == 1){
                    if (!Block){
                        System.out.println(monster.getName1() + " used physical attack");
                        if ((monster.getSTR()-player.getDEF()) <=0){
                            System.out.println(monster.getName1() + " dealt 0 physical damage");
                        } else{
                            System.out.println(monster.getName1() + " dealt " + (monster.getSTR()-player.getDEF())
                                + " physical damage");
                            player.minusHP(monster.getSTR()-player.getDEF());
                        }
                    } else{
                        System.out.println("You blocked " + monster.getName1() + "'s attack");
                        Block=false;
                    }
                } else if (MAction == 2) { 
                    if (!Block){
                        System.out.println(monster.getName1() + " used magical attack");
                        if ((monster.getMP()-player.getDEF()) <=0){
                            System.out.println(monster.getName1() + " dealt 0 magical damage");
                        } else{
                            System.out.println(monster.getName1() + " dealt " + (monster.getMP()-player.getDEF())
                                + " magical damage");
                            player.minusHP(monster.getMP()-player.getDEF());
                        }
                    } else{
                        System.out.println("You blocked " + monster.getName1() + "'s attack");
                        Block=false;
                    }
                }else if (MAction == 3){
                    MBlock = true;
                } else if (MAction == 4){
                    monster.addHP(monster.getMP());
                    System.out.println(monster.getName1() + " got healed");
                    if (monster.getHP()>MmaxHP){
                        monster.setHP(MmaxHP);
                    }
                    MhealCooldown = 4;
                }

                if (Floor>=85){
                    if (monster.getHP()<=MmaxHP/5){
                        if (monster.getSPD()>=player.getSPD()){
                            int run1 = r.nextInt(10)+1;
                            if (run1 >= 7){
                                Mrun[0] = true;
                                System.out.println(monster.getName1() + " ran away");
                            }else{
                                System.out.println(monster.getName1() + " failed to run away");
                            }
                        } else{
                            int run1 = r.nextInt(10)+1;
                            if (run1 >= 9){
                                Mrun[0] = true;
                                System.out.println(monster.getName1() + " ran away");
                            }else{
                                System.out.println(monster.getName1() + " failed to run away");
                            }
                        }

                    }
                }
                MskillCooldown--;
                MhealCooldown--;
                turn=0;
            }
            turnAll[0]++;
            spacing();
        }
        while(turnAll[0] > 0){
            turnAll[0]-=5;
            player.addDays(1);
        }
    }

    public void gacha(Player player){
        boolean power = true;
        Scanner in = new Scanner(System.in);
        Random r = new Random();
        int[] buff = new int[5];
        while (power){
            System.out.println("Do you want to pull? (1. 1 pull or 2. 10 pulls or 3. Custom pulls)");
            boolean G1 = true;
            while (G1){

                String temp1 = in.next();
                if(temp1.equalsIgnoreCase("1") || temp1.equalsIgnoreCase("1 pull")){
                    if (player.getGold()<1*Floor){
                        System.out.println("You don't have enough golds to pull!");
                        return;
                    }
                    Gcharacter a = new Gcharacter();
                    System.out.println(a);
                    player.addGold(-1*Floor);
                    if(!addC(a, player, buff)){
                        player.gInv.add(a);
                    }
                    G1 = false;
                }else if(temp1.equalsIgnoreCase("2") || temp1.equalsIgnoreCase("10 pulls")){
                    if (player.getGold()<10*Floor){
                        System.out.println("You don't have enough golds to pull!");
                        return;
                    }
                    for (int i = 0; i < 10; i++){
                        Gcharacter a = new Gcharacter();
                        System.out.println(a);
                        player.addGold(-1*Floor);
                        if(!addC(a, player, buff)){
                            player.gInv.add(a);
                        }
                    }
                    G1 = false;
                }else if (temp1.equalsIgnoreCase("3") || temp1.equalsIgnoreCase("Custom pulls")){
                    System.out.println("How many pulls do you want to do? ");
                    int temp2 = in.nextInt();
                    if (player.getGold()<temp2*Floor){
                        System.out.println("You don't have enough golds to pull!");
                        return;
                    }
                    for (int i = 0; i < temp2; i++){
                        Gcharacter a = new Gcharacter();
                        System.out.println(a);
                        player.addGold(-1*Floor);
                        if(!addC(a, player, buff)){
                            player.gInv.add(a);
                        }
                    }
                    G1 = false;
                }else if (temp1.equalsIgnoreCase("4") || temp1.equalsIgnoreCase("Free pulls")){
                    System.out.println("How many \"free\" pulls do you want to do? ");
                    int temp2 = in.nextInt();
                    for (int i = 0; i < temp2; i++){
                        Gcharacter a = new Gcharacter();
                        System.out.println(a);
                        if(!addC(a, player, buff)){
                            player.gInv.add(a);
                        }
                    }
                    G1 = false;
                }
            }
            spacing();
            System.out.println("\nYou have " + player.getGold() + " golds remaining");
            spacing();
            boolean G2 = true;
            while (G2){
                System.out.println("Which action do you want to do? (1. Gacha or 2. Inventory or 3. Exit or 4. Recharge)");
                String temp2 = in.next();
                if(temp2.equalsIgnoreCase("1") || temp2.equalsIgnoreCase("Gacha")){
                    G2 = false;
                }else if(temp2.equalsIgnoreCase("2") || temp2.equalsIgnoreCase("Inventory")){
                    Collections.sort(player.gInv, new GcharComparator());
                    System.out.print("[" + player.gInv.get(0));
                    for (int i = 1; i < player.gInv.size(); i++){
                        System.out.print(", " + player.gInv.get(i));
                    }
                    System.out.print("]");
                    System.out.println();
                }else if(temp2.equalsIgnoreCase("3") || temp2.equalsIgnoreCase("Exit")){
                    
                    spacing();
                    for (int i = 0; i < 5; i++){
                        System.out.print(Tower_Life_client.statsname[i] + player.getStats(i) + "+(" + buff[i] + ")\t");
                        player.addAllStats(i, buff[i]);
                    }
                    System.out.println("\n");
                    System.out.println("lvl " + player.getLevel() + " " + player.getName() + "'s stats: ");
                    player.getStatus();
                    spacing();
                    return;
                }else if(temp2.equalsIgnoreCase("4") || temp2.equalsIgnoreCase("Recharge")){
                    System.out.println("How much do you want to recharge? (Your soul as payment)");
                    int money = in.nextInt();
                    player.addGold(money);
                    System.out.println("You added " + money + " golds! Thank you for your purchase!");
                }
            }
        }
    }

    public boolean addC(Gcharacter b, Player player, int[] buff){
        Random r = new Random();
        int z = r.nextInt(5)+1;
        if (z == 1){
            buff[0]+=b.Rarity;
        }else if (z == 2){
            buff[1]+=b.Rarity;
        }else if (z == 3){
            buff[2]+=b.Rarity;
        }else if (z == 4){
            buff[3]+=b.Rarity;
        }else if (z == 5){
            buff[4]+=b.Rarity;
        }
        for (int i = 0; i < player.gInv.size(); i++){
            if (b.name.equalsIgnoreCase(player.gInv.get(i).name)){
                player.gInv.get(i).Copies++;
                return true;
            }
        }
        return false;
    }

    public void inventory(Player player){

    }

    public void statsUpgrade(Player player){
        Scanner in = new Scanner(System.in);
        System.out.println("1. Stats upgrade: (Type 1 or Stats upgrade)");
        System.out.println("2. Stats upgrade: (Type 2 or Reset stats)");

        String act01 = in.next();
        if (act01.equalsIgnoreCase("1") || act01.equalsIgnoreCase("Stats upgrade")){
            boolean exit01 = false;

            while (!exit01){

                if (player.getStatP() <= 0){
                    System.out.println("You have no more stat points to spend, do you want to leave? (type leave)");
                    String act03 = "";
                    while (!act03.equalsIgnoreCase("leave")){
                        act03 = in.next();
                        if (act03.equalsIgnoreCase("leave")){
                            exit01 = true;
                            break;
                        }
                    }
                    spacing();
                    System.out.println();
                }else{
                    System.out.println("Stats points: adding 1 stat point to health will increase it by 5");
                    System.out.println("Adding 1 stat point to every other stats will increase it by 2");
                    System.out.println();
                    System.out.println("Upgrade health: (Type 1 or Health)");
                    System.out.println("Upgrade magic: (Type 2 or Magic)");
                    System.out.println("Upgrade speed: (Type 3 or Speed)");
                    System.out.println("Upgrade strength: (Type 4 or Strength)");
                    System.out.println("Upgrade defense: (Type 5 or Defense)");
                    System.out.println();
                    System.out.println("Type leave to leave");

                    System.out.println("You have " + player.getStatP() + " stat points to spend");
                    System.out.println();
                    System.out.println();
                    player.getStatus();
                    System.out.println();
                    System.out.println();
                    String act1 = in.next();
                    if(act1.equalsIgnoreCase("1") || act1.equalsIgnoreCase("health")){
                        player.addMHP(5);
                        player.sUpgrade(0);
                        player.addStatP(-1);
                    }else if (act1.equalsIgnoreCase("2") || act1.equalsIgnoreCase("magic")){
                        player.addMMP(2);
                        player.sUpgrade(1);
                        player.addStatP(-1);
                    }else if (act1.equalsIgnoreCase("3") || act1.equalsIgnoreCase("speed")){
                        player.addMSPD(2);
                        player.sUpgrade(2);
                        player.addStatP(-1);
                    }else if (act1.equalsIgnoreCase("4") || act1.equalsIgnoreCase("strength")){
                        player.addMSTR(2);
                        player.sUpgrade(3);
                        player.addStatP(-1);
                    }else if (act1.equalsIgnoreCase("5") || act1.equalsIgnoreCase("defense")){
                        player.addMDEF(2);
                        player.sUpgrade(4);
                        player.addStatP(-1);
                    }else if (act1.equalsIgnoreCase("leave")){
                        exit01=true;
                    }
                }
            }
            player.allHeal();
        }else if (act01.equalsIgnoreCase("2") || act01.equalsIgnoreCase("Reset stat")){
            System.out.print("You could also reset your stats points but everytime you reset");
            System.out.print(" the price for resetting double");
            System.out.println();
            System.out.println("The first time for resetting is free");
            System.out.print("Are you sure to reset? (yes or no)");
            String act02 = in.next();
            if (act02.equalsIgnoreCase("yes") || act02.equalsIgnoreCase("y")){
                if (player.getGold()<player.getRP()){
                    System.out.println("It seems that you don't have enough money, you can't reset your stats.");
                }else{
                    player.addGold(-1 * player.getRP());
                    if (player.getRP()==0){
                        player.addRP(100);
                    }else{
                        player.addRP(player.getRP());
                    }
                    player.resetStats();
                    System.out.println("You have successfully reset your stats!");
                }
                spacing();
            }
            player.allHeal();
        }
    }
}
