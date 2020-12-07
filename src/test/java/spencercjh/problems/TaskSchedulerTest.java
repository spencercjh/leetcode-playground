package spencercjh.problems;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
class TaskSchedulerTest {
  @Inject
  private TaskScheduler solution;

  @Test
  void leastInterval() {
    assertEquals(8, solution.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));
    assertEquals(16, solution.leastInterval(
      new char[]{'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'}, 2));
    assertEquals(12, solution.leastInterval(
      new char[]{'A', 'A', 'A', 'B', 'B', 'B', 'C', 'C', 'C', 'D', 'D', 'E'}, 2));
  }
}
