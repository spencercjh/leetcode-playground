package spencercjh.problems;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
class SimilarStringGroupsTest {

  @Inject
  private SimilarStringGroups solution;

  @Test
  void numSimilarGroups() {
    assertEquals(2, solution.numSimilarGroups(new String[]{"tars", "rats", "arts", "star"}));
    assertEquals(1, solution.numSimilarGroups(new String[]{"omv", "ovm"}));
  }

}
