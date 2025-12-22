package baekjoon.step32;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main14002 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int[] A = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 0; i < N; i++) {
      A[i] = Integer.parseInt(st.nextToken());
    }

    int[] dp = new int[N];
    int[] prev = new int[N];

    Arrays.fill(dp, 1);
    Arrays.fill(prev, -1);

    int maxLen = 1;
    int lastIdx = 0;

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < i; j++) {
        if (A[j] < A[i] && dp[i] < dp[j] + 1) {
          dp[i] = dp[j] + 1;
          prev[i] = j;
        }
      }
      if (dp[i] > maxLen) {
        maxLen = dp[i];
        lastIdx = i;
      }
    }

    Stack<Integer> stack = new Stack<>();
    int cur = lastIdx;
    while (cur != -1) {
      stack.push(A[cur]);
      cur = prev[cur];
    }

    StringBuilder sb = new StringBuilder();
    sb.append(maxLen).append('\n');
    while (!stack.isEmpty()) {
      sb.append(stack.pop()).append(' ');
    }

    System.out.println(sb.toString().trim());
  }
}
