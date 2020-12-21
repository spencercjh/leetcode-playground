package spencercjh.problems;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@MicronautTest
class RemoveDuplicateLettersTest {

  @Inject
  private RemoveDuplicateLetters solution;

  @Test
  void removeDuplicateLetters() {
    System.out.println(solution.removeDuplicateLetters("bcabc"));
    System.out.println(solution.removeDuplicateLetters("cbacdb"));
  }

}
