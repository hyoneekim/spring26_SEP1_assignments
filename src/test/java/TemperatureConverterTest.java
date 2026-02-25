import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TemperatureConverterTest {

    @Test
    void convertTemperatureToCelsius() {
        double[] fahrenheitValues = {32.0, 212.0, 98.6};
        double[] expectedCelsiusValues = {0.0, 100.0, 37.0};

        for (int i = 0; i < fahrenheitValues.length; i++) {
            double fahrenheit = fahrenheitValues[i];
            double expectedCelsius = expectedCelsiusValues[i];
            double actualCelsius = TemperatureConverter.fahrenheitToCelsius(fahrenheit);
            assertEquals(expectedCelsius, actualCelsius, 0.1);
        }
    }

    @Test
    void convertTemperatureToFahrenheit() {
        double[] celsiusValues = {0.0, 100.0, 37.0};
        double[] expectedFahrenheitValues = {32.0, 212.0, 98.6};

        for (int i = 0; i < celsiusValues.length; i++) {
            double celsius = celsiusValues[i];
            double expectedFahrenheit = expectedFahrenheitValues[i];
            double actualFahrenheit = TemperatureConverter.celsiusToFahrenheit(celsius);
            assertEquals(expectedFahrenheit, actualFahrenheit, 0.1);
        }
    }

    @Test
    void testExtremeTemperatureInCelsius() {
        assertTrue(TemperatureConverter.isExtremeTemperatureInCelsius(-50.0));
        assertTrue(TemperatureConverter.isExtremeTemperatureInCelsius(60.0));
        assertFalse(TemperatureConverter.isExtremeTemperatureInCelsius(20.0));
    }
}