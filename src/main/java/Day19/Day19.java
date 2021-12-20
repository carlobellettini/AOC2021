package Day19;

import static java.lang.Math.abs;
import static java.lang.Math.max;

import org.paukov.combinatorics3.Generator;

import java.io.InputStream;
import java.util.*;
import java.util.stream.Stream;


public class Day19 {
  static private final List<List<Integer>> comb = Generator.permutation(0, 1, 2).simple().stream().toList();
  private final HashMap<Coord, List<MatRighe>> mappa = new HashMap<>();
  String input = "input.txt";
  private Mat[] scannersBeacons;
  private Coord[] scannersPos;

  public void common_start() {
    readInput();
    normalizzaCoordinate();
  }

  public int part_1() {
    return numberOfBeacons();
  }

  public int part_2() {
    return maxManhattanDistance();
  }

  private void readInput() {
    InputStream inputStream = getClass().getResourceAsStream(input);
    assert inputStream != null : "error in reading resource " + input;
    Scanner sc = new Scanner(inputStream);
    sc.useDelimiter("--- scanner [0123456789]* ---\n");
    int scan = 0;
    List<Mat> list = new ArrayList<>();
    while (sc.hasNext()) {
      String scannerBeacons = sc.next();
      Mat m = new Mat();
      m.readFromCVS(List.of(scannerBeacons.split("\n")));
      list.add(m);
    }
    scannersBeacons = list.toArray((value) -> new Mat[value]);
  }

  private void normalizzaCoordinate() {
    scannersPos = new Coord[scannersBeacons.length];
    scannersPos[0] = new Coord(0, 0, 0);
    boolean finito = false;
    while (!finito) {
      finito = true;
      for (int j = 0; j < scannersBeacons.length; j++)
        for (int i = 0; i < scannersBeacons.length; i++)
          if (i != j && scannersPos[j] != null && scannersPos[i] == null)
            for (List<Integer> rot : comb) {
              mappa.clear();
              confrontaRuotato(j, List.of(0, 1, 2));
              confrontaRuotato(i, rot);
              var x = mappa.values().stream()
                  .filter(entry -> entry.size() > 1)
                  .toList();
              if (x.size() >= 12) { //match
                finito = false;

                ruota(i, rot);

                Delta dx = getDelta(x, 0);
                Delta dy = getDelta(x, 1);
                Delta dz = getDelta(x, 2);

                trasla(x.get(0).get(1).scanner, dx, dy, dz);
                scannersPos[i] = new Coord(dx.offset, dy.offset, dz.offset);
              }
            }
    }
  }

  private void trasla(int scanner, Delta dx, Delta dy, Delta dz) {
    for (int i = 0; i < scannersBeacons[scanner].rows(); i++) {
      scannersBeacons[scanner].mat[i][0] = scannersBeacons[scanner].mat[i][0] * (dx.neg ? -1 : 1) + dx.offset;
      scannersBeacons[scanner].mat[i][1] = scannersBeacons[scanner].mat[i][1] * (dy.neg ? -1 : 1) + dy.offset;
      scannersBeacons[scanner].mat[i][2] = scannersBeacons[scanner].mat[i][2] * (dz.neg ? -1 : 1) + dz.offset;
    }
  }

  private Delta getDelta(List<List<MatRighe>> x, int coord) {
    List<MatRighe> A = x.get(0);
    Mat beacon0 = scannersBeacons[A.get(0).scanner];
    Mat beacon1 = scannersBeacons[A.get(1).scanner];
    var DX = max(beacon0.mat[A.get(0).row1][coord], beacon0.mat[A.get(0).row2][coord]) -
        max(beacon1.mat[A.get(1).row1][coord], beacon1.mat[A.get(1).row2][coord]);
    var DXN = max(beacon0.mat[A.get(0).row1][coord], beacon0.mat[A.get(0).row2][coord]) -
        max(-beacon1.mat[A.get(1).row1][coord], -beacon1.mat[A.get(1).row2][coord]);

    A = x.get(1);
    beacon0 = scannersBeacons[A.get(0).scanner];
    beacon1 = scannersBeacons[A.get(1).scanner];

    var DXB = max(beacon0.mat[A.get(0).row1][coord], beacon0.mat[A.get(0).row2][coord]) -
        max(beacon1.mat[A.get(1).row1][coord], beacon1.mat[A.get(1).row2][coord]);

    return DX == DXB ? new Delta(DX, false) : new Delta(DXN, true);
  }

  void ruota(int scanner, List<Integer> rot) {
    for (int i = 0; i < scannersBeacons[scanner].rows(); i++) {
      int[] temp = new int[3];
      System.arraycopy(scannersBeacons[scanner].mat[i], 0, temp, 0, 3);
      for (int j = 0; j < 3; j++) scannersBeacons[scanner].mat[i][j] = temp[rot.get(j)];
    }
  }

  private void confrontaRuotato(int pos, List<Integer> rot) {
    Mat s1 = scannersBeacons[pos];
    for (int i = 0; i < s1.rows(); i++) {
      for (int j = i + 1; j < s1.rows(); j++) {
        Coord delta = new Coord(abs(abs(s1.mat[i][rot.get(0)]) - abs(s1.mat[j][rot.get(0)])),
            abs(abs(s1.mat[i][rot.get(1)]) - abs(s1.mat[j][rot.get(1)])),
            abs(abs(s1.mat[i][rot.get(2)]) - abs(s1.mat[j][rot.get(2)]))
        );
        List<MatRighe> lista;
        if (!mappa.containsKey(delta)) {
          lista = new ArrayList<>();
          mappa.put(delta, lista);
        } else {
          lista = mappa.get(delta);
        }
        lista.add(new MatRighe(pos, i, j));
      }
    }
  }

  private int numberOfBeacons() {
    Set<Coord> beacons = new HashSet<>();
    for (Mat scanner : scannersBeacons)
      for (int j = 0; j < scanner.rows(); j++)
        beacons.add(new Coord(scanner.mat[j]));
    return beacons.size();
  }

  private int maxManhattanDistance() {
    int distance = 0;
    for (int i = 0; i < scannersPos.length; i++)
      for (int j = i + 1; j < scannersPos.length; j++) {
        int dist = abs(scannersPos[i].x - scannersPos[j].x) +
            abs(scannersPos[i].y - scannersPos[j].y) +
            abs(scannersPos[i].z - scannersPos[j].z);
        if (dist > distance)
          distance = dist;
      }
    return distance;
  }

  public record Coord(int x, int y, int z) {
    public Coord(int[] c) {
      this(c[0], c[1], c[2]);
    }
  }

  public record MatRighe(int scanner, int row1, int row2) {
  }

  public record Delta(int offset, boolean neg) {
  }
}

class Mat {
  int[][] mat;
  private int cols;
  private int rows;

  public int cols() {
    return cols;
  }

  public int rows() {
    return rows;
  }

  public void readFromCVS(List<String> input) {
    mat = new int[input.size()][];
    for (int i = 0; i < input.size(); i++)
      mat[i] = Stream.of(input.get(i).split(",")).mapToInt(Integer::parseInt).toArray();
    rows = mat.length;
    cols = mat[0].length;
  }
}
