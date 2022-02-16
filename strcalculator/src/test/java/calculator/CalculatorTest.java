package calculator;

import java.util.List;
import java.util.function.IntBinaryOperator;
import java.util.stream.Stream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void createCalculator(){
        this.calculator = new Calculator();
    }

    @ParameterizedTest
    @MethodSource("calcInputParam")
    void doCalculator(int num1, int num2, String sign, int result){
        Assertions.assertThat(calculator.calculator(num1, num2, sign)).isEqualTo(result);
    }

    @Test
    void addCalculator() {
        Assertions.assertThat(calculator.add(10, 20)).isEqualTo(30);
    }

    @Test
    void subtractCalculator() {
        Assertions.assertThat(calculator.subtract(20, 10)).isEqualTo(10);
    }

    @Test
    void multiplyCalculator() {
        Assertions.assertThat(calculator.multiply(10, 10)).isEqualTo(100);
    }

    @Test
    void divideZeroError(){
        calculator.divide(0, 10);
//        Assertions.assertThatThrownBy(()->{
//                calculator.divide(0, 10);
//        }).isInstanceOf(ArithmeticException.class);
    }

    @Test
    void divideCalculator() {
        Assertions.assertThat(calculator.divide(10, 10)).isEqualTo(1);
    }

    private static Stream<Arguments> calcInputParam() { // argument source method
        return Stream.of(
                Arguments.of(10, 10, "+", 20),
                Arguments.of(10, 10, "-", 0),
                Arguments.of(10, 10, "*", 100),
                Arguments.of(10, 10, "/", 1)
        );
    }
}