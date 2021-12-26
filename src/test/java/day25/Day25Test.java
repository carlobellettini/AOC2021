package day25;

import static org.assertj.core.api.Assertions.assertThat;

import day00.FetchInput;
import org.junit.*;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Day25Test {

  private Day25 create(){
    return new Day25();
  }

  @Test
  public void part1Test() {
    assertThat(create().part1("example-1.txt")).isEqualTo("58");
  }
  @Test
  public void part1TestReal() {
    assertThat(create().part1()).isEqualTo("489");
  }
}
