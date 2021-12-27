package day03;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Day03Test {

  private Day03 create() {
    System.err.print("DAY03 ");
    return new Day03();
  }

  @Test
  public void part1Test() {
    assertThat(create().part1("example-1.txt")).isEqualTo("198");
  }

  @Test
  public void part2Test() {
    assertThat(create().part2("example-1.txt")).isEqualTo("230");
  }

  @Test
  public void part1TestReal() {
    assertThat(create().part1()).isEqualTo("2003336");
  }

  @Test
  public void part2TestReal() {
    assertThat(create().part2()).isEqualTo("1877139");
  }
}
