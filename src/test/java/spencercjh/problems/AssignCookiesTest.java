package spencercjh.problems;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
class AssignCookiesTest {

  @Inject
  private AssignCookies solution;

  @Test
  void findContentChildren() {
    assertEquals(2, solution.findContentChildren(new int[]{1, 2}, new int[]{1, 2, 3}));
    assertEquals(1, solution.findContentChildren(new int[]{1, 2, 3}, new int[]{1, 1}));
    assertEquals(2, solution.findContentChildren(new int[]{10, 9, 8, 7}, new int[]{5, 6, 7, 8}));
  }

}
