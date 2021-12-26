package day05;


import static org.assertj.core.api.Assertions.assertThat;

import day00.Day;
import day04.Day04;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Day05Test {

  private Day05 create() {
    return new Day05();
  }

  @Test
  public void part1Test() {
    assertThat(create().part1("example-1.txt")).isEqualTo("5");
  }

  @Test
  public void part2Test() {
    assertThat(create().part2("example-1.txt")).isEqualTo("12");
  }

  @Test
  public void part1TestReal() {
    assertThat(create().part1()).isEqualTo("8622");
  }

  @Test
  public void part2TestReal() {
    assertThat(create().part2()).isEqualTo("22037");
  }
}
