package day14;

import day00.Day;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

record Rule(String a, String b) {
}

public class Day14 extends Day {
  final HashMap<String, String> rules = new HashMap<>();

  @Override
  protected String part1() {
    long[] charCounters = simulateAndCount(inputAsList(), 10);
    var sorted = Arrays.stream(charCounters).filter(x -> x > 0).sorted().toArray();
    return "" + (sorted[sorted.length - 1] - sorted[0]);
  }

  @Override
  protected String part2() {
    long[] charCounters = simulateAndCount(inputAsList(), 40);
    var sorted = Arrays.stream(charCounters).filter(x -> x > 0).sorted().toArray();
    return "" + (sorted[sorted.length - 1] - sorted[0]);
  }

  private long[] simulateAndCount(List<String> input, int numSteps) {
    HashMap<String, Long> pairCounters = new HashMap<>();
    String start = input.get(0);

    readRules(input);
    initPairCounters(pairCounters, start);
    pairCounters = steps(pairCounters, numSteps);

    return countChars(pairCounters, start);
  }

  private HashMap<String, Long> steps(HashMap<String,
      Long> pairCounters, int numSteps) {
    for (int i = 0; i < numSteps; i++)
      pairCounters = step(pairCounters);
    return pairCounters;
  }

  private long[] countChars(HashMap<String, Long> pairCounters, String start) {
    long[] charCounters = new long[128];
    for (String s : pairCounters.keySet())
      charCounters[s.charAt(1)] += pairCounters.get(s);
    charCounters[start.charAt(0)]++; //fix first character
    return charCounters;
  }

  private void initPairCounters(HashMap<String, Long> pairCounters, String start) {
    for (int i = 0; i < start.length() - 1; i++) {
      pairCounters.put(start.substring(i, i + 2),
          1 + pairCounters.getOrDefault(start.substring(i, i + 2), 0L));
    }
  }

  private void readRules(List<String> input) {
    for (int i = 2; i < input.size(); i++) {
      String[] line = input.get(i).split(" -> ");
      rules.put(line[0], line[1]);
    }
  }

  private HashMap<String, Long> step(HashMap<String, Long> counters) {
    HashMap<String, Long> result = new HashMap<>();
    for (String s : counters.keySet()) {
      long num = counters.get(s);
      if (num > 0) {
        String ch = rules.get(s);
        result.put(s.charAt(0) + ch,
            num + result.getOrDefault(s.charAt(0) + ch, 0L));
        result.put(ch + s.charAt(1),
            num + result.getOrDefault(ch + s.charAt(1), 0L));
      }
    }
    return result;
  }
}
