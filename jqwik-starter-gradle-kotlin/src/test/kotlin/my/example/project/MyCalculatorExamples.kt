package my.example.project

import net.jqwik.api.Example
import org.assertj.core.api.Assertions

class MyCalculatorExamples {
    @Example
    fun summingUpZeros() {
        val result = MyCalculator().sum(listOf(0, 0, 0))
        Assertions.assertThat(result).isEqualTo(0)
    }

    @Example
    fun summingUpTwoNumbers() {
        val result = MyCalculator().sum(listOf(1, 41))
        Assertions.assertThat(result).isEqualTo(42)
    }
}