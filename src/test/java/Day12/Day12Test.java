package day12;


import static org.assertj.core.api.Assertions.assertThat;

import day00.FetchInput;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import java.util.List;
import java.util.stream.Stream;


public class Day12Test {

  @Rule
  public SystemOutRule output = new SystemOutRule().enableLog().muteForSuccessfulTests();

  private Day12 create() {
    return new Day12();
  }

  @Test
  @Ignore
  public void getInputFiles() {
    new FetchInput().retrieveDay("12", "2021");
  }

  @Test
  public void part1Test() {
    assertThat(create().part1("example-4.txt")).isEqualTo("19");
    assertThat(create().part1("example-6.txt")).isEqualTo("226");
    System.err.println("SOLUZIONE PARTE 1: <" + create().part1() + ">");
  }

  @Test
  public void part2Test() {
    assertThat(create().part2("example-1.txt")).isEqualTo("36");
    assertThat(create().part2("example-4.txt")).isEqualTo("103");
    assertThat(create().part2("example-6.txt")).isEqualTo("3509");
    System.err.println("SOLUZIONE PARTE 2: <" + create().part2() + ">");
  }

  @Test
  public void part1TestReal() {
    assertThat(create().part1()).isEqualTo("3576");
  }

  @Test
  public void part2TestReal() {
    assertThat(create().part2()).isEqualTo("84271");
  }

  @Test
  public void pathOutputTest() {
    final Day12 day12 = new Day12();
    assertThat(day12.part2("example-1.txt")).isEqualTo("36");
    String expected = """
        start,A,b,A,b,A,c,A,end
        start,A,b,A,b,A,end
        start,A,b,A,b,end
        start,A,b,A,c,A,b,A,end
        start,A,b,A,c,A,b,end
        start,A,b,A,c,A,c,A,end
        start,A,b,A,c,A,end
        start,A,b,A,end
        start,A,b,d,b,A,c,A,end
        start,A,b,d,b,A,end
        start,A,b,d,b,end
        start,A,b,end
        start,A,c,A,b,A,b,A,end
        start,A,c,A,b,A,b,end
        start,A,c,A,b,A,c,A,end
        start,A,c,A,b,A,end
        start,A,c,A,b,d,b,A,end
        start,A,c,A,b,d,b,end
        start,A,c,A,b,end
        start,A,c,A,c,A,b,A,end
        start,A,c,A,c,A,b,end
        start,A,c,A,c,A,end
        start,A,c,A,end
        start,A,end
        start,b,A,b,A,c,A,end
        start,b,A,b,A,end
        start,b,A,b,end
        start,b,A,c,A,b,A,end
        start,b,A,c,A,b,end
        start,b,A,c,A,c,A,end
        start,b,A,c,A,end
        start,b,A,end
        start,b,d,b,A,c,A,end
        start,b,d,b,A,end
        start,b,d,b,end
        start,b,end
        """;

    List<String> l = Stream.of(expected.split("\n")).toList();
    //assertThat(day12.paths).containsExactlyElementsOf(l);
    //assertThat(day12.paths).isEqualTo(l);
    //assertThat(output.getLog()).isEqualTo(expected);
  }
}
