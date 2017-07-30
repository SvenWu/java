package leetcode.hashtable;

import java.util.*;

/**
 * Created by wth on 2016/11/14.
 */
public class Solution {
    /**
     * 3. Longest Substring Without Repeating Characters
     * */
    public  int lengthOfLongestSubstring(String s) {
        char []c = s.toCharArray();
        HashMap<Character,Integer> map = new HashMap<>();
        int n = s.length();
        int count =0;
        int max = 0;
        for (int i =0;i<n;i++)
        {
            if(map.containsKey(c[i]))
            {
                count =Math.max(map.get(c[i])+1,count);    // ����Ҫ  һ��Ҫ�� �±��pointer������  ���ܻص�֮ǰ���±�
            }
            map.put(c[i],i);
            max = Math.max(max,i-count+1);
        }
        return max;
    }


    /**
     * 30. Substring with Concatenation of All Words
     * */

    public static List<Integer> findSubstring(String s, String[] words) {
        HashMap<String,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int m=s.length();
        int n=words.length;
        int l=words[0].length();
        for(String str:words)
        {
            if(map.containsKey(str)) map.put(str,map.get(str)+1);
            else map.put(str,1);
        }
        //��ʼ����
        for(int i=0;i<=m-n*l;i++)    //ע����С�ڵ���
        {
            HashMap<String,Integer> copy = new HashMap<>(map);
            for(int j =0;j<n;j++)
            {
                String str = s.substring(i+j*l,i+j*l+l);
                if(!copy.containsKey(str)||copy.get(str)==0) break;
                else {
                    copy.put(str,copy.get(str)-1);
                }
                if(j==n-1) list.add(i);
            }
        }
        return list;
    }


    /**49. Group Anagrams
     *
     * */

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for(String s: strs)
        {
            char [] c = s.toCharArray();
            Arrays.sort(c);
            String s1 = Arrays.toString(c);
            //String s1 = c.toString();
            System.out.println(s1);
            if(!map.containsKey(s1)) map.put(s1,new ArrayList<String>());
            map.get(s1).add(s);
        }
        List<List<String>> l = new ArrayList<>();
        for(String s: map.keySet())
        {
            l.add(map.get(s));
        }
        return l;
    }


    /**
     *76. Minimum Window Substring
     * */

    public static String minWindow(String s, String t) {
//        HashMap<Character,Integer> map = new HashMap<>();
//        for(char c : s.toCharArray())
//            map.put(c,0);
//        for(char c : t.toCharArray())
//        {
//            if(map.containsKey(c))
//                map.put(c,map.get(c)+1);
//            else
//                return "";
//        }
//
//        int start =0, end=0, minStart=0,minLen = Integer.MAX_VALUE, counter = t.length();
//        while(end < s.length())
//        {
//            char c1 = s.charAt(end);
//            if(map.get(c1) > 0)
//                counter--;
//            map.put(c1,map.get(c1)-1);
//
//            end++;
//
//            while(counter == 0)
//            {
//                if(minLen > end-start)
//                {
//                    minLen = end-start;
//                    minStart = start;
//                }
//
//                char c2 = s.charAt(start);
//                map.put(c2, map.get(c2)+1);
//
//                if(map.get(c2) > 0)
//                    counter++;
//
//                start++;
//            }
//        }
//        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart,minStart+minLen);
        HashMap<Character,Integer> map = new HashMap<>();
        for(Character c : s.toCharArray())
        {
            map.put(c,0);
        }
        for(Character c : t.toCharArray())
        {
            if(map.containsKey(c)) map.put(c,map.get(c)+1);
            else return "";
        }
        int start = 0,end = 0,count = 0,min = Integer.MAX_VALUE,minstart=0;
        while(end < s.length())
        {
            char c = s.charAt(end);                    //end 指针
            if(map.get(c)>0)  count++;
            map.put(c,map.get(c)-1);
            end++;

            while(count==t.length())               //start 指针
            {
                if(min>end-start)
                {
                    min = end -start;
                    minstart=start;
                }
                char c1 = s.charAt(start);
                map.put(c1,map.get(c1)+1);
                if(map.get(c1)>0)
                {
                    count--;
                }
                start++;
            }
        }
        return min==Integer.MAX_VALUE?"":s.substring(minstart, start+min);
    }

    /**
     * 85. Maximal Rectangle
     * */

    public static int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 1,col=1,colmin=Integer.MAX_VALUE,maxrec=0,rec=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                    if(matrix[i][j]=='1')
                    {
                        int rowindex=i;                    //一定要记得再次初始化
                        int colindex=j;
                        colmin = Integer.MAX_VALUE;
                        while(rowindex<m)
                        {
                            outer:
                            while(colindex<n)
                            {
                                if(matrix[rowindex][colindex]=='1') {
                                    col = colindex-j+1;
                                    colindex++;
                                }
                                else break outer;
                            }
                            colmin = Math.min(colmin,col);
                            row = rowindex-i+1;
                            rec = colmin * row;
                            maxrec=Math.max(rec,maxrec);
                            rowindex++;
                            if(rowindex==m)  continue;
                            if(matrix[rowindex][j]=='1') {
                                colindex=j;

                            }
                            else break;
                        }
                    }
            }
        }
        return maxrec;
    }


    /**
     * 136. Single Number
     * 超级简单的方法   利用XOR
     * */
    public static int singleNumber(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            if(map.containsKey(nums[i]))
            {
                map.put(nums[i],map.get(nums[i])+1);
            }else{
                map.put(nums[i],1);
            }
        }
        int sn=0;
        // for(Integer i :map.keySet())
        // {
        //     if(map.get(i)==1)  {sn=i;}
        // }
        // return sn;
        for(Map.Entry<Integer,Integer> entry : map.entrySet())
        {
            // if(map.entrySet().isEmpty())  return 0;
            if(entry.getValue()==1)  sn= entry.getKey();
        }
        return sn;

        /**
         * 超级简单的方法   利用XOR
         * */
