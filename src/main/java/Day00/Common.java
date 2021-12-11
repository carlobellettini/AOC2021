package Day00;


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

