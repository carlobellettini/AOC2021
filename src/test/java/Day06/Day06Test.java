package day06;


import static org.assertj.core.api.Assertions.assertThat;

import day00.Common;
import day00.Day;
import day04.Day04;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Scanner;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Day06Test {

  private Day06 create() {
    return new Day06();
  }

  @Test
  public void part1Test() {
    assertThat(create().part1("example-1.txt")).isEqualTo("5934");
  }

  @Test
  public void part2Test() {
    assertThat(create().part2("example-1.txt")).isEqualTo("26984457539");
  }

  @Test
  public void part1TestReal() {
    assertThat(create().part1()).isEqualTo("345387");
  }

  @Test
  public void part2TestReal() {
    assertThat(create().part2()).isEqualTo("1574445493136");
  }
}
