package tudelft.caesarshift;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import tudelft.ghappy.GHappy;

public class CaesarShiftCipherTest {

    private CaesarShiftCipher caesar;

    @BeforeEach
    public void initialize() {
        this.caesar = new CaesarShiftCipher();
    }

    @Test
    public void positiveShift(){
        String result = caesar.CaesarShiftCipher("abc",1);
        Assertions.assertEquals("bcd", result);
    }

    @Test
    public void negativeShift(){
        String result = caesar.CaesarShiftCipher("bcd",-1);
        Assertions.assertEquals("abc", result);
    }

    @ParameterizedTest(name = "input={0}, shift={1}, result={2}")
    @CsvSource({
            "abc,-3,xyz", "axz,3,dac"
    })
    public void boudaries(String input, int shift, String result ){
        String test = caesar.CaesarShiftCipher(input,shift);
        Assertions.assertEquals(result, test);
    }

    @ParameterizedTest(name = "input={0}")
    @CsvSource({
            "abc123","ABC","A2B@!"
    })
    public void invalidCharacters(String input){
        String result = caesar.CaesarShiftCipher(input,1);
        Assertions.assertEquals("invalid", result);
    }
}
