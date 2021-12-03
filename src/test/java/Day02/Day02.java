package Day02;

import static Day02.Main.part1;
import static Day02.Main.part2;
import static org.junit.Assert.*;

import Day00.Common;
import org.junit.Before;
import org.junit.Test;

import java.util.Scanner;

public class Day02 {

  private Scanner input;

  @Before
  public void setUp() throws Exception {
    input = Common.readResourceToScanner(Main.class, "example-1.txt");
  }

  @Test
  public void part1Test() {
    assertEquals("150  (= 15 * 10)", part1(input));
  }

  @Test
  public void part2Test() {
    assertEquals("900  (= 15 * 60)", part2(input));
  }
}