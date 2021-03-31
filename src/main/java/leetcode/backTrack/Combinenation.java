package leetcode.backTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sven (bjwthwu@cn.ibm.com)
 * @date 2021/1/12
 */
public class Combinenation {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {

        backTracking(new ArrayList<Integer>(), k ,n ,1);

        System.out.println(Arrays.deepToString(res.toArray()));

        System.out.println(res.stream().mapToInt(List::size).sum());

        return res;
    }

    public void backTracking(List<Integer> list, int k , int n, int start) {
        if (list.size() > k) {
            return;
        }

        if (n == 0 && list.size() == k) {
            List<Integer> li = new ArrayList<Integer>(list);
            res.add(li);
            return;
        }

        for(int i = 1; i <= 9; i++) {

//            //if add this statement, the result set will contain all the combination.
//            if (list.contains(i)) {
//                continue;
//            }

            list.add(i);


            backTracking(list,k,n-i,i+1);

            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        new Combinenation().combinationSum3(3,7);
        new Combinenation().combinationSum4(3,7);
    }

    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum4(int k, int n) {

        combination(new ArrayList<Integer>(), k, 1, n);

        System.out.println(Arrays.deepToString(ans.toArray()));
        return ans;
    }

    private void combination( List<Integer> comb, int k,  int start, int n) {
        if (comb.size() == k && n == 0) {
            List<Integer> li = new ArrayList<Integer>(comb);
            ans.add(li);
            return;
        }
        for (int i = start; i <= 9; i++) {
            comb.add(i);
            combination( comb, k, i+1, n-i);
            comb.remove(comb.size() - 1);
        }
    }
}
