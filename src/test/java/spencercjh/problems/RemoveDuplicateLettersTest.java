package spencercjh.problems;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
class RemoveDuplicateLettersTest {

  @Inject
  private RemoveDuplicateLetters solution;

  @Test
  void removeDuplicateLetters() {
    assertEquals("abc", solution.removeDuplicateLetters("bcabc"));
    assertEquals("acdb", solution.removeDuplicateLetters("cbacdbc"));
  }
}
