package test.my.modules;

import my.example.project.*;
import net.jqwik.api.*;
import net.jqwik.api.constraints.*;
import org.assertj.core.api.*;

class TestMyCalculatorProperties {

	@Property
	boolean sumsOfSmallPositivesAreAlwaysPositive(@ForAll @Size(min = 1, max = 10) @IntRange(min = 1, max = 1000) int[] addends) {
		int result = new MyCalculator().sum(addends);
		return result > 0;
	}

	@Property
	void addingZeroToAnyNumberResultsInNumber(@ForAll int aNumber) {
		int result = new MyCalculator().sum(aNumber, 0);
		Assertions.assertThat(result).isEqualTo(aNumber);
	}
}
