package NiuKe.sward_to_offer.tree;

import java.util.*;

/**
 * Created by wth on 2017/5/27.
 */
public class Permutation {
    boolean[] flag;
    Set<String> set = new HashSet<>();
    char[] res;
    public ArrayList<String> Permutation(String str) {
        char [] arr = str.toCharArray();
        int len = arr.length;
        res = new char[len];
        flag = new boolean[len];
        backTrack(arr,0);
        ArrayList<String> list = new ArrayList<>(set);
        Collections.sort(list);
        return list;
    }
    public void backTrack(char[] arr, int pos) {
        if(pos == arr.length) {
            //set.add(res.toString());
            String s = "";
            for (char c : res) {
                s += c;
            }
            set.add(s);
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if(!flag[i]) {
                res[pos] = arr[i];
                flag[i] =true;
                backTrack(arr,pos+1);
                flag[i] = false;
            }
        }
    }
}
