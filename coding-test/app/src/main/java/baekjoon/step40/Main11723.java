package baekjoon.step40;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main11723 {

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int M = Integer.parseInt(br.readLine());
    int set = 0;

    while (M-- > 0) {
      String line = br.readLine();

      if (line.startsWith("add")) {
        int x = line.charAt(4) - '0';
        if (line.length() == 6) {
          x = 10 + (line.charAt(5) - '0');
        }
        set |= (1 << x);
      } else if (line.startsWith("remove")) {
        int x = line.charAt(7) - '0';
        if (line.length() == 9) {
          x = 10 + (line.charAt(8) - '0');
        }
        set &= ~(1 << x);
      } else if (line.startsWith("check")) {
        int x = line.charAt(6) - '0';
        if (line.length() == 8) {
          x = 10 + (line.charAt(7) - '0');
        }
        sb.append((set & (1 << x)) != 0 ? 1 : 0).append('\n');
      } else if (line.startsWith("toggle")) {
        int x = line.charAt(7) - '0';
        if (line.length() == 9) {
          x = 10 + (line.charAt(8) - '0');
        }
        set ^= (1 << x);
      } else if (line.equals("all")) {
        set = (1 << 21) - 2;
      } else {
        set = 0;
      }
    }

    System.out.print(sb);
  }
}
