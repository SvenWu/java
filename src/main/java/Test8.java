/**
 * Created by wth on 2016/7/5.
 *
 * 优化y轴坐标值
 */

public class Test8 {
    double data[]={2312,3412,42.13,5657};
    public static void main(String []args){
        System.out.println(new Test8().yaxisDataMin());
        System.out.print(new Test8().yaxisDataMax());
    }

    public double yaxisDataMin(){
        double min=data[0];int a; double b;
        for(int i=1;i<data.length;i++)
        {
            if(min>data[i]){
                min=data[i];
            }
        }
                                                  //      a=String.valueOf(min).indexOf(".");  //查找小数点的索引位置  不好 整数返回-1了
        if(min<1){
            min=0;
            return min;
        }
        a=(int)(Math.log10(min)+1);                //a为位数
        if(a<3)
        {
            min=min-(min%10);
            return min;
        }else{
            b=Math.pow(10,a-2);
            min=min-(min%b);
        }

        return min;
    }
    public double yaxisDataMax(){
        double max=data[0];int a; double b;
        for(int i=1;i<data.length;i++)
        {
            if(max<data[i]){
                max=data[i];
            }
        }
        if(max<1){
            return max;
        }
        a=(int)(Math.log10(max)+1);             //a为位数
        if(a<3)
        {
            max=max-(max%10)+10;
            return max;
        }else{
            b=Math.pow(10,a-2);
            max=max-(max%b)+b;
        }
        return max;
    }
}
