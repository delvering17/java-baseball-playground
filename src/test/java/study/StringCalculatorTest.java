package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import stringCaulator.StringCalculator;

import java.util.Scanner;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {

    StringCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new StringCalculator();
    }


    @Test
    void calculateTest() {
        testCalculator("1 + 2", 3);
        testCalculator("10 - 2", 8);
        testCalculator("12 * 5", 60);
        testCalculator("20 / 5", 4);
        testCalculator("1 + 2 - 3 * 4 / 5", 0);
        testCalculator("10 + 2 - 3 * 4 / 8", 4);
    }

    @Test
    void notSupportedOperationTest() {
        assertThatThrownBy(() ->
                calculator.calculate("1 % 2")
        ).isInstanceOf(IllegalArgumentException.class);
    }

    private void testCalculator(String input, int expected) {
        int result = calculator.calculate(input);

        assertThat(result).isEqualTo(expected);
    }

}
