package Day21;

import static org.assertj.core.api.Assertions.assertThat;

import Day00.FetchInput;
import org.junit.Ignore;
import org.junit.Test;


public class Day21Test {


  private Day21 create() {
    return new Day21();
  }

  @Test
  @Ignore
  public void getInputFiles() {
    new FetchInput().retrieveDay("21", "2021");
  }

  @Test
  public void part1Test() {
    assertThat(create().part1("example-1.txt")).isEqualTo("739785");
    //  System.err.println("SOLUZIONE PARTE 1: <" + create().part1()+">");
  }

  @Test
  public void part2Test() {
    assertThat(create().part2("example-1.txt")).isEqualTo("444356092776315");
    // System.err.println("SOLUZIONE PARTE 2: <" + create().part2()+">");
  }

  @Test
  public void part1TestReal() {
    assertThat(create().part1()).isEqualTo("742257");
  }

  @Test
  public void part2TestReal() {
    assertThat(create().part2()).isEqualTo("93726416205179");
  }

  @Test
  public void part2TestIterativo() {
    assertThat(create().part2iterativo(4, 8)).isEqualTo(444356092776315L);
  }

  @Test
  public void part2TestIterativoReal() {
    assertThat(create().part2iterativo(10, 3)).isEqualTo(93726416205179L); //input
  }
}
