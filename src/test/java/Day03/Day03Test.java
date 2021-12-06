package Day03;

import static Day03.Main.part1;
import static Day03.Main.part2;
import static org.assertj.core.api.Assertions.assertThat;


import Day00.Common;
import org.junit.Before;
import org.junit.Test;


import java.util.List;

public class Day03Test {

  List<String> listOfStrings;
  @Before
  public void setUp()  {
    listOfStrings = Common.stringListInput(Main.class, "example-1.txt");
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
