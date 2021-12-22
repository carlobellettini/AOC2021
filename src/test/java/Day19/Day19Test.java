package day19;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;


public class Day19Test {
  private Day19 d;

  @Before
  public void setUp() throws Exception {
    d = new Day19();
  }

  @Test
  public void testDay19_inputDiTest() {
    d.input = "example-6.txt";
    d.common_start();
    assertThat(d.part_1()).isEqualTo(79);
    assertThat(d.part_2()).isEqualTo(3621);
  }

  @Test
  public void testDay19_mioinput() {
    d.common_start();
    assertThat(d.part_1()).isEqualTo(462);
    assertThat(d.part_2()).isEqualTo(12158);
  }
}