package thread.extthread;

/**
 * Created by wth on 2017/4/17.
 */
public class MyThread extends Thread {
    private int i = 5;
    @Override
     public void run(){
        for (int i = 0;  i < 50;  i++) {
            System.out.println("i= "+i+Thread.currentThread().getName());
        }

    }
}
