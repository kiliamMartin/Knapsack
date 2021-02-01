package Knapsack.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Tabulation {
    
    private List<Item> takenItems;
    private int benefit,room, ksWeightNow;
    private double time;
    
    /**
     * Solve Tabulation Algorithm
     * 
     * @param items
     * @param capacity
     */
    public void solveTabulation(List<Item> items, int capacity)
    {
        double start = System.currentTimeMillis();
        int n = items.size()+1;
        int W = capacity+1;
        int[][] V = new int[n][W];
        
        for (int i = 1; i < n; i++) {
            for (int w = 0; w < W; w++) {
                
                if (items.get(i-1).getWeight() <= w){
                    if (items.get(i-1).getValue() + V[i-1][w-items.get(i-1).getWeight()] > V[i-1][w]){
                        V[i][w] = items.get(i-1).getValue() + V[i-1][w-items.get(i-1).getWeight()];
                    }
                    else V[i][w] = V[i-1][w];
                }
                else V[i][w] = V[i-1][w];               
            }           
        } 
        benefit= V[n-1][W-1];   
        int i = items.size();
        int k = capacity;
        ksWeightNow = 0;
        takenItems = new ArrayList<>();
        while (i > 0 && k > 0)
        {
            if(V[i][k] != V[i-1][k])
            {
                i = i-1;
                k = k-items.get(i).getWeight();
                takenItems(items.get(i));
                ksWeightNow += items.get(i).getWeight();
            }
            else i = i-1;
        }       
        room = capacity - ksWeightNow;
        double end = System.currentTimeMillis();
        time = (end - start)/1000;
        

    }
     
    /**
     * Return benefit
     * 
     * @return 
     */
    public int getBenefit()
    {
        return benefit;
    }
    
    /**
     * Return time
     * 
     * @return
     */
    public double getTime() 
    {
        return time;
    }
    
    
    private void takenItems(Item item)
    {
       
        takenItems.add(item);
       
    }
    
    /**
     * Return index of taken items
     * 
     * @return 
     */
    public int[] getTakenItems()
    {
        int [] index = new int[takenItems.size()];
        for (int i = 0; i < index.length; i++) {
            index[i] = takenItems.get(i).getIndex();     
        }
        Arrays.sort(index);
        return index;
    }
    
    /**
     * Return Knapsack room
     * 
     * @return
     */
    public int getRoom()
    {
        return room;
    }
    
    
}
