package Day00;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.List;
import java.util.Scanner;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Day {
  String input = "input.txt";

  final protected Scanner inputAsScanner() {
    return Common.scannerInput(this.getClass(), input);
  }

  final protected List<String> inputAsList() {
    return Common.stringListInput(this.getClass(), input);
  }

  final protected String inputAsString() {
    return Common.stringInput(this.getClass(), input);
  }

  final protected Stream<String> scannerToStream(Scanner scanner) {
    return StreamSupport
        .stream(Spliterators.spliteratorUnknownSize(scanner, Spliterator.ORDERED | Spliterator.NONNULL),
            false)
        .onClose(scanner::close);
  }

  final protected String inputAsString2(Class o, String name) {
    try {
      return Files.readString(FileSystems.getDefault().getPath(o.getResource(name).getPath()));
    } catch (IOException e) {
      e.printStackTrace();
    }
    assert false;
    return null;
  }

  protected String part1() {
    return "!!!";
  }

  protected String part2() {
    return "!!!";
  }

  final public String part1(String input) {
    this.input = input;
    return part1();
  }

  final public String part2(String input) {
    this.input = input;
    return part2();
  }
}
