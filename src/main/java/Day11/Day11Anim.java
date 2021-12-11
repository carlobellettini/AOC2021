package Day11;

import Day00.Day;
import Day00.Mat;


public class Day11Anim extends Day {

  public static void main(String[] args) {
    Day d = new Day11();
    System.out.println(Mat.ANSI_CLS);
    d.part1("input.txt");
  }


  @Override
  protected String part1() {
    Mat11 m = new Mat11();
    m.readFrom(inputAsList());


    long flashed = 0;
    for (int i = 0; i < 100; i++) {
      System.out.printf(Mat.ANSI_POS + Mat.ANSI_NORMAL + "%03d", 1, 3, i + 1);
      flashed += m.step();
    }

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


class Mat11Anim extends Mat {

  @Override
  public String elemFormat(int anInt) {
    if (anInt % 10 != 0)
      return String.format(ANSI_BG_COLOR + " ", 232 + (anInt - 1) * 3);
    else
      return String.format(ANSI_BG_COLOR + " ", 11);
  }

  public void stampaElem(int r, int c) {
    System.out.printf(ANSI_POS, r + 3, c + 3);
    System.out.print(elemFormat(mat[r][c]));
    try {
      Thread.sleep(0, 50);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void stampa(int delay) {
    System.out.println(ANSI_HOME);
    super.stampa(delay);
  }

  long step() {
    long flashed = 0;

    for (int r = 0; r < rows(); r++)
      for (int c = 0; c < columns(); c++) {
        mat[r][c]++;
        stampaElem(r, c);
      }
    //@ANIM stampa(50);
    for (int r = 0; r < rows(); r++)
      for (int c = 0; c < columns(); c++)
        if (mat[r][c] > 9)
          flashed += flash(r, c);

    return flashed;
  }

  private long flash(int r, int c) {
    long flashed = 1;
    mat[r][c] = 0;
    stampaElem(r, c);
    for (CelleVicineEDiag d : CelleVicineEDiag.values()) {
      if (valide(r + d.r, c + d.c) &&
          mat[r + d.r][c + d.c] != 0) {
        mat[r + d.r][c + d.c]++;
        stampaElem(r + d.r, c + d.c);
        //@ANIM stampa(3);
        if (mat[r + d.r][c + d.c] > 9)
          flashed += flash(r + d.r, c + d.c);
      }
    }
    return flashed;
  }
}
