package Day12;

import Day00.Day;

import java.util.*;

public class Day12 extends Day {
  //List<String> paths = new ArrayList<>();

  @Override
  protected String part1() {
    return "" + visitFrom(getRootOfGraph(inputAsList()), new ArrayDeque<>(), true);
  }

  private Node getRootOfGraph(List<String> input) {
    Map<String, Node> index = new HashMap<>();
    for (String line : input) {
      String[] parts = line.split("-");
      Node uno = getPutIndex(index, parts[0]);
      Node due = getPutIndex(index, parts[1]);
      uno.connectTo(due);
    }
    return index.get("start");
  }

  private Node getPutIndex(Map<String, Node> index, String name) {
    if (index.containsKey(name))
      return index.get(name);
    else {
      Node n = new Node(name);
      index.put(name, n);
      return n;
    }
  }

  long visitFrom(Node curr, Deque<Node> visited, boolean visited2) {
    if (!curr.big && visited.contains(curr)) {
      if (visited2 || curr.name.equals("start"))
        return 0;
      else
        visited2 = true;
    }
    if (curr.name.equals("end")) {
      //paths.add(stringPath(visited));
      return 1;
    }
    visited.push(curr);

    int counter = 0;
    for (Node node : curr.vicini())
      counter += visitFrom(node, visited, visited2);

    visited.pop();
    return counter;
  }

  @Override
  protected String part2() {
    return "" + visitFrom(getRootOfGraph(inputAsList()), new ArrayDeque<>(), false);
  }

  /*private String stringPath(Deque<Node> visited) {
    StringBuilder sb = new StringBuilder();

    for (var it = visited.descendingIterator(); it.hasNext(); ) {
      Node next = it.next();
      sb.append(next.name).append(",");
    }
    sb.append("end");
    return sb.toString();
  }*/
}

