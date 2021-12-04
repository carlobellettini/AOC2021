package Day01;

import static Day01.Main.sum;
import static org.assertj.core.api.Assertions.*;

import Day00.Common;
import org.junit.Before;
import org.junit.Test;

import java.util.Scanner;

public class Day01Test {

  private Scanner input;

  @Before
  public void setUp()  {
    input = Common.readResourceToScanner(Main.class, "example-1.txt");
  }

  @Test
  public void sumTest() {
    assertThat(sum(1, input)).isEqualTo(7);
  }

  @Test
  public void sum3Test() {
    assertThat(sum(3, input)).isEqualTo(5);
  }
}
