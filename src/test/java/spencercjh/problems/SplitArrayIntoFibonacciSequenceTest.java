package spencercjh.problems;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
class SplitArrayIntoFibonacciSequenceTest {
  @Inject
  private SplitArrayIntoFibonacciSequence solution;

  @Test
  void splitIntoFibonacci() {
    assertEquals(List.of(123, 456, 579), solution.splitIntoFibonacci("123456579"));
    assertEquals(List.of(1, 1, 2, 3, 5, 8, 13), solution.splitIntoFibonacci("11235813"));
    assertEquals(Collections.emptyList(), solution.splitIntoFibonacci("0123"));
  }

  @Test
  void charsToNum() {
    assertEquals(Integer.parseInt("123"), solution.subDigitsToNum("123".toCharArray(), 0, "123".length() - 1));
    assertEquals(Integer.parseInt("10"), solution.subDigitsToNum("10".toCharArray(), 0, "10".length() - 1));
  }
}
