package spencercjh;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * if assertTrue(Arrays.equals(a, b)) failed, the difference is invisible, so add some log before assertion
 *
 * @author spencercjh
 */
public final class AssertionUtils {
  final static Logger logger = LoggerFactory.getLogger(AssertionUtils.class);

  private AssertionUtils() {
  }

  public static void assertArrayEquals(boolean[] a, boolean[] b) {
    logger.info("Comparing {} and {}", Arrays.toString(a), Arrays.toString(b));
    assertTrue(Arrays.equals(a, b));
  }

  public static void assertArrayEquals(String[] a, String[] b) {
    logger.info("Comparing {} and {}", Arrays.toString(a), Arrays.toString(b));
    assertTrue(Arrays.equals(a, b));
  }

  public static void assertArrayEquals(char[] a, char[] b) {
    logger.info("Comparing {} and {}", Arrays.toString(a), Arrays.toString(b));
    assertTrue(Arrays.equals(a, b));
  }

  public static void assertArrayEquals(double[] a, double[] b) {
    logger.info("Comparing {} and {}", Arrays.toString(a), Arrays.toString(b));
    assertTrue(Arrays.equals(a, b));
  }

  public static void assertArrayEquals(int[] a, int[] b) {
    logger.info("Comparing {} and {}", Arrays.toString(a), Arrays.toString(b));
    assertTrue(Arrays.equals(a, b));
  }
}
