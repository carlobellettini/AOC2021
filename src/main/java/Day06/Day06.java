package Day06;

import Day00.Day;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Scanner;

public class Day06 extends Day {

  @Override
  protected String part1() {
    long[] lanterfish = readInitialStatus(inputAsScanner());
    for (int i = 0; i < 80; i++) nuovoGiorno(lanterfish);
    return "" + conteggio(lanterfish);
  }

  @Override
  protected String part2() {
    long[] lanterfish = readInitialStatus(inputAsScanner());
    for (int i = 0; i < 256; i++) nuovoGiorno(lanterfish);
    return "" + conteggio(lanterfish);
  }

  private  long[] readInitialStatus(@NotNull Scanner input) {
    input.useDelimiter("[,\n]");

    long[] lanterfish = new long[9];
    while (input.hasNextInt()) {
      int nuovo = input.nextInt();
      assert nuovo >= 0 && nuovo < 9;
      lanterfish[nuovo]++;
    }
    return lanterfish;
  }

  private  void nuovoGiorno(long[] lanterfish) {
    long nuoviNati = lanterfish[0];
    for (int i = 0; i < 8; i++) lanterfish[i] = lanterfish[i + 1];
    lanterfish[6] += nuoviNati;
    lanterfish[8] = nuoviNati;
  }

  long conteggio(long[] fishes) {
    return Arrays.stream(fishes).sum();
  }
}
