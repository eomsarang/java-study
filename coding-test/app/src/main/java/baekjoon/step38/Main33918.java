package baekjoon.step38;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main33918 {

  static final long NEG = Long.MIN_VALUE / 4;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int C = Integer.parseInt(st.nextToken());
    int D = Integer.parseInt(st.nextToken());

    int[] b = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      b[i] = Integer.parseInt(st.nextToken());
    }

    long[] prev = new long[M + 1];
    long[] cur = new long[M + 1];

    for (int k = 1; k <= M; k++) {
      prev[k] = M - Math.abs(b[0] - k);
    }

    for (int t = 1; t < N; t++) {
      Arrays.fill(cur, NEG);

      for (int r = 0; r < C; r++) {
        Deque<Integer> dq = new ArrayDeque<>();

        for (int k = r == 0 ? C : r; k <= M; k += C) {

          while (!dq.isEmpty() && dq.peekFirst() < k - D) {
            dq.pollFirst();
          }

          int p = k;
          while (!dq.isEmpty() && prev[dq.peekLast()] <= prev[p]) {
            dq.pollLast();
          }
          dq.addLast(p);

          if (!dq.isEmpty()) {
            cur[k] = prev[dq.peekFirst()] +
                (M - Math.abs(b[t] - k));
          }
        }
      }

      long[] tmp = prev;
      prev = cur;
      cur = tmp;
    }

    long ans = NEG;
    for (int k = 1; k <= M; k++) {
      ans = Math.max(ans, prev[k]);
    }
    System.out.println(ans);
  }
}
