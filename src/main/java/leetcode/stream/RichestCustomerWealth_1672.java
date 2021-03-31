package leetcode.stream;

import java.util.Arrays;

/**
 * @author sven (bjwthwu@cn.ibm.com)
 * @date 2020/12/1
 */
public class RichestCustomerWealth_1672 {
    public int maximumWealth(int[][] accounts) {
        return Arrays.stream(accounts).mapToInt(account ->
                Arrays.stream(account).sum()
        ).max().getAsInt();
    }
}
