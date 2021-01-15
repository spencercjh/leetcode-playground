package spencercjh.problems;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
class IntegerToRomanTest {
  @Inject
  private IntegerToRoman solution;

  @Test
  void intToRoman() {
    assertEquals("III", solution.intToRoman(3));
    assertEquals("IV", solution.intToRoman(4));
    assertEquals("IX", solution.intToRoman(9));
    assertEquals("LVIII", solution.intToRoman(58));
    assertEquals("MCMXCIV", solution.intToRoman(1994));
  }
}
