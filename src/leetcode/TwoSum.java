package leetcode;

import java.util.HashMap;

public class TwoSum {
    public static int[] execute(int[] nums, int target) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        int first = -1;
        int second = -1;
        for(int i = 0; i<nums.length-1; i++) {
            first = i;
            int t = target - nums[i];
            for(int j = i + 1; j<nums.length; j++) {
                int tt = nums[j];
                if(t == tt) {
                    second = j;
                    return new int[]{first, second};
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        //System.out.println(lengthOfLongestSubstring("dvdf"));
        //System.out.println(execute(new int[]{-1,-2,-3,-4,-5}, -8));
        System.out.println(execute(new int[]{3,2,4}, 6));
    }
}
