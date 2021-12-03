package Day04;

import Day00.Common;

import java.util.List;

public class Main {
  public static void main(String[] args) {
    List<String> listOfStrings = Common.readResourceToStringList(Main.class, "input.txt");

    System.out.println("DAY 4 Part 1: " + part1(listOfStrings));
    System.out.println("DAY 4 Part 2: " + part2(listOfStrings));
  }

  static int part2(List<String> input) {
    return 4242;
  }

  static int part1(List<String> input) {
    return 424242;
  }
}