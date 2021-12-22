package day00;


import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Common {
  public static long lcm(long number1, long number2) {
    if (number1 == 0 || number2 == 0) {
      return 0;
    }
    long absNumber1 = Math.abs(number1);
    long absNumber2 = Math.abs(number2);
    long absHigherNumber = Math.max(absNumber1, absNumber2);
    long absLowerNumber = Math.min(absNumber1, absNumber2);
    long lcm = absHigherNumber;
    while (lcm % absLowerNumber != 0) {
      lcm += absHigherNumber;
    }
    return lcm;
  }

  static public <T>  Scanner scannerInput(Class<T> o, String name) {
    InputStream inputStream = o.getResourceAsStream(name);
    assert inputStream != null : "error in reading resource " + name;
    return new Scanner(inputStream);
  }

  static public <T> List<String> stringListInput(Class<T> o, String name) {
    Scanner input = scannerInput(o, name);
    List<String> stringInput = new ArrayList<>();
    while (input.hasNextLine())
      stringInput.add(input.nextLine().intern());
    return stringInput;
  }

  static public <T> String stringInput(Class<T> o, String name) {
    try {
      return IOUtils.toString(o.getResourceAsStream(name), StandardCharsets.UTF_8.name());
    } catch (IOException e) {
      throw new IllegalStateException("Fallita lettura risorsa in stringa");
    }
  }
}