//        int result = 0;
//        for(int i=0;i<nums.length;i++)
//        {
//            result ^= nums[i];
//        }
//        return result;
    }




    /**
     * 202. Happy Number
     * */
    public boolean isHappy(int n) {
        HashMap<Integer,Integer> map = new HashMap<>();
        while(!map.containsKey(n))
        {
            map.put(n,0);
            n = Solution.happy(n);
            if (n==1) return true;
        }
        return false;
    }
    public static int happy(int n){
        int dig = 0;
        int result = 0;
        while(n>0)
        {
            dig = n%10;
            result += Math.pow(dig,2);
            n = n/10;
        }
        return result;
    }



    /**
     * 204. Count Primes
     * */

    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
            isPrime[i] = true;
        }
        // Loop's ending condition is i * i < n instead of i < sqrt(n)
        // to avoid repeatedly calling an expensive function sqrt().
        for (int i = 2; i * i < n; i++) {
            if (!isPrime[i]) continue;
            for (int j = i * i; j < n; j += i) {
                isPrime[j] = false;
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) count++;
        }
        return count;
    }


    /**
     * 242. Valid Anagra
     */

    public boolean isAnagram(String s, String t) {
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
       if(Arrays.toString(c1).equals(Arrays.toString(c2)))return true;
        return false;
    }


    /**
     *274. H-Index
     * */
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int res= 0;
        for(int i = citations.length-1;i>=0;i--)
        {
            if(citations[i]<n) n--;
            else res = n;
        }
        return res;
    }

    /**
     * 299. Bulls and Cows
     **/
    

    public static void main(String[] args){
        Solution sol = new Solution();
        int num = 7;
        String s = "wordgoodgoodgoodbestword";
        String[] words = {"word","good","best","good"};
        String s1 = "ADOBECODEBANC";
        String t = "ABC";
        int [] nums = {2,2,3};
        char [][] c = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        //System.out.println(Solution.findSubstring(s, words));
       // System.out.println(Solution.groupAnagrams(words));
        //System.out.println(Solution.minWindow(s1,t));
        //System.out.println(Solution.maximalRectangle(c));
        //System.out.println(Solution.singleNumber(nums));
        //System.out.print(sol.isHappy(num));
        //System.out.println(sol.countPrimes(50));
        //System.out.println(sol.isAnagram("g", "g"));
        System.out.print((int)Math.pow(0,0));    //结果是1
    }

}
