package Day04;


import static org.junit.Assert.assertEquals;

import Day00.Common;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

public class Day04 {

  List<String> listOfStrings;

  @Before
  public void setUp() throws Exception {
    listOfStrings = Common.readResourceToStringList(Main.class, "example-1.txt");
  }

  @Test
  public void part1Test() {
    assertEquals(4242, Main.part1(listOfStrings));
  }

  @Test@Ignore
  public void part2Test() {
    assertEquals(424242, Main.part2(listOfStrings));
  }
}