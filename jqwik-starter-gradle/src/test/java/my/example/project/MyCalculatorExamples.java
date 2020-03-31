package my.example.project;

import net.jqwik.api.*;
import org.assertj.core.api.*;

class MyCalculatorExamples {

	@Example
	void summingUpZeros() {
		int result = new MyCalculator().sum(0, 0, 0);
		Assertions.assertThat(result).isEqualTo(0);
	}

	@Example
	void summingUpTwoNumbers() {
		int result = new MyCalculator().sum(1, 41);
		Assertions.assertThat(result).isEqualTo(42);
	}
}
