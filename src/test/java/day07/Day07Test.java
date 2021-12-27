package day07;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Day07Test {

  private Day07 create() {
    return new Day07();
  }

  @Test
  public void part1Test() {
    assertThat(create().part1("example-1.txt")).isEqualTo("37");
  }

  @Test
  public void part2Test() {
    assertThat(create().part2("example-1.txt")).isEqualTo("168");
  }


  @Test
  public void part1TestReal() {
    assertThat(create().part1()).isEqualTo("343441");
  }

  @Test
  public void part2TestReal() {
    assertThat(create().part2()).isEqualTo("98925151");
  }
}
