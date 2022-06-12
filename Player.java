import java.util.ArrayList;
public class Player{
    //{Health, Mana, Speed, Strength, Defense}
    private int[] stats = new int[5];
    private int[] MaxS = new int[5];
    private String name;
    private int level;
    private int gold;
    private int days;
    //{Helmet(name + 5 stats), Chestplate(name + 5 stats), Leggings(name + 5 stats), Boots(name + 5 stats)
    //, Weapon(name + 5 stats), Accessary-maybe(name + 5 stats)}
    //private String[][] armor = new String[6][6];
    //private String[][] inv = new String[25][6];
    private int[] inv2 = new int[10];
    //{xp, xp limit, stats points, skill points, price for resetting}
    int[] currentXP = new int[5];
    private int[] timeUpgraded = new int[5];
    public ArrayList<Gcharacter> gInv = new ArrayList<>();
    
    public Player(String name){
        MaxS[0] = 10;
        stats[0] = 10;
        for(int i = 1; i < stats.length; i++){
            MaxS[i] = 1;
            stats[i] = 1;
        }
        currentXP[1] = Tower_Life_client.Floor;
        this.level = 1;
        this.gold = 15;
        this.days = 0;
        this.name = name;

    }
    
    public boolean checkDead(){
        return stats[0]<=0;
    }
    
    public void addDays(int days){
        this.days+=days;
    }
    
    public void addInv2(int tier){
        inv2[tier]++;
    }
    
    public void addGold(int amount){
        this.gold+=amount;
    }
    
    public void addXP(int amount){
        this.currentXP[0]+=amount;
    }
    
    public void minusXP(int amount){
        this.currentXP[0]-=amount;
    }
    
    public void addXPLim(int amount){
        this.currentXP[1]+=amount;
    }
    
    public void addStatP(int amount){
        this.currentXP[2]+=amount;
    }
    
    public void addSkillP(){
        this.currentXP[3]++;
    }
    
    public void addLevel(){
        this.level++;
    }
    
    public void addMHP(int amount){
        MaxS[0]+=amount;
        stats[0]+=amount;
    }
    
    public void addMMP(int amount){
        MaxS[1]+=amount;
        stats[1]+=amount;
    }
    
    public void addMSPD(int amount){
        MaxS[2]+=amount;
        stats[2]+=amount;
    }
    
    public void addMSTR(int amount){
        MaxS[3]+=amount;
        stats[3]+=amount;
    }
    
    public void addMDEF(int amount){
        MaxS[4]+=amount;
        stats[4]+=amount;
    }
    
    public void addRP(int amount){
        currentXP[4]+=amount;
    }
    
    public void setHP(int amount){
        stats[0]=amount;
    }
    
    public void setMHP(int amount){
        MaxS[0]=amount;
    }
    
    public void setMP(int amount){
        stats[1]=amount;
    }
    
    public void setSPD(int amount){
        stats[2]=amount;
    }
    
    public void setSTR(int amount){
        stats[3]=amount;
    }
    
    public void setDEF(int amount){
        stats[4]=amount;
    }
    
    public void minusHP(int damage){
        stats[0]-=damage;
    }
    
    public void addHP(int heal){
        stats[0]+=heal;
    }
    
    public void sUpgrade(int where){
        timeUpgraded[where]++;
    }
    
    public void setXPLim(int what){
        currentXP[1]=what;
    }
    
    public void getStatus(){
        for (int i = 0; i < 5; i++){
            System.out.print(Tower_Life_client.statsname[i] + stats[i] + "\t");
        }
    }
    
    public int getStats(int i){
        return stats[i];
    }
    
    public void addAllStats(int i, int j){
        MaxS[i]+=j;
        stats[i]+=j;
    }
    
    public int getMStatus(int amount){
        return MaxS[amount];
    }
    
    public void resetStats(){
        this.currentXP[2]+=getTimeUpgraded();
        this.MaxS[0]+=-5*timeUpgraded[0];
        timeUpgraded[0]=0;
        for (int i = 1; i < timeUpgraded.length; i++){
            this.MaxS[i]+=-2*timeUpgraded[i];
            timeUpgraded[i]=0;
        }
        
    }
    
    public void allHeal(){
        for (int i = 0; i < stats.length; i++){
            this.stats[i] = this.getMStatus(i);
        }
        
    }
    
    public int getTimeUpgraded(){
        int count=0;
        for (int a: timeUpgraded){
            count+=a;
        }
        return count;
    }
    
    public int getXP(){
        return currentXP[0];
    }
    
    public int getXPLim(){
        return currentXP[1];
    }
    
    public int getStatP(){
        return currentXP[2];
    }
    
    public int getSkillP(){
        return currentXP[3];
    }
    
    public int getRP(){
        return currentXP[4];
    }
    
    public int getDays(){
        return this.days;
    }
    
    public int getGold(){
        return this.gold;
    }
    
    public String getName(){
        return name;
    }
    
    public int getMHP(){
        return MaxS[0];
    }
    
    public int getMMP(){
        return MaxS[1];
    }
    
    public int getMSPD(){
        return MaxS[2];
    }
    
    public int getMSTR(){
        return MaxS[3];
    }
    
    public int getMDEF(){
        return MaxS[4];
    }
    
    public int getLevel(){
        return this.level;
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
    
    
}
