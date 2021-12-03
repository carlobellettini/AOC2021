package Day03;

import static Day03.Main.part1;
import static Day03.Main.part2;
import static org.junit.Assert.assertEquals;


import Day00.Common;
import org.junit.Before;
import org.junit.Test;


import java.util.List;

public class Day03 {

  List<String> listOfStrings;
  @Before
  public void setUp() throws Exception {
    listOfStrings = Common.readResourceToStringList(Main.class, "example-1.txt");
  }

  @Test
  public void part1Test() {
    assertEquals(198, part1(listOfStrings));
  }

  @Test
  public void part2Test() {
    assertEquals(230, part2(listOfStrings));
  }
}