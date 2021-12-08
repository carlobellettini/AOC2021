package Day08;

import Day00.Day;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

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
    char[] tempArray = input.toCharArray();
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

    numberString[2] = getNumberString(numbers, List.of(f), 5, 5);                 //ACDFG
    numberString[5] = getNumberString(numbers, List.of(c), 5, 5);
    numberString[3] = getNumberString(numbers, cf, 5, 3);                         //ABDFG
    numberString[9] = getNumberString(numbers, getCharSet(numberString[4]), 6, 2); //ABCDFG

    numberString[0] = Stream.of(numbers)
        .filter(val -> !List.of(Arrays.copyOfRange(numberString, 1, 10)).contains(val)).findFirst().get(); //the last remaining one

    return numberString;
  }


  @NotNull
  private List<Integer> getCharSet(String s) {
    return s.chars().boxed().toList();
  }

  @NotNull
  private String getNumberString(String[] numbers, int dim) {
    return Stream.of(numbers).filter(e -> e.trim().length() == dim).findFirst().get();
  }

  @NotNull
  private String getNumberString(String[] numbers, List<Integer> toRemove, int dimBefore, int dimAfter) {
    return Stream.of(numbers)
        .filter(e -> e.trim().length() == dimBefore)
        .filter(e -> e.chars().filter(val -> !toRemove.contains(val)).count() == dimAfter).findFirst().get();
  }
}
