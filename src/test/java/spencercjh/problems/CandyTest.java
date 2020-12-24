package spencercjh.problems;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
class CandyTest {

  @Inject
  private Candy solution;

  @Test
  void candy() {
    assertEquals(3, solution.candy(new int[]{1, 1, 1}));
    assertEquals(5, solution.candy(new int[]{1, 0, 2}));
    assertEquals(4, solution.candy(new int[]{1, 2, 2}));
    assertEquals(13, solution.candy(new int[]{1, 2, 87, 87, 87, 2, 1}));
  }

}
