/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RPG;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Star
 */
public class Main {

    /**
     * @param args the command line arguments
     */
        private static BufferedReader br;
        private static FantasyCharacter player = null;
        private static BattleScene battleScene = null;
       
        
    public static void main(String[] args) {
        br = new BufferedReader(new InputStreamReader(System.in));
        
        battleScene = new BattleScene();
   
        System.out.println("Введите имя персонажа:");
  
        try {
        command(br.readLine());
        } catch (IOException e) {
       e.printStackTrace();
      }
    }
    private static void command(String string) throws IOException {
   
   if (player == null) {
        player = new Hero(string,100,20,20,0,0);
       System.out.println(String.format("%s начинает свое путешествие! Да прибудет с тобой сила юный боец!", player.getName()));
       
       printNavigation();
   }
   
   switch (string) {
       case "1": {
           if(player.getGold()<50){
           System.out.println("Торговец еще не приехал");
           command(br.readLine());
           }else if(player.getGold()>=50){
           System.out.println("Торговец принес свою дурь,хотите подлечится?"); 
           if(br.readLine().equals("4")) { 
           player.setHealthPoints(100);
           player.setGold(0);
           System.out.println("Держи свою дурь");
           printNavigation();
           }else{ 
           System.out.println("Зачем приходил?");
           printNavigation();
          }  
           }   
       }
       break;
       case "2": {
           commitFight();
       }
       break;
       case "3":
           System.exit(1);
           break;
       case "yes":
           command("2");
           break;
       case "no": 
           printNavigation();
           command(br.readLine());
       
   }
   
   command(br.readLine());  
    }
    private static void printNavigation() {
    System.out.println("Куда вы хотите пойти?");
    System.out.println("1. К Торговцу");
    System.out.println("2. В темный лес");
    System.out.println("3. Выход");
  }
    private static void commitFight() {
   battleScene.fight(player, createMonster(), new FightCallback() {
       @Override
       public void fightWin() {
           System.out.println(String.format("%s победил! Теперь у вас %d опыта и %d монет, а также осталось %d единиц здоровья.", player.getName(), player.getXp(), player.getGold(), player.getHealthPoints()));
           System.out.println("Желаете продолжить поход или вернуться в город? (да/нет)");
           try {
               command(br.readLine());
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
       
      
       public void fightLost() {

       }
   });
}

    private static FantasyCharacter createMonster() {
   
   int random = (int) (Math.random() * 10);
    
   if (random % 2 == 0) return new Goblin(
           "Гоблин",
           50,
           10,
           10,
           100,
           20
   );
   else return new Skeleton(
           "Скелет",
           25,
           20,
           20,
           100,
           10
   );
}

  interface FightCallback {
   void fightWin();
   void fightLost();
 }
}
