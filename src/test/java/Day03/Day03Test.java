package day03;

import static day03.Day03.part1;
import static day03.Day03.part2;
import static org.assertj.core.api.Assertions.assertThat;


import day00.Common;
import org.junit.Before;
import org.junit.Test;


import java.util.List;

public class Day03Test {

  List<String> listOfStrings;
  @Before
  public void setUp()  {
    listOfStrings = Common.stringListInput(Day03.class, "example-1.txt");
  }

  @Test
  public void part1Test() {
    assertThat(part1(listOfStrings)).isEqualTo(198);
  }

  @Test
  public void part2Test() {
    assertThat(part2(listOfStrings)).isEqualTo(230);
  }
}
