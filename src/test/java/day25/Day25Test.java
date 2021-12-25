package day25;

import static org.assertj.core.api.Assertions.assertThat;

import day00.FetchInput;
import org.junit.*;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Day25Test {

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

  private Day25 create(){
    return new Day25();
  }

  @Test@Ignore
  public void getInputFiles() {
    new FetchInput().retrieveDay("25", "2021");
  }

  @Test@Ignore
  public void part1Test() {
    assertThat(create().part1("example-1.txt")).isEqualTo("58");
    System.err.println("SOLUZIONE PARTE 1: <" + create().part1()+">");
  }


  @Test@Ignore
  public void part1TestReal() {
    assertThat(create().part1()).isEqualTo("429");
  }


}
