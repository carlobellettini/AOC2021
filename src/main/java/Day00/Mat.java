package day00;

import java.util.List;
import java.util.stream.Stream;

public class Mat {
  public static final String ANSI_CLS = "\u001b[2J";
  public static final String ANSI_POS = "\033[%d;%dH";
  public static final String ANSI_HOME = "\u001b[H";
  public static final String ANSI_BOLD = "\u001b[1m";
  public static final String ANSI_AT55 = "\u001b[10;10H";
  public static final String ANSI_REVERSEON = "\u001b[7m";
  public static final String ANSI_NORMAL = "\u001b[0m";
  public static final String ANSI_BG_COLOR = "\u001b[48;5;%dm";
  public static final String ANSI_FG_COLOR = "\u001b[38;5;%dm";
  public int[][] mat;

  protected int cols;
  protected int rows;

  public int rows() {
    return rows;
  }
  public int columns() {
    return cols;
  }

  public Mat() {
  }

  public Mat( int rows, int cols) {
    this.cols = cols;
    this.rows = rows;
    mat = new int[rows][cols];
  }

  public void readFrom(List<String> input) {
    mat = new int[input.size()][];
    for (int i = 0; i < input.size(); i++) {
      mat[i] = Stream.of(input.get(i).split("")).mapToInt(Integer::parseInt).toArray();
    }
    rows = mat.length;
    cols = mat[0].length;
  }

  public void readFromCVS(List<String> input) {
    mat = new int[input.size()][];
    for (int i = 0; i < input.size(); i++) {
      mat[i] = Stream.of(input.get(i).split(",")).mapToInt(Integer::parseInt).toArray();
    }
    rows = mat.length;
    cols = mat[0].length;
  }


  public void stampa(int delay) {

    for (int r = 0; r < rows(); r++) {
      for (int c = 0; c < columns(); c++) {
        System.out.print(elemFormat(mat[r][c]));
      }
      System.out.println();
    }
    if (delay > 0) {
      try {
        Thread.sleep(delay);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  public String elemFormat(int anInt) {
    return String.format("%d", anInt % 10);
  }

  public boolean valida(int r, int c) {
    return r >= 0 && r < rows() && c >= 0 && c < columns();
  }

  public boolean valida(CelleVicineEDiag d, int r, int c) {
    return r + d.r >= 0 && r + d.r < rows() && c + d.c >= 0 && c + d.c < columns();
  }

  public boolean valida(CelleVicine d, int r, int c) {
    return r + d.r >= 0 && r + d.r < rows() && c + d.c >= 0 && c + d.c < columns();
  }

  public boolean valida(QuadratoCelle d, int r, int c) {
    return r + d.r >= 0 && r + d.r < rows() && c + d.c >= 0 && c + d.c < columns();
  }

  public int valore(CelleVicineEDiag v, int r, int c) {
    return mat[r + v.r][c + v.c];
  }

  public int valore(CelleVicine v, int r, int c) {
    return mat[r + v.r][c + v.c];
  }

  public int valore(QuadratoCelle v, int r, int c) {
    return mat[r + v.r][c + v.c];
  }

  public enum CelleVicine {
    UP(-1, 0),
    RIGHT(0, 1),
    DOWN(1, 0),
    LEFT(0, -1);

    final public int r;
    final public int c;

    CelleVicine(int r, int c) {
      this.r = r;
      this.c = c;
    }

    static public CelleVicine of(int i) {
      assert i >= 0 && i < 4;
      return CelleVicine.values()[i];
    }

    CelleVicine rotateCW() {
      return of((this.ordinal() + 1) % 4);
    }
  }

  public enum CelleVicineEDiag {
    UPLEFT(-1, -1),
    UP(-1, 0),
    UPRIGHT(-1, 1),
    RIGHT(0, 1),
    DOWNRIGHT(1, 1),
    DOWN(1, 0),
    DOWNLEFT(1, -1),
    LEFT(0, -1);

    final public int r;
    final public int c;

    CelleVicineEDiag(int r, int c) {
      this.r = r;
      this.c = c;
    }

    static public CelleVicineEDiag of(int i) {
      assert i >= 0 && i < 8;
      return CelleVicineEDiag.values()[i];
    }

    CelleVicineEDiag rotateCW() {
      return of((this.ordinal() + 1) % 8);
    }

    public boolean valida(int r, int c, Mat m) {
      return r + this.r >= 0 && r + this.r < m.rows() &&
          c + this.c >= 0 && c + this.c < m.columns();
    }
  }

  public enum QuadratoCelle {
    UPLEFT(-1, -1),
    UP(-1, 0),
    UPRIGHT(-1, 1),
    LEFT(0, -1),
    CENTER(0,0),
    RIGHT(0, 1),
    DOWNLEFT(1, -1),
    DOWN(1, 0),
    DOWNRIGHT(1, 1);

    final public int r;
    final public int c;

    QuadratoCelle(int r, int c) {
      this.r = r;
      this.c = c;
    }

    static public QuadratoCelle of(int i) {
      assert i >= 0 && i < 8;
      return QuadratoCelle.values()[i];
    }

    QuadratoCelle rotateCW() {
      return of((this.ordinal() + 1) % 8);
    }

    public boolean valida(int r, int c, Mat m) {
      return r + this.r >= 0 && r + this.r < m.rows() &&
          c + this.c >= 0 && c + this.c < m.columns();
    }
  }

}
