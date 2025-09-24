package baekjoon.step19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2447 {

  static char[][] arr;

  public static void star(int x, int y, int n, boolean blank) {
    if (blank) {
      for (int i = x; i < x + n; i++) {
        for (int j = y; j < y + n; j++) {
          arr[i][j] = ' ';
        }
      }
      return;
    }

    if (n == 1) {
      arr[x][y] = '*';
      return;
    }

    int size = n / 3;
    int count = 0;
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        count++;
        // 가운데 블록
        star(x + i * size, y + j * size, size, count == 5);
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    arr = new char[N][N];
    star(0, 0, N, false);

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < N; i++) {
      sb.append(arr[i]).append("\n");
    }

    System.out.print(sb);
  }
}
