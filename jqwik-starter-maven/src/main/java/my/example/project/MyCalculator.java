package my.example.project;

import java.util.*;

public class MyCalculator {
	public int sum(int... addends) {
		return Arrays.stream(addends).sum();
	}
}
