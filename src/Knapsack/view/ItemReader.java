package Knapsack.view;


import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;


public class ItemReader {
    private int capacity,n_items;
    private int[] itemData;

    /**
     * Return Knapsack Capacity
     * 
     * @return
     */
    public int getCapacity()
    {
        return capacity;
    }
    
     /**
     * Return number of Items read
     * 
     * @return
     */
    public int getNumItems()
    {
        return n_items;
    }
    
     /**
     * Return Item Data (Values and Weights) read
     * 
     * @return
     */
    public int[] getItemData()
    {
        return itemData;
    }
    
    /**
     * Read data files and set Knapsack capacity, number of items and items data
     * 
     * @param f
     * @throws FileNotFoundException
     */
    public void read(File f) throws FileNotFoundException {
        try (Scanner sc = new Scanner(f)) {
            n_items = sc.nextInt();
            itemData = new int[n_items*2];  
            capacity = sc.nextInt();
            for (int i = 0; i < itemData.length; i++) {
                
                
            }         
        }
    }
    
}