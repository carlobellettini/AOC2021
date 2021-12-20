package Day18;

import static org.assertj.core.api.Assertions.assertThat;

import Day00.FetchInput;
import org.junit.Ignore;
import org.junit.Test;


public class Day18Test {


  private Day18 create() {
    return new Day18();
  }

  @Test
  @Ignore
  public void getInputFiles() {
    new FetchInput().retrieveDay("18", "2021");
  }

  @Test
  public void part1Test() {
    assertThat(create().part1("example-6.txt")).isEqualTo("3488");
    assertThat(create().part1("example-8.txt")).isEqualTo("4140");
    System.err.println("SOLUZIONE PARTE 1: <" + create().part1() + ">");
  }

  @Test
  public void part2Test() {
    assertThat(create().part2("example-8.txt")).isEqualTo("3993");
    System.err.println("SOLUZIONE PARTE 2: <" + create().part2() + ">");
  }

  @Test
  public void part1TestReal() {
    assertThat(create().part1()).isEqualTo("4124");
  }

  @Test
  public void part2TestReal() {
    assertThat(create().part2()).isEqualTo("4673");
  }

  @Test
  public void testSplit() {
    Tree x = new Tree("[[7,8],[0,13]]");
    x.root.split();
    assertThat(x).asString().isEqualTo("[[7,8],[0,[6,7]]]");
  }

  @Test
  public void testExplode() {
    Tree x = new Tree("[[[[[9,8],1],2],3],4]");
    x.root.explode();
    assertThat(x).asString().isEqualTo("[[[[0,9],2],3],4]");
  }

  @Test
  public void testReduce() {
    Tree x = new Tree("[[[[[9,8],1],2],3],4]");
    x.reduce();
    assertThat(x).asString().isEqualTo("[[[[0,9],2],3],4]");
  }

  @Test
  public void testReduce2() {
    Tree x = new Tree("[[[[[4,3],4],4],[7,[[8,4],9]]],[1,1]]");
    x.reduce();
    assertThat(x).asString().isEqualTo("[[[[0,7],4],[[7,8],[6,0]]],[8,1]]");
  }

  @Test
  public void magnitudo() {
    Tree x = new Tree("[[[[8,7],[7,7]],[[8,6],[7,7]]],[[[0,7],[6,6]],[8,7]]]");
    assertThat(x.magnitude()).isEqualTo(3488);
  }
}
