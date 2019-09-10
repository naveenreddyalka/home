package ok.toptal;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestToptal {
  Toptal3 toptal3 = new Toptal3();

  @Test
  public void case1() {
    assertEquals(toptal3.test1(123, 456),0);
    assertEquals(toptal3.test1(555, 555),3);
    assertEquals(toptal3.test1(900, 1),0);
    assertEquals(toptal3.test1(145, 55),2);
    assertEquals(toptal3.test1(0, 0),0);
    assertEquals(toptal3.test1(1, 99999),5);
    assertEquals(toptal3.test1(999045, 1055),5);
  }

  
}
