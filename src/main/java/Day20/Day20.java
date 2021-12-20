package Day20;

import Day00.Day;
import Day00.Mat;
import org.jetbrains.annotations.NotNull;

import java.util.List;

class Mat20 extends Mat {

  public Mat20(int r, int c) {
    super(r, c);
  }

  public Mat20() {
  }

  static int[][] deepCopy(int[][] matrix) {
    return java.util.Arrays.stream(matrix).map(int[]::clone).toArray($ -> matrix.clone());
  }

  public long conta1() {
    long counter = 0;
    for (int i = 0; i < rows; i++)
      for (int j = 0; j < cols; j++) counter += mat[i][j];
    return counter;
  }

  public void step(String algo) {
    Mat20 copy = new Mat20();
    copy.mat = deepCopy(this.mat);
    copy.rows = rows;
    copy.cols = cols;

    for (int r = 0; r < rows; r++)
      for (int c = 0; c < cols; c++) {
        StringBuilder bin = new StringBuilder();
        for (QuadratoCelle d : QuadratoCelle.values())
          bin.append(valida(d, r, c) ? (copy.valore(d, r, c) == 0 ? '0' : '1') : (mat[r][c] == 0 ? '0' : '1'));
        int binNum = Integer.parseInt(bin.toString(), 2);
        mat[r][c] = algo.charAt(binNum) == '#' ? 1 : 0;
      }
  }
}


public class Day20 extends Day {
  @Override
  protected String part1() {
    int numsteps = 2;

    List<String> input = inputAsList();
    String algo = input.get(0);

    Mat20 g = readMat(numsteps + 1, input);

    for (int i = 0; i < numsteps; i++) g.step(algo);

    return String.valueOf(g.conta1());
  }

  @Override
  protected String part2() {
    int numsteps = 50;

    List<String> input = inputAsList();
    String algo = input.get(0);

    Mat20 g = readMat(numsteps + 1, input);

    for (int i = 0; i < numsteps; i++) g.step(algo);

    return String.valueOf(g.conta1());
  }

  @NotNull
  private Mat20 readMat(int over, List<String> input) {
    Mat20 g = new Mat20(input.size() - 2 + over * 2, input.get(2).length() + over * 2);

    for (int r = 0; r < input.size() - 2; r++)
      for (int c = 0; c < input.get(2).length(); c++)
        g.mat[r + over][c + over] = input.get(r + 2).charAt(c) == '#' ? 1 : 0;
    return g;
  }
}
