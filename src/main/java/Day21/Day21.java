package day21;

import day00.Day;

import java.util.ArrayList;
import java.util.List;

public class Day21 extends Day {

  static long[] timesM = {0, 0, 0, 1, 3, 6, 7, 6, 3, 1};

  /* //DUE MODI PER CALCOLARE timesM
  static {
    for (int i = 1; i < 4; i++)
      for (int j = 1; j < 4; j++)
        for (int k = 1; k < 4; k++)
          timesM[i + j + k]++;
  }

  public static void main(String[] args) {
    final Map<Integer,Integer> comb = Generator.permutation(1,2,3).withRepetitions(3)
        .stream().map(e-> e.get(0)+e.get(1)+e.get(2)).collect(Collectors.groupingBy(
            Function.identity(),
            Collectors.counting()));


    System.out.println(comb);
  }
*/

  public long part2iterativo(int startPos0, int startPos1) {

    List<PosPuntiTimes> l = new ArrayList<>();
    l.add(new PosPuntiTimes(startPos0, 0, 1, startPos1, 0));

    long[] wins = {0, 0};

    int turn = -1;
    while (!l.isEmpty()) {
      turn++;
      List<PosPuntiTimes> n = new ArrayList<>();
      for (PosPuntiTimes p : l)
        for (int i = 3; i < 10; i++) {
          PosPuntiTimes h;
          int punti;
          if (turn % 2 == 0) {
            int pos = ((p.pos - 1 + i) % 10) + 1;
            punti = p.punt + pos;
            h = new PosPuntiTimes(pos, punti, p.times * timesM[i], p.pos1, p.punt1);
          } else {
            int pos = ((p.pos1 - 1 + i) % 10) + 1;
            punti = p.punt1 + pos;
            h = new PosPuntiTimes(p.pos, p.punt, p.times * timesM[i], pos, punti);
          }
          if (punti >= 21) {
            wins[turn % 2] += h.times;
          } else
            n.add(h);
        }
      l = n;
    }
    return  Math.max(wins[0], wins[1]);
  }

  @Override
  protected String part1() {
    // very simple parser
    var input = inputAsList();
    int[] positions = {
        Integer.parseInt(input.get(0).substring(28)),
        Integer.parseInt(input.get(1).substring(28))
    };

    int[] points = {0, 0};
    int turn = 0;
    int counter = 0;
    int firstDiceValue = 1; // si potrebbe eliminare in favore di counter (non serve operazione modulo)

    while (points[0] < 1000 && points[1] < 1000) {
      positions[turn] = newPos(positions[turn], (firstDiceValue + 1) * 3);
      points[turn] += positions[turn];
      firstDiceValue = (firstDiceValue + 3) % 100;
      counter += 3;
      turn = (turn + 1) % 2;
    }

    return "" + counter * Math.min(points[0], points[1]);
  }

  int newPos(int old, int roll) {
    return ((old - 1 + roll) % 10) + 1;
  }

  @Override
  protected String part2() {
    List<String> input = inputAsList();
    int[] positions = {
        Integer.parseInt(input.get(0).substring(28)),
        Integer.parseInt(input.get(1).substring(28))
    };

    long wins0 = 0;
    long wins1 = 0;

    for (int j = 3; j <= 9; j++) {
      WinsCounter x = play(0, positions[0], positions[1], 0, 0, j);
      wins0 += timesM[j] * x.p0;
      wins1 += timesM[j] * x.p1;
    }

    return "" + Math.max(wins0, wins1);
  }

  private WinsCounter play(int turn, int pos0, int pos1, int point0, int point1, int roll) {
    if (turn % 2 == 0) {
      pos0 = newPos(pos0, roll);
      point0 += pos0;
      if (point0 >= 21) return new WinsCounter(1, 0);
    } else {
      pos1 = newPos(pos1, roll);
      point1 += pos1;
      if (point1 >= 21) return new WinsCounter(0, 1);
    }
    turn++;
    long counter0 = 0;
    long counter1 = 0;
    for (int newRoll = 3; newRoll <= 9; newRoll++) {
      WinsCounter wins = play(turn, pos0, pos1, point0, point1, newRoll);
      counter0 += timesM[newRoll] * wins.p0;
      counter1 += timesM[newRoll] * wins.p1;
    }
    return new WinsCounter(counter0, counter1);
  }


  public record PosPuntiTimes(int pos, int punt, long times, int pos1, int punt1) {
  }

  public record WinsCounter(long p0, long p1) {
  }
}
