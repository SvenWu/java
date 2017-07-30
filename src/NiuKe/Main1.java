package NiuKe;

/**
 * Created by wth on 2017/4/18.
 */
import java.util.Scanner;
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int [][] nums = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                nums[i][j] = sc.nextInt();
            }
        }

    }
}
