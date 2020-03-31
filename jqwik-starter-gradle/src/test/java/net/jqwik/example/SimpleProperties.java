package net.jqwik.example;

import net.jqwik.api.*;
import net.jqwik.api.constraints.*;
import org.assertj.core.api.*;

public class SimpleProperties {

	@Property
	boolean allPositiveIntegersAreGreaterThan0(@ForAll @IntRange(min = 1) int anInteger) {
		return anInteger > 0;
	}

	@Property
	void firstStringOrdersAfterSecond(@ForAll String first, @ForAll String second) {
		Assertions.assertThat(first).isLessThan(second);
	}

	@Property
	void germanZipCodesHaveFiveDigits(@ForAll("germanZipCodes") String zipCode) {
		Assertions.assertThat(zipCode).hasSize(5);
		Assertions.assertThat(zipCode).containsOnlyDigits();
	}

	@Provide
	Arbitrary<String> germanZipCodes() {
		return Arbitraries.strings()
						  .numeric()
						  .ofLength(5);
	}
}
