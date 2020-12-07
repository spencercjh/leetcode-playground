package spencercjh.problems;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@MicronautTest
class PascalsTriangleTest {
  @Inject
  private PascalsTriangle solution;

  @Test
  void generate() {
    final List<List<Integer>> actual = solution.generate(5);
    actual.forEach(row -> {
      row.forEach(element -> System.out.print(element + " "));
      System.out.println();
    });
    assertEquals(5, actual.size());
    assertTrue(Arrays.equals(new Integer[]{1, 4, 6, 4, 1}, actual.get(actual.size() - 1).toArray()));
  }
}
