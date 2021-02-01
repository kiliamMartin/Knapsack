package Knapsack.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Memoization {

    private double time;
    private int benefit;
    private int room;
    private List<Item> takenItems;
    private int ksWeightNow;
    
    /**
     * Solve Memoization Algorithm
     * 
     * @param items
     * @param capacity
     */
    public void solveMemoization(List<Item> items, int capacity)
    {
        double start = System.currentTimeMillis();
        int n = items.size();
        int W = capacity;
        int [][] V = new int[n+1][W+1];

        benefit = auxMemoization(items,W,n,V);
        int i = items.size();
        int k = W;
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
    
    private int auxMemoization(List<Item> items, int W, int n, int[][] V)
    {
        if(n == 0 || W == 0) return 0;
        
        if(V[n][W] != 0) return V[n][W];
        
        if(items.get(n-1).getWeight() <= W ){
            V[n][W] = Math.max(items.get(n-1).getValue() + 
                      auxMemoization(items, W-items.get(n-1).getWeight(), n-1,V),auxMemoization(items, W, n-1,V));
            return V[n][W];
        }
        else{
             V[n][W] = auxMemoization(items, W, n-1,V);
        }
        
        return V[n][W];
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
