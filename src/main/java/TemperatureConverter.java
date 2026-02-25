import java.util.Scanner;

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

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        double fahrenheit = fahrenheitToCelsius(a);
        double celsius = celsiusToFahrenheit(a);
        System.out.println("In F: " + fahrenheit + "in C: " + celsius);



    }
}
