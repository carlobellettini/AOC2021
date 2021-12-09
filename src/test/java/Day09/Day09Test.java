package Day09;


import static org.assertj.core.api.Assertions.assertThat;

import Day00.FetchInput;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


public class Day09Test {

  private Day09 day;

  @Before
  public void setUp() {
    day = new Day09();
  }


  @Test@Ignore
  public void getInputFiles() {
    new FetchInput().retrieveDay("9", "2021");
  }

  @Test
  public void part1Test() {
    assertThat(day.part1("example-1.txt")).isEqualTo("15");
  }

  @Test
  public void part2Test() {
    assertThat(day.part2("example-1.txt")).isEqualTo("1134");
  }

  @Test
  public void part1TestReal() {
    assertThat(day.part1()).isEqualTo("491");
  }

  @Test
  public void part2TestReal() {
    assertThat(day.part2()).isEqualTo("1075536");
  }
}
