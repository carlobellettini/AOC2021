package day23;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Day23Test {

  private Day23 create() {
    return new Day23();
  }

  @Test
  public void part1Test() {
    assertThat(create().part1("example-1.txt")).isEqualTo("12521");
  }

  @Test
  public void part2Test() {
    assertThat(create().part2("example-1p2.txt")).isEqualTo("44169");
  }

  @Test
  public void part1TestReal() {
    assertThat(create().part1()).isEqualTo("15365");
  }

  @Test
  public void part2TestReal() {
    assertThat(create().part2("inputP2.txt")).isEqualTo("52055");
  }
}
