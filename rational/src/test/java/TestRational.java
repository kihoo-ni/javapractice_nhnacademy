import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.nhnacademy.Rational;

public class TestRational {
    @Test
    void testConstructor() {
        assertDoesNotThrow(() -> {
            new Rational(1, 2);
        });
    }

    @Test
    void testInvalidConstructor() {
        assertThrowsExactly(ArithmeticException.class, () -> {
            new Rational(1, 0);
        });
    }

    @ParameterizedTest
    @MethodSource("validConstrutorProvider")
    void testValidConstructor2(int numerator, int denominator){
        assertDoesNotThrow(()->{
            new Rational(numerator, denominator);
        });
    }

    static Stream<Arguments> validConstrutorProvider(){
        return Stream.of(
            Arguments.arguments(1,2),
            Arguments.arguments(100, 25),
            Arguments.arguments(12, 45),
            Arguments.arguments(-10, -4)
        );
    }
}
