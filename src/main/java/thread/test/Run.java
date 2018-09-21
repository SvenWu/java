package thread.test;
import thread.extthread.MyThread;
import thread.extthread.ThreadA;
import thread.extthread.ThreadB;
import thread.service.Myservice;

/**
 * Created by wth on 2017/4/17.
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        Myservice service = new Myservice();
        ThreadA a = new ThreadA(service);
        ThreadB b = new ThreadB(service);
        a.start();
        b.start();
        System.out.println(service);
//        MyThread run = new MyThread();
//        Thread t1 = new Thread(run);
//        Thread t2 = new Thread(run);
//        Thread t3 = new Thread(run);
//        Thread t4 = new Thread(run);
//        Thread t5 = new Thread(run);
//        t1.start();
//        t2.start();
        //System.out.println("this thread is"+Thread.currentThread().getName());
//        t2.start();
//        t3.start();
//        t4.start();
//        t5.start();
        /*
        /i= 5Thread-1
        i= 3Thread-5
        i= 2Thread-4
        i= 4Thread-2
        i= 4Thread-3
         */
    }
}
