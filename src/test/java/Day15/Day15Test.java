package day15;

import static org.assertj.core.api.Assertions.assertThat;

import day00.FetchInput;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Day15Test {

  private Day15 create(){
    return new Day15();
  }

  private Day15_with_Dijkstra create_Dijkstra(){
    return new Day15_with_Dijkstra();
  }

  @Test
  public void getInputFiles() {
    new FetchInput().retrieveDay("15", "2021");
  }

  @Test
  public void part1Test() {
    assertThat(create().part1("example-1.txt")).isEqualTo("40");
  }

  @Test
  public void part1TestDijkstra() {
    assertThat(create_Dijkstra().part1("example-1.txt")).isEqualTo("40");
  }

  @Test
  public void part2Test() {
    assertThat(create().part2("example-1.txt")).isEqualTo("315");
    //System.err.println("SOLUZIONE PARTE 2: <" + create().part2()+">");
  }
  @Test
  public void part2TestDijkstra() {
    assertThat(create_Dijkstra().part2("example-1.txt")).isEqualTo("315");
    //System.err.println("SOLUZIONE PARTE 2: <" + create_Dijkstra().part2()+">");
  }

  @Test
  public void part1TestReal() {
    assertThat(create().part1()).isEqualTo("462");
  }
  @Test
  public void part1TestRealDijkstra() {
    assertThat(create_Dijkstra().part1()).isEqualTo("462");
  }

  @Test
  public void part2TestReal() {
    assertThat(create().part2()).isEqualTo("2846");
  }

  @Test
  public void part2TestRealDijkstra() {
    assertThat(create_Dijkstra().part2()).isEqualTo("2846");
  }
}
