package spencercjh.problems;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import spencercjh.Utils;

import javax.inject.Inject;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@MicronautTest
class BinaryPrefixDivisibleBy5Test {

  @Inject
  private BinaryPrefixDivisibleBy5 solution;

  @Test
  void prefixesDivBy5() {
    assertTrue(Utils.equals(List.of(true, false, false), solution.prefixesDivBy5(new int[]{0, 1, 1})));
    assertTrue(Utils.equals(List.of(false, false, false), solution.prefixesDivBy5(new int[]{1, 1, 1})));
  }

}
