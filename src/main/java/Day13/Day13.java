package day13;

import static java.lang.Character.isDigit;
import static java.lang.Integer.parseInt;

import day00.Day;
import day00.Mat;

import java.util.List;

class Mat13 extends Mat {

  public Mat13() {
  }


  public void readFromCVS(List<String> input) {
    var m = input.stream().map(l -> l.split(","))
        .filter(a -> a[0].length() > 0 && isDigit(a[0].charAt(0))).map(a -> new int[]{parseInt(a[0]), parseInt(a[1])})
        .reduce((a, b) -> new int[]{Math.max(a[0], b[0]), Math.max(a[1], b[1])}).get();

    cols = m[0] + 1;
    rows = m[1] + 1;
    mat = new int[rows][cols];

    for (String line : input) {
      if (line.length() > 0 && isDigit(line.charAt(0))) {
        String[] coord = line.split(",");
        mat[parseInt(coord[1])][parseInt(coord[0])] = 1;
      }
    }
  }


  @Override
  public String elemFormat(int anInt) {
    if (anInt > 0)
      return String.format(ANSI_BG_COLOR + ANSI_FG_COLOR + "#" + ANSI_NORMAL, 232, 232);
    else
      return String.format(ANSI_BG_COLOR + ANSI_FG_COLOR + "." + ANSI_NORMAL, 255, 255);
  }

  public void fold(char dir, int val) {
    if (dir == 'y') {
      for (int i = 1; i < rows - val; i++)
        for (int c = 0; c < cols; c++)
          mat[val - i][c] += mat[val + i][c];
      rows = val;
    }
    if (dir == 'x') {
      for (int i = 1; i < cols - val; i++)
        for (int r = 0; r < rows; r++)
          mat[r][val - i] += mat[r][val + i];
      cols = val;
    }
  }

   long contaBuchi() {
    long counter = 0;
    for (int i = 0; i < rows; i++)
      for (int j = 0; j < cols; j++)
        if (mat[i][j] > 0)
          counter++;
    return counter;
  }
}

public class Day13 extends Day {
  @Override
  protected String part1() {

    List<String> input = inputAsList();

    Mat13 m = new Mat13();
    m.readFromCVS(input);

    for (String line : input) {
      if (line.startsWith("fold")) {
        String[] istr = line.substring(11).split("=");
        m.fold(istr[0].charAt(0), parseInt(istr[1]));
        break;
      }
    }

    return "" + m.contaBuchi();
  }

  @Override
  protected String part2() {

    List<String> input = inputAsList();

    Mat13 m = new Mat13();
    m.readFromCVS(input);

    for (String line : input) {
      if (line.startsWith("fold")) {
        String[] istr = line.substring(11).split("=");
        m.fold(istr[0].charAt(0), parseInt(istr[1]));
      }
    }

    m.stampa(0);
    return "Cosa leggi?";
  }
}
