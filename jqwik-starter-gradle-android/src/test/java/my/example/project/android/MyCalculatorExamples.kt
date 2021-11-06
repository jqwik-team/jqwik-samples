package my.example.project.android

import net.jqwik.api.Example

class MyCalculatorExamples {
    @Example
    fun summingUpZeros() {
        val result = MyCalculator().sum(0, 0, 0)
        assert(result == 0)
    }

    @Example
    fun summingUpTwoNumbers() {
        val result = MyCalculator().sum(1, 41)
        assert(result == 42)
    }
}