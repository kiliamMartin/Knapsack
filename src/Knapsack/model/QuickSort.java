package Knapsack.model;

import java.util.List;
import java.util.Random;

public class QuickSort {
    private static void random(List<Item>item,int low,int high) 
    { 
     
        Random rand= new Random(); 
        int pivot = rand.nextInt(high-low)+low; 
        Item temp=item.get(pivot);  
        item.set(pivot, item.get(high)); 
        item.set(high, temp); 
    } 
     
    private static int partition(List<Item>item,boolean inAscendingOrder,int low, int high) {
        
      random(item, low, high);
      Item pivot = item.get(high);
      int i = low - 1;
      for (int j = low; j < high; j++) {
        if (inAscendingOrder == false)
        {
          if (item.get(j).getWeight() > pivot.getWeight()) 
          {
          i++;
          Item temp = item.get(i);
          item.set(i,item.get(j));
          item.set(j,temp);
          }
        }
        else
        {
            if (item.get(j).getWeight() < pivot.getWeight()) 
            {
                i++;
                Item temp = item.get(i);
                item.set(i,item.get(j));
                item.set(j,temp);
            }
        }
      }
      Item temp = item.get(i+1);
      item.set(i+1,item.get(high));
      item.set(high, temp);
      return (i + 1);
    }

    /**
     * QuickSort Algorithm
     * 
     * @param item
     * @param inAscendingOrder
     * @param low
     * @param high
     */
    public static void quickSort(List<Item> item,boolean inAscendingOrder,int low, int high) {
      if (low < high) {
          int pi = partition(item,inAscendingOrder,low, high);
          quickSort(item,inAscendingOrder, low, pi - 1);
          quickSort(item,inAscendingOrder,pi + 1, high);
      }
    }
}
