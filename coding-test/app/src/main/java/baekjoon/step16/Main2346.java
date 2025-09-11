package baekjoon.step16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main2346 {

  static class Balloon {

    int idx, move;

    Balloon(int idx, int move) {
      this.idx = idx;
      this.move = move;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());

    Deque<Balloon> deque = new ArrayDeque<>();
    for (int i = 1; i <= N; i++) {
      int move = Integer.parseInt(st.nextToken());
      deque.add(new Balloon(i, move));
    }

    while (!deque.isEmpty()) {
      Balloon b = deque.pollFirst();
      sb.append(b.idx).append(" ");

      if (deque.isEmpty()) {
        break;
      }

      int move = b.move;
      if (move > 0) {
        for (int i = 0; i < move - 1; i++) {
          deque.addLast(deque.pollFirst());
        }
      } else {
        for (int i = 0; i < Math.abs(move); i++) {
          deque.addFirst(deque.pollLast());
        }
      }
    }

    System.out.println(sb);
  }
}
