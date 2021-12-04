package Day04;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

record Tess(int turno, int punti, int giocatore) {
}

public class Tessera {
  private int ID;
  private final int[][] numeri = new int[5][5];

  public Tessera(@NotNull List<String> numbers) {
    assert numbers.size() == 5;
    assert numbers.get(0).length() == 14;
    for (int i = 0; i < 5; i++) {
      Scanner linea = new Scanner(numbers.get(i));
      for (int j = 0; j < 5; j++) {
        numeri[i][j] = linea.nextInt();
      }
    }
  }

  @NotNull Tess giocaNumeri(@NotNull Scanner estrazioni) {
    estrazioni.useDelimiter(",");
    int turno = 0;

    while (estrazioni.hasNextInt()) {
      int numero = estrazioni.nextInt();
      turno++;
      if (segna(numero) && controllaVittoria())
        return new Tess(turno, numero * calcolaPunteggio(), this.ID);
    }
    return new Tess(100, 0, this.ID);
  }

  boolean segna(int estratto) {
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        if (estratto == numeri[i][j]) {
          numeri[i][j] = -100 + numeri[i][j];
          return true;
        }
      }
    }
    return false;
  }

  boolean controllaVittoria() {
    return controllaRighe() || controllaColonne();
  }

  private boolean controllaRighe() {
    return Arrays.stream(numeri)
        .anyMatch(riga -> Arrays.stream(riga)
            .noneMatch(numero -> numero > 0));
  }

  private boolean controllaColonne() {
    return IntStream.range(0, 5)
        .anyMatch(colonna -> IntStream.range(0, 5)
            .noneMatch(riga -> numeri[riga][colonna] > 0));
  }


  int calcolaPunteggio() {
    return Arrays.stream(numeri)
        .flatMapToInt(Arrays::stream)
        .filter(anInt -> anInt > 0)
        .sum();
  }

  public void setID(int i) {
    ID = i;
  }
}
