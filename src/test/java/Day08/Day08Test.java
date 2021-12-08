package Day08;

import static org.assertj.core.api.Assertions.assertThat;

import Day00.FetchInput;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class Day08Test {

  private Day08 day;

  @Before
  public void setUp() {
    day = new Day08();
  }

  @Test
  @Ignore
  public void getInputFiles() {
    new FetchInput().retrieveDay("8", "2021");
  }

  @Test
  public void part1Test() {
    assertThat(day.part1("example-3.txt")).isEqualTo("26");
  }

  @Test
  public void part2Test() {
    assertThat(day.part2("example-2.txt")).isEqualTo("5353");
  }

  @Test
  public void part2Test2() {
    assertThat(day.part2("example-3.txt")).isEqualTo("61229");
  }
  @Test
  public void part2Decode() {
    assertThat(day.decode("acedgfb cdfbe gcdfa fbcad dab cefabd cdfgeb eafb cagedb ab"))
        .containsExactly("cagedb", "ab", "gcdfa", "fbcad", "eafb", "cdfbe", "cdfgeb", "dab", "acedgfb", "cefabd");
  }

  @Test
  public void part1TestReal() {
    assertThat(day.part1()).isEqualTo("397");
  }

  @Test
  public void part2TestReal() {
    assertThat(day.part2()).isEqualTo("1027422");
  }
}
