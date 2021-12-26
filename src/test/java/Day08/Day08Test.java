package day08;

import static org.assertj.core.api.Assertions.assertThat;

import day00.FetchInput;
import day04.Day04;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Day08Test {

  private Day08 create() {
    return new Day08();
  }

  @Test
  public void part1Test() {
    assertThat(create().part1("example-3.txt")).isEqualTo("26");
  }

  @Test
  public void part2Test() {
    assertThat(create().part2("example-2.txt")).isEqualTo("5353");
  }

  @Test
  public void part2Test2() {
    assertThat(create().part2("example-3.txt")).isEqualTo("61229");
  }

  @Test
  public void part2Decode() {
    assertThat(create().decode("acedgfb cdfbe gcdfa fbcad dab cefabd cdfgeb eafb cagedb ab"))
        .containsExactly("cagedb", "ab", "gcdfa", "fbcad", "eafb", "cdfbe", "cdfgeb", "dab", "acedgfb", "cefabd");
  }

  @Test
  public void part1TestReal() {
    assertThat(create().part1()).isEqualTo("397");
  }

  @Test
  public void part2TestReal() {
    assertThat(create().part2()).isEqualTo("1027422");
  }
}
