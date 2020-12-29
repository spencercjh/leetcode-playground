package spencercjh.problems;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
class PatchingArrayTest {

  @Inject
  private PatchingArray solution;

  @Test
  void minPatches() {
    assertEquals(2, solution.minPatches(new int[]{1, 5, 10}, 20));
    assertEquals(1, solution.minPatches(new int[]{1, 3}, 6));
    assertEquals(4, solution.minPatches(new int[]{}, 8));
  }
}
