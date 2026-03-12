package baekjoon.step46;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main1305 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int L = Integer.parseInt(br.readLine());
    String s = br.readLine();

    int[] lps = new int[L];
    int j = 0;

    for (int i = 1; i < L; i++) {
      while (j > 0 && s.charAt(i) != s.charAt(j)) {
        j = lps[j - 1];
      }

      if (s.charAt(i) == s.charAt(j)) {
        j++;
        lps[i] = j;
      }
    }

    System.out.println(L - lps[L - 1]);
  }
}
