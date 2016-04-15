/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package change_coin;

/**
 *
 * @author me
 */
public class Change_coin {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
         greedy_algo(100);
         dynamic_algorithm(100);
        
        
    }
    
      public static int greedy_algo(int amount)
    {
      int  count =0;
       
       
         while(  amount >= 25)
        {
            count++;
            
            amount = amount-25;
        }
          while(  amount >= 10)
        {
            count++;
       
            amount = amount-10;
        }
           while(  amount >= 5)
        {
            count++;
            
            amount = amount-5;
        }
            while(  amount >= 1)
        {
            count++;
            amount = amount-25;
        }
            
            System.out.println("Minimum number of coins by greedy approach: " + amount);
    
    return 0;
    
    }
    
    
     public static void dynamic_algorithm(int amount )
        {
            int [] coin_val = {1,5,10,25};
            int[] coin = new int[amount+1];
            if(amount == 0)
                coin[0] = 0;
             for (int i=1; i<=amount; i++)
             {
                 coin[i] = 1000000;
             }
             
            
	for (int i=1; i<=amount; i++)
    {
        // Go through all coins smaller than i
        for (int j=0; j< coin_val.length; j++)
          if (coin_val[j] <= i)
          {
              int result = coin[i-coin_val[j]];
              if (result != 1000000 && result + 1 < coin[i])
                  coin[i] = result + 1;
          }
         
    }
        
      System.out.println("Minimum number of coins by dynamic approach: "+coin[amount]);

        }
        
    
}

    
    

