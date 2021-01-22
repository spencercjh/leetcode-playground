package spencercjh.problems;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import spencercjh.Utils;

import javax.inject.Inject;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@MicronautTest
class AddToArrayFormOfIntegerTest {

  @Inject
  private AddToArrayFormOfInteger solution;

  @Test
  void addToArrayForm() {
    assertTrue(Utils.equals(List.of(1, 2, 3, 4), solution.addToArrayForm(new int[]{1, 2, 0, 0}, 34)));
    assertTrue(Utils.equals(List.of(4, 5, 5), solution.addToArrayForm(new int[]{2, 7, 4}, 181)));
    assertTrue(Utils.equals(List.of(1, 0, 2, 1), solution.addToArrayForm(new int[]{2, 1, 5}, 806)));
    assertTrue(Utils.equals(List.of(1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), solution.addToArrayForm(new int[]{9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, 1)));
    assertTrue(Utils.equals(List.of(1, 0, 0, 0, 0), solution.addToArrayForm(new int[]{1}, 9999)));
  }
}
