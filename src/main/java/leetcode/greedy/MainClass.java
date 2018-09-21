package leetcode.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean lemonadeChange(int[] bills) {
        Map<Integer,Integer> map = new HashMap<>();

        for (int bill : bills) {
            if (bill == 5) {
                map.put(bill,map.getOrDefault(5,0) + 1);
            }else if (bill == 10) {
                map.put(5,map.getOrDefault(5,0) - 1);
                if (map.get(5) < 0) return false;
                map.put(bill,map.getOrDefault(10,0) + 1);
            }else if (bill == 20) {
                map.put(5,map.getOrDefault(5,0) - 1);
                if (map.getOrDefault(5,0) < 0) return false;
                if (map.getOrDefault(10,0) - 1 >= 0) {
                    map.put(10,map.getOrDefault(10,0) - 1);
                    continue;
                }else {
                    if (map.getOrDefault(5,0) - 2 < 0) {
                        return false;
                    }else {
                        map.put(5,map.getOrDefault(5,0) - 2);
                    }
                }
            }
        }

        return true;
    }
}

public class MainClass {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] bills = stringToIntegerArray(line);

            boolean ret = new Solution().lemonadeChange(bills);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }
}
