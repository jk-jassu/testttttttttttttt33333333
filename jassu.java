import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class jassu {

    public static float add(float num1, float num2) {
        return num1 + num2;
    }

    public static float subtract(float num1, float num2) {
        return num1 - num2;
    }

    public static float multiply(float num1, float num2) {
        return num1 * num2;
    }

    public static float divide(float num1, float num2) {
        if (num2 != 0) {
            return num1 / num2;
        } else {
            throw new ArithmeticException("Cannot divide by zero");
        }
    }
}

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void setUp() {
        this.calculator = new Calculator();
    }

    @Test
    public void testAddition() {
        float num1 = 10.5f;
        float num2 = 5.3f;
        float expectedResult = 15.8f;

        float result = Calculator.add(num1, num2);

        assertEquals(expectedResult, result, 0.0001);
    }

    @Test
    public void testSubtraction() {
        float num1 = 10.5f;
        float num2 = 5.3f;
        float expectedResult = 5.2f;

        float result = Calculator.subtract(num1, num2);

        assertEquals(expectedResult, result, 0.0001);
    }

    @Test
    public void testMultiplication() {
        float num1 = 10.5f;
        float num2 = 5.3f;
        float expectedResult = 55.65f;

        float result = Calculator.multiply(num1, num2);

        assertEquals(expectedResult, result, 0.0001);
    }

    @Test
    public void testDivision() {
        float num1 = 10.5f;
        float num2 = 5.0f;
        float expectedResult = 2.1f;

        float result = Calculator.divide(num1, num2);

        assertEquals(expectedResult, result, 0.0001);
    }
}
