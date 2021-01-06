package spencercjh.problems;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import spencercjh.Utils;

import javax.inject.Inject;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@MicronautTest
class PositionsOfLargeGroupsTest {

  @Inject
  private PositionsOfLargeGroups solution;

  @Test
  void largeGroupPositions1() {
    assertTrue(Utils.equals(List.of(List.of(3, 5), List.of(6, 9), List.of(12, 14)),
      solution.largeGroupPositions("abcdddeeeeaabbbcd")));
  }

  @Test
  void largeGroupPositions2() {
    assertTrue(Utils.equals(List.of(List.of(3, 6)), solution.largeGroupPositions("abbxxxxzzy")));
  }
}
