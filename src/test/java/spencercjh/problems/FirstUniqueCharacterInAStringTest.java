package spencercjh.problems;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
class FirstUniqueCharacterInAStringTest {

  @Inject
  private FirstUniqueCharacterInAString solution;

  @Test
  void firstUniqChar() {
    assertEquals(0, solution.firstUniqChar("leetcode"));
    assertEquals(2, solution.firstUniqChar("loveleetcode"));
    assertEquals(-1, solution.firstUniqChar("aabbcc"));
  }

}
