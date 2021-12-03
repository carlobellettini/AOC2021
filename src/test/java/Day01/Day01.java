package Day01;

import static Day01.Main.sum;
import static org.junit.Assert.*;

import Day00.Common;
import org.junit.Before;
import org.junit.Test;

import java.util.Scanner;

public class Day01 {

  private Scanner input;

  @Before
  public void setUp() throws Exception {
    input = Common.readResourceToScanner(Main.class, "example-1.txt");
  }

  @Test
  public void sumTest() {
    assertEquals(7, sum(1, input));
  }

  @Test
  public void sum3Test() {
    assertEquals(5, sum(3, input));
  }
}