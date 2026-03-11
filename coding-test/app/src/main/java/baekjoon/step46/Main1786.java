package baekjoon.step46;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main1786 {

  static int[] makeLPS(String p) {
    int m = p.length();
    int[] lps = new int[m];

    int len = 0;
    for (int i = 1; i < m; i++) {
      while (len > 0 && p.charAt(i) != p.charAt(len)) {
        len = lps[len - 1];
      }

      if (p.charAt(i) == p.charAt(len)) {
        lps[i] = ++len;
      }
    }

    return lps;
  }

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String T = br.readLine();
    String P = br.readLine();

    int n = T.length();
    int m = P.length();

    int[] lps = makeLPS(P);

    List<Integer> result = new ArrayList<>();

    int j = 0;

    for (int i = 0; i < n; i++) {

      while (j > 0 && T.charAt(i) != P.charAt(j)) {
        j = lps[j - 1];
      }

      if (T.charAt(i) == P.charAt(j)) {

        if (j == m - 1) {
          result.add(i - m + 2); // 1-index
          j = lps[j];
        } else {
          j++;
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    sb.append(result.size()).append("\n");

    for (int pos : result) {
      sb.append(pos).append(" ");
    }

    System.out.println(sb);
  }
}
