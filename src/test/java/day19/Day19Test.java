package day19;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Day19Test {

  private Day19 create() {
     return new Day19();
  }

  @Test
  public void part1Test() {
    assertThat(create().part1("example-6.txt")).isEqualTo("79");
  }

  @Test
  public void part2Test() {
    assertThat(create().part2("example-6.txt")).isEqualTo("3621");
  }

  @Test
  public void part1TestReal() {
    assertThat(create().part1()).isEqualTo("462");
  }

  @Test
  public void part2TestReal() {
    assertThat(create().part2()).isEqualTo("12158");
  }
}
