package thread.service;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by wth on 2017/5/2.
 */
public class Myservice {
    ReentrantLock lock = new ReentrantLock();
    public Condition conditionA = lock.newCondition();
    public Condition conditionB = lock.newCondition();
    public void awaitA(){
        try {
            lock.lock();
            lock.hasWaiters(conditionA);
            Thread.sleep(1000);
            System.out.println("begin awaitA time is" + System.currentTimeMillis() +
                    Thread.currentThread().getName());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    synchronized public void awaitB(){
        try {
            //lock.lock();
            System.out.println("begin awaitB time is" + System.currentTimeMillis() +
                    Thread.currentThread().getName());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //lock.unlock();
        }
    }
}
