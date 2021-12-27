package day02;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Day02Test {

  private Day02 create() {
    return new Day02();
  }

  @Test
  public void part1Test() {
    assertThat(create().part1("example-1.txt")).isEqualTo("150  (= 15 * 10)");
  }

  @Test
  public void part2Test() {
    assertThat(create().part2("example-1.txt")).isEqualTo("900  (= 15 * 60)");
  }

  @Test
  public void part1TestReal() {
    assertThat(create().part1()).isEqualTo("1815044  (= 1988 * 913)");
  }

  @Test
  public void part2TestReal() {
    assertThat(create().part2()).isEqualTo("1739283308  (= 1988 * 874891)");
  }

}
