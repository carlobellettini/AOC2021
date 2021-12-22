package day10;


import static org.assertj.core.api.Assertions.assertThat;

import day00.FetchInput;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


public class Day10Test {

  private Day10 day;

  @Before
  public void setUp() {
    day = new Day10();
  }


  @Test@Ignore
  public void getInputFiles() {
    new FetchInput().retrieveDay("10", "2021");
  }

  @Test
  public void part1Test() {
    assertThat(day.part1("example-2.txt")).isEqualTo("26397");
  }

  @Test
  public void part2Test() {
    assertThat(day.part2("example-2.txt")).isEqualTo("288957");
  }



  @Test
  public void part1TestReal() {
    assertThat(day.part1()).isEqualTo("399153");
  }

  @Test
  public void part2TestReal() {
    assertThat(day.part2()).isEqualTo("2995077699");
  }
}
