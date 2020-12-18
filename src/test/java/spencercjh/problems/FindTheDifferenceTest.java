package spencercjh.problems;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
class FindTheDifferenceTest {

  @Inject
  private FindTheDifference solution;

  @Test
  void findTheDifference() {
    assertEquals('a', solution.findTheDifference("aaa", "aaaa"));
    assertEquals('b', solution.findTheDifference("a", "ab"));
  }

}
