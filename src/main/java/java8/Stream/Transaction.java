package java8.Stream;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @auther sven (bjwthwu@cn.ibm.com)
 * @date 2018/12/11
 */
@Data
@AllArgsConstructor
public class Transaction {
    private final Trader trader;

    private final int year;

    private final int value;
}
