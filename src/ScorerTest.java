import org.junit.jupiter.api.Test;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertArrayEquals;

public class ScorerTest{


//----------------------------------------------------------------------------------------------------------------------

    // TEST FOR PARSER CLASS

    @Test
    public void testCategoryParser(){

        String test = "(1, 2, 3, 4, 5) fullhouse";
        String expectedResult = "fullhouse";

        assertEquals(expectedResult, Parser.parseCategoryChosen(test));
    }

    @Test
    public void testDiceInputs(){
        int[] test = Parser.parseDiceValues("(1, 2, 3, 4, 5) fullhouse");

        int[] expectedResult = new int[]{1,2,3,4,5};

        assertArrayEquals(expectedResult, test);
    }




//----------------------------------------------------------------------------------------------------------------------

    // TEST NUMBERS

    @Test
    public void testNumbersScore(){

        int[] values = new int[]{2,3,2,3,2};

        int test = CalculateScore.numberChoice(2, values);

        int expectedResult = 3;

        assertEquals(expectedResult, test);
    }

    @Test
    public void testNumbersNoScore(){

        int[] values = new int[]{1,2,3,4,5};

        int test = CalculateScore.numberChoice(6, values);

        int expectedResult = 0;

        assertEquals(expectedResult, test);

    }

    @Test
    public void testFullHouseScore(){

        int[] values = new int[]{1,1,2,2,2};

        int test = CalculateScore.fullHouse(values);

        int expectedResult = 8;

        assertEquals(expectedResult, test);

    }

    @Test
    public void testFullHouseNoScore(){
        int[] values = new int[]{1,1,2,2,3};

        int test = CalculateScore.fullHouse(values);

        int expectedResult = 0;

        assertEquals(expectedResult, test);
    }


//----------------------------------------------------------------------------------------------------------------------

}
