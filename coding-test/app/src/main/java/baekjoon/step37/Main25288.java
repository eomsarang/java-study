package baekjoon.step37;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main25288 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    String alpha = br.readLine();
    int k = alpha.length();

    StringBuilder sb = new StringBuilder(N * k);

    for (int i = 0; i < N; i++) {
      if (i % 2 == 0) {
        for (int j = 0; j < k; j++) {
          sb.append(alpha.charAt(j));
        }
      } else {
        for (int j = k - 1; j >= 0; j--) {
          sb.append(alpha.charAt(j));
        }
      }
    }

    System.out.println(sb);
  }
}
