import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by wth on 2016/9/12.
 */
public class ZigZag {
    public static void main(String[] args){
//        System.out.println(convert(new String("abcdefghijk"),4));
//        Solution s=new Solution();
////        System.out.println(s.reverse(123));
//        String a="abc";
//        String b="abf";
//        int c='c'-'f';
//        System.out.println(a.compareTo(b)+""+c+""+a.concat(b));
//        System.out.println(sol.reverse("I love you"));
//        System.out.println(Solution1.isPalindrome(2147483646));
//        System.out.println(IntToRoman.intToRoman(2573));
////        int s[]=[-1, 0, 1, 2, -1, 4];
//        System.out.println(s.threeSum(new int[]{-1, 0, 1, 2, -1, 4}));
//        System.out.println(Solution.mySqrt(300));
//        System.out.println(Solution.fourSum(new int[]{-1, 0, 1, 2, -1, -4}, -1));
//        System.out.println(Solution.addBinary("1", "1"));
//        System.out.println(Solution.countAndSay(1));
          System.out.println(Solution.isNumber("1"));
          System.out.println(Solution.removeDuplicates(new int[]{1,1,2}));
          int b[][]=new int[2][2];
          b[0][0]=1;
          b[0][1]=1;
          HashSet hs=new HashSet();
          hs.add(b[0][0]);
          if(hs.add(b[0][1])) {
              System.out.println(hs);
          }

  }
    public static String convert(String s, int numRows) {
//        char[] c = s.toCharArray();
//        int len = c.length;
//        StringBuffer[] sb = new StringBuffer[nRows];
//        for (int i = 0; i < sb.length; i++) sb[i] = new StringBuffer();
//
//        int i = 0;
//        while (i < len) {
//            for (int idx = 0; idx < nRows && i < len; idx++) // vertically down
//                sb[idx].append(c[i++]);
//
//
//            for (int idx = 1; idx <= nRows-2 && i < len; idx++) // obliquely up
//                sb[idx].append(c[i++]);
//        }
//        for (int idx = 1; idx < sb.length; idx++)
//            sb[0].append(sb[idx]);
//        return sb[0].toString();
        char[] c=s.toCharArray();
        int len=c.length;
        StringBuffer[] sb=new StringBuffer[numRows];
        for(int i=0;i<numRows;i++)
        {
            sb[i]=new StringBuffer();
        }
        int i=0;
        while(i<len)
        {
            for(int index=0;index<numRows;index++)
            {
                sb[index].append(c[i++]);
            }
            for(int index=1;index<numRows-1&&i<len;index++)
            {
                sb[index].append(c[i++]);
            }
        }
        for(int index=1;index<numRows;index++)
        {
            sb[0].append(sb[index]);
        }
        return sb[0].toString();
    }
}
 class Solution {
     public int reverse(int x) {
         char c[];
         String s;
         if (x >= 0) {
             s = Integer.toString(x);
             StringBuffer sb = new StringBuffer(s);
             sb.reverse();
             s = sb.toString();
             x = Integer.parseInt(s);
             return x;
         } else {
             s = Integer.toString(x * -1);
             StringBuffer sb1 = new StringBuffer(s);
             sb1.reverse();
             s = sb1.toString();
             x = Integer.parseInt(s);
             return x * -1;
         }
     }

     public static List<List<Integer>> fourSum(int[] nums, int target) {
         List<List<Integer>> l = new ArrayList<>();
         int len = nums.length;
         if (len < 4) return l;
         Arrays.sort(nums);
         int a = 0, b, c, d, sum;
         for (; a < len - 3; a++) {
             if (a > 0 && nums[a] == nums[a - 1]) continue;
             b = a + 1;
             for (; b < len - 2; b++) {
                 if (b > a + 1 && nums[b] == nums[b - 1]) continue;
                 c = b + 1;
                 d = len - 1;
                 while (c < d) {
                     sum = nums[a] + nums[b] + nums[c] + nums[d];
                     if (sum == target) {
                         l.add(Arrays.asList(nums[a], nums[b], nums[c], nums[d]));
                         while (c < d && nums[c] == nums[c + 1]) c++;
                         c++;
                     } else if (sum < target) {
                         while (c < d && nums[c] == nums[c + 1]) c++;
                         c++;
                     } else {
                         while (c < d && nums[d] == nums[d - 1]) d--;
                         d--;
                     }
                 }
             }
         }
         return l;
     }


     public static String addBinary(String a, String b) {
         int m = 0, n = 0;
         if (a.equals("") || b.equals("")) return a + b;
         if (a.equals("0")) return b;
         if (b.equals("0")) return a;
         int len1 = a.length();
         int len2 = b.length();
         for (int i = 0; i < len1; i++) {
             if (a.charAt(len1 - 1 - i) == '1')
                 m += (int) Math.pow(2, i);
         }
         for (int i = 0; i < len2; i++) {
             if (b.charAt(len2 - 1 - i) == '1')
                 n += (int) Math.pow(2, i);
         }
         int k = m + n, j;
         String s = "";
         while (k / 2 >= 1)                         //k至少是大于1的  前面排除掉了
         {
             j = k % 2;
             s = Integer.toString(j) + s;
             k = k / 2;
             if (k == 1) {
                 s = "1" + s;
             }
         }
         return s;
     }


     public List<List<Integer>> threeSum(int[] nums) {
         List<List<Integer>> l = new ArrayList<>();
         Arrays.sort(nums);
         if (nums.length < 3) {
             return null;
         }
         for (int i = 0; i < nums.length - 2; i++) {
             if (i > 0 && nums[i] == nums[i - 1]) continue;  // ==if(i==0||i>0&&nums[i]!=nums[i-1])
             int j = i + 1, k = nums.length - 1;
             int sum = 0 - nums[i];
             while (j < k) {
                 if (nums[j] + nums[k] == sum) {
                     l.add(Arrays.asList(nums[i], nums[j], nums[k]));
                     while (j < k && nums[j] == nums[j + 1]) j++;
                     j++;

                 } else if (nums[j] + nums[k] < sum) {
                     while (j < k && nums[j] == nums[j + 1]) j++;
                     j++;
                 } else {
                     while (j < k && nums[k] == nums[k - 1]) k--;
                     k--;
                 }
             }

         }
         return l;
     }


     public static int mySqrt(int x) {
         if (x <= 0) return 0;
         int digit = (int) Math.log10(x) + 1;
         int d = (int) Math.pow(10, (digit + 1) / 2 - 1);
         while (Math.pow(d, 2) < x) {
             d++;
             if (Math.pow(d, 2) > x) {
                 d--;
                 break;
             }
         }
         return d;
     }

     public static boolean isValid(String s) {
         ArrayDeque<Character> stack = new ArrayDeque<>();
         for (int i = 0; i < s.length(); i++) {
             switch (s.charAt(i)) {
                 case '(':
                     stack.push('(');
                     break;
                 case '{':
                     stack.push('{');
                     break;
                 case '[':
                     stack.push('[');
                     break;
                 case ')':
                     if (stack.size() == 0 || stack.pop() != '(') return false;
                     break;
                 case '}':
                     if (stack.size() == 0 || stack.pop() != '{') return false;
                     break;
                 case ']':
                     if (stack.size() == 0 || stack.pop() != '[') return false;
                     break;
             }
         }
         return stack.isEmpty();
     }

     public static String countAndSay(int n) {
//         List<Integer> l=new ArrayList<>();
         int[] a = new int[32];
         int res, dig;
         if (n == 0) return "0";
         dig = (int) Math.log10(n) + 1;
         for (int i = 0; i < dig; i++) {
             while (n > 0) {
                 res = n % 10;
//             l.add(res);
                 a[i] = res;
                 n /= 10;
             }
         }
         int i = 0;
         int count = 1;
         StringBuilder sb = new StringBuilder();
         while (i < dig) {
             while (i < dig && a[i] == a[i + 1]) {
                 count++;
                 i++;
             }
             sb.append(count * 10 + a[i]);
             i++;
         }
         return sb.reverse().toString();
     }

     public static boolean isNumber(String s) {
         //1    .不在第一位和最后一位   有且有1个
         //2     e不在第一位  最后一位   有且有1个
         //3     点只能在e前面
         //    e=101  .=46
         int len=s.length();
//        if(len==1) return (int)s.charAt(0)>=0&&(int)s.charAt(0)<=9;
//        if(len==2)
         if(s.isEmpty())return false;
         if(s.equals("0"))return true;
         if(s.equals("."))return false;
         if (len<3){
             if(s.charAt(0)=='0')return false;
             for(int i=0;i<len;i++){
                 if(s.charAt(0)=='.') continue;
                 if(!((int)s.charAt(i)>=48&&(int)s.charAt(i)<=57)) return false;
             }
             return true;
         }

         if((int)s.charAt(len-1)==46) return false;
         if((int)s.charAt(0)==101||(int)s.charAt(len-1)==101) return false;
         if(s.indexOf(",",s.indexOf("."))>-1) return false;
         if(s.indexOf("e",s.indexOf("e"))>-1) return false;
         if(s.indexOf("e")>-1) {
             if (s.indexOf(".") > s.indexOf("e")) return false;
         }
         for(int i=0;i<len;i++){
             if(((int)s.charAt(i)>=48&&(int)s.charAt(i)<=57)||(int)s.charAt(i)==46||(int)s.charAt(i)==101)
                 i++;
             return false;
         }
         return true;
     }

     public static int removeDuplicates(int[] nums) {
         Arrays.sort(nums);
         int dig=nums.length;
         if(dig<=1)  return dig ;
         for(int i=0;i<dig;i++)
         {
             while(nums[i]==nums[i+1]){
                 dig--;
                 i++;
                 if(i==nums.length-2) break;
             }
             if(i==nums.length-2) break;
         }
         return dig;
     }


     public boolean isValidSudoku(char[][] board) {
         for(int i=0;i<9;i++){
             HashSet row=new HashSet();
             HashSet col=new HashSet();
             HashSet cube=new HashSet();
             for(int j=0;j<9;j++)
             {
                 if(board[i][j]!='.'&&!row.add(board[i][j])) return false;
                 if(board[j][i]!='.'&&!col.add(board[j][i])) return false;
                 if(board[i/3*3][j]!='.'&&!cube.add(board[i/3*3][j])) return false;
             }
         }
         return true;
     }

//     public int[] getNext(String s){
//         int len=s.length();
//         char[] c=s.toCharArray();
//         int[] next=new int[len];
//         next[0]=-1;
//         int i=0,j=-1;
//         while(i<len){
//             if(j==-1||c[i]==c[j]){     // i表示后缀   j表示前缀
//                 j++;i++;
//
//             }
//         }
//     }


     public int longestValidParentheses(String s) {
            ArrayDeque<Character> stack=new ArrayDeque<>();
            int len =s.length();
            int count=0,max=0;
            for(int i=0;i<len;i++)
            {
                switch (s.charAt(i)){
                    case '(':
                        if(stack.size()==0)
                        stack.push('(');
                        break;
                    case ')':
                        if(stack.size()!=0&&stack.pop()=='(') {
                            count+=2;
                            if(max<count) max=count;
                        }else {
                            count=0;
                        }
                        break;
                }
            }
         return max;
     }



 }


