/**
 * Created by wth on 2016/6/14.
 */
public class Test6 {
    public static void main(String[] args) {
        Animal cat = new Cat();
        cat.cry();
        cat=new Dog();
        cat.cry();
    }
}
class Animal{


    private String name;
    private int age;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void cry(){
        System.out.println("哈哈哈");
    }
}
class Dog extends Animal{
    public void cry(){
        System.out.println("wangwangwang");
    }
}
class Cat extends Animal{
    @Override
    public void cry(){
        System.out.println("miaomaiomiao");
    }
}

