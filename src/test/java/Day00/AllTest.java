package day00;

import static org.assertj.core.api.Assertions.assertThat;

import day01.Day01;
import day02.Day02;
import day03.Day03;
import day04.Day04;
import day05.Day05;
import day06.Day06;
import day07.Day07;
import day08.Day08;
import day09.Day09;
import day10.Day10;
import day11.Day11;
import day12.Day12;
import day13.Day13;
import day14.Day14;
import day15.Day15;
import day16.Day16;
import day17.Day17;
import day18.Day18;
import day19.Day19;
import day20.Day20;
import day21.Day21;
import day22.Day22;
import day23.Day23;
import day24.Day24;
import day25.Day25;
import org.junit.Test;

public class AllTest {
  @Test
  public void allRealTest() {
    assertThat(new Day01().part1()).isEqualTo("1466");
    assertThat(new Day01().part2()).isEqualTo("1491");
    assertThat(new Day02().part1()).isEqualTo("1815044  (= 1988 * 913)");
    assertThat(new Day02().part2()).isEqualTo("1739283308  (= 1988 * 874891)");
    assertThat(new Day03().part1()).isEqualTo("2003336");
    assertThat(new Day03().part2()).isEqualTo("1877139");
    assertThat(new Day04().part1()).isEqualTo("49686");
    assertThat(new Day04().part2()).isEqualTo("26878");
    assertThat(new Day05().part1()).isEqualTo("8622");
    assertThat(new Day05().part2()).isEqualTo("22037");
    assertThat(new Day06().part1()).isEqualTo("345387");
    assertThat(new Day06().part2()).isEqualTo("1574445493136");
    assertThat(new Day07().part1()).isEqualTo("343441");
    assertThat(new Day07().part2()).isEqualTo("98925151");
    assertThat(new Day08().part1()).isEqualTo("397");
    assertThat(new Day08().part2()).isEqualTo("1027422");
    assertThat(new Day09().part1()).isEqualTo("491");
    assertThat(new Day09().part2()).isEqualTo("1075536");
    assertThat(new Day10().part1()).isEqualTo("399153");
    assertThat(new Day10().part2()).isEqualTo("2995077699");
    assertThat(new Day11().part1()).isEqualTo("1667");
    assertThat(new Day11().part2()).isEqualTo("488");
    assertThat(new Day12().part1()).isEqualTo("3576");
    assertThat(new Day12().part2()).isEqualTo("84271");
    assertThat(new Day13().part1()).isEqualTo("661");
    assertThat(new Day13().part2()).isEqualTo("Cosa leggi?");
    assertThat(new Day14().part1()).isEqualTo("2703");
    assertThat(new Day14().part2()).isEqualTo("2984946368465");
    assertThat(new Day15().part1()).isEqualTo("462");
    assertThat(new Day15().part2()).isEqualTo("2846");
    assertThat(new Day16().part1()).isEqualTo("875");
    assertThat(new Day16().part2()).isEqualTo("1264857437203");
    assertThat(new Day17().part1()).isEqualTo("13203");
    assertThat(new Day17().part2()).isEqualTo("5644");
    assertThat(new Day18().part1()).isEqualTo("4124");
    assertThat(new Day18().part2()).isEqualTo("4673");
    assertThat(new Day19().part1()).isEqualTo("462");
    assertThat(new Day19().part2()).isEqualTo("12158");
    assertThat(new Day20().part1()).isEqualTo("5400");
    assertThat(new Day20().part2()).isEqualTo("18989");
    assertThat(new Day21().part1()).isEqualTo("742257");
    assertThat(new Day21().part2()).isEqualTo("93726416205179");
    assertThat(new Day22().part1()).isEqualTo("537042");
    assertThat(new Day22().part2()).isEqualTo("1304385553084863");
    assertThat(new Day23().part1()).isEqualTo("15365");
    assertThat(new Day23().part2("inputP2.txt")).isEqualTo("52055");
    assertThat(new Day24().part1()).isEqualTo("99429795993929");
    assertThat(new Day24().part2()).isEqualTo("18113181571611");
    assertThat(new Day25().part1()).isEqualTo("489");

  }

  @Test
  public void AllTestReal2() {
    assertThat(new Day01().part1()).isEqualTo("1466");
    assertThat(new Day01().part2()).isEqualTo("1491");
    assertThat(new Day02().part1()).isEqualTo("1815044  (= 1988 * 913)");
    assertThat(new Day02().part2()).isEqualTo("1739283308  (= 1988 * 874891)");
    assertThat(new Day03().part1()).isEqualTo("2003336");
    assertThat(new Day03().part2()).isEqualTo("1877139");
    assertThat(new Day04().part1()).isEqualTo("49686");
    assertThat(new Day04().part2()).isEqualTo("26878");
    assertThat(new Day05().part1()).isEqualTo("8622");
    assertThat(new Day05().part2()).isEqualTo("22037");
    assertThat(new Day06().part1()).isEqualTo("345387");
    assertThat(new Day06().part2()).isEqualTo("1574445493136");
    assertThat(new Day07().part1()).isEqualTo("343441");
    assertThat(new Day07().part2()).isEqualTo("98925151");
    assertThat(new Day08().part1()).isEqualTo("397");
    assertThat(new Day08().part2()).isEqualTo("1027422");
    assertThat(new Day09().part1()).isEqualTo("491");
    assertThat(new Day09().part2()).isEqualTo("1075536");
    assertThat(new Day10().part1()).isEqualTo("399153");
    assertThat(new Day10().part2()).isEqualTo("2995077699");
    assertThat(new Day11().part1()).isEqualTo("1667");
    assertThat(new Day11().part2()).isEqualTo("488");
    assertThat(new Day12().part1()).isEqualTo("3576");
    assertThat(new Day12().part2()).isEqualTo("84271");
    assertThat(new Day13().part1()).isEqualTo("661");
    assertThat(new Day13().part2()).isEqualTo("Cosa leggi?");
    assertThat(new Day14().part1()).isEqualTo("2703");
    assertThat(new Day14().part2()).isEqualTo("2984946368465");
    assertThat(new Day15().part1()).isEqualTo("462");
    assertThat(new Day15().part2()).isEqualTo("2846");
    assertThat(new Day16().part1()).isEqualTo("875");
    assertThat(new Day16().part2()).isEqualTo("1264857437203");
    assertThat(new Day17().part1()).isEqualTo("13203");
    assertThat(new Day17().part2()).isEqualTo("5644");
    assertThat(new Day18().part1()).isEqualTo("4124");
    assertThat(new Day18().part2()).isEqualTo("4673");
    assertThat(new Day19().part1()).isEqualTo("462");
    assertThat(new Day19().part2()).isEqualTo("12158");
    assertThat(new Day20().part1()).isEqualTo("5400");
    assertThat(new Day20().part2()).isEqualTo("18989");
    assertThat(new Day21().part1()).isEqualTo("742257");
    assertThat(new Day21().part2()).isEqualTo("93726416205179");
    assertThat(new Day22().part1()).isEqualTo("537042");
    assertThat(new Day22().part2()).isEqualTo("1304385553084863");
    assertThat(new Day23().part1()).isEqualTo("15365");
    assertThat(new Day23().part2("inputP2.txt")).isEqualTo("52055");
    assertThat(new Day24().part1()).isEqualTo("99429795993929");
    assertThat(new Day24().part2()).isEqualTo("18113181571611");
    assertThat(new Day25().part1()).isEqualTo("489");

  }
}

