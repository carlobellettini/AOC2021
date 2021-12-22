package day15;

import static day00.Mat.CelleVicine;

import day00.Day;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;


public class Day15_with_Dijkstra extends Day {
  final private PriorityQueue<Node> pq;
  final private Map<Coords, Integer> dist;
  private Mat15 adj = new Mat15();

  public Day15_with_Dijkstra() {
    dist = new HashMap<>();
    pq = new PriorityQueue<>();
  }

  public void dijkstra(Coords src) {
    pq.add(new Node(src, 0));
    dist.put(src, 0);

    while (!pq.isEmpty()) {
      Coords u = pq.remove().coords();
      e_Neighbours(u);
    }
  }

  private void e_Neighbours(Coords u) {
    for (CelleVicine d : CelleVicine.values()) {
      Coords vicino = new Coords(u.r() + d.r, u.c() + d.c);
      if (adj.valida(d, u.r(), u.c())) {
        int newDistance = dist.get(u) + adj.valore(d, u.r(), u.c());
        if (newDistance < dist.getOrDefault(vicino, Integer.MAX_VALUE)) {
          dist.put(vicino, newDistance);
          pq.add(new Node(vicino, newDistance));
        }
      }
    }
  }

  @Override
  protected String part1() {
    adj.readFrom(inputAsList());
    dijkstra(new Coords(0, 0));
    return "" + dist.get(new Coords(adj.rows() - 1, adj.columns() - 1));
  }

  @Override
  protected String part2() {
    adj.readFrom(inputAsList());

    adj = adj.growByFactor(5);

    dijkstra(new Coords(0, 0));
    return "" + dist.get(new Coords(adj.rows() - 1, adj.columns() - 1));
  }
}

record Coords(int r, int c) {
}

record Node(Coords coords, int cost) implements Comparable<Node> {
  @Override
  public int compareTo(@NotNull Node o) {
    return Integer.compare(cost, o.cost);
  }
}
