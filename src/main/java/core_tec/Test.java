package core_tec;

/**
 * Created by wth on 2017/6/12.
 */
public class Test {
    public static void main(String[] args) {
        Father father = new Son();
        //虽然不报错  但是编译的时候还是会 报错
        //所以在继承中，子类可以自动转型为父类，
        // 但是父类强制转换为子类时只有当引用类型真正的身份为子类时才会强制转换成功，否则失败。
        Son son = (Son)new Father();
        son.study();
    }
}
