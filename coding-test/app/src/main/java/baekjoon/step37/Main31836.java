package baekjoon.step37;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main31836 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    long[] F = new long[N + 1];
    F[1] = 1;
    if (N >= 2) {
      F[2] = 1;
    }
    for (int i = 3; i <= N; i++) {
      F[i] = F[i - 1] + F[i - 2];
    }

    long total = 0;
    for (int i = 1; i <= N; i++) {
      total += F[i];
    }
    long target = total / 2;

    // dp[s] = 최대 사용 개수
    Map<Long, Integer> dp = new HashMap<>();
    dp.put(0L, 0);

    // 역추적용
    Map<Long, Integer> from = new HashMap<>();
    Map<Long, Long> prevSum = new HashMap<>();

    for (int i = N; i >= 1; i--) {
      Map<Long, Integer> next = new HashMap<>(dp);
      for (long s : dp.keySet()) {
        long ns = s + F[i];
        if (ns > target) {
          continue;
        }
        int cnt = dp.get(s) + 1;
        if (!next.containsKey(ns) || next.get(ns) < cnt) {
          next.put(ns, cnt);
          from.put(ns, i);
          prevSum.put(ns, s);
        }
      }
      dp = next;
    }

    long best = 0;
    int bestCnt = -1;
    for (long s : dp.keySet()) {
      if (dp.get(s) > bestCnt) {
        bestCnt = dp.get(s);
        best = s;
      }
    }

    boolean[] used = new boolean[N + 1];
    long cur = best;
    while (cur != 0) {
      int idx = from.get(cur);
      used[idx] = true;
      cur = prevSum.get(cur);
    }

    List<Integer> A = new ArrayList<>();
    List<Integer> B = new ArrayList<>();

    for (int i = 1; i <= N; i++) {
      if (used[i]) {
        A.add(i);
      } else if (B.size() < A.size()) {
        B.add(i);
      }
    }

    System.out.println(A.size());
    for (int x : A) {
      System.out.print(x + " ");
    }
    System.out.println();

    System.out.println(B.size());
    for (int x : B) {
      System.out.print(x + " ");
    }
    System.out.println();
  }
}
