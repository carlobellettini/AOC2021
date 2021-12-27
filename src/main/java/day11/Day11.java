package day11;

import day00.Day;
import day00.Mat;

import java.util.List;
import java.util.stream.IntStream;

public class Day11 extends Day {

  @Override
  protected String part1(List<String> input) {
    Mat11 m = new Mat11();
    m.readFrom(input);

    long flashed = IntStream.range(0, 100).mapToLong(i -> m.step()).sum();
    return String.valueOf(flashed);
  }

  @Override
  protected String part2(List<String> input) {
    Mat11 m = new Mat11();
    m.readFrom(input);

    int iterazioni = 0;
    long flashed;
    do {
      flashed = m.step();
      iterazioni++;
    } while (flashed != m.rows() * m.columns());

    return String.valueOf(iterazioni);
  }
}

class Mat11 extends Mat {
  long step() {
    long flashed = 0;
    for (int r = 0; r < rows(); r++)
      for (int c = 0; c < columns(); c++)
        mat[r][c]++;
    for (int r = 0; r < rows(); r++)
      for (int c = 0; c < columns(); c++)
        if (mat[r][c] > 9)
          flashed += flash(r, c);
    return flashed;
  }

  private long flash(int r, int c) {
    long flashed = 1;
    mat[r][c] = 0;
    for (CelleVicineEDiag vicina : CelleVicineEDiag.values())
      if (valida(vicina, r, c) && valore(vicina, r, c) != 0) {
        mat[r + vicina.r][c + vicina.c]++;
        if (valore(vicina, r, c) > 9)
          flashed += flash(r + vicina.r, c + vicina.c);
      }
    return flashed;
  }
}
