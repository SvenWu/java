package leetcode.string;

import java.util.*;


/**
 * Created by wth on 2017/3/20.
 */
public class Solution {
    /**
     * 227. Basic Calculator II
     */
    public int calculate(String s) {
        if (s.length() == 0) return 0;
        Deque<Integer> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder(s);
        String str = "+-*/";
        char sign = '+';
        int i = 0;
        int num;
        for (; i < sb.length(); i++) {
            if (str.contains(sb.charAt(i) + "") || i == sb.length() - 1) {
                if(i == sb.length() - 1)  num = Integer.parseInt(sb.substring(0,sb.length() ));
                else  num = Integer.parseInt(sb.substring(0, i));
                switch (sign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                }
                sign = sb.charAt(i);
                sb = new StringBuilder(sb.substring(i + 1, sb.length()));
                i = -1;
            }
        }
        int res = 0;
        for (int fuck : stack) {
            res += fuck;
        }
        return res;
    }

    /**
     * 524. Longest Word in Dictionary through Deleting
     * */

//    public String findLongestWord(String s, List<String> d) {
//        Collections.sort(d);
//        char [] c = s.toCharArray();
//        String str = c.toString();
//        int len = d.size();
//        int count = 0;
//        int max = 0;
//        int index = 0;
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (String s1 : d) {
//            for (int i = 0; i < s1.length(); i++) {
//                if(sort(s).charAt(i))
//                }
//            }
//        }
//        return d.get(index);
//    }
    public String sort(String s){
        char [] c1 = s.toCharArray();
        Arrays.sort(c1);
        return c1.toString();
    }

    /**
     * 567. Permutation in String
     * */
    public boolean checkInclusion(String s1, String s2) {
        int[] count = new int[128];
        for(int i = 0; i < s1.length(); i++) count[s1.charAt(i)]--;
        for(int l = 0, r = 0; r < s2.length(); r++) {
            if (++count[s2.charAt(r)] > 0)
                while(--count[s2.charAt(l++)] != 0) { /* do nothing */}
            else if ((r - l + 1) == s1.length()) return true;
        }
        return false;
    }


    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("ale");
        list.add("apple");
        list.add("monkey");
        list.add("plea");
        Solution sol = new Solution();
        String s = "1+3*4";
        //System.out.println(sol.findLongestWord("abpcplea",list));
        String s1 = "adc";
        String s2 = "dcda";
        System.out.println(sol.checkInclusion(s1,s2));
    }
}