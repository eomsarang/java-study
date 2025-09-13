package baekjoon.step16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main24511 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] A = new int[N];
    for (int i = 0; i < N; i++) {
      A[i] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine());
    Deque<Integer> queue = new ArrayDeque<>();
    for (int i = 0; i < N; i++) {
      int b = Integer.parseInt(st.nextToken());
      if (A[i] == 0) { // 큐만 실제로 영향을 줌
        queue.addLast(b);
      }
    }

    int M = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < M; i++) {
      int c = Integer.parseInt(st.nextToken());
      queue.addLast(c);
      sb.append(queue.pollFirst()).append(" ");
    }

    System.out.println(sb);
  }
}
