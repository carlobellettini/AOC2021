package day13;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Day13Test {


  @Rule
  public SystemOutRule output = new SystemOutRule().enableLog().muteForSuccessfulTests();


  private Day13 create() {
    return new Day13();
  }


  @Test
  public void part1Test() {
    assertThat(create().part1("example-2.txt")).isEqualTo("17");
  }

  @Test
  public void part2Test() {

    create().part2("example-2.txt");
    assertThat(output.getLog().replaceAll("\u001B\\[[;\\d]*m", "")).isEqualTo("""
        #####
        #...#
        #...#
        #...#
        #####
        .....
        .....
        """);
    System.out.println("Dovresti leggere < O >");
  }

  @Test
  public void part1TestReal() {
    assertThat(create().part1()).isEqualTo("661");
  }

  @Test
  public void part2TestReal() {
    create().part2();
    assertThat(output.getLog().replaceAll("\u001B\\[[;\\d]*m", "")).isEqualTo("""
        ###..####.#..#.#....#..#..##..####.###..
        #..#.#....#.#..#....#.#..#..#.#....#..#.
        #..#.###..##...#....##...#....###..#..#.
        ###..#....#.#..#....#.#..#....#....###..
        #....#....#.#..#....#.#..#..#.#....#....
        #....#....#..#.####.#..#..##..#....#....
        """);
    System.out.println("Dovresti leggere < PFKLKCFP >");
  }
}
