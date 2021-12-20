package Day12;

import java.util.HashSet;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;

class Node {
  public final String name;
  public final boolean big;
  public final Set<Node> vicini = new HashSet<>();

  public Node(String name) {
    this.name = name;
    big = name.toUpperCase(Locale.ROOT).equals(name);
  }

  public void connectTo(Node vicino) {
    vicini.add(vicino);
    vicino.vicini.add(this);
  }

  public Iterable<Node> vicini() {
    return () -> vicini.iterator();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Node node = (Node) o;
    return name.equals(node.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  @Override
  public String toString() {
    return "Node{" + name + '}';
  }
}
