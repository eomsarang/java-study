package baekjoon.step38;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main9935 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String str = br.readLine();
    String bomb = br.readLine();

    int n = str.length();
    int m = bomb.length();

    char[] stack = new char[n];
    int top = 0;

    for (int i = 0; i < n; i++) {
      stack[top++] = str.charAt(i);

      if (top >= m) {
        boolean match = true;
        for (int j = 0; j < m; j++) {
          if (stack[top - m + j] != bomb.charAt(j)) {
            match = false;
            break;
          }
        }

        if (match) {
          top -= m;
        }
      }
    }

    if (top == 0) {
      System.out.println("FRULA");
    } else {
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < top; i++) {
        sb.append(stack[i]);
      }
      System.out.println(sb);
    }
  }
}
