import org.junit.Test;
import org.junit.Assert;

public class StringCalculatorTest {
	
	@Test
    public void testEmptyStringReturnZero() {
        
		Assert.assertEquals(new StringCalculator().add(""), 0);
		
    }

    @Test
    public void testSingleNumberReturnItsValue() {

    	Assert.assertEquals(new StringCalculator().add("1"), 1);
    	
    }

    @Test
    public void testTwoCommaSeparatedNumbersReturnTheirSum() {
        
    	Assert.assertEquals(new StringCalculator().add("1,2"), 3);
        
    }

    @Test
    public void testUnknownAmountOfNumbersCommaSeparatedNumbersReturnTheirSum() {

    	Assert.assertEquals(new StringCalculator().add("1,2,3"), 6);
    	
    }

    @Test
    public void testNewLineAsSeparator() {

    	Assert.assertEquals(new StringCalculator().add("1\n2,3"), 6);
    	
    }

    @Test
    public void testBeginningOfStringWillContainASeparator() {

    	Assert.assertEquals(new StringCalculator().add("//;\n1;2"), 3);
    	
    }

    @Test
    public void testCustomSeparatorForEmptyStringReturnZero() {

    	Assert.assertEquals(new StringCalculator().add("//,\n"), 0);
        
    }

    @Test
    public void testCustomSeparatorForSingleNumberReturnItsValue() {

    	Assert.assertEquals(new StringCalculator().add("//,\n1"), 1);
        
    }

    @Test
    public void testCustomSepratorForTwoCommaSeparatedNumbersReturnTheirSum() {

    	Assert.assertEquals(new StringCalculator().add("//,\n1,2"), 3);
        
    }
    
    @Test
    public void testCustomSepratorForUnknownAmountOfNumbersCommaSeparatedNumbersReturnTheirSum() {

    	Assert.assertEquals(new StringCalculator().add("//,\n1,2,3"), 6);
    	
    }

    @Test
    public void testANegativeNumberWillThrowAnException() {
    	
    	try {
        	
        	new StringCalculator().add("-1");
            Assert.fail("exception should have been thrown");
            
        } catch (Exception e) {
        	
        	Assert.assertEquals("failure message", "Negatives not allowed: [-1]", e.getMessage());
        	
        }
        
    }

    @Test
    public void testMultipleNegativeNumbersWillThrowAnException() {

    	try {
        	
        	new StringCalculator().add("-1,-2");
            Assert.fail("exception should have been thrown");
            
        } catch (Exception e) {
        	
        	Assert.assertEquals("failure message", "Negatives not allowed: [-1, -2]", e.getMessage());
        	
        }
        
    }

    public void testNumbersBiggerThan1000ShouldBeIgnored() {

    	Assert.assertEquals(new StringCalculator().add("1001,1002,1"), 1);
        
    }

}
