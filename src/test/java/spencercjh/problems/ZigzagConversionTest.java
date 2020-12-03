package spencercjh.problems;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
class ZigzagConversionTest {
  @Inject
  private ZigzagConversion solution;

  @Test
  void convert() {
    assertEquals("LCIRETOESIIGEDHN", solution.convert("LEETCODEISHIRING", 3));
    assertEquals("LDREOEIIECIHNTSG", solution.convert("LEETCODEISHIRING", 4));
  }
}
