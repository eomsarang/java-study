package baekjoon.step46;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main14725 {

  static class Node {

    TreeMap<String, Node> child = new TreeMap<>();
  }

  static Node root = new Node();
  static StringBuilder sb = new StringBuilder();

  static void insert(String[] foods) {
    Node cur = root;

    for (String f : foods) {
      cur.child.putIfAbsent(f, new Node());
      cur = cur.child.get(f);
    }
  }

  static void dfs(Node node, int depth) {
    for (String key : node.child.keySet()) {

      for (int i = 0; i < depth; i++) {
        sb.append("--");
      }

      sb.append(key).append("\n");

      dfs(node.child.get(key), depth + 1);
    }
  }

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    for (int i = 0; i < N; i++) {

      StringTokenizer st = new StringTokenizer(br.readLine());

      int K = Integer.parseInt(st.nextToken());

      String[] foods = new String[K];

      for (int j = 0; j < K; j++) {
        foods[j] = st.nextToken();
      }

      insert(foods);
    }

    dfs(root, 0);

    System.out.print(sb);
  }
}
