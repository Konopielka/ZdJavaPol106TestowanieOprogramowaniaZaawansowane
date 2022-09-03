package pl.sdacademy.unit.test.advance.exercises.parametrized.methodsource.provider;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class FibonacciProvider {

    public static Stream<Arguments> provideData(){
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(1, 1),
                Arguments.of(7, 13),
                Arguments.of(12, 144)
        );
    }
}
