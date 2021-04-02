package spencercjh.problems;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import spencercjh.ListNode;

import javax.inject.Inject;

import static spencercjh.AssertionUtils.assertArrayEquals;

@MicronautTest
class RemoveDuplicatesFromSortedListTest {

  @Inject
  private RemoveDuplicatesFromSortedList solution;

  @Test
  void deleteDuplicates() {
    assertArrayEquals(ListNode.parseListNodeToArray(solution.deleteDuplicates(
      ListNode.buildListNodeWithValues(1, 1, 2, 2, 3, 3, 4))), new int[]{1, 2, 3, 4});
  }

}
