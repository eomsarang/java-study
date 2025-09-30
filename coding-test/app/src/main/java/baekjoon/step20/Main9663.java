package baekjoon.step20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main9663 {

  static long count = 0;
  static long mask;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine().trim());
    mask = (1L << N) - 1L;
    solve(0L, 0L, 0L);
    System.out.println(count);
  }

  static void solve(long col, long ld, long rd) {
    if (col == mask) {
      count++;
      return;
    }
    long avail = mask & ~(col | ld | rd);
    while (avail != 0L) {
      long bit = avail & -avail;
      avail -= bit;
      solve(col | bit, (ld | bit) << 1, (rd | bit) >> 1);
    }
  }
}
