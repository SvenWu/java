package leetcode.dynamic_programing;

import com.sun.org.apache.xerces.internal.parsers.AbstractDOMParser;

/**
 * Created by wth on 2017/4/28.
 */
public class Main {
    /**
     * 5. Longest Palindromic Substring
     * */
    public String longestPalindrome(String s) {
        int len = s.length();
        String str = "";
        int max = 0;
        boolean dp[][] = new boolean[len][len];
        for (int i = len-1; i >= 0; i--){
            dp[i][i] = true;
            for (int j = i; j < len; j++){
                if(s.charAt(i) == s.charAt(j)){
                    if(j-1<i+1) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                } else {
                    dp[i][j] = false;
                }
                if(dp[i][j] && j+1-i > max){
                    max = j+1-i;
                    str = s.substring(i,j+1);
                }
            }
        }
        return str;
    }

    /**
     * 91. Decode Ways
     * */

    public int numDecodings(String s) {
        int len = s.length();
        int []dp = new int[len];
        if(len == 0 || s.charAt(0) == '0') {
            return 0;
        }
        dp[0] = 1;
        for (int i = 1; i < len; i++) {
            if(s.charAt(i) != '0'){
                if(10*(s.charAt(i-1)-'0')+s.charAt(i)-'0'<=26 && s.charAt(i-1)!=0) {
                    dp[i] = dp[i-1]+1;
                } else {
                    dp[i] = dp[i-1];
                }
            }else {
                if(s.charAt(i-1) == '1' || s.charAt(i-1) == '2') {
                    dp[i] = dp[i-1];
                } else {
                    return 0;
                }
            }
        }
        return dp[len-1];
    }

    /**
     * 115. Distinct Subsequences
     * */

    public int numDistinct(String s, String t) {
        int[] dp = new int[t.length()+1];
        dp[0] = 1;
        for(int i = 1; i < s.length()+1; i++){
            for(int j = t.length(); j >= 1; j--){
                if(s.charAt(i-1) == t.charAt(j-1)) {
                    dp[j] = dp[j-1] + dp[j];
                }
            }
        }
        return dp[t.length()];
    }


    /**
     * 97. Interleaving String
     * */

    public boolean isInterleave(String s1, String s2, String s3){
        int l = s1.length(), m = s2.length(), n = s3.length();
        if(l+m != n) {
            return false;
        }
        boolean [][] dp = new boolean[l+1][m+1];
        dp[0][0] = true;
        for (int j = 1; j <= m; j++){
            if(s2.charAt(j-1) == s3.charAt(j-1)) {
                dp[0][j] = dp[0][j-1];
            }
        }
        for (int i = 1; i <= l; i++) {
            if(s1.charAt(i-1) == s3.charAt(i-1)) {
                dp[i][0] = dp[i-1][0];
            }
        }
        for (int i = 1; i <= l; i++) {
            for (int j = 1; j <= m; j++) {
                /**
                 * ���仰���Ժϳ�һ�仰
                 *     dp[i][j] = (dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1))
                 || (dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1));
                 * */

                if(s1.charAt(i-1) == s3.charAt(i+j-1) && s2.charAt(j-1) != s3.charAt(i+j-1)) {
                    dp[i][j] = dp[i-1][j];
                } else if(s2.charAt(j-1) == s3.charAt(i+j-1) && s1.charAt(i-1) != s3.charAt(i+j-1)) {
                    dp[i][j] = dp[i][j-1];
                } else if(s1.charAt(i-1) == s3.charAt(i+j-1) && s2.charAt(j-1) == s3.charAt(i+j-1)) {
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }
            }
        }
        return dp[l][m];
    }


    /**
     * 1,3,5,7兑换n
     * */

    public int exchange(int[] nums, int n) {
        int m = nums.length;
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i < m+1; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if(j>=nums[i-1]){
                    dp[i][j] = dp[i-1][j] + dp[i][j-nums[i-1]];
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,7};
        System.out.println(new Main().exchange(nums,6));
        
//        String s = "bb";
//        String t = "b";
//        String s1 = "aabcc";
//        String s2 = "dbbca";
//        String s3 = "aadbbcbcac";
//        System.out.println(new Main().isInterleave(s1,s2,s3));
        //System.out.println(new Main().numDistinct(s,t));
        //System.out.println(new Main().longestPalindrome(s));
    }
}
