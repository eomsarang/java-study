package baekjoon.step22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main16139 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    String S = br.readLine();
    int n = S.length();
    int q = Integer.parseInt(br.readLine());

    int[][] prefix = new int[26][n];

    prefix[S.charAt(0) - 'a'][0] = 1;

    for (int i = 1; i < n; i++) {
      int cur = S.charAt(i) - 'a';
      for (int j = 0; j < 26; j++) {
        prefix[j][i] = prefix[j][i - 1];
      }
      prefix[cur][i]++;
    }

    for (int i = 0; i < q; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      char alpha = st.nextToken().charAt(0);
      int l = Integer.parseInt(st.nextToken());
      int r = Integer.parseInt(st.nextToken());

      int idx = alpha - 'a';
      if (l == 0) {
        sb.append(prefix[idx][r]).append('\n');
      } else {
        sb.append(prefix[idx][r] - prefix[idx][l - 1]).append('\n');
      }
    }

    System.out.print(sb);
  }
}
