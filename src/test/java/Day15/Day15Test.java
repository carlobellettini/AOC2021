package day15;

import static org.assertj.core.api.Assertions.assertThat;

import day00.FetchInput;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;


public class Day15Test {

  @Rule
  public SystemOutRule output = new SystemOutRule().enableLog().muteForSuccessfulTests();

  private Day15 create(){
    return new Day15();
  }

  private Day15_with_Dijkstra create_Dijkstra(){
    return new Day15_with_Dijkstra();
  }

  @Test@Ignore
  public void getInputFiles() {
    new FetchInput().retrieveDay("15", "2021");
  }

  @Test
  public void part1Test() {
    assertThat(create().part1("example-1.txt")).isEqualTo("40");
    System.err.println("SOLUZIONE PARTE 1: <" + create().part1()+">");
  }

  @Test
  public void part1DijkstraTest() {
    assertThat(create_Dijkstra().part1("example-1.txt")).isEqualTo("40");
    System.err.println("SOLUZIONE PARTE 1: <" + create_Dijkstra().part1()+">");
  }

  @Test
  public void part2Test() {
    assertThat(create().part2("example-1.txt")).isEqualTo("315");
    System.err.println("SOLUZIONE PARTE 2: <" + create().part2()+">");
  }
  @Test
  public void part2DijkstraTest() {
    assertThat(create_Dijkstra().part2("example-1.txt")).isEqualTo("315");
    System.err.println("SOLUZIONE PARTE 2: <" + create_Dijkstra().part2()+">");
  }

  @Test
  public void part1TestReal() {
    assertThat(create().part1()).isEqualTo("462");
  }
  @Test
  public void part1DijkstraTestReal() {
    assertThat(create_Dijkstra().part1()).isEqualTo("462");
  }

  @Test
  public void part2TestReal() {
    assertThat(create().part2()).isEqualTo("2846");
  }
  @Test
  public void part2DijkstraTestReal() {
    assertThat(create_Dijkstra().part2()).isEqualTo("2846");
  }
}
