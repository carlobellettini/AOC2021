package Day10;

import Day00.Day;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Day10 extends Day {
  @Override
  protected String part1() {
    return "" + inputAsList().stream().mapToLong(linea -> points(report(linea).charAt(0))).sum();
  }

  @Override
  protected String part2() {
    List<Long> points = new ArrayList<>();
    for (String linea : inputAsList()) {
      String comp = report(linea);
      if (List.of('(', '[', '{', '<').contains(comp.charAt(0)))
        points.add(comp.chars().mapToLong(s -> pointsP2((char)s)).reduce((x, y) -> x = x * 5 + y).getAsLong());
    }
    points.sort(null);
    return String.valueOf(points.get(points.size() / 2));
  }

  private String report(String linea) {
    Deque<Character> pila = new ArrayDeque<>();

    for (char s : linea.toCharArray())
      if (List.of('(', '[', '{', '<').contains(s))
        pila.push(s);
      else {
        assert (!pila.isEmpty());
        char aperta = pila.pop();
        if (('(' == aperta && ')' != s) ||
            ('{' == aperta && '}' != s) ||
            ('[' == aperta && ']' != s) ||
            ('<' == aperta && '>' != s))
          return String.valueOf(s);
      }
    //return pila.stream().collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
    return pila.stream().map(String::valueOf).reduce((a, b) -> a + b).get();
  }

  long points(char s) {
    return switch (s) {
      case ')' -> 3;
      case ']' -> 57;
      case '}' -> 1197;
      case '>' -> 25137;
      default -> 0;
    };
  }

  long pointsP2(char s) {
    return switch (s) {
      case '(' -> 1;
      case '[' -> 2;
      case '{' -> 3;
      case '<' -> 4;
      default -> 0;
    };
  }
}