class sol{
    public static String reverse(String s){
//        StringBuilder[] sb=new StringBuilder[3];
//        for(int i=0;i<3;i++)
//        {
//            sb[i]=new StringBuilder();
//        }
//        int index=0;
//        sb[0].append(s);
//        index=sb[0].indexOf(" ");
//        sb[1]=sb[0].substring(0,index);
        String[] st=new String[3];
        String st1="";
        int index=0;
        int temp=0;
        for (int i=0;i<3;i++)
        {
            temp=(index==0?-1:index);
            index =(index==s.lastIndexOf(" "))?s.length():s.indexOf(" ", index+1);
            st[i] = s.substring(temp + 1, index);
        }
        for(int i=2;i>=0;i--)
        {
            st1=st1.concat(st[i]+" ");
        }
        return st1;
    }
}

class Solution1 {
    public static boolean isPalindrome(int x) {
        int y=(int)Math.sqrt((double)x);
        int i=0;
        if(x==1||x==2)
        {
            return false;
        }else if (x==3)
        {
            return true;
        }
        while (i!=y+1)
        {
            for (i = 2; i <= y; i++) {
                if (x % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}

class IntToRoman{
    public static String intToRoman(int num){
        int a,b,c;
        String s="";
        while(num-1000>=0){
            s=s+"M";
            num-=1000;
        }
        c=num%10;b=(num/10)%10;a=(num/100)%10;
        if(a==9){s=s+"CM";}
        if(a==4){s=s+"CD";}
        while (a>0&&a<4){
            s=s+"C";
            a--;
        }
        if(a>=5&&a<9){s=s+"D";}
        while (a>5&&a<9){
            s=s+"C";
            a--;
        }
        if(b==9){s=s+"XC";}
        if(b==4){s=s+"XL";}
        while (b>0&&b<4){
            s=s+"X";
            b--;
        }
        if(b>=5&&b<9){s=s+"L";}
        while (b>5&&b<9){
            s=s+"X";
            b--;
        }
        if(c==9){s=s+"IX";}
        if(c==4){s=s+"IV";}
        while (c>0&&c<4){
            s=s+"I";
            c--;
        }
        if(c>=5&&c<9){s=s+"V";}
        while (c>5&&c<9){
            s=s+"I";
            c--;
        }
        return s;

    }

}
