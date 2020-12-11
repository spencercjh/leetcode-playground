package spencercjh.problems;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static spencercjh.problems.Dota2Senate.DIRE;
import static spencercjh.problems.Dota2Senate.RADIANT;

@MicronautTest
class Dota2SenateTest {
  @Inject
  private Dota2Senate solution;

  @Test
  void predictPartyVictory() {
    assertEquals(DIRE, solution.predictPartyVictory("RDD"));
    assertEquals(RADIANT, solution.predictPartyVictory("RD"));
    assertEquals(DIRE, solution.predictPartyVictory("DDRRR"));
    assertEquals(RADIANT, solution.predictPartyVictory("RDRDD"));
    assertEquals(RADIANT, solution.predictPartyVictory("DDRRRR"));
  }
}
