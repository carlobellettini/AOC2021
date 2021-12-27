package day00;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.List;
import java.util.Scanner;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Day {
  static {
    System.setProperty("java.util.logging.SimpleFormatter.format",
        "%5$s%n");
  }

  String input = "input.txt";
  Logger log = Logger.getAnonymousLogger();

  final protected Scanner inputAsScanner() {
    return Common.scannerInput(this.getClass(), input);
  }

  protected List<String> inputAsList() {
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

  public String part1() {
    List<String> input = inputAsList();
    long start = System.nanoTime();
    String s = part1(input);
    long end = System.nanoTime();
    log.info("["+getClass().getSimpleName()+ " P1] "+ ((end - start)/1000000.0) + "ms");
    return s;
  }

  public String part2() {
    List<String> input = inputAsList();
    long start = System.nanoTime();
    String s = part2(input);
    long end = System.nanoTime();
    log.info("["+getClass().getSimpleName()+ " P2] "+ (end - start)/1000000.0 + "ms");
    return s;
  }

  protected String part1(List<String> input) {
    return "!!!";
  }

  protected String part2(List<String> input) {
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
