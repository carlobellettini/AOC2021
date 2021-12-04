package Day02;

import static Day02.Main.part1;
import static Day02.Main.part2;
import static org.assertj.core.api.Assertions.*;

import Day00.Common;
import org.junit.Before;
import org.junit.Test;

import java.util.Scanner;

public class Day02Test {

  private Scanner input;

  @Before
  public void setUp()  {
    input = Common.readResourceToScanner(Main.class, "example-1.txt");
  }

  @Test
  public void part1Test() {
    assertThat(part1(input)).isEqualTo("150  (= 15 * 10)");
  }

  @Test
  public void part2Test() {
    assertThat(part2(input)).isEqualTo("900  (= 15 * 60)");
  }
}
