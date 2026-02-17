package baekjoon.step41;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main23656 {

  public static void main(String[] args) throws Exception {
    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw =
        new BufferedWriter(new OutputStreamWriter(System.out));

    long L = 1;
    long R = 1_000_000_000L;

    while (true) {
      String line = br.readLine();
      if (line == null) {
        return;
      }

      long x = Long.parseLong(line);

      long left = x - L;
      long right = R - x;

      if (left >= right) {
        bw.write("<\n");
        bw.flush();
        R = x - 1;
      } else {
        bw.write(">\n");
        bw.flush();
        L = x + 1;
      }
    }
  }
}
