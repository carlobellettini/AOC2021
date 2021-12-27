package day17;

import day00.Day;
import day00.ReadsFormattedString;

import java.util.List;
import java.util.Optional;


public class Day17 extends Day {

  private Target t;

  @Override
  protected String part1(List<String> input) {
    t = ReadsFormattedString.readString(input.get(0), "target area: x=%d..%d, y=%d..%d", Target.class);

    for (int vx = (int) Math.sqrt(t.x0()); vx <= t.x1(); vx++)
      for (int vy = 9999; vy >= t.y0(); vy--) {
        var res = simula(vx, vy);
        if (res.isPresent())
          return "" + res.get();
      }
    return super.part1();
  }

  private Optional<Integer> simula(int vx, int vy) {
    int x = 0;
    int y = 0;
    int maxy = 0;
    while (!failed(x, y)) {
      if (maxy < y) maxy = y;
      if (intoTarget(x, y)) return Optional.of(maxy);
      x += vx;
      y += vy;
      if (vx > 0) vx--;
      vy--;
    }
    return Optional.empty();
  }

  boolean intoTarget(int x, int y) {
    return x >= t.x0() && x <= t.x1() && y >= t.y0() && y <= t.y1();
  }

  boolean failed(int x, int y) {
    return y < t.y0() || x > t.x1();
  }

  @Override
  protected String part2(List<String> input) {
    t = ReadsFormattedString.readString(input.get(0), "target area: x=%d..%d, y=%d..%d", Target.class);

    long counter = 0;

    for (int vx = (int) (Math.sqrt(t.x0())); vx <= t.x1(); vx++)
      for (int vy = 9999; vy >= t.y0(); vy--)
        if (simula(vx, vy).isPresent())
          counter++;
    return "" + counter;
  }

  public record Target(int x0, int x1, int y0, int y1) {
  }
}
