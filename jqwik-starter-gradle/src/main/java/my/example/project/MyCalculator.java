package my.example.project;

import java.util.*;

public class MyCalculator {
	public int sum(List<Integer> addends) {
		return addends.stream().mapToInt(i -> i).sum();
	}
}
