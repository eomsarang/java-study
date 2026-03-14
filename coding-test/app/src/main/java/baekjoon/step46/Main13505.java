package baekjoon.step46;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main13505 {

  static class Node {

    Node[] child = new Node[2];
  }

  static Node root = new Node();

  static void insert(int num) {

    Node cur = root;

    for (int i = 30; i >= 0; i--) {

      int bit = (num >> i) & 1;

      if (cur.child[bit] == null) {
        cur.child[bit] = new Node();
      }

      cur = cur.child[bit];
    }
  }

  static int search(int num) {

    Node cur = root;
    int xor = 0;

    for (int i = 30; i >= 0; i--) {

      int bit = (num >> i) & 1;
      int opposite = bit ^ 1;

      if (cur.child[opposite] != null) {
        xor |= (1 << i);
        cur = cur.child[opposite];
      } else {
        cur = cur.child[bit];
      }
    }

    return xor;
  }

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());

    int[] arr = new int[N];

    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
      insert(arr[i]);
    }

    int max = 0;

    for (int x : arr) {
      max = Math.max(max, search(x));
    }

    System.out.println(max);
  }
}
