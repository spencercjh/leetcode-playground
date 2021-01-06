package spencercjh.problems;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static spencercjh.ListNode.buildListNodeWithValues;
import static spencercjh.ListNode.parseListNodeToArray;

@MicronautTest
class PartitionListTest {

  @Inject
  private PartitionList solution;

  @Test
  void partition() {
    assertTrue(Arrays.equals(new int[]{1, 2, 2, 4, 3, 5},
      parseListNodeToArray(solution.partition(buildListNodeWithValues(1, 4, 3, 2, 5, 2), 3))));
  }
}
