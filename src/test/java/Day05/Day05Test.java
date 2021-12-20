package Day05;


import static org.assertj.core.api.Assertions.assertThat;

import Day00.Day;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


public class Day05Test {

  private Day05 day;

  @Before
  public void setUp() {
    day = new Day05();
  }

  @Test
  public void part1Test() {
    assertThat(day.part1("example-1.txt")).isEqualTo("5");
  }

  @Test
  public void part2Test() {
    assertThat(day.part2("example-1.txt")).isEqualTo("12");
  }



  @Test
  public void part1TestReal() {
    assertThat(day.part1()).isEqualTo("8622");
  }

  @Test
  public void part2TestReal() {
    assertThat(day.part2()).isEqualTo("22037");
  }
}
