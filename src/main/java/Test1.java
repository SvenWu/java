class Person {
    private int i=1;

    public Person()
    {
        System.out.print("P");
    }

    public void print()
    {
        System.out.print(i);
    }
}
class Friend {
    public Friend()
    {
        System.out.print("F");
    }
}
class Son extends Person {
    private Friend f=new Friend();

    public Son()
    {
        System.out.print("S");
    }

    public void print()
    {
        int i=2;
        System.out.print(i);
    }

    public static void main(String[] args) {
        Person s = new Son();
        s.print();
    }
}