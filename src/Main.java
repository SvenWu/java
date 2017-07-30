import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<Integer> inputs = new ArrayList<Integer>();
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        if(line != null && !line.isEmpty()) {
            int res = resolve(line.trim());
            System.out.println(String.valueOf(res));
        }
    }

    // write your code here
    public static int resolve(String expr) {
        String[] str = expr.split("\\s+");
        ArrayDeque<String> stack = new ArrayDeque<>();
        String op = "+*-";
        int res = 0;
        if(str.length ==1 ){
            if(op.contains(str[0])) return -1;
            return Integer.parseInt(str[0]);
        }
        for(String t : str)
        {
            if(!op.contains(t))  {
                stack.push(t);
                if(stack.size()>16) return -2;
            }
            else {
                int  op1;//第一个运算数
                int  op2;//第二个
                if(!(t.equals("-")) && stack.size()<2) return -1;
                if(t.equals("-") && stack.isEmpty()) return -1;
                //不考虑会超界
                if(t.equals("-")){
                    op1 = Integer.parseInt(stack.pop());
                    stack.push(op1+1+"");
                }else{
                    op2 = Integer.parseInt(stack.pop());
                    op1 = Integer.parseInt(stack.pop());
                    res = eval(op1,op2,t);
                    stack.push(""+res);
                }
            }
        }
        return Integer.parseInt(stack.pop());
    }
    static int eval(int a,int b,String s){
        if(s.equals("+")) return a + b;
        if(s.equals("*")) return a * b;
        return 0;
    }
    public int filter(String s, String pattern){
        int len = s.length();
        int idx = 0;
        for (int i = 0; i < len; i++) {
            idx = i;
            if(pattern.charAt(i) == '?' || pattern.charAt(i) == '*') break;
            if(s.charAt(i) != pattern.charAt(i)) return 0;
        }
        return 1;
    }
}