package spencercjh.problems;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;


@MicronautTest
class GroupAnagramsTest {
  @Inject
  private GroupAnagrams solution;

  @Test
  void groupAnagrams() {
    assertEquals(3, solution.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}).size());
  }
}
