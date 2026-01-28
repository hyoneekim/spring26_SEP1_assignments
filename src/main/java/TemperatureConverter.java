public class TemperatureConverter {

    static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }
    static boolean isExtremeTemperatureInCelsius(double temperature) {
        return temperature < -40 || temperature > 50;
    }
}
