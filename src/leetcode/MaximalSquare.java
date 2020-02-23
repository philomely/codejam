package leetcode;

import java.util.HashMap;

public class MaximalSquare {
    private static boolean expand(char[][] m, int x, int y, int len) {
        if(x + len>=m.length || y + len >=m[0].length)
            return false;
        for(int i=0; i<len; ++i) {
            if(m[x + len][y+i] == '0') {
                return false;
            }
            if(m[x+i][y+ len] == '0') {
                return false;
            }
            if(m[x+len][y+ len] == '0') {
                return false;
            }
        }
        return true;
    }
    public static int execute(char[][] matrix) {
        int maxLen = 0;
        int w = matrix.length;
        if(w==0) return 0;
        int h = matrix[0].length;
        for(int i=0; i<w; ++i) {
            for (int j = 0; j < h; ++j) {
                if(matrix[i][j] == '1') {
                    int len = 1;
                    while(expand(matrix, i, j, len)) {
                        len++;
                    };
                    if(len>maxLen) maxLen = len;
                }
            }
        }
        return maxLen*maxLen;
    }

    public static void main(String[] args) {
        //System.out.println(lengthOfLongestSubstring('dvdf'));
        //System.out.println(execute(new int[]{-1,-2,-3,-4,-5}, -8));
        char[][] table = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '0'},
                {'1', '0', '1', '1', '0'},
                {'1', '0', '0', '0', '0'},
                {'1', '0', '0', '1', '0'}};
        char[][] table2 = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        char[][] table3 = {{'1', '1'}, {'1', '1'}};
        char[][] table4 = {
                {'1', '1', '1', '1'},
                {'1', '1', '1', '1'},
                {'1', '1', '1', '1'},
                {'1', '1', '1', '1'}
        };


        char[][] table5 =
        {
            {'0', '0', '0', '1', '0', '1', '1', '1'},
            {'0', '1', '1', '0', '0', '1', '0', '1'},
            {'1', '0', '1', '1', '1', '1', '0', '1'},
            {'0', '0', '0', '1', '0', '0', '0', '0'},
            {'0', '0', '1', '0', '0', '0', '1', '0'},
            {'1', '1', '1', '0', '0', '1', '1', '1'},
            {'1', '0', '0', '1', '1', '0', '0', '1'},
            {'0', '1', '0', '0', '1', '1', '0', '0'},
            {'1', '0', '0', '1', '0', '0', '0', '0'}
        };
        System.out.println(execute(table5));
    }
}
