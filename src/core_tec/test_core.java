package core_tec;

import java.util.*;

/**
 * Created by wth on 2017/6/20.
 */
public class test_core implements Cloneable {
    public static void main(String[] args) {
        Object a = new Object();
        if(a instanceof Objects) System.out.println("true");
        test_core t = new test_core();
        test_core b;
        try {
            b = (test_core)t.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        Integer [] c = new Integer[]{1,2};
        Arrays.sort(c,new Comparator<Integer>(){
            @Override
            public int compare(Integer o,Integer o2) {
                return 0;
            }
        });

        HashMap<Integer,Integer> map = new HashMap<>();


    }
//
//    @Override
//    public test_core clone() throws CloneNotSupportedException {
//        return (test_core)super.clone();
//    }
}
