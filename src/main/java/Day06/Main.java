package Day06;

import Day00.Common;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main  {

  public static void main(String[] args) {
    Scanner scanner = Common.scannerInput(Main.class, "input.txt");

    System.out.println("DAY 6 Part 1: " + part1(scanner));
    scanner = Common.scannerInput(Main.class, "input.txt");
    System.out.println("DAY 6 Part 2: " + part2(scanner));
  }


   static String part1(@NotNull Scanner input) {
    long[] lanterfish = readInitialStatus(input);
    for (int i = 0; i < 80; i++) nuovoGiorno(lanterfish);
    return "" + conteggio(lanterfish);
  }

   static String part2(@NotNull Scanner input) {
    long[] lanterfish = readInitialStatus(input);
    for (int i = 0; i < 256; i++) nuovoGiorno(lanterfish);
    return "" + conteggio(lanterfish);
  }

  private static long[] readInitialStatus(@NotNull Scanner input) {
    long[] lanterfish = new long[9];
    input.useDelimiter("[,\n]");
    while (input.hasNextInt()) {
      int nuovo = input.nextInt();
      assert nuovo >= 0 && nuovo < 9;
      lanterfish[nuovo]++;
    }
    return lanterfish;
  }

  private static void nuovoGiorno(long[] lanterfish) {
    long nuoviNati = lanterfish[0];
    for (int i = 0; i < 8; i++) {
      lanterfish[i] = lanterfish[i + 1];
    }
    lanterfish[6] += nuoviNati;
    lanterfish[8] = nuoviNati;
  }

  static long conteggio(long[] fishes) {
    return Arrays.stream(fishes).sum();
  }
}
