package day01;

import day00.Day;

import java.util.List;

public class Day01 extends Day {

  static int sum(int windowSize, List<String> input) {
    int counter = 0;
    int[] window = new int[input.size()];
    for (int i = 0; i < windowSize; i++) {
      window[i] = Integer.parseInt(input.get(i));
    }
    for (int i = windowSize; i < input.size(); i++) {
      window[i] = Integer.parseInt(input.get(i));
      if (window[i] > window[i-windowSize]) counter++;
    }
    return counter;
  }

  @Override
  public String part1(List<String> input) {
    return "" + sum(1, input);
  }

  @Override
  public String part2(List<String> input) {
    return "" + sum(3, input);
  }
}
