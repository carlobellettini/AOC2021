package day04;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Bingo implements Iterable<Tessera>{
  @NotNull final private Scanner estrazioni;
  final private List<Tessera> tessere = new ArrayList<>();

  public Bingo(@NotNull String numeriEstratti) {
    estrazioni = new Scanner(numeriEstratti);
    estrazioni.useDelimiter(",");
  }

  void aggiungiTessere(@NotNull List<String> input) {
    int numlinea = 2;
    int counterID = 0;
    do {
      final Tessera t = new Tessera(input.subList(numlinea, numlinea + 5));
      t.setID(counterID++);
      addTessera(t);

      numlinea += 6;
    } while (numlinea < input.size());
  }

  int estraiProssimo() {
    if (estrazioni.hasNextInt()) {
      int numero = estrazioni.nextInt();
      // System.err.println("numero = " + numero);
      for (Tessera tessera : tessere) {
        if (tessera.segna(numero) && tessera.controllaVittoria())
          return numero * tessera.calcolaPunteggio();
      }
      return 0;
    }
    return -1;
  }

  void addTessera(@NotNull Tessera t) {
    tessere.add(t);
  }


  @NotNull
  @Override
  public Iterator<Tessera> iterator() {
    return tessere.iterator();
  }
}
