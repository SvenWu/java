package leetcode.bitManipulation;

/**
 * @author sven (bjwthwu@cn.ibm.com)
 * @date 2020/12/2
 */

/**
 * use binary manipulation to optimize the space using O(1) instead O(n).
 * cause the result is less than 1000 so we can use 10 bits to present this value. And
 * we have another 22 bits to use to save the shuffle value.
 */
public class ShuffleTheArray_1470 {
    public int[] shuffle(int[] nums, int n) {
        for (int i = 0,j = 0; i < 2*n; i+=2,j++) {
            nums[i] |= (nums[j] & 1023) << 10;
            nums[i+1] |= (nums[j+n] & 1023) << 10;
        }

        for (int i = 0; i < 2*n; i++) {
            nums[i] >>= 10;
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {2,5,1,3,4,7};
        new ShuffleTheArray_1470().shuffle(nums,3);
    }
}
