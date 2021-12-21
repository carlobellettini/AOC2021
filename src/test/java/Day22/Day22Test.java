package Day22;

import static org.assertj.core.api.Assertions.assertThat;

import Day00.FetchInput;
import org.junit.Ignore;
import org.junit.Test;


public class Day22Test {

  private Day22 create() {
    return new Day22();
  }

  @Test
  @Ignore
  public void getInputFiles() {
    new FetchInput().retrieveDay("22", "2021");
  }

  @Test
  public void part1Test() {
    assertThat(create().part1("example-2.txt")).isEqualTo("590784");
    System.err.println("SOLUZIONE PARTE 1: <" + create().part1() + ">");
  }

  @Test
  public void part1TestSmall() {
    assertThat(create().part1("example-1.txt")).isEqualTo("39");
  }

  @Test
  public void part2Test() {
    assertThat(create().part2("example-3.txt")).isEqualTo("2758514936282235");
 //   System.err.println("SOLUZIONE PARTE 2: <" + create().part2()+">");
  }

  @Test
  public void part1TestReal() {
    assertThat(create().part1()).isEqualTo("537042");
  }

  @Test
  public void part2TestReal() {
    assertThat(create().part2()).isEqualTo("1304385553084863");
  }
}
