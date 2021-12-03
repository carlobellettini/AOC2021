package Day01;

import Day00.Common;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {

    System.out.println("DAY 1 Part 1: " + sum(1,
        Common.readResourceToScanner(Main.class,"input.txt")));
    System.out.println("DAY 1 Part 2: " + sum(3,
        Common.readResourceToScanner(Main.class,"input.txt")));

  }
  
  static int sum(int windowSize, Scanner input) {
    int[] window = new int[windowSize];
    init(window, windowSize, input);
    int counter = 0;
    int pos = 0;
    while (input.hasNextInt()) {
      int nuovo = input.nextInt();
      if (nuovo > window[pos]) counter++;
      window[pos] = nuovo;
      pos = (pos+1)%windowSize;
    }
    return counter;
  }

  private static void init(int[] window, int windowSize, Scanner input) {
    for (int i = 0; i < windowSize; i++) {
      window[i] = input.nextInt();
    }
  }

}
