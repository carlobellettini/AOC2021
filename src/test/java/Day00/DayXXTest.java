package day00;

import static org.assertj.core.api.Assertions.assertThat;

import day00.FetchInput;
import day01.Day01;
import org.junit.*;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DayXXTest {

  /*@Rule
  public SystemOutRule output = new SystemOutRule().enableLog().muteForSuccessfulTests();
*/

  private DayXX create(){
    return new DayXX();
  }

  @Test@Ignore
  public void getInputFiles() {
    new FetchInput().retrieveDay("0", "2021");
  }

  @Test@Ignore
  public void part1Test() {
    assertThat(create().part1("example-1.txt")).isEqualTo("???");
    System.err.println("SOLUZIONE PARTE 1: <" + create().part1()+">");
  }

  @Test@Ignore
  public void part2Test() {
    assertThat(create().part2("example-1.txt")).isEqualTo("???");
    System.err.println("SOLUZIONE PARTE 2: <" + create().part2()+">");
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
