package spencercjh.problems;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
class CountAndSayTest {
  @Inject
  private CountAndSay solution;

  @Test
  void countAndSay() {
    final List<String> expect = List.of("111221", "1211", "21", "11", "1");
    for (int i = 5, j = 0; i >= 1 && j < expect.size(); i--, j++) {
      assertEquals(expect.get(j), solution.countAndSay(i));
    }
  }
}
