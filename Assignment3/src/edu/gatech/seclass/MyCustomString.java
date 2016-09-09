package edu.gatech.seclass;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Atharva on 9/5/2016.
 */
public class MyCustomString implements MyCustomStringInterface {
    private String myString;

    public MyCustomString() {
        myString = null;
    }

    @Override
    public String getString() {
        return myString;
    }

    @Override
    public void setString(String string) {
        myString = string;
    }

    @Override
    public int countNumbers() {
        if (myString != null) {
            Matcher matcher = Pattern.compile("(\\d+)").matcher(myString);
            int numberCount = 0;
            while (matcher.find()) {
                numberCount++;
            }
            return numberCount;
        } else {
            throw new NullPointerException();
        }
    }

    @Override
    public String getEveryNthCharacterFromBeginningOrEnd(int n, boolean startFromEnd) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        if (myString == null) {
            throw new NullPointerException();
        } else {
            if (myString.length() < n) {
                return "";
            } else {
                StringBuilder nThCharSequence = new StringBuilder();
                String charactersToBeReturned = null;
                if (!startFromEnd) {
                    for (int i = 0; i < myString.length(); i++) {
                        if ((i + 1) % n == 0) {
                            nThCharSequence.append(myString.charAt(i));
                        }
                    }
                    charactersToBeReturned = nThCharSequence.toString();
                } else {
                    for (int i = myString.length() - 1; i >= 0; i--) {
                        if ((myString.length() - i) % n == 0) {
                            nThCharSequence.append(myString.charAt(i));
                        }
                    }
                    charactersToBeReturned = nThCharSequence.reverse().toString();
                }
                return charactersToBeReturned;
            }
        }
    }

    @Override
    public void convertDigitsToNamesInSubstring(int startPosition, int endPosition) {
        if (startPosition > endPosition) {
            throw new IllegalArgumentException();
        } else if (startPosition > 0 && endPosition > 0) {
            if (myString == null) {
                throw new NullPointerException();
            } else {
                if (endPosition > myString.length() || startPosition > myString.length() || startPosition < 1 || endPosition < 1) {
                    throw new MyIndexOutOfBoundsException();
                } else {
                    StringBuilder stringBuilder = new StringBuilder(myString);
                    String subStringToBeReplaced = myString.substring(startPosition - 1, endPosition);

                    subStringToBeReplaced = subStringToBeReplaced
                            .replaceAll("0", "Zero")
                            .replaceAll("1", "One")
                            .replaceAll("2", "Two")
                            .replaceAll("3", "Three")
                            .replaceAll("4", "Four")
                            .replaceAll("5", "Five")
                            .replaceAll("6", "Six")
                            .replaceAll("7", "Seven")
                            .replaceAll("8", "Eight")
                            .replaceAll("9", "Nine");
                    myString = stringBuilder.replace(startPosition -1, endPosition, subStringToBeReplaced).toString();
                }
            }
        } else {
            throw new MyIndexOutOfBoundsException();
        }
    }
}
