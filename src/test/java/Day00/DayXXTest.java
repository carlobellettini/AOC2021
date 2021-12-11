package Day00;


import static org.assertj.core.api.Assertions.assertThat;

import Day00.FetchInput;
import org.junit.Ignore;
import org.junit.Test;


public class DayXXTest {

  private DayXX create(){
    return new DayXX();
  }

  @Test@Ignore
  public void getInputFiles() {
    new FetchInput().retrieveDay("0", "2021");
  }

  @Test
  public void part1Test() {
    assertThat(create().part1("example-1.txt")).isEqualTo("???");
    System.out.println("SOLUZIONE PARTE 1: <" + create().part1()+">");
  }

  @Test@Ignore
  public void part2Test() {
    assertThat(create().part2("example-1.txt")).isEqualTo("???");
    System.out.println("SOLUZIONE PARTE 2: <" + create().part2()+">");
  }

  @Test@Ignore
  public void part1TestReal() {
    assertThat(create().part1()).isEqualTo("???");
  }

  @Test@Ignore
  public void part2TestReal() {
    assertThat(create().part2()).isEqualTo("???");
  }
}
