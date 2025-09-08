package baekjoon.step16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main12789 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());

    int[] arr = new int[N];
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    Stack<Integer> stack = new Stack<>();
    int need = 1;

    for (int i = 0; i < N; i++) {
      int cur = arr[i];

      if (cur == need) {
        need++;
      } else {
        while (!stack.isEmpty() && stack.peek() == need) {
          stack.pop();
          need++;
        }
        stack.push(cur);
      }
    }

    while (!stack.isEmpty() && stack.peek() == need) {
      stack.pop();
      need++;
    }

    if (need == N + 1) {
      System.out.println("Nice");
    } else {
      System.out.println("Sad");
    }
  }
}
