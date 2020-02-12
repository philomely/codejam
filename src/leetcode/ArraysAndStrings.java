package leetcode;

import java.util.*;

public class ArraysAndStrings {
    static private List<Character> prevList = new LinkedList<>();
    static public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int curLen = 0;
        for(int i = 0; i<s.length(); i++) {
            char curChar = s.charAt(i);
            if(prevList.contains(curChar)) {
                if(curLen > result) {
                    result = curLen;
                }
                int prevLen = prevList.lastIndexOf(curChar);
                for(int j = 0; j<=prevLen; j++) {
                    prevList.remove(0);
                }
                prevList.add(curChar);
                curLen = prevList.size();
            }
            else {
                prevList.add(curChar);
                curLen += 1;
            }
        }
        if(curLen > result) {
            result = curLen;
        }

        return result;
    }

    public static void main(String[] args) {
        //System.out.println(lengthOfLongestSubstring("dvdf"));
        System.out.println(lengthOfLongestSubstring("aabaab!bb"));
        //System.out.println(lengthOfLongestSubstring("bbbbb"));
    }
}
