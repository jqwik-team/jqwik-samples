package net.jqwik.example;

import net.jqwik.api.*;

public class SimpleExampleTests {

	@Property
	boolean succeedingProperty() {
		return true;
	}

	@Property
	boolean failingProperty() {
		return false;
	}
}
