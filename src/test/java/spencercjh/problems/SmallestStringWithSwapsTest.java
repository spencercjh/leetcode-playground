package spencercjh.problems;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
class SmallestStringWithSwapsTest {

  @Inject
  private SmallestStringWithSwaps solution;

  @Test
  void smallestStringWithSwaps() {
    assertEquals("abcd", solution.smallestStringWithSwaps("dcab",
      List.of(List.of(0, 3), List.of(1, 2), List.of(0, 2))));

    assertEquals("abc", solution.smallestStringWithSwaps("cba",
      List.of(List.of(0, 1), List.of(1, 2))));
  }

}
