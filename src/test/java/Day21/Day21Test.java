package day21;

import static org.assertj.core.api.Assertions.assertThat;

import day00.FetchInput;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Day21Test {

  private Day21 create() {
    return new Day21();
  }

  @Test
  public void part1Test() {
    assertThat(create().part1("example-1.txt")).isEqualTo("739785");
  }

  @Test
  public void part2Test() {
    assertThat(create().part2("example-1.txt")).isEqualTo("444356092776315");
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
  public void part2TestRealIterativo() {
    assertThat(create().part2iterativo(10, 3)).isEqualTo(93726416205179L);
  }
}
