package Day01;

import static org.assertj.core.api.Assertions.assertThat;


import Day00.FetchInput;
import org.junit.Ignore;
import org.junit.Test;


public class Day01Test {


  private Day01 create(){
    return new Day01();
  }

  @Test@Ignore
  public void getInputFiles() {
    new FetchInput().retrieveDay("1", "2021");
  }

  @Test
  public void part1Test() {
    assertThat(create().part1("example-1.txt")).isEqualTo("7");
    System.err.println("SOLUZIONE PARTE 1: <" + create().part1()+">");
  }

  @Test
  public void part2Test() {
    assertThat(create().part2("example-1.txt")).isEqualTo("5");
    System.err.println("SOLUZIONE PARTE 2: <" + create().part2()+">");
  }

  @Test
  public void part1TestReal() {
    assertThat(create().part1()).isEqualTo("1466");
  }

  @Test
  public void part2TestReal() {
    assertThat(create().part2()).isEqualTo("1491");
  }
}
