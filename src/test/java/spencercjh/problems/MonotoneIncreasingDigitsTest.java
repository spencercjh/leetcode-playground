package spencercjh.problems;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
class MonotoneIncreasingDigitsTest {

  @Inject
  private MonotoneIncreasingDigits solution;

  @Test
  void monotoneIncreasingDigits() {
    assertEquals(299, solution.monotoneIncreasingDigits(332));
    assertEquals(9, solution.monotoneIncreasingDigits(10));
    assertEquals(1234, solution.monotoneIncreasingDigits(1234));
    assertEquals(4499, solution.monotoneIncreasingDigits(4532));
    assertEquals(0, solution.monotoneIncreasingDigits(0));
    assertEquals(1, solution.monotoneIncreasingDigits(1));
  }
}
