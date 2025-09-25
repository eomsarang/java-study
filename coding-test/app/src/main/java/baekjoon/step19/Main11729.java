package baekjoon.step19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main11729 {

  static StringBuilder sb = new StringBuilder();

  // 하노이 재귀 함수
  public static void hanoi(int n, int from, int to, int via) {
    if (n == 1) {
      sb.append(from).append(" ").append(to).append("\n");
      return;
    }
    hanoi(n - 1, from, via, to);
    sb.append(from).append(" ").append(to).append("\n");
    hanoi(n - 1, via, to, from);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    sb.append((1L << N) - 1).append("\n");

    hanoi(N, 1, 3, 2);

    System.out.print(sb.toString());
  }
}
