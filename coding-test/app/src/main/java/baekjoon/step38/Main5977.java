package baekjoon.step38;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main5977 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    long[] prefix = new long[N + 1];
    for (int i = 1; i <= N; i++) {
      prefix[i] = prefix[i - 1] + Long.parseLong(br.readLine());
    }

    long[] dp = new long[N + 1];
    Deque<Integer> deque = new ArrayDeque<>();

    deque.add(0);

    for (int i = 1; i <= N; i++) {

      while (!deque.isEmpty() && deque.peekFirst() < i - K - 1) {
        deque.pollFirst();
      }

      dp[i] = dp[i - 1];

      if (!deque.isEmpty()) {
        int best = deque.peekFirst();
        dp[i] = Math.max(dp[i],
            prefix[i] + dp[best] - prefix[best]);
      }

      while (!deque.isEmpty()) {
        int last = deque.peekLast();
        if (dp[last] - prefix[last] <= dp[i] - prefix[i]) {
          deque.pollLast();
        } else {
          break;
        }
      }
      deque.addLast(i);
    }

    System.out.println(dp[N]);
  }
}
