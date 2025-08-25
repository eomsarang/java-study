package baekjoon.step11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main24313 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int a1 = Integer.parseInt(st.nextToken());
    int a0 = Integer.parseInt(st.nextToken());

    int c = Integer.parseInt(br.readLine().trim());
    int n0 = Integer.parseInt(br.readLine().trim());

    boolean ok = (c >= a1) && (a1 * n0 + a0 <= c * n0);
    System.out.println(ok ? 1 : 0);
  }
}
