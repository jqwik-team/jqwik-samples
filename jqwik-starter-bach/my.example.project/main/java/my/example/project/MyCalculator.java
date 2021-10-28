package my.example.project;

import java.util.*;

public class MyCalculator {

	public MyCalculator() {}

	public int sum(int... addends) {
		return Arrays.stream(addends).sum();
	}
}
