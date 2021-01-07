package spencercjh.problems;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@MicronautTest
class EvaluateDivisionTest {

  @Inject
  private EvaluateDivision solution;

  @Test
  void calcEquation() {
    assertTrue(Arrays.equals(new double[]{6.0, 0.5, -1.0, 1.0, -1.0},
      solution.calcEquation(List.of(List.of("a", "b"), List.of("b", "c")),
        new double[]{2, 3}, List.of(List.of("a", "c"), List.of("b", "a"),
          List.of("a", "e"), List.of("a", "a"), List.of("x", "x")))));

    assertTrue(Arrays.equals(new double[]{3.75, 0.4, 5.0, 0.2, -1.0},
      solution.calcEquation(List.of(List.of("a", "b"), List.of("b", "c"),
        List.of("bc", "cd")), new double[]{1.5, 2.5, 5.0},
        List.of(List.of("a", "c"), List.of("c", "b"), List.of("bc", "cd"),
          List.of("cd", "bc"), List.of("x", "x")))));
  }

}
