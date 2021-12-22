package day16;

import static java.lang.Integer.parseInt;

import day00.Day;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Day16 extends Day {
  long versionSum = 0;
  Deque<Long> stack = new ArrayDeque<>();
  String expr = "";

  @Override
  protected String part1() {
    List<String> input = inputAsList();
    final String s = input.get(0);
    parseStringHex(s);
    return "" + versionSum;
  }

  public String parseStringHex(String hex) {
    StringBuilder bin = new StringBuilder();
    for (String c : hex.split("")) {
      String bits = Integer.toBinaryString(Integer.valueOf(c, 16));
      bin.append("0".repeat(4 - bits.length()));
      bin.append(bits);
    }
    parse(bin.toString());
    return "" + stack.pop();
  }

  private void parse(String bin) {
    while (bin.length() != 0)
      bin = parsePacket(bin);
  }

  private String parsePacket(String bin) {
    if (!bin.contains("1")) return "";
    long version = parseInt(bin.substring(0, 3), 2);
    versionSum += version;
    bin = bin.substring(3);
    if (bin.startsWith("100"))
      bin = parseLiteral(bin.substring(3));
    else
      bin = parseOperator(bin);
    return bin;
  }

  private String parseOperator(String bin) {
    int operator = parseInt(bin.substring(0, 3), 2);
    bin = bin.substring(3);
    if (bin.startsWith("0")) {
      bin = bin.substring(1); // tolgo lenght type
      int l = parseInt(bin.substring(0, 15), 2);
      bin = bin.substring(15);
      int n = stack.size();
      parse(bin.substring(0, l));
      n = stack.size() - n;
      bin = bin.substring(l);

      applyOp(operator, n);
    } else {
      bin = bin.substring(1);
      int n = parseInt(bin.substring(0, 11), 2);
      bin = bin.substring(11);
      for (int i = 0; i < n; i++) {
        bin = parsePacket(bin);
      }
      applyOp(operator, n);
    }
    return bin;
  }

  private void applyOp(int operator, int n) {
    for (int i = 0; i < n - 1; i++) {
      switch (operator) {
        case 0 -> stack.push(stack.pop() + stack.pop());
        case 1 -> stack.push(stack.pop() * stack.pop());
        case 2 -> stack.push(Math.min(stack.pop(), stack.pop()));
        case 3 -> stack.push(Math.max(stack.pop(), stack.pop()));
        case 5 -> stack.push(stack.pop().compareTo(stack.pop()) < 0 ? 1L : 0);
        case 6 -> stack.push(stack.pop().compareTo(stack.pop()) > 0 ? 1L : 0);
        case 7 -> stack.push(stack.pop().equals(stack.pop()) ? 1L : 0);
      }
    }
  }

  private String parseLiteral(String bin) {
    long value = 0;
    while (bin.startsWith("1")) {
      value = value * 16 + parseInt(bin.substring(1, 5), 2);
      bin = bin.substring(5);
    }
    value = value * 16 + parseInt(bin.substring(1, 5), 2);
    bin = bin.substring(5);
    stack.push(value);
    return bin;
  }

  @Override
  protected String part2() {
    List<String> input = inputAsList();
    StringBuilder bin = new StringBuilder();

    final String s = input.get(0);

    return String.valueOf(parseStringHex(s));
  }
}
