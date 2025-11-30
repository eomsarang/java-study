package baekjoon.step27;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main7576 {

  static int[] dx = {1, -1, 0, 0};
  static int[] dy = {0, 0, 1, -1};

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int M = Integer.parseInt(st.nextToken());
    int N = Integer.parseInt(st.nextToken());

    int[][] box = new int[N][M];
    Queue<int[]> q = new LinkedList<>();

    int unripe = 0;

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        box[i][j] = Integer.parseInt(st.nextToken());

        if (box[i][j] == 1) {
          q.add(new int[]{i, j});
        } else if (box[i][j] == 0) {
          unripe++;
        }
      }
    }

    if (unripe == 0) {
      System.out.println(0);
      return;
    }

    int days = -1;

    while (!q.isEmpty()) {
      int size = q.size();
      days++;

      for (int s = 0; s < size; s++) {
        int[] cur = q.poll();
        int x = cur[0];
        int y = cur[1];

        for (int k = 0; k < 4; k++) {
          int nx = x + dx[k];
          int ny = y + dy[k];

          if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
            if (box[nx][ny] == 0) {
              box[nx][ny] = 1;
              unripe--;
              q.add(new int[]{nx, ny});
            }
          }
        }
      }
    }

    if (unripe > 0) {
      System.out.println(-1);
    } else {
      System.out.println(days);
    }
  }
}
