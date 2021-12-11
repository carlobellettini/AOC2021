package Day00;

import java.util.List;
import java.util.stream.Stream;

public class Mat {
  public static final String ANSI_CLS = "\u001b[2J";
  public static final String ANSI_POS ="\033[%d;%dH";
  public static final String ANSI_HOME = "\u001b[H";
  public static final String ANSI_BOLD = "\u001b[1m";
  public static final String ANSI_AT55 = "\u001b[10;10H";
  public static final String ANSI_REVERSEON = "\u001b[7m";
  public static final String ANSI_NORMAL = "\u001b[0m";
  public static final String ANSI_BG_COLOR = "\u001b[48;5;%dm";

  public enum CelleVicine {
    UP(-1,0),
    LEFT(0,-1),
    RIGHT(0,1),
    DOWN(1,0);

    final public int r;
    final public int c;

    CelleVicine(int r, int c) {
      this.r = r;
      this.c = c;
    }
  }

  public enum CelleVicineEDiag {
    UPLEFT(-1,-1),
    UP(-1,0),
    UPRIGHT(-1,1),
    LEFT(0,-1),
    RIGHT(0,1),
    DOWNLEFT(1,-1),
    DOWN(1,0),
    DOWNRIGHT(1,1);

    final public int r;
    final public int c;

    CelleVicineEDiag(int r, int c) {
      this.r = r;
      this.c = c;
    }
  }

  protected int[][] mat;

  public void readFrom(List<String> input) {
    mat = new int[input.size()][];
    for (int i = 0; i < input.size(); i++) {
      mat[i] = Stream.of(input.get(i).split("")).mapToInt(Integer::parseInt).toArray();
    }
  }

  public int rows() {
    assert mat != null;
    return mat.length;
  }

  public int columns() {
    assert mat != null && mat[0] != null;
    return mat[0].length;
  }


  public void stampa(int delay) {
    for (int[] ints : mat) {
      for (int anInt : ints) {
        System.out.print(elemFormat(anInt));
      }
      System.out.println();
    }
    if (delay>0) {
      try {
        Thread.sleep(delay);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  public String elemFormat(int anInt) {
      return String.valueOf(anInt % 10);
  }

  public boolean valide(int r, int c) {
    return r >= 0 && r < rows() && c >= 0 && c < columns();
  }

}
