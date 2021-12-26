package day09;


import static org.assertj.core.api.Assertions.assertThat;

import day00.FetchInput;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Day09Test {

  public Day09 create() {
    return new Day09();
  }

  @Test
  public void part1Test() {
    assertThat(create().part1("example-1.txt")).isEqualTo("15");
  }

  @Test
  public void part2Test() {
    assertThat(create().part2("example-1.txt")).isEqualTo("1134");
  }

  @Test
  public void part1TestReal() {
    assertThat(create().part1()).isEqualTo("491");
  }

  @Test
  public void part2TestReal() {
    assertThat(create().part2()).isEqualTo("1075536");
  }
}
