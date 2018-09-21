package Design_pattern.Observer;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by wth on 2017/6/7.
 */
public class ForecastDisplay implements Observer{
    Observable observable;

    public ForecastDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void update(Observable observable, Object arg) {
        if(observable instanceof WeatherData) {
            //WeatherData weatherData = (WeatherData)observable;
            display();
        }
    }

    private void display() {
        System.out.println("the weather is fine");
    }
}
