package day25;

import day00.Day;
import day00.Mat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

// . 46
// > 118
// v 62

class Mat25 extends Mat {
  static int[][] deepCopy(int[][] matrix) {
    return Arrays.stream(matrix).map(int[]::clone).toArray($ -> matrix.clone());
  }

  @Override
  public String elemFormat(int anInt) {
    return switch (anInt) {
      case '>' -> ">";
      case 'v' -> "v";
      case '.' -> ".";
      default -> "H";
    };
  }

  @Override
  public void readFrom(List<String> input) {
    mat = new int[input.size()][];
    for (int i = 0; i < input.size(); i++) {
      mat[i] = Stream.of(input.get(i).split("")).mapToInt(c -> c.charAt(0)).toArray();
    }
    rows = mat.length;
    cols = mat[0].length;
  }

  boolean step() {
    int[][] prev = deepCopy(mat);
    boolean moved = false;
    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {
        if (prev[r][c] == '>' && prev[r][(c + 1) % cols] == '.') {
          mat[r][c] = '.';
          mat[r][(c + 1) % cols] = '>';
          moved = true;
        }
      }
    }
    prev = deepCopy(mat);
    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {
        if (prev[r][c] == 'v' && prev[(r+1)%rows][c] == '.') {
          mat[r][c] = '.';
          mat[(r+1)%rows][c] = 'v';
          moved = true;
        }
      }
    }
    return moved;
  }
}

public class Day25 extends Day {
  @Override
  protected String part1(List<String> input) {
    Mat25 m = new Mat25();
    m.readFrom(input);

    long counter = 1;
    while (m.step()) {
      counter++;
    }
    return String.valueOf(counter);
  }
}
