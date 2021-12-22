package day01;

import day00.Common;
import day00.Day;

import java.util.Scanner;

public class Day01 extends Day {
  
  static int sum(int windowSize, Scanner input) {
    int[] window = new int[windowSize];
    init(window, windowSize, input);
    int counter = 0;
    int pos = 0;
    while (input.hasNextInt()) {
      int nuovo = input.nextInt();
      if (nuovo > window[pos]) counter++;
      window[pos] = nuovo;
      pos = (pos+1)%windowSize;
    }
    return counter;
  }

  private static void init(int[] window, int windowSize, Scanner input) {
    for (int i = 0; i < windowSize; i++) {
      window[i] = input.nextInt();
    }
  }

  @Override
  protected String part1() {
    return ""+sum(1, inputAsScanner());
  }

  @Override
  protected String part2() {
    return ""+sum(3, inputAsScanner());
  }
}
