package Day09;

import Day00.Day;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.Stream;

public class Day09 extends Day {
  @Override
  protected String part1() {
    List<String> input = inputAsList();

    int rows = input.size();
    int cols = input.get(0).length();
    int[][] mat = readMatrix(input, rows);

    int riskLevel = 0;
    for (int r = 0; r < rows; r++)
      for (int c = 0; c < cols; c++)
        if (minimo(mat, r, c, rows, cols))
          riskLevel += mat[r][c] + 1;

    return "" + riskLevel;
  }


  @Override
  protected String part2() {
    String ans1 = part2_recursive();
    String ans2 = part2_iterative();

    assert (ans1.equals(ans2));

    return ans1;
  }

  private String part2_recursive() {
    List<String> input = inputAsList();

    int rows = input.size();
    int cols = input.get(0).length();

    int[][] mat = readMatrix(input, rows);

    List<Integer> basins = new ArrayList<>();

    for (int r = 0; r < rows; r++)
      for (int c = 0; c < cols; c++)
        if (minimo(mat, r, c, rows, cols))
          basins.add(calBasin(mat, r, c, rows, cols));

    basins.sort(Comparator.reverseOrder());

    assert (basins.size() >= 3);
    return "" + (basins.get(0) * basins.get(1) * basins.get(2));
  }

  private int[][] readMatrix(List<String> input, int rows) {
    int[][] mat = new int[rows][];

    for (int i = 0; i < input.size(); i++) {
      mat[i] = Stream.of(input.get(i).split("")).mapToInt(Integer::parseInt).toArray();
    }
    return mat;
  }

  private boolean minimo(int[][] mat, int r, int c, int rows, int cols) {
    int cella = mat[r][c];
    return (r <= 0 || mat[r - 1][c] > cella) &&
        (c <= 0 || mat[r][c - 1] > cella) &&
        ((r >= rows - 1) || mat[r + 1][c] > cella) &&
        ((c >= cols - 1) || mat[r][c + 1] > cella);
  }

  private int calBasin(int[][] mat, int r, int c, int rows, int cols) {
    if (r < 0 || c < 0 || r >= rows || c >= cols) return 0;
    if (mat[r][c] == 9 || mat[r][c] == -1) return 0;

    mat[r][c] = -1;
    return 1 +
        calBasin(mat, r - 1, c, rows, cols) +
        calBasin(mat, r, c - 1, rows, cols) +
        calBasin(mat, r + 1, c, rows, cols) +
        calBasin(mat, r, c + 1, rows, cols);
  }

  private  String part2_iterative() {
    List<String> input = inputAsList();

    int rows = input.size();
    int cols = input.get(0).length();
    int[][] mat = readMatrix(input, rows);

    int biasinNum = marcaMinimi(rows, cols, mat);

    espandiMinimiABacini(rows, cols, mat);

    int[] biasinSizes = calcolaDimensioneBacini(rows, cols, mat, biasinNum);

    int[] sol = Arrays.stream(biasinSizes).boxed().sorted(Comparator.reverseOrder()).mapToInt(e-> e).toArray();
    return ""+(sol[0]*sol[1]*sol[2]);
  }

  private int[] calcolaDimensioneBacini(int rows, int cols, int[][] mat, int biasinNum) {
    int [] biasinSizes = new int[biasinNum];
    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {
        if (mat[r][c] != 9)
          biasinSizes[-mat[r][c]]++;
      }
    }
    return biasinSizes;
  }

  private void espandiMinimiABacini(int rows, int cols, int[][] mat) {
    boolean modificata = true;
    while (modificata) {
      modificata = false;
      for (int r = 0; r < rows; r++)
        for (int c = 0; c < cols; c++)
          if (mat[r][c] != 9 && mat[r][c] > 0) {
            Optional<Integer> biasin = adiacenteABiasin(mat, r, c, rows, cols);
            if (biasin.isPresent()) {
              mat[r][c] = biasin.get();
              modificata = true;
            }
          }
    }
  }

  private int marcaMinimi(int rows, int cols, int[][] mat) {
    int biasinNum = 1;
    for (int r = 0; r < rows; r++)
      for (int c = 0; c < cols; c++)
        if (minimo(mat, r, c, rows, cols))
          mat[r][c] = -(biasinNum++);
    return biasinNum;
  }

  private Optional<Integer> adiacenteABiasin(int[][] mat, int r, int c, int rows, int cols) {
    if (r > 0 && mat[r - 1][c] < 0) return Optional.of(mat[r - 1][c]);
    if (c > 0 && mat[r][c - 1] < 0) return Optional.of(mat[r][c - 1]);
    if (r < rows - 1 && mat[r + 1][c] < 0) return Optional.of(mat[r + 1][c]);
    if (c < cols - 1 && mat[r][c + 1] < 0) return Optional.of(mat[r][c + 1]);
    return Optional.empty();
  }
}
