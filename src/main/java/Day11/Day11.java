package Day11;

import Day00.Day;
import Day00.Mat;


public class Day11 extends Day {

  @Override
  protected String part1() {
    Mat11 m = new Mat11();
    m.readFrom(inputAsList());

    long flashed = 0;
    for (int i = 0; i < 100; i++)
      flashed += m.step();
    return String.valueOf(flashed);
  }

  @Override
  protected String part2() {
    Mat11 m = new Mat11();
    m.readFrom(inputAsList());

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
    for (CelleVicineEDiag d : CelleVicineEDiag.values())
      if (valide(r + d.r, c + d.c) &&
          mat[r + d.r][c + d.c] != 0) {
        mat[r + d.r][c + d.c]++;
        if (mat[r + d.r][c + d.c] > 9)
          flashed += flash(r + d.r, c + d.c);
      }
    return flashed;
  }
}
