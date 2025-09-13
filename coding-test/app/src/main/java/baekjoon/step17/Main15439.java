package baekjoon.step17;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main15439 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    long N = Long.parseLong(br.readLine().trim());
    System.out.println(N * (N - 1));
  }
}
