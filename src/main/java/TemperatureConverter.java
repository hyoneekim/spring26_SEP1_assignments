//import java.util.Scanner;

public class TemperatureConverter {

    public static double fahrenheitToCelsius(double f) {
        return (f - 32) * 5 / 9;
    }

    public static double celsiusToFahrenheit(double c) {
        return (c * 9 / 5) + 32;
    }

    // Extreme Temperature: < -40C or > 50C
    public static boolean isExtremeTemperatureInCelsius(double c) {
        return c < -40.0 || c > 50.0;
    }

    public static void main(String[] args) {
        double input = 2.5;


        double fahrenheit = celsiusToFahrenheit(input);
        double celsius = fahrenheitToCelsius(input);

        System.out.println("In F: " + fahrenheit + " in C: " + celsius);

    }
}