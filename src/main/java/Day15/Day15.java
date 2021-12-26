package day15;

import day00.Day;
import day00.Mat;
import org.jetbrains.annotations.NotNull;

import java.util.List;

class Mat15 extends Mat {
  public Mat15() {}

  public Mat15(int r, int c) {
    super(r,c);
  }

  @NotNull Mat15 calculateRisks() {
    Mat15 risk = new Mat15(rows(),columns());

    risk.mat[0][0] = 1;
    boolean finito = false;

    while (!finito) {
      finito = true;
      for (int r = 0; r < rows(); r++)
        for (int c = 0; c < columns(); c++)
          for (CelleVicine d : CelleVicine.values())
            if (risk.valida(d, r, c) && risk.valore(d, r, c) > 0)
              if (risk.mat[r][c] == 0 ||
                  risk.valore(d, r, c) + this.mat[r][c] < risk.mat[r][c]) {
                risk.mat[r][c] = risk.valore(d, r, c) + this.mat[r][c];
                finito = false;
              }
    }

    return risk;
  }

  public int getFinalRisk() {
    return mat[rows-1][cols-1] - 1;
  }

  @NotNull Mat15 growByFactor(int factor) {
    Mat15 mat = new Mat15(rows() * factor, columns() * factor);

    for (int i = 0; i < factor; i++)
      for (int j = 0; j < factor; j++)
        for (int r = 0; r < rows; r++)
          for (int c = 0; c < cols; c++)
            mat.mat[i * rows + r][j * cols + c] =
                (this.mat[r][c] + i + j) > 9 ?
                ((this.mat[r][c] + i + j) % 10) + 1 :
                (this.mat[r][c] + i + j);

    return mat;
  }
}

public class Day15 extends Day {
  @Override
  protected String part1(List<String> input) {
    Mat15 mat = new Mat15();
    mat.readFrom(input);

    Mat15 risk = mat.calculateRisks();
    return String.valueOf(risk.getFinalRisk());
  }

  @Override
  protected String part2(List<String> input) {
    Mat15 mat = new Mat15();
    mat.readFrom(input);

    mat = mat.growByFactor(5);


    Mat15 risk = mat.calculateRisks();
    return String.valueOf(risk.getFinalRisk());
  }
}
