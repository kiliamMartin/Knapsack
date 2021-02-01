package Knapsack.view;

import Knapsack.model.Greedy;
import Knapsack.model.Item;
import Knapsack.model.Knapsack;
import Knapsack.model.Memoization;
import Knapsack.model.Tabulation;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public class ConsoleOptions {
    
    private int benefit,room,capacity;
    private double time;
    private int[] taken;
    private boolean error;
    
    private void showHelp()
    {
       
            System.out.println("usage: KnapsackApp [-h] [-d [DIRECTORY]] [-f [FILE]] [-b] [-r] [-t] [-dt] [-sg] [-sm] [-st]");
            System.out.println("");
            System.out.println("optional arguments:");
            System.out.println("-h, --help\t\tshow this help message and exit");
            System.out.println("-d [DIRECTORY], --directory [DIRECTORY]\n\t\t\tdirectory (process many files)");
            System.out.println("-f [FILE], --file [FILE]");
            System.out.println("\t\t\tfile (process a single file)");
            System.out.println("-b,  --benefit\t\tDisplay benefit");
            System.out.println("-r,  --room\t\tDisplay room (unused knapsack weigth)");
            System.out.println("-t,  --time\t\tDisplay time");
            System.out.println("-dt, --display_taken\tDisplay identifier of taken items");
            System.out.println("-sg, --greedy\t\tSolve it with Greedy");
            System.out.println("-sm, --memoization\tSolve it with Memoization");
            System.out.println("-st, --tabulation\tSolve it with Tabulation");
            System.out.println("");
            
    }
    
    /**
     * Set console input for run
     * 
     * @param option
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void setInput(String[] option) throws FileNotFoundException, IOException
    {
        ItemReader itr = new ItemReader();
        Knapsack ks;
        File file;
     
        switch(option[0])
        {
            case "-f" : file = new File(option[1]);
                        itr.read(file);
                        ks = new Knapsack(itr.getCapacity(),itr.getNumItems(),itr.getItemData());
                        ks.addItem();
                        System.out.println("----------------------------------------------------------------------------------------------");
                        System.out.println(file.getName());
                        error = false;
                        for (String opt : option) {
                            setAlgorithm(opt, ks.getItems(), ks.getCapacity());
                        }
                        if (error == false)
                        {
                            for (String opt : option) {
                                setOptions(opt);
                            }
                        }
                        System.out.println("----------------------------------------------------------------------------------------------");
                        System.exit(0);
                        break;

            
            case "-d" : File dir = new File(option[1]);
                        if(dir.isDirectory()) {
                            String[] ficheros = dir.list();
                            Arrays.sort(ficheros);
                            System.out.println("----------------------------------------------------------------------------------------------");
                            for (String f : ficheros) {
                                error = false;
                                file = new File(dir.getAbsoluteFile() + "/" + f);
                                itr.read(file);
                                ks = new Knapsack(itr.getCapacity(),itr.getNumItems(),itr.getItemData());
                                ks.addItem();
                                System.out.println(file.getName());
                                for (String opt : option) {
                                    setAlgorithm(opt, ks.getItems(), ks.getCapacity());
                                }
                                if (error == false)
                                {
                                    for (String opt : option) {
                                        setOptions(opt);
                                    }
                                }
                                System.out.println("----------------------------------------------------------------------------------------------");
                            }
                        }
                        System.exit(0);
                        break;
            
            case "-h" : showHelp();
                        System.exit(0);
                        break;
            
            default   : 
                        System.out.println("No valid option. Use -h for help");
                        System.exit(1);
                        break;
        }
    }
    
    private void setAlgorithm(String option, List<Item> items, int capacity)
    {
        
        switch(option)
        {
            case "-sg" : System.out.println("\t\tAlgorithm : " + "Greedy");
                         this.capacity = capacity; 
                         Greedy g = new Greedy();
                         try{
                             g.solveGreedy(items, capacity);
                             greedyLoadOptions(g);
                             
                         }catch(OutOfMemoryError e){
                             error = true;
                             System.out.println("\t\tError     : Can't apply Greedy into this file\n"+ "\t\tException : " + e.getMessage());  
                         }
                         
                         break;
            
            case "-st" : System.out.println("\t\tAlgorithm : " + "Tabulation");
                         this.capacity = capacity;
                         Tabulation t = new Tabulation();
                         try{
                                t.solveTabulation(items, capacity);
                                tabulationLoadOptions(t);
                                
                         }catch(OutOfMemoryError e){
                                error = true;
                                System.out.println("\t\tError     : Can't apply Tabulation into this file\n"+ "\t\tException : " + e.getMessage());       
                         }       
                         break;
                         
            
            case "-sm" : System.out.println("\t\tAlgorithm : " + "Memoization");
                         this.capacity = capacity;
                         Memoization m = new Memoization();
                         try{
                             m.solveMemoization(items, capacity);
                             memoizationLoadOptions(m);
                         }catch (OutOfMemoryError e){
                             error = true;
                             System.out.println("\t\tError     : Can't apply Memoization into this file\n"+ "\t\tException : " + e.getMessage());
                         } 
                         break;

            default: 
                         break;
        }
        
    }
    
       
    private void setOptions(String option)
    {
        switch(option)
        {
            case "-b" : System.out.println("\t\tBenefit   : " + benefit);
                        break;
            
            case "-r" : System.out.println("\t\tRoom      : " +  "Capacity : " + capacity + "\n\t\t\t    Unused   : " + room + "\n\t\t\t    Used     : " + (capacity-room));
                        break;
            
            case "-t" : System.out.println("\t\tTime      : " + time + " seconds");
                        break;
            
            case "-dt": System.out.println("\t\tTaken     : "  + Arrays.toString(taken));
                        break;
            
            default:
                        break;
                     
        }
    }

    private void greedyLoadOptions(Greedy g) {
        benefit = g.getBenefit();
        time    = g.getTime();
        room    = g.getRoom();
        taken   = g.getTakenItems();
    }
    private void tabulationLoadOptions(Tabulation t) {
        benefit = t.getBenefit();
        time    = t.getTime();
        room    = t.getRoom();
        taken   = t.getTakenItems();
    }
    
    private void memoizationLoadOptions(Memoization m)
    {
        benefit = m.getBenefit();
        time    = m.getTime();
        room    = m.getRoom();
        taken   = m.getTakenItems();
    }

    
    
}
