package my.example.project;

import java.util.*;

import net.jqwik.api.*;
import net.jqwik.api.constraints.*;
import org.assertj.core.api.*;

import static java.util.Arrays.*;

class MyCalculatorProperties {

	@Property
	boolean sumsOfSmallPositivesAreAlwaysPositive(@ForAll @Size(min = 1, max = 10) List<@IntRange(min = 1, max = 1000) Integer> addends) {
		int result = new MyCalculator().sum(addends);
		return result > 0;
	}

	@Property
	void addingZeroToAnyNumberResultsInNumber(@ForAll int aNumber) {
		int result = new MyCalculator().sum(asList(aNumber, 0));
		Assertions.assertThat(result).isEqualTo(aNumber);
	}
}
