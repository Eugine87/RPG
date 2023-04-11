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
public class Merchant implements Seller{
    
    public String sell(Goods goods) {
        
    String result ="";
    
    if(goods == Goods.POTION){
    result  = "potion";
    }
    return result;
    }
    public enum Goods{
    POTION
      }
    }