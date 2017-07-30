/**
 * Created by wth on 2016/5/31.
 */
public class Test5 {
    int age;
    public static void main(String []args)
    {
         System.out.println(new Test5().age);
         Test5 rt=new Test5();
         rt.grow().grow().grow();
         System.out.println("rt的成员变量是："+rt.age);
    }
    public Test5 grow()
    {
        age++;
        return this;
    }
}
