package leetcode;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class BullsCows {

    public static String execute(String secret, String guess) {
        List<Character> intPool = new LinkedList<>();
        for(int i = 0; i<secret.length(); i++) {
            intPool.add(secret.charAt(i));
        }
        int bulls = 0;
        int cows = 0;
        for(int i = 0; i<guess.length(); i++) {
            char c = guess.charAt(i);
            if(c == secret.charAt(i)) {
                bulls+=1;
                intPool.remove(new Character(c));
            }

        }
        for(int i = 0; i<guess.length(); i++) {
            char c = guess.charAt(i);
            if(c != secret.charAt(i) && intPool.contains(c)&&secret.indexOf(c)!=-1){
                cows+=1;
                intPool.remove(new Character(c));
            }
        }
        return bulls + "A" + cows + "B";
    }

    public static void main(String[] args) {
        //System.out.println(lengthOfLongestSubstring("dvdf"));
        //System.out.println(execute(new int[]{-1,-2,-3,-4,-5}, -8));
        System.out.println(execute("", ""));
    }
}
