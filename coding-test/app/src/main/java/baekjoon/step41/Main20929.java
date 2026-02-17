package baekjoon.step41;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class Main20929 {

  static BufferedReader br =
      new BufferedReader(new InputStreamReader(System.in));
  static PrintWriter out =
      new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

  static Map<String, Long> cache = new HashMap<>();

  static long ask(char arr, int idx) throws Exception {
    if (idx <= 0) {
      return Long.MIN_VALUE;
    }
    String key = arr + " " + idx;
    if (cache.containsKey(key)) {
      return cache.get(key);
    }

    out.println("? " + arr + " " + idx);
    out.flush();

    long v = Long.parseLong(br.readLine().trim());
    cache.put(key, v);
    return v;
  }

  public static void main(String[] args) throws Exception {

    int N = Integer.parseInt(br.readLine().trim());

    int lo = 0;
    int hi = N;

    long answer = 0;

    while (lo <= hi) {
      int i = (lo + hi) / 2;
      int j = N - i;

      long A_left = (i == 0) ? Long.MIN_VALUE : ask('A', i);
      long A_right = (i == N) ? Long.MAX_VALUE : ask('A', i + 1);

      long B_left = (j == 0) ? Long.MIN_VALUE : ask('B', j);
      long B_right = (j == N) ? Long.MAX_VALUE : ask('B', j + 1);

      if (A_left <= B_right && B_left <= A_right) {
        answer = Math.max(A_left, B_left);
        break;
      } else if (A_left > B_right) {
        hi = i - 1;
      } else {
        lo = i + 1;
      }
    }

    out.println("! " + answer);
    out.flush();
  }
}
