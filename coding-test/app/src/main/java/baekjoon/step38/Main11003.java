package baekjoon.step38;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

public class Main11003 {

  static class Node {

    int value;
    int index;

    Node(int value, int index) {
      this.value = value;
      this.index = index;
    }
  }

  static class FastScanner {

    private final byte[] buffer = new byte[1 << 16];
    private int ptr = 0, len = 0;
    private final InputStream in = System.in;

    private int readByte() throws IOException {
      if (ptr >= len) {
        len = in.read(buffer);
        ptr = 0;
        if (len <= 0) {
          return -1;
        }
      }
      return buffer[ptr++];
    }

    int nextInt() throws IOException {
      int c, sign = 1, val = 0;
      do {
        c = readByte();
      } while (c <= ' ');

      if (c == '-') {
        sign = -1;
        c = readByte();
      }

      while (c > ' ') {
        val = val * 10 + (c - '0');
        c = readByte();
      }
      return val * sign;
    }
  }

  public static void main(String[] args) throws Exception {
    FastScanner fs = new FastScanner();
    int N = fs.nextInt();
    int L = fs.nextInt();

    Deque<Node> deque = new ArrayDeque<>();
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < N; i++) {
      int x = fs.nextInt();

      while (!deque.isEmpty() && deque.peekLast().value > x) {
        deque.pollLast();
      }

      deque.addLast(new Node(x, i));

      if (Objects.requireNonNull(deque.peekFirst()).index <= i - L) {
        deque.pollFirst();
      }

      sb.append(Objects.requireNonNull(deque.peekFirst()).value).append(' ');
    }

    System.out.print(sb);
  }
}
