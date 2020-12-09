package spencercjh.problems;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
class StringToIntegerAtoiTest {
  @Inject
  private StringToIntegerAtoi solution;

  @Test
  void myAtoi() {
    assertEquals(123, solution.myAtoi("123"));
    assertEquals(123, solution.myAtoi("+123"));
    assertEquals(123, solution.myAtoi("      +123"));
    assertEquals(-123, solution.myAtoi("      -123"));
    assertEquals(123, solution.myAtoi("      123 is one two three"));
    assertEquals(0, solution.myAtoi("      one two three is 123"));
    assertEquals(Integer.MIN_VALUE, solution.myAtoi("-91283472332"));
    assertEquals(Integer.MAX_VALUE - 1, solution.myAtoi("2147483646"));
  }

  @Test
  void outOfBounds() {
    final int maxValue = Integer.MAX_VALUE;
    assertTrue(maxValue + 1 < maxValue);
    final int minValue = Integer.MIN_VALUE;
    assertTrue(minValue - 1 > minValue);
    assertThrows(NumberFormatException.class, () -> {
      final int ignore = Integer.parseInt("-6147483648");
    });
  }
}
