package Day00;


import static org.assertj.core.api.Assertions.assertThat;

import Day00.FetchInput;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


public class Day00Test {

  private Day day;

  @Before
  public void setUp() {
    day = new Day();
  }


  @Test@Ignore
  public void getInputFiles() {
    new FetchInput().retrieveDay("0", "2020");
  }

  @Test@Ignore
  public void part1Test() {
    assertThat(day.part1("example-1.txt")).isEqualTo("???");
  }

  @Test@Ignore
  public void part2Test() {
    assertThat(day.part2("example-1.txt")).isEqualTo("???");
  }



  @Test@Ignore
  public void part1TestReal() {
    assertThat(day.part1()).isEqualTo("???");
  }

  @Test@Ignore
  public void part2TestReal() {
    assertThat(day.part2()).isEqualTo("???");
  }
}
