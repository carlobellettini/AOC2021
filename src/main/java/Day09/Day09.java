package Day09;

import Day00.Day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

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
      mat[i] = Arrays.stream(input.get(i).split("")).mapToInt(Integer::parseInt).toArray();
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
}
