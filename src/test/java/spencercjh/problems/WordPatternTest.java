package spencercjh.problems;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@MicronautTest
class WordPatternTest {

  @Inject
  private WordPattern solution;

  @Test
  void wordPattern() {
    assertTrue(solution.wordPattern("abba", "dog cat cat dog"));
    assertFalse(solution.wordPattern("abba", "dog cat cat fish"));
    assertFalse(solution.wordPattern("aaaa", "dog cat cat dog"));
    assertFalse(solution.wordPattern("abba", "dog dog dog dog"));
  }

}
