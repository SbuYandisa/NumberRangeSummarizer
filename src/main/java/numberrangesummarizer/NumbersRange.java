package numberrangesummarizer;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author Yandisa Madinga
 */
//This class implements the NumberRangeSummarizer interface 
public class NumbersRange implements NumberRangeSummarizer {
    
    //Collects input as a string and converts it into a collection of integers.
    @Override 
    public Collection<Integer> collect(String input) {
        try {
            Collection<Integer> numbersList = Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        
            return numbersList;
        }catch(IllegalArgumentException e){
            try {
                throw new Exception("Invalid input");
            } catch (Exception ex) {
                Logger.getLogger(NumbersRange.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

     //Group numbers from the collection into a range when they are sequential and produces a comma delimited summary of numbers from the collection
    @Override
    public String summarizeCollection(Collection<Integer> input) {
       List<String> ranges = new ArrayList<>();
       List<Integer> currentRange = new ArrayList<>();
       Integer[] numbersArray = input.toArray(Integer[]::new);
       currentRange.add(numbersArray[0]);
       
       for (int i = 1; i < numbersArray.length; i++) {
            if (numbersArray[i] == currentRange.get(currentRange.size() - 1) + 1) {
                currentRange.add(numbersArray[i]);
            } 
            else {
                ranges.add(outputFormat(currentRange));
                currentRange.clear();
                currentRange.add(numbersArray[i]);
            }
        }
       
        ranges.add(outputFormat(currentRange));
        return String.join(", ", ranges);
    }
    //formats the range of numbers by adding and adds - between the range.
    private String outputFormat(List<Integer> range){
        if (range.size() == 1) {
            return String.valueOf(range.get(0));
        }
        else {
        return range.get(0) + "-" + range.get(range.size() - 1);
        }
    }
    
}
