package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class SetTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    void size() {
        int size = numbers.size();
        assertThat(size).isEqualTo(3);
    }

    @Test
    void contains() {
        assertThat(numbers).contains(1);
        assertThat(numbers).contains(2);
        assertThat(numbers).contains(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void parameterizedContainsTest(int input) {
        assertThat(numbers).contains(input);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "10000:false"}, delimiter = ':')
    void csvParameterizedContainsTest(int input, boolean expected) {
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }


}