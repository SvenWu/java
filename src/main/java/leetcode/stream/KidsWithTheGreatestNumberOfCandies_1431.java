package leetcode.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author sven (bjwthwu@cn.ibm.com)
 * @date 2020/12/1
 */
public class KidsWithTheGreatestNumberOfCandies_1431 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = Arrays.stream(candies).max().getAsInt();
        return Arrays.stream(candies).mapToObj(candy -> candy+extraCandies >= max).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        //System.out.println(1 << 3);

        System.out.println(new KidsWithTheGreatestNumberOfCandies_1431().getBinary(3077));

    }


    String getBinary(int a) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            res.append((a & (1 << i)) > 0 ? "1":"0");
        }
        return res.reverse().toString();
    }
}
