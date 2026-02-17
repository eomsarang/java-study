package baekjoon.step41;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main31430 {

  public static void main(String[] args) throws Exception {
    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());

    if (T == 1) {
      StringTokenizer st =
          new StringTokenizer(br.readLine());
      long A = Long.parseLong(st.nextToken());
      long B = Long.parseLong(st.nextToken());

      long S = A + B;

      char[] res = new char[13];

      for (int i = 12; i >= 0; i--) {
        res[i] = (char) ('a' + (S % 26));
        S /= 26;
      }

      System.out.println(new String(res));
    } else {
      String s = br.readLine();

      long value = 0;
      for (int i = 0; i < 13; i++) {
        value = value * 26 + (s.charAt(i) - 'a');
      }

      System.out.println(value);
    }
  }
}
