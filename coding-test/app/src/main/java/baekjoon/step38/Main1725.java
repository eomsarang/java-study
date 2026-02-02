package baekjoon.step38;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main1725 {

  static class Bar {

    int start;
    long height;

    Bar(int start, long height) {
      this.start = start;
      this.height = height;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    Deque<Bar> stack = new ArrayDeque<>();
    long maxArea = 0;

    for (int i = 0; i < N; i++) {
      long h = Long.parseLong(br.readLine());
      int start = i;

      while (!stack.isEmpty() && stack.peekLast().height > h) {
        Bar b = stack.pollLast();
        maxArea = Math.max(maxArea, b.height * (i - b.start));
        start = b.start;
      }

      stack.addLast(new Bar(start, h));
    }

    while (!stack.isEmpty()) {
      Bar b = stack.pollLast();
      maxArea = Math.max(maxArea, b.height * (N - b.start));
    }

    System.out.println(maxArea);
  }
}
