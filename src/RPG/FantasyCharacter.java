/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RPG;

/**
 *
 * @author Star
 */
public abstract class FantasyCharacter{
    
   private String name;
    
   private int healthPoints;
   private int strength;
   private int dexterity;
   
   int nextLevel = 100;
   public int xp;
   int level;
   private int gold;
   
   public FantasyCharacter(String name, int healthPoints, int strength, int dexterity, int xp, int gold) {
       this.name = name;
       this.healthPoints = healthPoints;
       this.strength = strength;
       this.dexterity = dexterity;
       this.xp = xp;
       this.gold = gold;
   }
   
   public int attack() {
       if (dexterity * 3 > getRandomValue()) return strength;
       else return  0;
   }

   public String getName() {
       return name;
   }
   
   public void setName(String name) {
       this.name = name;
   }
   public int getHealthPoints() {
       return healthPoints;
   }
   public void setHealthPoints(int healthPoints) {
       this.healthPoints = healthPoints;
   }
   public int getStrength() {
       return strength;
   }
   public void setStrength(int strength) {
       this.strength = strength;
   }
   public int getDexterity() {
       return dexterity;
   }
   public void setDexterity(int dexterity) {
       this.dexterity = dexterity;
   }
   public int getXp() {
       return xp;
   }
   public void setXp(int xp) {
       this.xp = xp;
   }
   public int getGold() {
       return gold;
   }
   public void setGold(int gold) {
       this.gold = gold;
   }
   private int getRandomValue() {
       return (int) (Math.random() * 100);
   }
   
   @Override
   public String toString() {
       return String.format("%s здоровье:%d", name, healthPoints);
   }
   public void getNextLevel(){  
          if(xp>+nextLevel){
              nextLevel=nextLevel  * 2;
              level++;
              System.out.println(level + " Уровень.Вы стали сильнее");
              setHealthPoints(getHealthPoints()+10);
              setStrength(getStrength()+10);
              setDexterity(getDexterity()+10);
          }
          
       
       }
}
