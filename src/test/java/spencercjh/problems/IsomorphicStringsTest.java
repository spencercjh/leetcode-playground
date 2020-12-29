package spencercjh.problems;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@MicronautTest
class IsomorphicStringsTest {

  @Inject
  private IsomorphicStrings solution;

  @Test
  void isIsomorphic() {
    assertTrue(solution.isIsomorphic("egg", "add"));
    assertTrue(solution.isIsomorphic("egg", "tdd"));
    assertTrue(solution.isIsomorphic("a", "a"));
    assertTrue(solution.isIsomorphic("a", "b"));
    assertTrue(solution.isIsomorphic("", ""));
    assertFalse(solution.isIsomorphic("ab", "aa"));
    assertTrue(solution.isIsomorphic("paper", "title"));
    assertFalse(solution.isIsomorphic("foo", "bar"));
  }
}
