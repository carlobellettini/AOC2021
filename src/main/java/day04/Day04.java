package day04;

import day00.Common;
import day00.Day;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Scanner;

public class Day04 extends Day {

  protected String part1(@NotNull List<String> input) {
    Bingo gioco = new Bingo(input.get(0));
    gioco.aggiungiTessere(input);

    int punteggioVincitore;
    do {
      punteggioVincitore = gioco.estraiProssimo();
    } while (punteggioVincitore == 0);

    return "" + punteggioVincitore;
  }


  protected String part1After2(@NotNull List<String> input) {
    Bingo gioco = new Bingo(input.get(0));
    gioco.aggiungiTessere(input);

    int turni = 100;
    int punti = 0;
    int winner = -1;
    for (Tessera tessera : gioco) {
      Tess result = tessera.giocaNumeri(new Scanner(input.get(0)));
      if (result.turno() < turni) {
        turni = result.turno();
        punti = result.punti();
        winner = result.giocatore();
      }
    }
    //System.out.println(winner);
    return "" + punti;
  }

  protected String part2(@NotNull List<String> input) {

    Bingo gioco = new Bingo(input.get(0));

    gioco.aggiungiTessere(input);

    int turni = 0;
    int punti = 0;
    int loser = -1;
    for (Tessera tessera : gioco) {
      Tess result = tessera.giocaNumeri(new Scanner(input.get(0)));
      if (result.turno() > turni) {
        turni = result.turno();
        punti = result.punti();
        loser = result.giocatore();
      }
    }
    //System.out.println(loser);
    return "" + punti;
  }
}





