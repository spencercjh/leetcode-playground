package spencercjh.problems;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
class RegionsCutBySlashesTest {

  @Inject
  private RegionsCutBySlashes solution;

  @Test
  void regionsBySlashes() {
    assertEquals(2, solution.regionsBySlashes(new String[]{" /", "/ "}));
    assertEquals(3, solution.regionsBySlashes(new String[]{"//", "/ "}));
  }

}
