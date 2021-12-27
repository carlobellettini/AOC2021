package day14;

import static org.assertj.core.api.Assertions.assertThat;

import day00.FetchInput;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Day14Test {

  private Day14 create(){
    return new Day14();
  }

  @Test
  public void part1Test() {
    assertThat(create().part1("example-1.txt")).isEqualTo("1588");
  }

  @Test
  public void part2Test() {
    assertThat(create().part2("example-1.txt")).isEqualTo("2188189693529");
  }

  @Test
  public void part1TestReal() {
    assertThat(create().part1()).isEqualTo("2703");
  }

  @Test
  public void part2TestReal() {
    assertThat(create().part2()).isEqualTo("2984946368465");
  }
}
