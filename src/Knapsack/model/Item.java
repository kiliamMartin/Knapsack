package Knapsack.model;


public class Item {

    private final int index;
    private final int value;
    private final int weight;

    /**
     * Item constructor
     * 
     * @param index
     * @param value
     * @param weight
     */
    public Item(int index, int value, int weight)
    {
        this.index = index;
        this.value = value;
        this.weight = weight;
    }
    
    /**
     * Return Item's weight
     * 
     * @return
     */
    public int getWeight()
    {
        return weight;
    }
    
    /**
     * Return Item's value
     * 
     * @return
     */
    public int getValue()
    {
        return value;
    }
    
    /**
     * Return Item's index
     * 
     * @return 
     */
    public int getIndex()
    {
        return index;
    }
    
    
}
