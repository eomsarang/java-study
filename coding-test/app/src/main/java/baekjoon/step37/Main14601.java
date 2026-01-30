package baekjoon.step37;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14601 {

  static int[][] board;
  static int tileNum = 1;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int K = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    int x = Integer.parseInt(st.nextToken());
    int y = Integer.parseInt(st.nextToken());

    int size = 1 << K;
    board = new int[size][size];

    // 배수구 위치 변환
    int holeRow = size - y;
    int holeCol = x - 1;
    board[holeRow][holeCol] = -1;

    tile(0, 0, holeRow, holeCol, size);

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        sb.append(board[i][j]).append(" ");
      }
      sb.append("\n");
    }
    System.out.print(sb);
  }

  static void tile(int r, int c, int hr, int hc, int size) {
    if (size == 1) {
      return;
    }

    int t = tileNum++;
    int half = size / 2;

    int midR = r + half;
    int midC = c + half;

    if (hr < midR && hc < midC) {
      tile(r, c, hr, hc, half);
    } else {
      board[midR - 1][midC - 1] = t;
      tile(r, c, midR - 1, midC - 1, half);
    }

    if (hr < midR && hc >= midC) {
      tile(r, midC, hr, hc, half);
    } else {
      board[midR - 1][midC] = t;
      tile(r, midC, midR - 1, midC, half);
    }

    if (hr >= midR && hc < midC) {
      tile(midR, c, hr, hc, half);
    } else {
      board[midR][midC - 1] = t;
      tile(midR, c, midR, midC - 1, half);
    }

    if (hr >= midR && hc >= midC) {
      tile(midR, midC, hr, hc, half);
    } else {
      board[midR][midC] = t;
      tile(midR, midC, midR, midC, half);
    }
  }
}
