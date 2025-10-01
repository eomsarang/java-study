package baekjoon.step20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main2580 {

  static int[][] board = new int[9][9];
  static List<int[]> blanks = new ArrayList<>();
  static boolean solved = false;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    for (int i = 0; i < 9; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 9; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
        if (board[i][j] == 0) {
          blanks.add(new int[]{i, j});
        }
      }
    }

    backtrack(0);

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        sb.append(board[i][j]).append(" ");
      }
      sb.append("\n");
    }
    System.out.print(sb);
  }

  static void backtrack(int idx) {
    if (solved) {
      return;
    }
    if (idx == blanks.size()) {
      solved = true;
      return;
    }

    int[] pos = blanks.get(idx);
    int r = pos[0], c = pos[1];

    for (int num = 1; num <= 9; num++) {
      if (isValid(r, c, num)) {
        board[r][c] = num;
        backtrack(idx + 1);
        if (solved) {
          return;
        }
        board[r][c] = 0;
      }
    }
  }

  static boolean isValid(int r, int c, int num) {
    for (int i = 0; i < 9; i++) {
      if (board[r][i] == num || board[i][c] == num) {
        return false;
      }
    }
    int sr = (r / 3) * 3;
    int sc = (c / 3) * 3;
    for (int i = sr; i < sr + 3; i++) {
      for (int j = sc; j < sc + 3; j++) {
        if (board[i][j] == num) {
          return false;
        }
      }
    }
    return true;
  }
}
