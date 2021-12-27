package day05;

import day00.Day;

import java.util.List;

public class Day05 extends Day {
  @Override
  public String part1(List<String> input) {
    Griglia venti = new Griglia(false);
    for (String s : input) {
      venti.addLine(s);
    }
    return "" + venti.contaIncroci();
  }

  @Override
  public String part2(List<String> input) {
    Griglia venti = new Griglia(true);
    for (String s : input) {
      venti.addLine(s);
    }
    return "" + venti.contaIncroci();
  }
}
