package day04;


import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.INT_2D_ARRAY;

import day00.Common;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.List;
import java.util.Scanner;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Day04Test {

  private List<String> listOfStrings;

  private Day04 create() {
    return new Day04();
  }

  @Test
  public void part1Test() {
    assertThat(create().part1("example-1.txt")).isEqualTo("4512");
  }

  @Test
  public void part2Test() {
    assertThat(create().part2("example-1.txt")).isEqualTo("1924");
  }

  @Test
  public void part1TestReal() {
    assertThat(create().part1()).isEqualTo("49686");
  }

  @Test
  public void part2TestReal() {
    assertThat(create().part2()).isEqualTo("26878");
  }

  @Before
  public void setUp() {
    listOfStrings = Common.stringListInput(Day04.class, "example-1.txt");
  }

  @Test
  public void testCostruttoreTessera() {
    Tessera mia = new Tessera(Common.stringListInput(Day04.class, "example-1.txt").subList(2, 2 + 5));
    assertThat(mia).extracting("numeri", as(INT_2D_ARRAY)).isDeepEqualTo(new int[][]{
        {22, 13, 17, 11, 0},
        {8, 2, 23, 4, 24},
        {21, 9, 14, 16, 7},
        {6, 10, 3, 18, 5},
        {1, 12, 20, 15, 19}});
  }

  @Test
  public void testPunteggio() {
    Tessera mia = new Tessera(listOfStrings.subList(14, 14 + 5));
    Bingo gioco = new Bingo(listOfStrings.get(0));
    gioco.addTessera(mia);

    int punteggio;
    do {
      punteggio = gioco.estraiProssimo();
    } while (punteggio == 0);

    assertThat(punteggio).isEqualTo(4512);
  }

  @Test
  public void controllaColonne() {
    Tessera mia = new Tessera(listOfStrings.subList(2, 2 + 5));
    assertThat(mia.controllaVittoria()).isFalse();
    mia.segna(13);
    assertThat(mia.controllaVittoria()).isFalse();
    mia.segna(9);
    mia.segna(2);
    mia.segna(12);
    mia.segna(7);
    assertThat(mia.controllaVittoria()).isFalse();
    mia.segna(10);
    assertThat(mia.controllaVittoria()).isTrue();
  }

  @Test
  public void testAggiungiTessere() {
    Bingo gioco = new Bingo(listOfStrings.get(0));
    gioco.aggiungiTessere(listOfStrings);

    int punteggio;
    do {
      punteggio = gioco.estraiProssimo();
    } while (punteggio == 0);

    assertThat(punteggio).isEqualTo(4512);
  }

  @Test
  public void TestPunteggioTessera() {
    Tessera SUT = new Tessera(listOfStrings.subList(14, 14 + 5));

    Tess res = SUT.giocaNumeri(new Scanner(listOfStrings.get(0)));

    assertThat(res.punti()).isEqualTo(4512);
    assertThat(res.turno()).isEqualTo(12);
  }
}
