package baekjoon.step38;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main17298 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    int[] A = new int[N];
    int[] ans = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      A[i] = Integer.parseInt(st.nextToken());
      ans[i] = -1;
    }

    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < N; i++) {
      while (!stack.isEmpty() && A[stack.peek()] < A[i]) {
        ans[stack.pop()] = A[i];
      }
      stack.push(i);
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < N; i++) {
      sb.append(ans[i]).append(' ');
    }
    System.out.println(sb);
  }
}
