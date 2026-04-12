package baekjoon.step50;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1040 {

  static String N;
  static int K;
  static int len;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = st.nextToken();
    K = Integer.parseInt(st.nextToken());

    len = N.length();

    String res = dfs(0, 0, 0, true);

    if (res != null) {
      System.out.println(res);
      return;
    }

    // 길이 증가
    for (int l = len + 1; l <= 19; l++) {
      String ans = buildMin(l);
      if (ans != null) {
        System.out.println(ans);
        return;
      }
    }
  }

  static String dfs(int pos, int mask, int used, boolean tight) {
    if (pos == len) {
      return (used == K) ? "" : null;
    }

    int start = tight ? (N.charAt(pos) - '0') : 0;

    for (int d = start; d <= 9; d++) {
      int newMask = mask;
      int newUsed = used;

      if ((mask & (1 << d)) == 0) {
        newMask |= (1 << d);
        newUsed++;
      }

      if (newUsed > K) {
        continue;
      }

      int remain = len - pos - 1;
      if (newUsed + remain < K) {
        continue;
      }

      boolean newTight = tight && (d == start);

      String next = dfs(pos + 1, newMask, newUsed, newTight);
      if (next != null) {
        return d + next;
      }
    }

    return null;
  }

  static String buildMin(int l) {
    StringBuilder sb = new StringBuilder();

    int mask = 0;
    int used = 0;

    for (int i = 0; i < l; i++) {
      for (int d = (i == 0 ? 1 : 0); d <= 9; d++) {
        int newMask = mask;
        int newUsed = used;

        if ((mask & (1 << d)) == 0) {
          newMask |= (1 << d);
          newUsed++;
        }

        if (newUsed > K) {
          continue;
        }

        int remain = l - i - 1;
        if (newUsed + remain < K) {
          continue;
        }

        sb.append(d);
        mask = newMask;
        used = newUsed;
        break;
      }
    }

    if (used == K) {
      return sb.toString();
    }
    return null;
  }
}