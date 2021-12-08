package Day08;

import Day00.Day;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day08 extends Day {
  @Override
  protected String part1() {
    List<String> input = inputAsList();

    int counter = 0;
    for (String s : input) {
      String[] part = s.split("\\|");

      for (String num : part[1].split(" ")) {
        if (List.of(2, 3, 4, 7).contains(num.length()))
          counter++;
      }
    }
    return "" + counter;
  }

  @Override
  protected String part2() {
    List<String> input = inputAsList();

    int counter = 0;

    for (String s : input) {
      String[] numberString = new String[10];
      String[] part = s.split("\\|");

      int value = valDecoded(decode(part[0]), part[1]);
      counter += value;
    }
    return "" + counter;
  }

  public String sort(String input) {
    char tempArray[] = input.toCharArray();
    Arrays.sort(tempArray);
    return new String(tempArray);
  }

  int indiceDi(String a, String[] b) {
    for (int i = 0; i < b.length; i++) {
      if (sort(a).equals(sort(b[i])))
        return i;
    }
    assert (false);
    return -1;
  }

  private int valDecoded(String[] decoded, String s) {
    int value = 0;
    for (String cifra : s.trim().split(" ")) {
      value = value * 10 + indiceDi(cifra, decoded);
    }
    return value;
  }

  protected String[] decode(String s) {
    String[] numberString = new String[10];
    String[] numbers = s.split(" ");

    numberString[1] = getNumberString(numbers, 2);                                              //CF
    numberString[4] = getNumberString(numbers, 4);                                              //BCDF
    numberString[7] = getNumberString(numbers, 3);                                              //ACF
    numberString[8] = getNumberString(numbers, 7);                                              //ABCDEFG

    List<Integer> cf = getCharSet(numberString[1]);
    numberString[6] = getNumberString(numbers, cf, 6, 5);                          //ABDEFG

    int c = numberString[8].chars().filter(e -> numberString[6].indexOf(e) < 0).findFirst().getAsInt(); //C
    int f = numberString[1].chars().filter(e -> e != c).findFirst().getAsInt();                         //F

    numberString[2] = getNumberString(numbers, List.of(f), 5, 5);                  //ABDFG
    numberString[3] = getNumberString(numbers, cf, 5, 3);                          //ACDFG
    numberString[5] = getNumberString(numbers, List.of(c), 5, 5);                  //ABDFG
    numberString[9] = getNumberString(numbers, getCharSet(numberString[4]), 6, 2); //ABCDFG

    List<String> allNumbers = new ArrayList<>(List.of(numbers));
    Arrays.stream(numberString, 1, 10).forEach(allNumbers::remove);
    numberString[0] = allNumbers.stream().findFirst().get();                                         //ABCEFG

    return numberString;
  }

  private String getNumberString(String[] numbers, int dim) {
    return Arrays.stream(numbers).filter(e -> e.trim().length() == dim).findFirst().get();
  }

  @NotNull
  private List<Integer> getCharSet(String s) {
    return s.chars().boxed().toList();
  }

  private String getNumberString(String[] numbers, List<Integer> toRemove, int dimBefore, int dimAfter) {
    return Arrays.stream(numbers)
        .filter(e -> e.trim().length() == dimBefore)
        .filter(e -> {
          List<Integer> cand = new ArrayList<Integer>(e.chars().boxed().toList());
          cand.removeAll(toRemove);
          return cand.size() == dimAfter;
        }).findFirst().get();
  }
}
