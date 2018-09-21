package NiuKe;

import java.util.Scanner;

/**
 * Created by wth on 2017/4/1.
 */
public class wangyi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] tx = new int [n];
        int [] ty = new int [n];
        for(int i=0; i<n; i++) {
            tx[i] = sc.nextInt();
        }
        for(int i=0; i<n; i++) {
            ty[i] = sc.nextInt();
        }
        int gx = sc.nextInt();
        int gy = sc.nextInt();
        int walkTime = sc.nextInt();
        int taxiTime = sc.nextInt();
        int walk;
        walk = (Math.abs(gx)+Math.abs(gy))*walkTime;
        int walkTaxi = 0;
        int alltime = 0;
        for(int i=0;i<n;i++)
        {
            walkTaxi =(Math.abs(tx[i])+Math.abs(ty[i]))*walkTime
                    +(Math.abs(gx-tx[i])+Math.abs(gy-ty[i]))*taxiTime;
            alltime = Math.min(walkTaxi,alltime);
        }
        System.out.println(Math.min(alltime,walk));
    }
}
