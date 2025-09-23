package baekjoon.step19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main4779 {

  static char[] arr;

  public static void cantor(int start, int size) {
    if (size == 1) {
      return;
    }
    int third = size / 3;
    for (int i = start + third; i < start + 2 * third; i++) {
      arr[i] = ' ';
    }
    cantor(start, third);
    cantor(start + 2 * third, third);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line;
    StringBuilder sb = new StringBuilder();

    while ((line = br.readLine()) != null && !line.isEmpty()) {
      int N = Integer.parseInt(line.trim());
      int length = (int) Math.pow(3, N);
      arr = new char[length];
      Arrays.fill(arr, '-');
      cantor(0, length);
      sb.append(arr).append("\n");
    }

    System.out.print(sb);
  }
}
