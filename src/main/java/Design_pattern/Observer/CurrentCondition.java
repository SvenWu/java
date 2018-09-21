package Design_pattern.Observer;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by wth on 2017/6/7.
 *
 *
 * 所以在继承中，子类可以自动转型为父类，
 * 但是父类强制转换为子类时只有当引用类型真正的身份为子类时才会强制转换成功，否则失败。
 */
public class CurrentCondition implements Observer,Displayment {
    Observable observable;
    private float temperature;
    private float humidity;

    public CurrentCondition(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void update(Observable obs, Object arg) {
        if(obs instanceof WeatherData) {
            WeatherData weatherData = (WeatherData)obs;
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            display();
        }
    }
    @Override
    public void display() {
        System.out.println("Current conditions: " + temperature + "F degrees and"
            + humidity + "% humidity");
    }
}
