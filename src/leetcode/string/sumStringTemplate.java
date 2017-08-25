package leetcode.string;

/**
 * Created by WuTianhao on 8/25/2017.
 */


public class sumStringTemplate {
    /**
     * 字符串相加的模板
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
        int m = a.length();
        int n = b.length();
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<m || i<n || carry == 1; i++) {
            int x = i < m? a.charAt(m-1-i)-'0': 0;
            int y = i < n? b.charAt(n-1-i)-'0': 0;
            sb.append(x^y^carry);
            carry = (x + y + carry) /2;
        }
        return sb.reverse().toString();
    }

    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for(int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry == 1; i--, j--){
            int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            sb.append((x + y + carry) % 10);
            carry = (x + y + carry) / 10;
        }
        return sb.reverse().toString();
    }
}
