package thread;

/**
 * Created by wth on 2017/4/5.
 */
public class JoinTread extends Thread {
    public JoinTread(String name){
        super(name);
    }
    public void run(){
        for (int i = 0; i < 100; i++) {
            System.out.println(getName()+ " " +i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new JoinTread("xinxiancheng").start();
        for (int i = 0; i < 100; i++) {
            if (i == 20) {
                JoinTread jt = new JoinTread("joined");
                jt.start();
                jt.join();
            }
            System.out.println(Thread.currentThread().getName()+" "+ i);
        }
    }
}
