package edu.gatech.seclass;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class MyCustomStringTest {

    private MyCustomStringInterface mycustomstring;

    @Before
    public void setUp() {
        mycustomstring = new MyCustomString();
    }

    @After
    public void tearDown() {
        mycustomstring = null;
    }

    /**
     * This test checks if method countNumbers
     * can correctly count number of numbers in a test string
     */
    @Test
    public void testCountNumbers1() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals(7, mycustomstring.countNumbers());
    }

    /**
     * This test checks if method countNumbers
     * can correctly count sequence of more than one digit as a single number
     */
    @Test
    public void testCountNumbers2() {
        mycustomstring.setString("This string contains multi digit numbers: 10_22_234_54_34345");
        assertEquals(5, mycustomstring.countNumbers());
    }

    /**
     * This test checks if method countNumbers
     * suitably throws NullPointerException when
     * string is null
     */
    @Test(expected=NullPointerException.class)
    public void testCountNumbers3() {
        mycustomstring.setString(null);
        mycustomstring.countNumbers();
    }

    /**
     * This test checks if method countNumbers
     * returns count of numbers to be 0 if there are no digits present in the string
     */
    @Test
    public void testCountNumbers4() {
        mycustomstring.setString("This string has no numbers!");
        assertEquals(0, mycustomstring.countNumbers());
    }

    /**
     * This test checks if method countNumbers
     * can count groups of consecutive digits where groups are separated by symbols like .,;! etc.
     * as different numbers
     */
    @Test
    public void testCountNumbers5() {
        mycustomstring.setString("21,35.42!58;96");
        assertEquals(5, mycustomstring.countNumbers());
    }

    /**
     * This test checks if method  countNumbers
     * can correctly count groups of consecutive digits with each group separated by spaces
     * as different numbers
     */
    @Test
    public void testCountNumbers6() {
        mycustomstring.setString("this string contains number separated by spaces like 26 32 1 22 etc.");
        assertEquals(4, mycustomstring.countNumbers());
    }

    /**
     * This test checks if method getEveryNthCharacterFromBeginningOrEnd
     * can correctly return nth character of a test string from the beginning of string
     */
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd1() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("d33p md1  i51,it", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, false));
    }

    /**
     * This test checks if method getEveryNthCharacterFromBeginningOrEnd
     * can correctly return nth character of a test string from the end of string
     */
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd2() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("'bt t0 6snh r6rh", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, true));
    }

    /**
     * This test checks if method getEveryNthCharacterFromBeginningOrEnd
     * can correctly retain the case of characters in the result
     * while search for the nth characters from given string with startFromEnd == false
     */
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd3() {
        mycustomstring.setString("ThIs StRinG cONTaiNs chAraCteRs");
        assertEquals("hsSRn OTiscAatR", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(2, false));
    }

    /**
     * This test checks if method getEveryNthCharacterFromBeginningOrEnd
     * can correctly retain the case of characters in the result
     * while search for the nth characters from given string with startFromEnd == true
     */
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd4() {
        mycustomstring.setString("ThIs StRinG cONTaiNs chAraCteRs");
        assertEquals("h RGOashae", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, true));
    }

    /**
     * This method checks if method getEveryNthCharacterFromBeginningOrEnd
     * suitably returns "" (empty string) when
     * string is not empty,
     * n > length of string.
     */
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd5() {
        mycustomstring.setString("A very short string!");
        assertEquals("", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(50, false));
        assertEquals("", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(50, true));
    }

    /**
     * This test checks if method getEveryNthCharacterFromBeginningOrEnd
     * suitably returns ""(empty string) when
     * string is empty,
     * n >= 1,
     * startFromEnd == false.
     */
    //Should return empty string when string is empty, n >= 1 & startFromEnd==false
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd6() {
        mycustomstring.setString("");
        assertEquals("", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(1, false));
        assertEquals("", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(5, false));
    }

    /**
     * This test checks if method getEveryNthCharacterFromBeginningOrEnd
     * suitably returns "" (empty string) when
     * string is empty,
     * n >= 1,
     * startFromEnd == true
     */
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd7() {
        mycustomstring.setString("");
        assertEquals("", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(1, true));
        assertEquals("", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(5, true));
    }

    /**
     * This test checks if method getEveryNthCharacterFromBeginningOrEnd
     * suitably throws IllegalArgumentException when
     * string is not empty,
     * n == 0,
     * startFromEnd == false
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetEveryNthCharacterFromBeginningOrEnd8() {
        mycustomstring.setString("This is a non-empty string.");
        mycustomstring.getEveryNthCharacterFromBeginningOrEnd(0, false);
    }

    /**
     * This test checks if method getEveryNthCharacterFromBeginningOrEnd
     * suitably throws IllegalArgumentException when
     * string is not empty,
     * n == 0,
     * startFromEnd == true
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetEveryNthCharacterFromBeginningOrEnd9() {
        mycustomstring.setString("This is a non-empty string.");
        mycustomstring.getEveryNthCharacterFromBeginningOrEnd(0, true);
    }

    /**
     * This test checks if method getEveryNthCharacterFromBeginningOrEnd
     * suitably throws IllegalArgumentException when
     * string is not empty
     * n < 0,
     * startFromEnd == false
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetEveryNthCharacterFromBeginningOrEnd10() {
        mycustomstring.setString("This is a non-empty string.");
        mycustomstring.getEveryNthCharacterFromBeginningOrEnd(-1, false);
    }

    /**
     * This test checks if method getEveryNthCharacterFromBeginningOrEnd
     * suitably throws exception IllegalArgumentException when
     * string is not empty,
     * n < 0,
     * startFromEnd == true
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetEveryNthCharacterFromBeginningOrEnd11() {
        mycustomstring.setString("This is a non-empty string.");
        mycustomstring.getEveryNthCharacterFromBeginningOrEnd(-1, true);
    }

    /**
     * This test checks if method getEveryNthCharacterFromBeginningOrEnd
     * suitably throws IllegalArgumentException when
     * string == null,
     * n > 0,
     * startFromEnd == false
     */
    @Test(expected=NullPointerException.class)
    public void testGetEveryNthCharacterFromBeginningOrEnd12() {
        mycustomstring.setString(null);
        mycustomstring.getEveryNthCharacterFromBeginningOrEnd(2, false);
    }

    /**
     * This test checks if method getEveryNthCharacterFromBeginningOrEnd
     * suitably throws IllegalArgumentException when
     * string == null,
     * n > 0,
     * startFromEnd == true
     */
    @Test(expected=NullPointerException.class)
    public void testGetEveryNthCharacterFromBeginningOrEnd13() {
        mycustomstring.setString(null);
        mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, true);
    }

    /**
     * This test checks if method getEveryNthCharacterFromBeginningOrEnd
     * suitably throws IllegalArgumentException when
     * string == null,
     * n == 0,
     * startFromEnd == false
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetEveryNthCharacterFromBeginningOrEnd14() {
        mycustomstring.setString("This is a good string");
        mycustomstring.getEveryNthCharacterFromBeginningOrEnd(0, false);
    }

    /**
     * This test checks if method getEveryNthCharacterFromBeginningOrEnd
     * suitably throws IllegalArgumentException when
     * string == null,
     * n < 0,
     * startFromEnd == false
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetEveryNthCharacterFromBeginningOrEnd15() {
        mycustomstring.setString("This is also a good string");
        mycustomstring.getEveryNthCharacterFromBeginningOrEnd(-1, false);
    }

    /**
     * This test checks if method getEveryNthCharacterFromBeginningOrEnd
     * suitably throws IllegalArgumentException.class when
     * string == null,
     * n == 0,
     * startFromEnd == true
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetEveryNthCharacterFromBeginningOrEnd16() {
        mycustomstring.setString(null);
        assertEquals("", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(0, true));
    }

    /**
     * This test checks if method getEveryNthCharacterFromBeginningOrEnd
     * suitably throws IllegalArgumentException when
     * string == null,
     * n < 0,
     * startFromEnd == true
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetEveryNthCharacterFromBeginningOrEnd17() {
        mycustomstring.setString(null);
        assertEquals("", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(-1, true));
    }

    /**
     * This test checks if method convertDigitsToNamesInSubstring
     * correctly converts digits into words within selected positions of the string
     */
    @Test
    public void testConvertDigitsToNamesInSubstring1() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        mycustomstring.convertDigitsToNamesInSubstring(17, 23);
        assertEquals("I'd b3tt3r put sZerome dOneSix1ts in this 5tr1n6, right?", mycustomstring.getString());
    }

    /**
     * This test checks if method convertDigitsToNamesInSubstring
     * suitably throws MyIndexOutOfBoundException when
     * startPosition < 1
     */
    @Test(expected = MyIndexOutOfBoundsException.class)
    public void testConvertDigitsToNamesInSubstring2() {
        mycustomstring.setString("2016 is the current year.");
        mycustomstring.convertDigitsToNamesInSubstring(0, 5);
    }

    /**
     * This test checks if method convertDigitsToNamesInSubstring
     * suitably throws MyIndexOutOfBoundException when
     * endPosition > length of string
     */
    @Test(expected = MyIndexOutOfBoundsException.class)
    public void testConvertDigitsToNamesInSubstring3() {
        mycustomstring.setString("2016 is the current year.");
        mycustomstring.convertDigitsToNamesInSubstring(1, 30);
    }

    /**
     * This test checks if method convertDigitsToNamesInSubstring
     * suitably throws NullPointerException when
     * string == null,
     * startPosition > 0,
     * endPosition > 0
     */
    @Test(expected = NullPointerException.class)
    public void testConvertDigitsToNamesInSubstring4() {
        mycustomstring.setString(null);
        mycustomstring.convertDigitsToNamesInSubstring(1, 10);
    }

    /**
     * This test checks if method convertDigitsToNamesInSubstring
     * throws IllegalArgumentException
     * when startPosition > endPosition
     * startPosition < length of string
     * endPosition < length of string
     **/
    @Test(expected = IllegalArgumentException.class)
    public void testConvertDigitsToNamesInSubstring5() {
        mycustomstring.setString("2016 is the current year");
        mycustomstring.convertDigitsToNamesInSubstring(5,1);
    }

    /**
     * This test checks if method convertDigitsToNamesInSubstring
     * suitably throws IllegalArgumentException when
     * startPosition > endPosition,
     * startPosition > length of string
     */
    @Test(expected = IllegalArgumentException.class)
    public void testConvertDigitsToNamesInSubstring6() {
        mycustomstring.setString("2016 is the current year");
        mycustomstring.convertDigitsToNamesInSubstring(70, 60);
    }

    /**
     * This method checks if method convertDigitsToNamesInSubstring
     * suitably throws MyIndexOutOfBoundException when
     * startPosition > length of string,
     * startPosition <= endPosition
     */
    @Test(expected = MyIndexOutOfBoundsException.class)
    public void testConvertDigitsToNamesInSubstring7() {
        mycustomstring.setString("2016 is the current year");
        mycustomstring.convertDigitsToNamesInSubstring(50, 55);
    }

    /**
     * This test checks if method convertDigitsToNamesInSubstring
     * suitably throws MyIndexOutOfBoundException when
     * string == null,
     * startPosition < 1
     */
    @Test(expected = MyIndexOutOfBoundsException.class)
    public void testConvertDigitsToNamesInSubstring8() {
        mycustomstring.setString(null);
        mycustomstring.convertDigitsToNamesInSubstring(0,0);
    }
}
