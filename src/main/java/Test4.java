/**
 * Created by wth on 2016/5/26.
 * 水仙花数运算
 */
public class Test4 {
    public static void main (String []args){
        int a,b,c,d;
        for(int i=100;i<=999;i++){
            a=i/100;
            b=i%100;
            c=b/10;
            d=b%10;
             //System.out.print(a+""+c+""+d);
//            System.out.println();
//            System.out.printf("%d,%d,%d",a,c,d);
//            System.out.println();
            if(i==(Math.pow(a,3)+Math.pow(c,3)+Math.pow(d,3))){
                System.out.println(i);
            }
        }
    }
}
