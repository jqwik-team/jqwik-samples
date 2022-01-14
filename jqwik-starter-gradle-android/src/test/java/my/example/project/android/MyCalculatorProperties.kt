package my.example.project

import net.jqwik.api.ForAll
import net.jqwik.api.Property
import net.jqwik.api.constraints.Size
import net.jqwik.kotlin.api.JqwikIntRange
import org.assertj.core.api.Assertions

class MyCalculatorProperties {
    @Property
    fun sumsOfSmallPositivesAreAlwaysPositive(
        @ForAll @Size(min = 1, max = 10) addends: List<@JqwikIntRange(min = 1, max = 1000) Int>
    ) = MyCalculator().sum(addends) > 0

    @Property
    fun addingZeroToAnyNumberResultsInNumber(@ForAll aNumber: Int) {
        val result = MyCalculator().sum(listOf(aNumber, 0))
        Assertions.assertThat(result).isEqualTo(aNumber)
    }
}
