package leetcode.backTrack;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sven (bjwthwu@cn.ibm.com)
 * @date 2021/1/13
 */
public class CountNumberswithUniqueDigits_357 {

    List<List<Integer>> res = new ArrayList<>();
    public int countNumbersWithUniqueDigits(int n) {

        for(int i = 1; i <= n; i++) {
            backTracking(new ArrayList<Integer>(),i,1,1);
        }

        System.out.println(Arrays.deepToString(res.toArray()));

        System.out.println(res.size());

        return res.stream().mapToInt(List::size).sum();
    }

    public void backTracking(List<Integer> list, int n, int start, int deep) {
        if(list.size() > n) return;

        if(list.size() == n) {
            res.add(new ArrayList(list));
            return;
        }

        for(int i = 0; i < 10; i++) {
            if(list.contains(i) || (deep == 1 && i ==0)) {
                continue;
            }

            list.add(i);

            backTracking(list,n,i+1,deep+1);

            list.remove(list.size()-1);
        }
    }


    public static void main(String[] args) {
        new CountNumberswithUniqueDigits_357().countNumbersWithUniqueDigits(3);

    }
}
