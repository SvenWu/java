/**
 * Created by wth on 2016/6/15.
 *
 * 打印乘法口诀
 */
public class Test7 {
    public static void main(String[] args){
         new Test7().set(9);  //无法从静态方法获取飞静态方法
    }
    public void set(int n){
        for(int i=1;i<=n;i++)
        {
            for (int j=1;j<=i;j++)
            {
                if (j==2&(i==4||i==3))
                {
                    System.out.print(j + "*" + i + "=" + i * j+"  ");
                }else {
                    System.out.print(j + "*" + i + "=" + i * j + " ");
                }
            }
            System.out.println();
        }
    }
}
