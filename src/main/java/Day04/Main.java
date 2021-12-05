package Day04;

import Day00.Common;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Main {
  public static void main(String[] args) {
    List<String> listOfStrings = Common.readResourceToStringList(Main.class, "input.txt");

    System.out.println("DAY 4 Part 1: " + part1After2(listOfStrings));
    System.out.println("DAY 4 Part 2: " + part2(listOfStrings));
  }

  static String part1(@NotNull List<String> input) {
    Bingo gioco = new Bingo(input.get(0));
    gioco.aggiungiTessere(input);

    int punteggioVincitore;
    do {
      punteggioVincitore = gioco.estraiProssimo();
    } while (punteggioVincitore == 0);

    return "" + punteggioVincitore;
  }


  static String part1After2(@NotNull List<String> input) {
    Bingo gioco = new Bingo(input.get(0));
    gioco.aggiungiTessere(input);

    int turni = 100;
    int punti = 0;
    int winner = -1;
    for (Tessera tessera : gioco) {
      Tess result  = tessera.giocaNumeri(new Scanner(input.get(0)));
      if (result.turno() < turni) {
        turni = result.turno();
        punti = result.punti();
        winner = result.giocatore();
      }
    }
    System.out.println(winner);
    return ""+punti;
  }

  static String part2(@NotNull List<String> input) {

    Bingo gioco = new Bingo(input.get(0));

    gioco.aggiungiTessere(input);

    int turni = 0;
    int punti = 0;
    int loser = -1;
    for (Tessera tessera : gioco) {
      Tess result  = tessera.giocaNumeri(new Scanner(input.get(0)));
      if (result.turno() > turni) {
        turni = result.turno();
        punti = result.punti();
        loser = result.giocatore();
      }
    }
    System.out.println(loser);
    return ""+punti;
  }
}





