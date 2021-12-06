package Day00;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

public class Day00Test {

  List<String> listOfStrings;

  @Before
  public void setUp() {
    listOfStrings = Common.stringListInput(Main.class, "example-1.txt");
  }


  @Test@Ignore
  public void part1Test() {
    assertThat(Main.part1(listOfStrings)).isEqualTo("???");
  }

  @Test@Ignore
  public void part2Test() {
    assertThat(Main.part2(listOfStrings)).isEqualTo("???");
  }

  @Test@Ignore
  public void part1TestReal() {
    listOfStrings = Common.stringListInput(Main.class, "input.txt");
    assertThat(Main.part1(listOfStrings)).isEqualTo("???");
  }

  @Test@Ignore
  public void part2TestReal() {
    listOfStrings = Common.stringListInput(Main.class, "input.txt");
    assertThat(Main.part2(listOfStrings)).isEqualTo("???");
  }
}
