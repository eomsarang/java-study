package baekjoon.step13;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main11650 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;

    int N = Integer.parseInt(br.readLine());
    int[][] points = new int[N][2];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      points[i][0] = Integer.parseInt(st.nextToken());
      points[i][1] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(points, (a, b) -> {
      if (a[0] == b[0]) {
        return a[1] - b[1];
      } else {
        return a[0] - b[0];
      }
    });

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < N; i++) {
      sb.append(points[i][0]).append(" ").append(points[i][1]).append("\n");
    }

    bw.write(sb.toString());
    bw.flush();
  }
}
