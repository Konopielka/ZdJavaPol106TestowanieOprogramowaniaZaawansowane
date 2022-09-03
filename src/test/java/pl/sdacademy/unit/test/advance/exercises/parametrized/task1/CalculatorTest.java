package pl.sdacademy.unit.test.advance.exercises.parametrized.task1;

import org.assertj.core.api.JUnitBDDSoftAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @ParameterizedTest
    @MethodSource("provideDataForMultiply")
    void shouldMultiplyTwoValues(int a, int b, int expectedResult){
        //when
        int result = Calculator.multiply(a, b);
        //then
        assertEquals(expectedResult, result);
        assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> provideDataForMultiply(){
        return Stream.of(
                Arguments.of(2, 3 ,6),
                Arguments.of(3, 2 ,6),
                Arguments.of(1, 4 ,4),
                Arguments.of(-5, -3 ,15)
        );
    }

    @Test
    void shouldThrowExceptionWhenSecondDigitIsZero(){
        //given
        int a = 5;
        int b = 0;
        //when % Then
        //JUnit
        assertThrows(IllegalArgumentException.class,
                ()-> Calculator.divide(a, b));

        //assertJ
        assertThatThrownBy(() -> Calculator.divide(a, b))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Can't divide by 0");
    }

    /*@ParameterizedTest
    @MethodSource("provideDataForDivide")
    void shouldDivideTwoValues(int a, int b, int expectedResult){
        //when
        int result = Calculator.divide(a, b);
        //then
        assertThatExceptionOfType(IllegalArgumentException.class);
    }

    private static  Stream<Arguments> provideDataForDivide(){
        return Stream.of(
                Arguments.of(0,1,0),
                Arguments.of(1,1,1),
                Arguments.of(1,0,assertThatIllegalArgumentException())
        );
    }*/
}