package Day00;

import java.util.List;
import java.util.Scanner;

public class Day {
  String input = "input.txt";

  final protected Scanner inputAsScanner() {
    return Common.scannerInput(this.getClass(), input);
  }

  final protected List<String> inputAsList() {
    return Common.stringListInput(this.getClass(), input);
  }

  final protected String inputAsString() {
    return Common.stringInput(this.getClass(), input);
  }

  protected String part1() {
    return "!!!";
  }

  protected String part2() {
    return "!!!";
  }

  final public String part1(String input) {
    this.input = input;
    return part1();
  }

  final public String part2(String input) {
    this.input = input;
    return part2();
  }
}
