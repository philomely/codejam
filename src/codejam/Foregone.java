package codejam;
import java.util.*;
import java.io.*;
public class Foregone {
    private static final boolean DEBUG = true;
    private static int hash(int i) {
        switch (i) {
            case 0: return 0;
            case 1: return 1;
            case 2: return 1;
            case 3: return 1;
            case 4: return 1;
            case 5: return 2;
            case 6: return 3;
            case 7: return 2;
            case 8: return 3;
            case 9: return 3;
        }
        return 0;
    }

    private static int compute(int i) {
        int result = 0;
        int factor = 1;
        while(i>0) {
            int r = i%10;
            int a = hash(r);
            result += a*factor;
            i = i/10;
            factor *= 10;
        }
        return result;
    }
    public int searchInsert(int[] nums, int target) {
        if(target <= nums[0]) {
            return 0;
        }
        else if(target > nums[nums.length - 1]) {
            return nums.length;
        }

        int il = 0;
        int ir = nums.length - 1;
        while(ir - il > 1) {
            int im = il + (ir-il)/2;
            int a = nums[im];
            if(a == target) {
                return im;
            }
            else if(a > target) {
                ir = im;
            }
            else {
                il = im;
            }
        }

        return ir;
    }

    private static Object object = new Object();

    public static void main(String[] args) throws FileNotFoundException {
        InputStream is = DEBUG ? new FileInputStream("input.txt") : System.in;
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(is)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            String n = in.next();
            String a = "";
            String b = "";
            for(char c: n.toCharArray()) {
                int aa = Character.getNumericValue(c);
                int _a = hash(aa);
                int _b = aa - _a;
                a += String.valueOf(_a);
                b += String.valueOf(_b);
            }
            //String b = n - a;
            System.out.println("Case #" + i + ": " + a + " " + b);
        }
	// write your code here
    }
}
