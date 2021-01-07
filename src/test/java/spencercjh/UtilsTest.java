package spencercjh;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static spencercjh.AssertionUtils.assertArrayEquals;

public class UtilsTest {
  @Test
  void listEquals() {
    List<Integer> a = List.of(1, 2, 3);
    List<Integer> b = List.of(1, 2, 3);
    assertTrue(Utils.equals(a, b));

    a = List.of(1, 2, 3);
    b = List.of(1, 2);
    assertFalse(Utils.equals(a, b));

    a = List.of(1, 2, 3);
    b = List.of(1, 2, 4);
    assertFalse(Utils.equals(a, b));

    a = List.of(1, 2);
    b = List.of(2, 3);
    assertFalse(Utils.equals(a, b));

    // Can't pass compiling
    // assertFalse(Utils.equals(a,List.of(1.5, 2.5)));

    a = null;
    b = null;
    assertTrue(Utils.equals(a, b));

    a = Collections.emptyList();
    b = Collections.emptyList();
    assertTrue(Utils.equals(a, b));

    List<List<Integer>> nestedA = List.of(List.of(1, 2, 3), List.of(1, 2, 3));
    List<List<Integer>> nestedB = List.of(List.of(1, 2, 3), List.of(1, 2, 3));
    assertTrue(Utils.equals(nestedA, nestedB));

    nestedA = List.of(List.of(1, 2), List.of(1, 2, 3));
    nestedB = List.of(List.of(1, 2, 3), List.of(1, 2, 3));
    assertFalse(Utils.equals(nestedA, nestedB));

    nestedA = List.of(List.of(1, 2, 3), List.of(1, 2));
    nestedB = List.of(List.of(1, 2, 3), List.of(1, 2, 3));
    assertFalse(Utils.equals(nestedA, nestedB));

    nestedA = List.of(List.of(1, 2), List.of(1, 3));
    nestedB = List.of(List.of(1, 2), List.of(1, 3));
    assertTrue(Utils.equals(nestedA, nestedB));

    // Can't pass compiling
    // assertFalse(Utils.equals(nestedA, List.of(List.of(1.5, 2.0), List.of(1.1, 3.2))));

    nestedA = List.of(Collections.emptyList(), Collections.emptyList());
    nestedB = List.of(Collections.emptyList(), Collections.emptyList());
    assertTrue(Utils.equals(nestedA, nestedB));
  }

  @Test
  void testAssertEquals() {
    assertArrayEquals(new int[]{1, 2, 3}, new int[]{1, 2, 3});
    assertArrayEquals(new double[]{1, 2, 3}, new double[]{1, 2, 3});
    assertArrayEquals(new char[]{1, 2, 3}, new char[]{1, 2, 3});
    assertArrayEquals(new String[]{"1", "2", "3"}, new String[]{"1", "2", "3"});
    assertArrayEquals(new boolean[]{true, false, true}, new boolean[]{true, false, true});
  }
}
