package com.truecaller.assignment;

import java.util.HashMap;

public class Utility {

    /*
     * 10th character
     * @param body of html in string builder
     * @return list of character in string
     * */
    public char truecaller10thCharacterRequest(StringBuilder stringBuilder) {
        char charOnPos = stringBuilder.charAt(10 - 1);

        return charOnPos;
    }


    /*
    * list of every 10th character in string
    * @param body of html in string builder
    * @return list of character in string
    * */
    public String truecallerEvery10thCharacterRequest(StringBuilder stringBuilder) {
        int stringLen;
        int loopCount;
        int jumpLoopCount = 0;  // every 10th position
        stringLen = stringBuilder.length();
        loopCount = stringLen / 10;
        int i = 0;
        char[] charArray = new char[loopCount];
        while (i < loopCount) {
            jumpLoopCount = jumpLoopCount + 10;
            charArray[i] = stringBuilder.charAt(jumpLoopCount - 1);
            i++;
        }
        String str2 = String.valueOf(charArray);

        return str2;
    }

    /*
     * calculate the word count
     * @param body of html in string builder
     * @return list of character in string
     * */

    public HashMap<String, Integer> calculateWordCount(StringBuilder stringBuilder) {

        String[] splitStr = stringBuilder.toString().trim().split("\\s+");
        HashMap<String, Integer> wordListWithCount = new HashMap<String, Integer>();

        for (String s : splitStr) {

            if (wordListWithCount.containsKey(s))
                wordListWithCount.put(s, wordListWithCount.get(s) + 1);
            else
                wordListWithCount.put(s, 1);
        }

        return wordListWithCount;

    }
}
