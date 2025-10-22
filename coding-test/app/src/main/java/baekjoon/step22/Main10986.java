package baekjoon.step22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main10986 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    long[] count = new long[M];
    long[] prefix = new long[N + 1];

    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      prefix[i] = (prefix[i - 1] + Integer.parseInt(st.nextToken())) % M;
      count[(int) prefix[i]]++;
    }

    long result = count[0];

    for (int i = 0; i < M; i++) {
      if (count[i] > 1) {
        result += (count[i] * (count[i] - 1)) / 2;
      }
    }

    System.out.println(result);
  }
}
