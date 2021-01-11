package spencercjh.problems;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import spencercjh.Utils;

import javax.inject.Inject;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@MicronautTest
class SummaryRangesTest {

  @Inject
  private SummaryRanges solution;

  @Test
  void summaryRanges() {
    assertTrue(Utils.equals(List.of("0->2", "4->5", "7"), solution.summaryRanges(new int[]{0, 1, 2, 4, 5, 7})));
  }
}
