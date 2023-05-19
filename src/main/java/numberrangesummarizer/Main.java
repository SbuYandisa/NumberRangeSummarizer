package numberrangesummarizer;

import java.util.Collection;

/**
 *
 * @author Yandisa Madinga
 */
//This was used for simple testing purpose,it can be ignored or deleted
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        NumbersRange nr = new NumbersRange();
        
        String numbers = "1,2,3,5,6,8,9,10";
        Collection<Integer> result = nr.collect(numbers);
        System.out.println(nr.summarizeCollection(result)); 
    }
    
}
