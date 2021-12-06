package Day06;


import static org.assertj.core.api.Assertions.assertThat;

import Day00.Common;
import org.junit.Before;
import org.junit.Test;

import java.util.Scanner;

public class Day06Test {

  Scanner listOfStrings;

  @Before
  public void setUp() {
    listOfStrings = Common.scannerInput(Main.class, "example-1.txt");
  }


  @Test
  public void part1Test() {
    assertThat(Main.part1(listOfStrings)).isEqualTo("5934");
  }

  @Test
  public void part2Test() {
    assertThat(Main.part2(listOfStrings)).isEqualTo("26984457539");
  }

  @Test
  public void part1TestReal() {
    listOfStrings = Common.scannerInput(Main.class, "input.txt");
    assertThat(Main.part1(listOfStrings)).isEqualTo("345387");
  }

  @Test
  public void part2TestReal() {
    listOfStrings = Common.scannerInput(Main.class, "input.txt");
    assertThat(Main.part2(listOfStrings)).isEqualTo("1574445493136");
  }
}
