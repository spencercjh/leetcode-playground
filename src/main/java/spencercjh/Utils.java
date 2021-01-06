package spencercjh;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * @author spencercjh
 */
public final class Utils {
  private Utils() {
  }

  public static <T> boolean equals(List<T> a, List<T> b) {
    if (a == null && b == null) {
      return true;
    }
    if (a == null || b == null || a.size() != b.size()) {
      return false;
    }
    for (int i = 0; i < a.size(); i++) {
      if (a.get(i) instanceof Collection) {
        //noinspection unchecked
        return equals(((List) a.get(i)), (List) b.get(i));
      } else {
        if (!Objects.equals(a.get(i), b.get(i))) {
          return false;
        }
      }
    }
    return true;
  }
}
