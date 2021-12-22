package day13;

import static org.assertj.core.api.Assertions.assertThat;

import day00.FetchInput;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;


public class Day13Test {


  @Rule
  public SystemOutRule output = new SystemOutRule().enableLog().muteForSuccessfulTests();


  private Day13 create(){
    return new Day13();
  }

  @Test@Ignore
  public void getInputFiles() {
    new FetchInput().retrieveDay("13", "2021");
  }

  @Test
  public void part1Test() {
    assertThat(create().part1("example-2.txt")).isEqualTo("17");
  //  System.err.println("SOLUZIONE PARTE 1: <" + create().part1()+">");
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
    System.err.println("Dovresti leggere < O >");

//    System.err.println("SOLUZIONE PARTE 2: <" + create().part2()+">");
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
    System.err.println("Dovresti leggere < PFKLKCFP >");
  }
}
