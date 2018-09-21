package thread;

/**
 * Created by wth on 2017/4/5.
 */
public class FirstThread extends Thread {  //通过集成thread类创建线程
    private int i;
    public void run(){
        for (; i < 100; i++) {
            System.out.println(getName()+" "+ i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        FirstThread ft = new FirstThread();
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+" "+i);
            if(i == 20)
            {

                ft.start();
                new FirstThread().start();
                //Thread.sleep(50);
            }
        }
    }
}
