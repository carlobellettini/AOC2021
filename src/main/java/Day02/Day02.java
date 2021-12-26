package day02;


import day00.Common;
import day00.Day;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Day02 extends Day {
  @Override
  protected String part1(List<String> input) {
    IPosition pos1 = new Position();
    pos1.executeCommands(input);
    return pos1.toString();
  }

  @Override
  protected String part2(List<String> input) {
    IPosition pos = new PositionWithAim();
    pos.executeCommands(input);
    return pos.toString();
  }

  interface IPosition {
    void executeCommands(List<String> input);
  }

  private static class Position implements IPosition {
    int h;
    int v;

    void forward(int val) {
      h += val;
    }
    void up(int val) {
      v -= val;
    }
    void down(int val) {
      v += val;
    }

    @Override
    public void executeCommands(List<String> input) {
      for (String s : input) {
        String[] commands = s.split(" ");
        final int value = Integer.parseInt(commands[1]);
        switch (commands[0]) {
          case "forward" -> forward(value);
          case "up" -> up(value);
          case "down" -> down(value);
          default -> System.err.println(Arrays.toString(commands));
        }
      }
    }

    @Override
    public String toString() {
      return String.format("%d  (= %d * %d)", h * v, h, v);
    }
  }


  private static class PositionWithAim extends Position {
    private int realV;

    @Override
    public void forward(int val) {
      h += val;
      realV += val * v;
    }

    @Override
    public String toString() {
      return String.format("%d  (= %d * %d)", h * realV, h, realV );
    }
  }
}
