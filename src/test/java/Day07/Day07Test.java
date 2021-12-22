package day07;


import static org.assertj.core.api.Assertions.assertThat;

import day00.FetchInput;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


public class Day07Test {

  private Day07 day;

  @Before
  public void setUp() {
    day = new Day07();
  }


  @Test@Ignore
  public void getInputFiles() {
    new FetchInput().retrieveDay("7", "2021");
  }

  @Test
  public void part1Test() {
    assertThat(day.part1("example-1.txt")).isEqualTo("37");
  }

  @Test
  public void part2Test() {
    assertThat(day.part2("example-1.txt")).isEqualTo("168");
  }



  @Test
  public void part1TestReal() {
    assertThat(day.part1()).isEqualTo("343441");
  }

  @Test
  public void part2TestReal() {
    assertThat(day.part2()).isEqualTo("98925151");
  }
}
