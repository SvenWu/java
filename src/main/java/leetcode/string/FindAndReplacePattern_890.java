package leetcode.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FindAndReplacePattern_890 {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        int[] p = format(pattern);
        for (String word : words) {
            if (Arrays.equals(p,format(word))) {
                res.add(word);
            }
        }

        return res;
    }

    public int[] format(String str) {
        int n = str.length();
        int[] res = new int[n];
        HashMap<Character,Integer> map = new HashMap<>(16);
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(str.charAt(i),map.size());
            res[i] = map.get(str.charAt(i));
        }

        return res;
    }
}
