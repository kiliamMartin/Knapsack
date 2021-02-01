import Knapsack.view.ConsoleOptions;
import java.io.FileNotFoundException;
import java.io.IOException;


public class KnapsackApp {

    /**
     * Run Knapsack 
     * 
     * @param args
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException{
        
        if (args.length >= 1)
        {
            ConsoleOptions co = new ConsoleOptions();
            co.setInput(args);
        }
    }
    
}

            
        