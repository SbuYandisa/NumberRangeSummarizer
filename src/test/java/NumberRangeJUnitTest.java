
import java.util.Collection;
import numberrangesummarizer.NumbersRange;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Yandisa Madinga
 */
public class NumberRangeJUnitTest {
    
    public NumberRangeJUnitTest() {
    }
    //Assumption:
    //input is allowed to be empty 
    @Test
    public void testEmptyStringAsInput(){
        var nr = new NumbersRange();
        Collection<Integer> result = nr.collect("");
        assertThrows(NullPointerException.class,
                ()-> {
                    nr.summarizeCollection(result);
                }
        );
    }
    //Assumption:
    //input is allowed to be a space character
    @Test
    public void testSpaceCharacterAsInput(){
        var nr = new NumbersRange();
        Collection<Integer> result = nr.collect(" ");
        assertThrows(NullPointerException.class,
                ()-> {
                    nr.summarizeCollection(result);
                }
        );
    }
    //Assumption:
    //input is allowed to be a string of words or characters
    @Test
    public void testWordsAsInput(){
        var nr = new NumbersRange();
        Collection<Integer> result = nr.collect("Words only");
        assertThrows(NullPointerException.class,
                ()-> {
                    nr.summarizeCollection(result);
                }
        );
    }
    //input is a single number.
    //"1"should return "1"
    @Test
    public void testSingleNumberAsInput(){
       var nr = new NumbersRange();
       Collection<Integer> result = nr.collect("1");
       Assertions.assertEquals("1", nr.summarizeCollection(result));
    }
    //input is only two different numbers
    //"1,2" should return "1-2"
    @Test
    public void testTwoDiffNumbersAsInput(){
       var nr = new NumbersRange();
       Collection<Integer> result = nr.collect("1,2");
       Assertions.assertEquals("1-2", nr.summarizeCollection(result));
    }
    //input is two same numbers
    //"1,1"should return "1, 1"
    @Test
    public void testTwoSameNumbersAsInput(){
       var nr = new NumbersRange();
       Collection<Integer> result = nr.collect("1,1");
       Assertions.assertEquals("1, 1", nr.summarizeCollection(result));
    }
    //input is five different and sequential numbers
    //"3,4,5,6,7," should return "3-7"
    @Test
    public void testFiveSequentialNumbersAsInput(){
       var nr = new NumbersRange();
       Collection<Integer> result = nr.collect("3,4,5,6,7");
       Assertions.assertEquals("3-7", nr.summarizeCollection(result));
    }
    //input is 10 numbers with two sequential groups
    //"1,2,3,5,7,9,10,11,13,15" should return "1-3, 5, 7, 9-11, 13, 15"
    @Test
    public void testTenNumbersWithTwoSequentialGroupsAsInput(){
       var nr = new NumbersRange();
       Collection<Integer> result = nr.collect("1,2,3,5,7,9,10,11,13,15");
       Assertions.assertEquals("1-3, 5, 7, 9-11, 13, 15", nr.summarizeCollection(result));
    }
    //input is 10 different and sequential numbers 
    //"10,11,12,13,14,15,16,17,18,19" should return "10-19"
    @Test
    public void testTenDiffSequentialNumbersAsInput(){
       var nr = new NumbersRange();
       Collection<Integer> result = nr.collect("10,11,12,13,14,15,16,17,18,19");
       Assertions.assertEquals("10-19", nr.summarizeCollection(result));
    }
    //Sample input provided
    //"1,3,6,7,8,12,13,14,15,21,22,23,24,31" sould return "1, 3, 6-8, 12-15, 21-24, 31"
    @Test
    public void testSampleInput(){
       var nr = new NumbersRange();
       Collection<Integer> result = nr.collect("1,3,6,7,8,12,13,14,15,21,22,23,24,31");
       Assertions.assertEquals("1, 3, 6-8, 12-15, 21-24, 31", nr.summarizeCollection(result));
    } 
}
