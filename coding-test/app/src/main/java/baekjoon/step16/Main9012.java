package baekjoon.step16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main9012 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < T; i++) {
      String str = br.readLine();
      sb.append(isVPS(str) ? "YES" : "NO").append("\n");
    }

    System.out.print(sb);
  }

  private static boolean isVPS(String str) {
    int count = 0;
    for (char ch : str.toCharArray()) {
      if (ch == '(') {
        count++;
      } else {
        count--;
      }
      if (count < 0) {
        return false;
      }
    }
    return count == 0;
  }
}
