package Design_pattern.Observer;

/**
 * Created by wth on 2017/6/7.
 */
public class WeatherStation extends Thread{
    public static void main(String[] args) throws InterruptedException {
        WeatherData weatherData = new WeatherData();


        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
        CurrentCondition currentCondition = new CurrentCondition(weatherData);
        //sleep(1000);


        weatherData.setMeasurements(80,65,30.4f);
        weatherData.setMeasurements(82,70,29.2f);
    }

}
