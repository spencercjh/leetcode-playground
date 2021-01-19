package spencercjh.problems;

import javax.inject.Singleton;
import java.util.*;

/**
 * https://leetcode-cn.com/problems/accounts-merge/
 *
 * @author spencercjh
 */
@Singleton
public class AccountsMerge {
  private int[] parents;

  public List<List<String>> accountsMerge(List<List<String>> accounts) {
    final Map<String, Integer> emailIndexMap = new HashMap<>();
    final Map<String, String> emailNamesMap = new HashMap<>();
    int emailIndex = 0;
    for (List<String> account : accounts) {
      final String name = account.get(0);
      for (int i = 1; i < account.size(); i++) {
        final String email = account.get(i);
        if (!emailIndexMap.containsKey(email) &&
          !emailNamesMap.containsKey(email)) {
          emailIndexMap.put(email, emailIndex++);
          emailNamesMap.put(email, name);
        }
      }
    }

    parents = new int[emailIndex];
    for (int i = 0; i < parents.length; i++) {
      parents[i] = i;
    }

    for (List<String> account : accounts) {
      final int x = emailIndexMap.get(account.get(1));
      for (int i = 2; i < account.size(); i++) {
        final int y = emailIndexMap.get(account.get(i));
        union(x, y);
      }
    }

    final Map<Integer, List<String>> indexEmailsMap = new HashMap<>();
    for (String email : emailIndexMap.keySet()) {
      final int root = find(emailIndexMap.get(email));
      final List<String> emails = indexEmailsMap.getOrDefault(root, new ArrayList<>());
      emails.add(email);
      indexEmailsMap.put(root, emails);
    }

    final List<List<String>> results = new ArrayList<>();
    for (List<String> emails : indexEmailsMap.values()) {
      Collections.sort(emails);
      final String name = emailNamesMap.get(emails.get(0));
      final List<String> result = new ArrayList<>();
      result.add(name);
      result.addAll(emails);
      results.add(result);
    }

    return results;
  }


  private int find(int n) {
    if (n != parents[n]) {
      parents[n] = find(parents[n]);
    }
    return parents[n];
  }

  private void union(int x, int y) {
    final int rootX = find(x);
    final int rootY = find(y);
    if (rootX == rootY) {
      return;
    }
    parents[rootX] = rootY;
  }
}
