package Day14;

import static org.assertj.core.api.Assertions.assertThat;

import Day00.FetchInput;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;


public class Day14Test {

  @Rule
  public SystemOutRule output = new SystemOutRule().enableLog().muteForSuccessfulTests();

  private Day14 create(){
    return new Day14();
  }

  @Test@Ignore
  public void getInputFiles() {
    new FetchInput().retrieveDay("14", "2021");
  }

  @Test
  public void part1Test() {
    assertThat(create().part1("example-1.txt")).isEqualTo("1588");
    System.err.println("SOLUZIONE PARTE 1: <" + create().part1()+">");
  }

  @Test
  public void part2Test() {
    assertThat(create().part2("example-1.txt")).isEqualTo("2188189693529");
    System.err.println("SOLUZIONE PARTE 2: <" + create().part2()+">");
  }

  @Test
  public void part1TestReal() {
    assertThat(create().part1()).isEqualTo("2703");
  }

  @Test
  public void part2TestReal() {
    assertThat(create().part2()).isEqualTo("2984946368465");
  }
}
