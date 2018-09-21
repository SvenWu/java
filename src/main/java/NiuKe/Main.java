package NiuKe;

/**
 * Created by wth on 2017/3/25.
 */
import com.sun.xml.internal.ws.api.ha.StickyFeature;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int [][]arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(new Main().land(arr));
    }
    public int land(int[][] arr){
        int m = arr.length;
        int n = arr[0].length;
        int count = 0;
        boolean flag[][] = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        int dirs[][] = new int[][]{{1,0},{-1,0},{0,-1},{0,1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(arr[i][j] == 1 && !flag[i][j]){
                    queue.offer(new int[]{i,j});
                    while(!queue.isEmpty()){
                        int [] cell = queue.poll();
                        flag[cell[0]][cell[1]] = true;
                        for(int [] d : dirs){
                            int row = cell[0] + d[0];
                            int col = cell[1] + d[1];
                            if(row<0 || row >=m || col<0 || col>=n || flag[row][col]
                                    || arr[row][col] == 0) {
                                continue;
                            } else {
                                queue.offer(new int[]{row,col});
                                flag[row][col] = true;
                            }
                        }
                    }
                    count++;
                }
            }
        }
        return count;
    }

    public void reOrderArray ( int[] array){
        int len = array.length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            if ((array[i] & 1) == 1) {
                count++;
            }
        }
        int[] copy = new int[len];
        for (int i = 0, l = 0, r = count; i < len; i++) {
            if ((array[i] & 1) == 1) {
                copy[l++] = array[i];
            } else {
                copy[r++] = array[i];
            }
        }
        for (int a : copy) {
            System.out.println(a);
        }
        array = Arrays.copyOf(copy, len);
    }
}

//public class Main {
//    public static void main(String[] args) {
//        Main sol = new Main();
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        double[] nums = new double[n];
//        for (int i = 0; i < n; i++) {
//            nums[i] = sc.nextInt()/100;
//        }
//        int m = (int)Math.ceil(n*6/10);
//        double res = 0;
//        for (int i = m; i <= n; i++) {
//            res += sol.backTrack(m,n,nums,0,res,0,0);
//        }
//        System.out.println(res);
//    }
//    double backTrack(int m,int n,double[] nums,double mul,double res,int pos,int j){
//        if(j == m){
//            res += mul;
//            return res;
//        }
//        for (int i = pos; i < n; i++) {
//            mul *= nums[i];
//            backTrack(m,n,nums,mul,res,i+1,j+1);
//            mul /= nums[i];
//            j -= 1;
//        }
//        return res;
//    }

//    public void ring(int n, int count , int[] num){
//
//        for(int j =0;j<count;j++)
//        {
//            int a = num[0];
//            for(int i =0; i<n; i++)
//            {
//                if(i+1 == n){
//                    num[i] = num[i] + a;
//                }
//                else num[i] = num[i]+num[i+1];
//                if(num[i] >=100) num[i] %= num[i];
//            }
//        }
//    }


