package spencercjh.problems;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.List;

@MicronautTest
class AccountsMergeTest {

  @Inject
  private AccountsMerge solution;

  @Test
  void accountsMerge() {
    System.out.println(solution.accountsMerge(List.of(
      List.of("John", "johnsmith@mail.com", "john00@mail.com"),
      List.of("John", "johnnybravo@mail.com"),
      List.of("John", "johnsmith@mail.com", "john_newyork@mail.com"),
      List.of("Mary", "mary@mail.com"))));
  }

}
