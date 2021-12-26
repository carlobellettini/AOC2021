package day10;


import static org.assertj.core.api.Assertions.assertThat;

import day00.FetchInput;
import day09.Day09;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Day10Test {

  public Day10 create() {
    return new Day10();
  }

  @Test
  public void part1Test() {
    assertThat(create().part1("example-2.txt")).isEqualTo("26397");
  }

  @Test
  public void part2Test() {
    assertThat(create().part2("example-2.txt")).isEqualTo("288957");
  }

  @Test
  public void part1TestReal() {
    assertThat(create().part1()).isEqualTo("399153");
  }

  @Test
  public void part2TestReal() {
    assertThat(create().part2()).isEqualTo("2995077699");
  }
}
