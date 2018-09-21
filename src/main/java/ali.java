import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by wth on 2017/3/19.
 */
public class ali {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String s1 = sc.nextLine();
//        String s2 = sc.nextLine();
//        String[] str = s2.split(" ");
//        List<int[]> list = new ArrayList<>();
//        list.add(new int[]{1});
//        list.add(new int[]{2});
//        System.out.println(list.get(0)[0]);

//    }
//    public String Dengshi(String s){
//        String str1 = s.substring(0,s.indexOf("="));
//        String str2 = s.substring(s.indexOf("="+1,s.length()));
//        String str3 = "+-*/";
//        int res = 0;
//        for(int i=0;i<str1.length();i++)
//        {
//            int j = str3.indexOf(str1.charAt(i));
//            if(j>0){
//
//            }
//        }
//        return "";
//    }
    public static void main(String[] args) throws ScriptException {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        String[] str = s2.split(" ");
        int count =0; // 空格的计数
        int[] idx = new int[s1.length()];
        for(int i = 0;i<s1.length();i++)
        {
            if(s1.charAt(i) == '_'){
                idx[count++] = i;
            }
        }
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine se = manager.getEngineByName("js");
        int n = str.length;

        List<List<Integer>> result = new ArrayList<>(combine(n,count));
        StringBuilder sb = new StringBuilder(s1);
        for(int j=0;j<result.size();j++)
        {
            for(int m=0;m<count;m++)
            {
                sb.replace(idx[m],idx[m]+1,str[result.get(j).get(m)-1]);
            }
            String s4 = sb.toString();
            String str1 = s4.substring(0, s4.indexOf("="));
            String str2 = s4.substring(s4.indexOf("=") + 1, s4.length());
            Double res =(Double) se.eval(str1);
            Double res1 = Double.parseDouble(str2);
            if(res.equals(res1)){
                System.out.println(str1+"="+str2);
            }
        }
}

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combs = new ArrayList<List<Integer>>();
        combine(combs, new ArrayList<Integer>(), 1, n, k);
        return combs;
    }
    public static void combine(List<List<Integer>> combs, List<Integer> comb, int start, int n, int k) {
        if(k==0) {
            combs.add(new ArrayList<Integer>(comb));
            return;
        }
        for(int i=start;i<=n;i++) {
            if(!comb.contains(i))
            {comb.add(i);
            combine(combs, comb, 1, n, k-1);
            comb.remove(comb.size()-1);}
        }
    }
//    void Sol(int n, int k, int level, List<Integer> out, List<List<Integer>> result) {
//        if (out.size() == k) {
//            result.add(out);
//            return;
//        }
//        for (int i = level; i <= n; ++i) {
//            if (!out.contains(i)) {
//                out.add(i);
//                Sol(n, k, 1, out, result);
//                out.remove(out.size() - 1);
//            }
//        }
//    }
//     List<List<Integer>> combine(int n, int k) {
//        List<Integer> out = new ArrayList<>();
//        List<List<Integer>> result = new ArrayList<>();
//        Sol(n, k, 1, out, result);
//        return result;
//    }
}
