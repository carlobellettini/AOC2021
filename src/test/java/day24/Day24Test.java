package day24;

import static org.assertj.core.api.Assertions.assertThat;

import day00.FetchInput;
import org.junit.*;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Day24Test {

  /*@Rule
  public SystemOutRule output = new SystemOutRule().enableLog().muteForSuccessfulTests();
*/
  @Rule
  public TestName name = new TestName();
  private long start, end;

  @Before
  public void setUp() throws Exception {
    start = System.currentTimeMillis();
  }

  @After
  public void tearDown() throws Exception {
    end = System.currentTimeMillis();
    System.err.println(name.getMethodName() + ": " + (end - start) + "ms");
  }

  private Day24 create(){
    return new Day24();
  }

  @Test@Ignore
  public void getInputFiles() {
    new FetchInput().retrieveDay("24", "2021");
  }

  @Test@Ignore
  public void part1Test() {
    assertThat(create().part1("example-1.txt")).isEqualTo("???");
    System.err.println("SOLUZIONE PARTE 1: <" + create().part1()+">");
  }

  @Test@Ignore
  public void part2Test() {
    assertThat(create().part2("example-1.txt")).isEqualTo("???");
    System.err.println("SOLUZIONE PARTE 2: <" + create().part2()+">");
  }

  @Test@Ignore
  public void part1TestReal() {
    assertThat(create().part1()).isEqualTo("99429795993929");
  }

  @Test@Ignore
  public void part2TestReal() {
    assertThat(create().part2()).isEqualTo("18113181571611");
  }

  /*@Test
  public void testSearch() {
    var d = create();
    d.input = d.inputAsList();
    d.searchMin("17",3);
  }*/
}