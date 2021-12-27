package day06;

import day00.Day;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Day06 extends Day {

  @Override
  public String part1(List<String> input) {
    long[] lanterfish = readInitialStatus(input);
    for (int i = 0; i < 80; i++) nuovoGiorno(lanterfish);
    return "" + conteggio(lanterfish);
  }

  @Override
  public String part2(List<String> input) {
    long[] lanterfish = readInitialStatus(input);
    for (int i = 0; i < 256; i++) nuovoGiorno(lanterfish);
    return "" + conteggio(lanterfish);
  }

  private long[] readInitialStatus(@NotNull List<String> input) {
    long[] lanterfish = new long[9];
    for (String s : input) {
      Scanner inputS = new Scanner(s);
      inputS.useDelimiter("[,\n]");
      while (inputS.hasNextInt()) {
        int nuovo = inputS.nextInt();
        assert nuovo >= 0 && nuovo < 9;
        lanterfish[nuovo]++;
      }
      inputS.close();
    }
    return lanterfish;
  }

  private void nuovoGiorno(long[] lanterfish) {
    long nuoviNati = lanterfish[0];
    System.arraycopy(lanterfish, 1, lanterfish, 0, 8);
    lanterfish[6] += nuoviNati;
    lanterfish[8] = nuoviNati;
  }

  long conteggio(long[] fishes) {
    return Arrays.stream(fishes).sum();
  }
}
