package Day05;


import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.MAP;

import Day00.Common;
import Day05.Griglia.Point;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class Day05Test {

  List<String> listOfStrings;

  @Before
  public void setUp() {
    listOfStrings = Common.readResourceToStringList(Main.class, "example-1.txt");
  }


  @Test
  public void testDiagonaleTL_BR() {
    Griglia g = new Griglia(true);
    g.addLine("1,2 -> 3,4");
    assertThat(g).extracting("gridMap", as(MAP))
        .containsOnlyKeys(new Point(1, 2),
            new Point(2, 3),
            new Point(3, 4)
        );
  }

  @Test
  public void testDiagonaleBR_TL() {
    Griglia g = new Griglia(true);
    g.addLine("3,4 -> 1,2");
    assertThat(g).extracting("gridMap", as(MAP))
        .containsOnlyKeys(new Point(1, 2),
            new Point(2, 3),
            new Point(3, 4)
        );
  }

  @Test
  public void testDiagonaleBL_TR() {
    Griglia g = new Griglia(true);
    g.addLine("1,4 -> 3,2");
    assertThat(g).extracting("gridMap", as(MAP))
        .containsOnlyKeys(new Point(1, 4),
            new Point(2, 3),
            new Point(3, 2)
        );
  }

  @Test
  public void testDiagonaleTR_BL() {
    Griglia g = new Griglia(true);
    g.addLine("3,2 -> 1,4");
    assertThat(g).extracting("gridMap", as(MAP))
        .containsOnlyKeys(new Point(3, 2),
            new Point(2, 3),
            new Point(1, 4)
        );
  }

  @Test
  public void part1Test() {
    assertThat(Main.part1(listOfStrings)).isEqualTo("5");
  }

  @Test
  public void part2Test() {
    assertThat(Main.part2(listOfStrings)).isEqualTo("12");
  }

  @Test
  public void part1TestReal() {
    listOfStrings = Common.readResourceToStringList(Main.class, "input.txt");
    assertThat(Main.part1(listOfStrings)).isEqualTo("8622");
  }

  @Test
  public void part2TestReal() {
    listOfStrings = Common.readResourceToStringList(Main.class, "input.txt");
    assertThat(Main.part2(listOfStrings)).isEqualTo("22037");
  }
}
