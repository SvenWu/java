package leetcode.array;

import java.util.HashSet;
import java.util.stream.IntStream;

/**
 * time complexity : O(n)
 * space complexity : min(O(A),O(B))
 */
public class Fair_Candy_Swap_888 {
    public int[] fairCandySwap(int[] A, int[] B) {
        int dif = (IntStream.of(A).sum() - IntStream.of(B).sum())/2;
        HashSet<Integer> set = new HashSet<>();
        for (int a : A) {
            set.add(a);
        }
        for (int b : B) {
            if (set.contains(b + dif)) {
                return new int[]{b + dif, b};
            }
        }
        return new int[0];
    }
}
