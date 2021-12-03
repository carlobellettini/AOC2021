package Day03;


import Day00.Common;

import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    List<String> listOfStrings = Common.readResourceToStringList(Main.class, "input.txt");

    System.out.println("DAY 3 Part 1: " + part1(listOfStrings));
    System.out.println("DAY 3 Part 2: " + part2(listOfStrings));
  }

  static int part2(List<String> input) {
    return Integer.parseInt(part2_recursive(new ArrayList<>(input), 0, true), 2) *
        Integer.parseInt(part2_recursive(input, 0, false), 2);
  }

  private static String part2_recursive(List<String> input, int iteration, boolean oxygen) {
    assert (iteration < input.get(0).length()) : "troppe iterazioni";

    char moreCommon = moreCommon(input, iteration);
    input.removeIf(current -> current.charAt(iteration) == moreCommon ^ !oxygen);

    if (input.size() == 1) return input.get(0);
    return part2_recursive(input, iteration + 1, oxygen);
  }

  private static char moreCommon(List<String> input, int position) {
    int ones = 0;
    for (String current : input) {
      if (current.charAt(position) == '1')
        ones++;
    }
    return ones >= (input.size() + 1) / 2 ? '1' : '0';
  }

  static int part1(List<String> input) {
    StringBuilder primo = new StringBuilder();
    StringBuilder secondo = new StringBuilder();
    for (int i = 0; i < input.get(0).length(); i++) {
      char common = moreCommon(input, i);
      primo.append(common);
      secondo.append(common == '1' ? '0' : '1');
    }
    return Integer.parseInt(primo.toString(), 2) * Integer.parseInt(secondo.toString(), 2);
  }
}
