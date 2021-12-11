package Day05;



import org.jetbrains.annotations.NotNull;


import java.util.HashMap;
import java.util.Map;


public class Griglia {
  final private Map<Point, Integer> gridMap = new HashMap<>();
  final private boolean diag;

  public Griglia(boolean diag) {
    this.diag = diag;
  }

  void addLine(@NotNull String line) {
    //Line l = readString(line, "%d,%d -> %d,%d", Line.class);
    //addLine(l.xStart, l.yStart, l.xEnd, l.yEnd);
    String[] points = line.split(" -> ");
    addLine(Integer.parseInt(points[0].split(",")[0]),
        Integer.parseInt(points[0].split(",")[1]),
        Integer.parseInt(points[1].split(",")[0]),
        Integer.parseInt(points[1].split(",")[1]));
  }

  void addLine(int x1, int y1, int x2, int y2) {
    int xmin = Math.min(x1, x2);
    int xmax = Math.max(x1, x2);
    int ymin = Math.min(y1, y2);
    int ymax = Math.max(y1, y2);

    if (x1 == x2)
      for (int y = ymin; y <= ymax; y++) incPoint(x1, y);
    else if (y1 == y2)
      for (int x = xmin; x <= xmax; x++) incPoint(x, y1);
    else if (diag) {
      int ystart = ymin;
      int ydir = 1;

      if (!sameDirection(x1, y1, x2, y2)) {
        ystart = ymax;
        ydir = -1;
      }

      for (int i = 0; i <= xmax - xmin; i++) {
        incPoint(
            xmin + i,
            ystart + i * ydir);
      }
    }
  }

  private boolean sameDirection(int x1, int y1, int x2, int y2) {
    return x2 - x1 == y2 - y1;
    //return (x1 < x2 && y1 < y2) || (x1 > x2 && y1 > y2);
  }

  private void incPoint(int x, int y) {
    Point point = new Point(x, y);
    gridMap.put(point, gridMap.getOrDefault(point, 0) + 1);
  }

  long contaIncroci() {
    return gridMap.values().stream().filter(value -> value > 1).count();
  }

  public record Point(int x, int y) {
  }

  public record Line(int xStart, int yStart, int xEnd, int yEnd){}
}
