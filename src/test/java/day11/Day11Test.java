package day11;


import static org.assertj.core.api.Assertions.assertThat;

import day00.FetchInput;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Day11Test {

  private static Day11 create() {
    return new Day11();
  }

  @Test
  public void part1Test() {
    assertThat(create().part1("example-1.txt")).isEqualTo("1656");
  }

  @Test
  public void part2Test() {
    assertThat(create().part2("example-1.txt")).isEqualTo("195");
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
