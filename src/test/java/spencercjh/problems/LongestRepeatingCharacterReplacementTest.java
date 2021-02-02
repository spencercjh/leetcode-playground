package spencercjh.problems;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
class LongestRepeatingCharacterReplacementTest {

  @Inject
  private LongestRepeatingCharacterReplacement solution;

  @Test
  void characterReplacement() {
    assertEquals(4, solution.characterReplacement("AABABBA", 1));
  }

}
