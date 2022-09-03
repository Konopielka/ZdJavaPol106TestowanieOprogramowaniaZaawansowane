package pl.sdacademy.unit.test.advance.exercises.task1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @ParameterizedTest
    @MethodSource("provideDataForMultiply")
    void shouldMultiplyTwoValues(int firstDigit, int secondDigit, int expectedResult) {
        //when
        int result = Calculator.multiply(firstDigit, secondDigit);
        //then
        assertEquals(expectedResult, result); //Junit
        assertThat(result).isEqualTo(expectedResult); //assertJ
    }

    @Test
    void shouldThrowExceptionWhenSecondDigitIsZero() {
        //given
        int firstDigit = 5;
        int secondDigit = 0;
        //when & then
        //Junit5
        assertThrows(IllegalArgumentException.class, () -> Calculator.divide(firstDigit, secondDigit));

        //assertJ
        assertThatThrownBy(() -> Calculator.divide(firstDigit, secondDigit))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Can't divide by 0");
    }

    private static Stream<Arguments> provideDataForMultiply() {
        return Stream.of(
                Arguments.of(2, 3, 6),
                Arguments.of(-5, -10, 50),
                Arguments.of(4, -3, -12)
        );
    }
}