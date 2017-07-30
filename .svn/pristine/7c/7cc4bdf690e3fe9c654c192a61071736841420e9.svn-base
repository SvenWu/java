package leetcode.bitManipulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by wth on 2016/12/12.
 */
public class Solution {
    /**
     * 260. Single Number III
     * */
    public int[] singleNumber3(int[] nums) {
        int xor = 0;
        int n = nums.length;
        int [] res = new int[2];
        for(int i=0;i<n;i++)
        {
            xor^=nums[i];
        }

        xor &= -xor;    //精华！！能得到右边第一个不同的位数
        for(int i:nums)
        {
            if((i & xor) ==0) res[0]^=i;
            else res[1] ^= i;
        }
        return res;
    }



    /**
     * 190.Reverse Bits
     * */
    public int reverseBits(int n) {
//        int []bit = new int[32];
//        int res = 0;
//        int firstBit = n>0?0:1;
//         n = n>0?n:-n;
//        for(int i=30;i>=0;i--)
//        {
//            res += Math.pow(2,i);
//            if(res<=n) {
//                n = n-res;
//                bit[i] = 1;
//            } else bit[i] = 0;
//        }
//        res=0;
//        for(int i=1;i<31;i++)
//        {
//            res += Math.pow(2,i)*bit[31-i];
//        }
//        return (res + firstBit)*(bit[0]==0?1:-1);

        int res = 0;
        for(int i=0;i<32;i++)
        {
            res |= (n>>i)&1;
            if(i==31) break;
            res <<= 1;
        }
        return res;
    }

    /**
     * 169. Majority Element
     * */
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (map.containsKey(nums[i])) map.put(nums[i],map.get(nums[i])+1);
            else map.put(nums[i], 1);
        }
        for (int i = 0; i < 2 / len; i++) {
            if (map.get(nums[i]) > len / 2) return nums[i];
        }
        return 0;
    }

    /**
     * 78. Subsets
     * */
    public List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;
        int totalLen = 1<<len;
        List<List<Integer>> collection = new ArrayList<>();
        for(int i=0;i<totalLen;i++)
        {
            List<Integer> list = new ArrayList<>();
            for(int j=0;j<len;j++)
            {
                if(((i>>j)&1)==1)  list.add(nums[j]);
            }
            collection.add(list);
        }
        return collection;
    }

    /**
     * 268. Missing Number
     * */
    public int missingNumber(int[] nums) {
        int res = 0;
        for(int i=0;i<nums.length;i++)
        {
            res ^= i^nums[i];
        }
        return res^nums.length;
    }
}
