package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import stringCaulator.StringCalculator;
import stringCaulator.StringInputProvider;

import java.util.Scanner;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {

    @Test
    void calculateTest() {
        assertThat(calculateInput("1 + 2")).isEqualTo(3);
        assertThat(calculateInput("10 - 2")).isEqualTo(8);
        assertThat(calculateInput("12 * 5")).isEqualTo(60);
        assertThat(calculateInput("20 / 5")).isEqualTo(4);
        assertThat(calculateInput("1 + 2 - 3 * 4 / 5")).isEqualTo(0);
        assertThat(calculateInput("10 + 2 - 3 * 4 / 8")).isEqualTo(4);
    }

    @Test
    void notSupportedOperationTest() {
        assertThatThrownBy(() ->
                calculateInput("1 % 2")
        ).isInstanceOf(IllegalArgumentException.class);
    }

    private int calculateInput(String input) {
        StringInputProvider inputProvider = new StringInputProvider(input);
        StringCalculator calculator = new StringCalculator(inputProvider);

        return calculator.calculate();
    }

}
