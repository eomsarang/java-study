package baekjoon.step20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14889 {

  static int N;
  static int[][] S;
  static boolean[] selected;
  static int minDiff = Integer.MAX_VALUE;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine().trim());

    S = new int[N][N];
    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        S[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    selected = new boolean[N];
    comb(0, 0);

    System.out.println(minDiff);
  }

  static void comb(int idx, int cnt) {
    if (cnt == N / 2) {
      calcDiff();
      return;
    }
    if (idx == N) {
      return;
    }

    selected[idx] = true;
    comb(idx + 1, cnt + 1);

    selected[idx] = false;
    comb(idx + 1, cnt);
  }

  static void calcDiff() {
    int start = 0, link = 0;

    for (int i = 0; i < N; i++) {
      for (int j = i + 1; j < N; j++) {
        if (selected[i] && selected[j]) {
          start += S[i][j] + S[j][i];
        } else if (!selected[i] && !selected[j]) {
          link += S[i][j] + S[j][i];
        }
      }
    }

    int diff = Math.abs(start - link);
    minDiff = Math.min(minDiff, diff);

    if (minDiff == 0) {
      System.out.println(0);
      System.exit(0);
    }
  }
}
