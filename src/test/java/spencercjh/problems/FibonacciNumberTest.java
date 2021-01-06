package spencercjh.problems;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
class FibonacciNumberTest {

  @Inject
  private FibonacciNumber solution;

  @Test
  void fib() {
    assertEquals(0, solution.fib(0));
    assertEquals(1, solution.fib(1));
    assertEquals(1, solution.fib(2));
    assertEquals(2, solution.fib(3));
    assertEquals(3, solution.fib(4));
    assertEquals(5, solution.fib(5));
    assertEquals(8, solution.fib(6));
    assertEquals(13, solution.fib(7));
    assertEquals(21, solution.fib(8));
    assertEquals(34, solution.fib(9));
    assertEquals(55, solution.fib(10));
    assertEquals(89, solution.fib(11));
    assertEquals(144, solution.fib(12));
  }
}
