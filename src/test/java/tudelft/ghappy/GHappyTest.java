package tudelft.ghappy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class GHappyTest {
    //There's a g by itself => false
    @Test
    public void lonelyG(){
        GHappy gTest = new GHappy();
        boolean result = gTest.gHappy("xxgxx");
        Assertions.assertFalse(result);
    }

    @Test
    public void happyG(){
        GHappy gTest = new GHappy();
        boolean result = gTest.gHappy("xxggxx");
        Assertions.assertTrue(result);
    }

    @Test
    public void manyG(){
        GHappy gTest = new GHappy();
        boolean result = gTest.gHappy("xxggyygxx");
        Assertions.assertFalse(result);
    }

    @ParameterizedTest(name = "input={0}, result={1}")
    @CsvSource({
            "yyxxgg,true", "yyxxg,false", "ggyyxx,true", "gyyxx,false"
    })
    public void boundaryG(String input, boolean result ){
        GHappy gTest = new GHappy();
        boolean test = gTest.gHappy(input);
        Assertions.assertEquals(test, result);
    }
}
