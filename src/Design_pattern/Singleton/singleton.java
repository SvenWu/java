package Design_pattern.Singleton;

/**
 * Created by wth on 2017/8/20.
 */
public class singleton {
//    private static singleton ourInstance = new singleton();
//
//    public static singleton getInstance() {
//        return ourInstance;
//    }
//
//    private singleton() {
//    }

    private static singleton instance;

    private singleton() {
    }

//    public synchronized static singleton getInstance() {
//        if(instance == null) {
//            instance = new singleton();
//        }
//        return instance;
//    }
    public static singleton getInstance(){
        if(instance == null) {
            synchronized (singleton.class) {
                if(instance == null)
                    instance = new singleton();
            }
        }
        return instance;
    }
}
