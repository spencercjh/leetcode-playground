package spencercjh;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Objects;

/**
 * Collection equals is not included in the project, so this is a simple implementation for unit test
 *
 * @author spencercjh
 */
public final class Utils {
  final static Logger logger = LoggerFactory.getLogger(Utils.class);

  private Utils() {
  }

  @SuppressWarnings({"rawtypes", "unchecked"})
  public static <T> boolean equals(List<T> a, List<T> b) {
    if (a == b) {
      return true;
    }
    if (a == null || b == null || a.size() != b.size()) {
      return false;
    }
    logger.info("Comparing {} and {}", a.toString(), b.toString());
    for (int i = 0; i < a.size(); i++) {
      if (a.get(i) instanceof List) {
        if (!equals(((List) a.get(i)), (List) b.get(i))) {
          return false;
        }
      } else {
        if (!Objects.equals(a.get(i), b.get(i))) {
          return false;
        }
      }
    }
    return true;
  }
}
