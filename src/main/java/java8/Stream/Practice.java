package java8.Stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @auther sven (bjwthwu@cn.ibm.com)
 * @date 2018/12/11
 */
public class Practice {
    Trader raoul = new Trader("Raoul","Cambridge");
    Trader mario = new Trader("Mario","Milan");
    Trader alan = new Trader("Alan","Cambridge");
    Trader biran = new Trader("Biran","Cambridge");

    List<Transaction> transactions = Arrays.asList(
            new Transaction(biran,2011,300),
            new Transaction(raoul,2012,1000),
            new Transaction(raoul,2011,400),
            new Transaction(mario,2012,710),
            new Transaction(mario,2012,700),
            new Transaction(alan,2012,950)
    );

    public static void main(String[] args) {

        Object[] objects = {1,3,2.3,"da"};
        Arrays.stream(objects).forEach(System.out::println);
    }

    // 1  2011年交易 按交易额排序 低到高
    public void solution1() {
        List<Transaction> transactions1 = transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());
    }

    // 2 traders 在哪儿工作
    public void solution2() {
        transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .forEach(System.out::print);
    }

    // 3 find all cambrige traders sorted by name
    public void solution3() {
        List<Trader> traders = transactions.stream()
                .map(transaction -> transaction.getTrader())
                .filter(trader -> trader.getCity().equals("Cambrige"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());
    }

    //4 返回traders的所有姓名的链接string 按字母排序
    public void solution4() {
        String names = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("",(s1,s2) -> s1+s2);

    }

    // 5 有没有交易员在米兰工作
    public void solution5() {
        boolean milan = transactions.stream()
                .anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
    }

    // 6 print all the value lived in cambride
    public void solution6() {
        transactions.stream()
                .filter(transaction -> "cambrige".equals(transaction.getTrader().getCity()))
                .forEach(System.out::println);
    }

    // 7 max value of all the transactions
    public void solution7() {
        int value = transactions.stream()
                .map(Transaction::getValue)
                .reduce(0,Integer::max);
    }

    // 8 find trasaction with min value
    public void solution8() {
        int value = transactions.stream()
                .map(Transaction::getValue)
                .reduce(0,Integer::min);

        transactions.stream()
                .filter(transaction -> transaction.getValue() == value)
                .findAny();

        // or
        Optional<Transaction> minT = transactions.stream()
                .min(Comparator.comparing(Transaction::getValue));
    }
}
