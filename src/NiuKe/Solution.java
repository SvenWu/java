package NiuKe;

import javax.net.ssl.SSLContext;

/**
 * Created by wth on 2017/3/1.
 */
public class Solution {
    public String replaceSpace(StringBuffer str) {
        String s = str.toString();
        String[] res;
        String ss= "11";
        System.out.print(Integer.parseInt(ss));
        res = s.split(" ");
        String result = "";
        for(int i=0;i<res.length-1;i++)
        {
            result += res[i]+"20%";
        }
        result += res[res.length-1];
        return result;
    }

    public static void main(String[] args) {

    }
}
