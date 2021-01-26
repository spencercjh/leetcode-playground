package spencercjh.problems;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
class NumberOfEquivalentDominoPairsTest {

  @Inject
  private NumberOfEquivalentDominoPairs solution;

  @Test
  void numEquivDominoPairs() {
    assertEquals(1, solution.numEquivDominoPairs(new int[][]{{1, 2}, {2, 1}, {3, 4}, {5, 6}}));
  }

}
