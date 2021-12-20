package Day17;

import static org.assertj.core.api.Assertions.assertThat;

import Day00.FetchInput;
import Day00.Submit;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;


public class Day17Test {

  private Day17 create(){
    return new Day17();
  }

  @Test@Ignore
  public void getInputFiles() {
    new FetchInput().retrieveDay("17", "2021");
  }

  @Test
  public void part1Test() {
    assertThat(create().part1("example-1.txt")).isEqualTo("45");
    System.err.println("SOLUZIONE PARTE 1: <" + create().part1()+">");
  }

  @Test
  public void part2Test() {
    assertThat(create().part2("example-1.txt")).isEqualTo("112");
    System.err.println("SOLUZIONE PARTE 2: <" + create().part2()+">");
  }

  @Test
  public void part1TestReal() {
    assertThat(create().part1()).isEqualTo("13203");
  }

  @Test
  public void part2TestReal() {
    assertThat(create().part2()).isEqualTo("5644");
  }
}
