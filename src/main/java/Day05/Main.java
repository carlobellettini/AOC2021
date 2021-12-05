package Day05;

import Day00.Common;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Main {
  public static void main(String[] args) {
    List<String> listOfStrings = Common.readResourceToStringList(Main.class, "input.txt");

    System.out.println("DAY 5 Part 1: " + part1(listOfStrings));
    System.out.println("DAY 5 Part 2: " + part2(listOfStrings));
  }

  static String part1(@NotNull List<String> input) {
    Griglia venti = new Griglia(false);
    for (String s : input) {
      venti.addLine(s);
    }
    return "" + venti.contaIncroci();
  }


  static String part2(@NotNull List<String> input) {
    Griglia venti = new Griglia(true);
    for (String s : input) {
      venti.addLine(s);
    }
    return "" + venti.contaIncroci();
  }
}







