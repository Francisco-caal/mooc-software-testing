package tudelft.roman;

import java.util.HashMap;
import java.util.Map;

public class   RomanNumeral {

    private static Map<Character, Integer> map;

    static {
        map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    public int convert(String s) {

        int convertedNumber = 0;
        int[] nonSubstract = new int[]{5, 50, 500};
        char currentNumeral = ' ';
        int repetition = 0;


        for(int i = 0; i < s.length(); i++) {

            if(currentNumeral != s.charAt(i)){
                currentNumeral = s.charAt(i);
                repetition = 0;
            }

            repetition++;

            if(repetition > 3) {
                return -1;
            }

            int currentNumber = map.get(s.charAt(i));
            int next = i+1 < s.length() ? map.get(s.charAt(i+1)) : 0;
            int previous = i-1 >= 0 ? map.get(s.charAt(i-1)) : 0;

            if(currentNumber >= next){
                convertedNumber += currentNumber;
            }else{
                //Check for multiple substractions
                if(previous != 0 && previous <= currentNumber){
                    return -1;
                }
                //Check for invalid substractions
                for (int n : nonSubstract) {
                    if (n == currentNumber) {
                        return -1;
                    }
                }

                convertedNumber -= currentNumber;
            }
        }

        return convertedNumber;

    }
}
