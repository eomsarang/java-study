package baekjoon.step38;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main15678 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int D = Integer.parseInt(st.nextToken());

    long[] K = new long[N + 1];
    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      K[i] = Long.parseLong(st.nextToken());
    }

    long[] dp = new long[N + 1];
    Deque<Integer> deque = new ArrayDeque<>();

    long answer = Long.MIN_VALUE;

    for (int i = 1; i <= N; i++) {

      while (!deque.isEmpty() && deque.peekFirst() < i - D) {
        deque.pollFirst();
      }

      long bestPrev = 0;
      if (!deque.isEmpty()) {
        bestPrev = Math.max(0, dp[deque.peekFirst()]);
      }

      dp[i] = K[i] + bestPrev;
      answer = Math.max(answer, dp[i]);

      while (!deque.isEmpty() && dp[deque.peekLast()] <= dp[i]) {
        deque.pollLast();
      }
      deque.addLast(i);
    }

    System.out.println(answer);
  }
}
