package day16;

import static org.assertj.core.api.Assertions.assertThat;

import day00.FetchInput;
import org.junit.Ignore;
import org.junit.Test;


public class Day16Test {

  private Day16 create() {
    return new Day16();
  }

  @Test
  @Ignore
  public void getInputFiles() {
    new FetchInput().retrieveDay("16", "2021");
  }

  @Test
  public void part1Test() {
    assertThat(create().part1("example-3.txt")).isEqualTo("9");
    assertThat(create().part1("example-1.txt")).isEqualTo("16");
    assertThat(create().part1("example-2.txt")).isEqualTo("12");
    System.err.println("SOLUZIONE PARTE 1: <" + create().part1() + ">");
  }

  @Test
  public void parseStringHexTestPart2() {
    assertThat(create().parseStringHex("C200B40A82")).isEqualTo("3");
    assertThat(create().parseStringHex("04005AC33890")).isEqualTo("54");
    assertThat(create().parseStringHex("880086C3E88112")).isEqualTo("7");
    assertThat(create().parseStringHex("CE00C43D881120")).isEqualTo("9");
    assertThat(create().parseStringHex("620080001611562C8802118E34")).isEqualTo("46");
    assertThat(create().parseStringHex("D2FE28")).isEqualTo("2021");
    assertThat(create().parseStringHex("F600BC2D8F")).isEqualTo("0");
    assertThat(create().parseStringHex("9C005AC2F8F0")).isEqualTo("0");
    assertThat(create().parseStringHex("D8005AC2A8F0")).isEqualTo("1");
  }

  @Test
  public void part2Test() {
    assertThat(create().parseStringHex("9C0141080250320F1802104A08")).isEqualTo("1");
    System.err.println("SOLUZIONE PARTE 2: <" + create().part2() + ">");

  }

  @Test
  public void part1TestReal() {
    assertThat(create().part1()).isEqualTo("875");
  }

  @Test
  public void part2TestReal() {
    assertThat(create().part2()).isEqualTo("1264857437203");
  }
}
