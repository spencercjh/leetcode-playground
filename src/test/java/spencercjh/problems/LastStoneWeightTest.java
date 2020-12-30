package spencercjh.problems;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
class LastStoneWeightTest {

  @Inject
  private LastStoneWeight solution;

  @Test
  void lastStoneWeight() {
    assertEquals(1, solution.lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}));
    assertEquals(1, solution.lastStoneWeight(new int[]{1}));
    assertEquals(0, solution.lastStoneWeight(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}));
  }

}
