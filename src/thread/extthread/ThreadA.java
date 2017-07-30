package thread.extthread;

import thread.service.Myservice;

/**
 * Created by wth on 2017/5/2.
 */
public class ThreadA extends Thread {
    private Myservice service;
    public ThreadA(Myservice service){
        super();
        this.service = service;
    }
    @Override
    public void run(){
        service.awaitA();
    }
}
