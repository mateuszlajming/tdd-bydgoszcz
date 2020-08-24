package d_assertj_solution;

import b_exceptions_solution.ExceptionsCalculator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AssertJCalculatorTest {

    ExceptionsCalculator exceptionsCalculator;

    @BeforeEach
    public void before() {
        exceptionsCalculator = new ExceptionsCalculator();
    }

    @Test
    public void divide_whenDividing4By2_shouldReturn2() {
        Integer quotient = exceptionsCalculator.divide(4, 2);
        
        Assertions.assertThat(quotient).isEqualTo(2);
    }

    @Test
    public void divide_whenDividingBy0_shouldThrowIllegalArgumentExceptionWithProperMessage() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> {
                exceptionsCalculator.divide(1, 0);
            }).withMessage("division by 0");
    }

}
