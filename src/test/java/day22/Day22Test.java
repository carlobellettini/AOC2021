package day22;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Day22Test {

  private Day22 create() {
    return new Day22();
  }

  @Test
  public void part1Test() {
    assertThat(create().part1("example-2.txt")).isEqualTo("590784");
  }

  @Test
  public void part1SmallTest() {
    assertThat(create().part1("example-1.txt")).isEqualTo("39");
  }

  @Test
  public void part2Test() {
    assertThat(create().part2("example-3.txt")).isEqualTo("2758514936282235");
  }

  @Test
  public void part1TestReal() {
    assertThat(create().part1()).isEqualTo("537042");
  }

  @Test
  public void part2TestReal() {
    assertThat(create().part2()).isEqualTo("1304385553084863");
  }
}
