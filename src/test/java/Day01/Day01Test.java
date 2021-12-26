package day01;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Day01Test {

  private Day01 create() {
    return new Day01();
  }

  @Test
  public void part1Test() {
    assertThat(create().part1("example-1.txt")).isEqualTo("7");
  }

  @Test
  public void part2Test() {
    assertThat(create().part2("example-1.txt")).isEqualTo("5");
  }

  @Test
  public void part1TestReal() {
    assertThat(create().part1()).isEqualTo("1466");
  }

  @Test
  public void part2TestReal() {
    assertThat(create().part2()).isEqualTo("1491");
  }
}
