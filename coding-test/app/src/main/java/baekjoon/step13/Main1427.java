package baekjoon.step13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main1427 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String N = br.readLine();

    Integer[] digits = new Integer[N.length()];
    for (int i = 0; i < N.length(); i++) {
      digits[i] = N.charAt(i) - '0';
    }

    Arrays.sort(digits, Collections.reverseOrder());

    StringBuilder sb = new StringBuilder();
    for (int d : digits) {
      sb.append(d);
    }
    System.out.println(sb);
  }
}
