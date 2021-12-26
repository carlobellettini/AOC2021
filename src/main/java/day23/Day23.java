package day23;

import day00.Day;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Day23 extends Day {

  final private PriorityQueue<Node> pq = new PriorityQueue<>(10000);
  final private Map<State, Integer> dist = new HashMap<>();

  private State readState(List<String> input) {
    int dimension = input.size()- 3;
    char[][] h = new char[dimension][4];
    for (int r = 0; r < dimension; r++) {
      String l = input.get(2 + r).replaceAll("#", "").replaceAll(" ", "");
      for (int c = 0; c < 4; c++) {
        h[r][c] = l.charAt(c);
      }
    }

    return new State(
        new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
        h);
  }

  public int dijkstra(State src) {
    pq.add(new Node(src,0));
    dist.put(src,0);

    while (!pq.isEmpty()) {
      Node nu = pq.remove();
      State u = nu.s();
      int energy = nu.energy();

      if (u.targetOK()) {
        return nu.energy();
      }

      for (Node nextNode : u.nextStates(energy)) {
        if (nextNode.energy() < dist.getOrDefault(nextNode.s(), Integer.MAX_VALUE)) {
          dist.put(nextNode.s(), nextNode.energy());
          pq.add(nextNode);
        }
      }
    }
    throw new IllegalStateException("not reached final state");
  }


  @Override
  protected String part1(List<String> input) {
    return String.valueOf(dijkstra(readState(input)));
  }

  @Override
  protected String part2(List<String> input) {
    return String.valueOf(dijkstra(readState(input)));
  }


}

record State(char[] corridoio, char[][] homes) {
  final static int[] energia = {1, 10, 100, 1000};

  State(char[] corridoio, char[][] homes) {
    this.corridoio = corridoio.clone();
    this.homes = deepCopy(homes);
  }

  static char[][] deepCopy(char[][] matrix) {
    return Arrays.stream(matrix).map(char[]::clone).toArray($ -> matrix.clone());
  }

  public boolean targetOK() {
    for (char[] home : homes)
      for (int c = 0; c < home.length; c++)
        if (home[c] != 'A' + c)
          return false;
    return true;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    State state = (State) o;

    if (!Arrays.equals(corridoio, state.corridoio)) return false;
    return Arrays.deepEquals(homes, state.homes);
  }

  @Override
  public int hashCode() {
    int result = Arrays.hashCode(corridoio);
    result = 31 * result + Arrays.deepHashCode(homes);
    return result;
  }

  List<Node> nextStates(int energy) {
    List<Node> result = new ArrayList<>();
    for (int i = 0; i < 11; i++) {
      if (corridoio[i] != '.' && possibileAndareHome(i, corridoio[i]) > 0) {
        State t = new State(corridoio, homes);
        int e = t.goHome(i, corridoio[i]);
        return List.of(new Node(t, e + energy));
      }
    }
    for (int c = 0; c < 4; c++) {
      if (!allCorrectInColonna(c))
        for (int r = 0; r < homes.length; r++)
          if (homes[r][c] != '.') {
            for (int i = 0; i < 11; i++)
              if (possibileAndareCorridoio(r, c, i) > 0) {
                State t = new State(corridoio, homes);
                int e = t.goCorridoio(r, c, i);
                result.add(new Node(t, e + energy));
              }
            break;
          }
    }
    return result;
  }

  private boolean allCorrectInColonna(int c) {
    for (char[] home : homes) {
      if (home[c] != '.' && home[c] != c + 'A')
        return false;
    }
    return true;
  }

  private int goCorridoio(int r, int c, int to) {
    int d = distanza(to, c, r);
    if (d > 0) {
      corridoio[to] = homes[r][c];
      homes[r][c] = '.';
      return d * energia[corridoio[to] - 'A'];
    }
    throw new IllegalStateException();
  }


  public int goHome(int from, char who) {
    int d = possibileAndareHome(from, who);
    if (d > 0) {
      int colonna = who - 'A';
      for (int i = homes.length - 1; i >= 0; i--) {
        if (homes[i][colonna] == '.') {
          homes[i][colonna] = who;
          corridoio[from] = '.';
          return d * energia[colonna];
        }
      }
    }
    throw new IllegalStateException();
  }

  public int distanza(int corr, int colonna, int riga) {
    int min = Math.min(corr, ((colonna + 1) * 2));
    int max = Math.max(corr, ((colonna + 1) * 2));
    for (int i = min + 1; i < max; i++) {
      if (corridoio[i] != '.') return -1;
    }
    for (int i = 0; i < riga; i++) {
      if (homes[i][colonna] != '.') return -1;
    }
    return max - min + 1 + riga;
  }

  public int possibileAndareHome(int from, char who) { // da fare per ognuno nel corridoio
    int colonna = who - 'A';
    for (int i = homes.length - 1; i >= 0; i--) {
      if (homes[i][colonna] != who && homes[i][colonna] != '.') return -1;
    }
    for (int i = homes.length - 1; i >= 0; i--) {
      if (homes[i][colonna] == '.')
        return distanza(from, colonna, i);
    }
    return -1;
  }

  public int possibileAndareCorridoio(int fromR, int fromC, int to) { // da fare per il primo di ogni colonna
    if (corridoio[to] != '.' || to == 2 || to == 4 || to == 6 || to == 8)
      return -1;
    return distanza(to, fromC, fromR);
  }

  @Override
  public String toString() {
    return "State[" +
        "c=" + Arrays.toString(corridoio) + ", " +
        "h=" + Arrays.deepToString(homes) + ']';
  }
}

record Node(State s, int energy) implements Comparable<Node>{
  @Override
  public int compareTo(@NotNull Node o) {
    return Integer.compare(energy, o.energy);
  }
}



