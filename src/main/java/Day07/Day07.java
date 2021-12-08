package Day07;

import Day00.Day;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.ToIntBiFunction;
import java.util.stream.IntStream;

public class Day07 extends Day {
  @Override
  protected String part1() {
    Scanner scanner = inputAsScanner();
    List<Integer> pos = getIntegerList(scanner);
    int min = pos.stream().min(Comparator.naturalOrder()).get();
    int max = pos.stream().max(Comparator.naturalOrder()).get();

    return "" + getMinCost(pos, min, max, (start, end) -> Math.abs(end - start));
  }

  private int getMinCost(List<Integer> pos, int min, int max, ToIntBiFunction<Integer, Integer> cost) {
    return IntStream.rangeClosed(min, max).map(val -> pos.stream().mapToInt(e -> cost.applyAsInt(val, e)).sum()).min().getAsInt();
  }

  @Override
  protected String part2() {
    Scanner scanner = inputAsScanner();
    List<Integer> pos = getIntegerList(scanner);
    int min = pos.stream().min(Comparator.naturalOrder()).get();
    int max = pos.stream().max(Comparator.naturalOrder()).get();

    return "" + getMinCost(pos, min, max, (start, end) -> ((Math.abs(end - start) + 1) * Math.abs(end - start)) / 2);

  }

  private int getMinCost(List<Integer> pos, int min, int max, ToIntBiFunction<Integer, Integer> cost) {
    return IntStream.rangeClosed(min, max).map(val -> pos.stream().mapToInt(e -> cost.applyAsInt(val, e)).sum()).min().getAsInt();
  }

  @NotNull
  private List<Integer> getIntegerList(Scanner scanner) {
    scanner.useDelimiter("[,\n]");
    List<Integer> pos = new ArrayList<Integer>();
    while (scanner.hasNextInt())
      pos.add(scanner.nextInt());
    return pos;
  }
}
