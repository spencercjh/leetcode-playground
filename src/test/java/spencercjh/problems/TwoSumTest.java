package spencercjh.problems;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;


@MicronautTest
class TwoSumTest {
  @Inject
  private TwoSum solution;

  static Stream<Arguments> PARAMETERS_PROVIDER() {
    return Stream.of(Arguments.of(new int[]{2, 7, 11, 5}, 9));
  }

  @ParameterizedTest
  @MethodSource(value = {"PARAMETERS_PROVIDER"})
  void twoSum(int[] nums, int target) {
    assertTrue(Arrays.equals(solution.twoSum(nums, target), new int[]{0, 1}));
  }
}
