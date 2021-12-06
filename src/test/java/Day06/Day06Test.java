package Day06;


import static org.assertj.core.api.Assertions.assertThat;

import Day00.Common;
import Day00.Day;
import org.junit.Before;
import org.junit.Test;

import java.util.Scanner;

public class Day06Test {

  private Day06 day;

  @Before
  public void setUp() {
    day = new Day06();
  }

  @Test
  public void part1Test() {
    assertThat(day.part1("example-1.txt")).isEqualTo("5934");
  }

  @Test
  public void part2Test() {
    assertThat(day.part2("example-1.txt")).isEqualTo("26984457539");
  }

  @Test
  public void part1TestReal() {
    assertThat(day.part1()).isEqualTo("345387");
  }

  @Test
  public void part2TestReal() {
    assertThat(day.part2()).isEqualTo("1574445493136");
  }
}
