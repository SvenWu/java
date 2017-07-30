package NiuKe;

import java.util.Scanner;

/**
 * Created by wth on 2017/4/1.
 */
public class wangyi3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int count1= new wangyi3().adjust(s,'G');
        int count2= new wangyi3().adjust(s,'B');
        System.out.println(Math.min(count1,count2));
    }

    public int adjust(String s, char c){
        int len = s.length();
        int count = 0;
        int sum = 0;
        for(int i =0;i<len;i++)
        {
            if(s.charAt(i) == c) count++;
        }
        int count2 = count;
        for(int i=0;i<len;i++)
        {
            if(count == 0) break;
            if(s.charAt(i) == c)
            {
                sum += i+count-count2;
                count--;
            }

        }
        return sum;
    }
}
