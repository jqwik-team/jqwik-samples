package my.example.project.android

import net.jqwik.api.ForAll
import net.jqwik.api.Property
import net.jqwik.api.constraints.Size
import net.jqwik.kotlin.api.JqwikIntRange

class MyCalculatorProperties {
    @Property
    fun sumsOfSmallPositivesAreAlwaysPositive(@ForAll @Size(min = 1, max = 10) @JqwikIntRange(min = 1, max = 1000) addends: IntArray) =
            MyCalculator().sum(*addends) > 0

    @Property
    fun addingZeroToAnyNumberResultsInNumber(@ForAll aNumber: Int) {
        val result = MyCalculator().sum(aNumber, 0)
        assert(result == aNumber)
    }
}