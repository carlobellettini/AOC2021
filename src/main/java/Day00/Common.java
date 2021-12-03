package Day00;



import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Common {
  static public Scanner readResourceToScanner(Class o, String name) {
    InputStream inputStream = o.getResourceAsStream(name);
    assert inputStream != null : "error in reading resource " + name;
    return new Scanner(inputStream);
  }

  static public List<String> readResourceToStringList(Class o, String name) {
    Scanner input = readResourceToScanner(o, name);
    List<String> stringInput = new ArrayList<>();
    while (input.hasNextLine())
      stringInput.add(input.nextLine().intern());
    return stringInput;
  }

  static public String readResourceToString(Class o, String name) throws IOException {
    return IOUtils.toString(o.getResourceAsStream(name), StandardCharsets.UTF_8.name());
  }

  public static void main(String[] args) {
    Day01.Main.main(args);
    Day02.Main.main(args);
    Day03.Main.main(args);
  }
}
