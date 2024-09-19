package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split() {
        String input = "1,2";
        String[] splitArr = input.split(",");

        assertThat(splitArr).containsExactly("1", "2");
    }

    @Test
    void substring() {
        String input = "(1,2)";
        String result = input.substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    void charAt() {
        String input = "abc";

        assertThat(findChar(input, 0)).isEqualTo('a');
        assertThat(findChar(input, 1)).isEqualTo('b');
        assertThat(findChar(input, 2)).isEqualTo('c');
        assertThatThrownBy(() -> {
            assertThat(findChar(input, 3));
        })
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }

    private char findChar(String str, int index) {
        return str.charAt(index);
    }

}
