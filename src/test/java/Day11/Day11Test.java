package day11;


import static org.assertj.core.api.Assertions.assertThat;

import day00.FetchInput;
import org.junit.Ignore;
import org.junit.Test;


public class Day11Test {

  private static Day11 create() {
    return new Day11();
  }

  @Test
  @Ignore
  public void getInputFiles() {
    new FetchInput().retrieveDay("11", "2021");
  }

  @Test
  public void part1Test() {
    assertThat(create().part1("example-1.txt")).isEqualTo("1656");
    System.out.println("SOLUZIONE PARTE 1: <" + create().part1()+">");
  }

  @Test
  public void part2Test() {
    assertThat(create().part2("example-1.txt")).isEqualTo("195");
    System.out.println("SOLUZIONE PARTE 2: <" + create().part2()+">");
  }


  @Test
  public void part1TestReal() {
    assertThat(create().part1()).isEqualTo("1667");
  }

  @Test
  public void part2TestReal() {
    assertThat(create().part2()).isEqualTo("488");
  }
}
