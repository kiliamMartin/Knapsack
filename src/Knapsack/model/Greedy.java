package Knapsack.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Greedy {
    
    private int ksWeightNow,benefit,room;
    private double time;
    private List<Item> takenItems;
    //
    

    /**
     * Solve Greedy Algorithm
     * 
     * @param items
     * @param capacity
     */
    public void solveGreedy(List<Item> items, int capacity) 
    {
        double start = System.currentTimeMillis();
        QuickSort qs = new QuickSort();
        int size = items.size();
        qs.quickSort(items,false,0,size-1);

        ksWeightNow = 0;
        int i = 0;
        benefit = 0;
        takenItems = new ArrayList<>();
        while(ksWeightNow <= capacity && i< items.size()){
            if(items.get(i).getWeight() <= (capacity-ksWeightNow)) {
                takenItems(items.get(i));
                ksWeightNow += items.get(i).getWeight();
                benefit += items.get(i).getValue();
            }
            i++;
        }
        double end = System.currentTimeMillis();
        time = (end - start)/1000;
        room = capacity - ksWeightNow;
        
        
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
