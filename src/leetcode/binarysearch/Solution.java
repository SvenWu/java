package leetcode.binarysearch;

/**
 * Created by wth on 2017/3/13.
 */
public class Solution {
    static  int m =0;
    public String smallestGoodBase(String n) {
        long remainder = 0;
        long len = Long.parseLong(n);
        for(int i=2; i<Math.sqrt(len);i++)
        {
            long num = len;
            while(num>i)
            {
                remainder = num%i;
                num /= i;
                if(remainder != 1) {
                    break;
                }
                if(num<i && num == 1) {
                    return i+"";
                }
            }
        }
        return String.valueOf(len-1);
    }

/**
 * 153. Find Minimum in Rotated Sorted Array
 * */
    public int findMin(int[] nums) {
        int len = nums.length;
        if(nums == null || len == 0) {
            return 0;
        }
        int l = 0 , r = len-1;
        int mid =0;
        while(l<=r)
        {
            mid = l + (r-l)/2;
            if(nums[mid] >= nums[len-1]) {
                l = mid+1;
            } else {
                r = mid -1;
            }
        }
        return nums[mid];
    }

    public static void main(String[] args){
        int x =2;
        int[] nums = new int[]{1};
        Solution sol = new Solution();
        System.out.println(sol.findMin(nums));
        double num = 470988884881403701.0;
        long startTime = System.currentTimeMillis(); // ?????????
        // doThing(); // ?????????
//        System.out.println(sol.smallestGoodBase("470988884881403701"));
//        System.out.println(Math.pow(470988884881403701.0, 1.0 / 3));
//        System.out.println(Math.pow(470988884881403701.0,1.0/2));
        long endTime = System.currentTimeMillis(); // ??????????
       // System.out.println("shijian " + (endTime - startTime) + "ms");
    }
}

