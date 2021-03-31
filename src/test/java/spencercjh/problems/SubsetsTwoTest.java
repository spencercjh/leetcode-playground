package spencercjh.problems;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

@MicronautTest
class SubsetsTwoTest {
  @Inject
  private SubsetsTwo solution;

  @Test
  void subsetsWithDup() {
    final List<List<Integer>> result = solution.subsetsWithDup(new int[]{1, 2, 2});
    assertFalse(result.isEmpty());
  }
}
