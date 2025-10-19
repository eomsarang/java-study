package baekjoon.step22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11659 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int[] prefix = new int[N + 1];

    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      prefix[i] = prefix[i - 1] + Integer.parseInt(st.nextToken());
    }

    StringBuilder sb = new StringBuilder();
    for (int m = 0; m < M; m++) {
      st = new StringTokenizer(br.readLine());
      int i = Integer.parseInt(st.nextToken());
      int j = Integer.parseInt(st.nextToken());
      sb.append(prefix[j] - prefix[i - 1]).append('\n');
    }

    System.out.print(sb);
  }
}
