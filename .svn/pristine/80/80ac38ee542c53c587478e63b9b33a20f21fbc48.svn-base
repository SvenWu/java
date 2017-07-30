package leetcode.backTrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by wth on 2017/3/23.
 */
public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        backTrace(res,list,0,s);
        return res;
    }
    public boolean isPalin(String s,int l,int r){
        while(l<r)
        {
            if(s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }
    public void backTrace(List<List<String>> res, List<String> list, int pos,String s){
        if(pos == s.length())   res.add(new ArrayList<String>(list));  /**很重要必须new一个实力  否则list会随着改变   引用传递*/
        else{
            for(int i=pos; i<s.length(); i++)
            {
                if(isPalin(s,pos,i))
                {
                    list.add(s.substring(pos,i+1));
                    backTrace(res,list,i+1,s);
                    list.remove(list.size()-1);
                }
            }
        }
    }

    /**
     * 89. Gray Code
     * */
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        if(n ==0) return res;
        int len = (int)Math.pow(2,n);
        backTrack(res,n,0,len);
        return res;
    }
    public boolean isGrayCode(int num1, int num2 , int n){
        int count = 0;
        for(int i=0; i<n; i++)
        {
            if((num1 ^ (num2 >>i)) == 0) count++;
        }
        return count == 1?true:false;
    }
    public void backTrack(List<Integer> res, int n, int start,int len){
        if(res.size() == len) return;
        for(int i = 0; i<len; i++)
        {
            if(isGrayCode(start,i,n)) {
                if(!res.contains(i)) res.add(i);
                else continue;
            }
            backTrack(res,n,i+1,len);
            res.remove(res.size()-1);
        }
    }

//    public int adapt(String s){
//        int count = 0;
//        int sum = 0;
//        int len = s.length();
//        for(int i=0; i<len; i++)
//        {
//            if(s.charAt(i) =='G') count++;
//        }
//        for(int i=0;i<len;i++)
//        {
//            if(s.charAt(i) == 'G'){
//                sum += i-
//            }
//        }
//    }

//    public int[] ring(int n, int count , int[] num){
//        int a = num[0];
//        for(int j =0;j<count;j++)
//        {
//            for(int i =0; i<n; i++)
//            {
//                if(i+1 == n){
//                    num[i] = num[i] + a;
//                }
//                num[i] = num[i]+num[i+1];
//                if(num[i] >=100) num[i] %= num[i];
//            }
//        }
//    }


    /**
     * 47. Permutations II
     * */
    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] visited= new boolean[nums.length];
        List<Integer> list = new ArrayList<>();
        HashSet<List<Integer>> res = new HashSet<>();
        backTrack(res,list,nums,visited);
        List<List<Integer>> result = new ArrayList<>(res);
        return result;
    }
    public void backTrack(HashSet<List<Integer>> res, List<Integer> list,int[] nums, boolean[] visited){
        if(list.size() == nums.length){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i =0; i<nums.length; i++)
        {
            if(visited[i]) continue;
            list.add(nums[i]);
            visited[i] = true;
            backTrack(res,list,nums,visited);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }

    /**
     * 140. Word Break II
     * */
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        backTrack(res,wordDict,new String(),s,0,0);
        return res;
    }
    public void backTrack(List<String> res,List<String> wordDict, String str,String s, int pos, int sum){
        if(sum == s.length()){
            res.add(new String(str));
            return;
        }
        for(int i = pos;i<wordDict.size();i++)
        {
            if(sum+wordDict.get(i).length() > s.length())  continue;
            if(s.substring(sum,sum+(wordDict.get(i).length())).equals(wordDict.get(i))){
                str += wordDict.get(i)+" ";
                sum += wordDict.get(i).length();
            }

            backTrack(res,wordDict,str,s,i+1,sum);
            if(str.length()-wordDict.get(i).length()-1<=0) str = "";
            str = str.substring(0,str.length()-wordDict.get(i).length()-1);
            sum -= wordDict.get(i).length();
        }
    }

    /**
     * 17. Letter Combinations of a Phone Number
     * */

    public List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for(int i =0; i<digits.length();i++){
            int x = Character.getNumericValue(digits.charAt(i));
            while(ans.peek().length()==i){
                String t = ans.remove();
                for(char s : mapping[x].toCharArray())
                    ans.add(t+s);
            }
        }
        return ans;
    }
    public static void main(String[] args){
        Solution sol = new Solution();
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cat");
        wordDict.add("cats");
        wordDict.add("and");
        wordDict.add("sand");
        wordDict.add("dog");
        sol.letterCombinations("345");
        //System.out.println(Math.pow(0,0));
    }
}
