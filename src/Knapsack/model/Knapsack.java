package Knapsack.model;

import java.util.List;
import java.io.FileNotFoundException;
import java.util.ArrayList;


public class Knapsack {
    
    private final int capacity, n_items;
    private final int[] itemData;
    private final List<Item> ksitems = new ArrayList<>();
    
    /**
     * Knapsack constructor 
     * 
     * @param capacity
     * @param n_items
     * @param itemData
     */
    public Knapsack(int capacity, int n_items, int[] itemData)
    {
        this.capacity = capacity;
        this.n_items = n_items;
        this.itemData=itemData;
        
    }
    
    /**
     * Add items to Knapsack
     * 
     * @throws FileNotFoundException
     */
    public void addItem() throws FileNotFoundException
    {
        Item item;
        int i = 0;
        for (int x = 0; x < n_items; x++) {
            item = new Item(x, itemData[i], itemData[i+1]);
            ksitems.add(item);
            i=i+2;
        }
    }
    
    /**
     * Return Knapsack capacity
     * 
     * @return
     */
    public int getCapacity()
    {
        return capacity;
    }
    
    /**
     * Return Knapsack items
     * 
     * @return
     */
    public List<Item> getItems()
    {
        return ksitems;
    }
    
    /**
     * Return Number of items inside Knapsack
     * 
     * @return
     */
    public int getNumberOfItems()
    {
        return ksitems.size();
    }
    
}
