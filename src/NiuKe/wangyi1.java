package NiuKe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by wth on 2017/4/1.
 */
public class wangyi1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] num = new int[n];
        int sum = 0;
        for(int i=0; i<n ; i++)
        {
            num[i] = sc.nextInt();
            sum += num[i];
        }
        sum >>= 1;
        List<Integer> ans = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        new wangyi1().backtrack(0, sum, num, ans, list, 0);
        int time = 0;
        int min = Integer.MAX_VALUE;
        for(List<Integer> l : list){
            for(int i : l){
                time += i;
            }
            min = Math.min(time,min);
            time = 0;
        }
        System.out.println(min);
    }
    void backtrack(int res ,int sum, int[]num,List<Integer> ans,List<List<Integer>> list, int pos){
        if(res >= sum) {
            list.add(new ArrayList<Integer>(ans));
            return;
        }
        for(int i = pos; i<num.length; i++)
        {
            ans.add(num[i]);
            res += num[i];
            backtrack(res, sum, num, ans, list, i + 1);
            res -= ans.remove(ans.size()-1);
        }
    }
}
