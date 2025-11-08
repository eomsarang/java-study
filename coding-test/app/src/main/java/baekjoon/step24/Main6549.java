package baekjoon.step24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main6549 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    while (true) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      if (n == 0) {
        break;
      }

      long[] h = new long[n];
      for (int i = 0; i < n; i++) {
        h[i] = Long.parseLong(st.nextToken());
      }

      Stack<Integer> stack = new Stack<>();
      long maxArea = 0;

      for (int i = 0; i < n; i++) {
        while (!stack.isEmpty() && h[stack.peek()] > h[i]) {
          long height = h[stack.pop()];
          int width = stack.isEmpty() ? i : i - stack.peek() - 1;
          maxArea = Math.max(maxArea, height * width);
        }
        stack.push(i);
      }

      while (!stack.isEmpty()) {
        long height = h[stack.pop()];
        int width = stack.isEmpty() ? n : n - stack.peek() - 1;
        maxArea = Math.max(maxArea, height * width);
      }

      sb.append(maxArea).append('\n');
    }

    System.out.print(sb);
  }
}
