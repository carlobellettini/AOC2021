package day05;

import day00.Day;

public class Day05 extends Day {
  @Override
  protected String part1() {
    Griglia venti = new Griglia(false);
    for (String s : inputAsList()) {
      venti.addLine(s);
    }
    return "" + venti.contaIncroci();
  }

  @Override
  protected String part2() {
    Griglia venti = new Griglia(true);
    for (String s : inputAsList()) {
      venti.addLine(s);
    }
    return "" + venti.contaIncroci();
  }
}
