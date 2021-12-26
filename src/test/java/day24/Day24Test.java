package day24;

import static org.assertj.core.api.Assertions.assertThat;

import day00.FetchInput;
import org.junit.*;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Day24Test {

  private Day24 create(){
    return new Day24();
  }

  @Test
  public void part1TestReal() {
    assertThat(create().part1()).isEqualTo("99429795993929");
  }

  @Test
  public void part2TestReal() {
    assertThat(create().part2()).isEqualTo("18113181571611");
  }

}
