package baekjoon.step46;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main5670 {

  static class Node {

    Map<Character, Node> child = new HashMap<>();
    boolean end;
  }

  static Node root;

  static void insert(String word) {
    Node cur = root;

    for (char c : word.toCharArray()) {
      cur.child.putIfAbsent(c, new Node());
      cur = cur.child.get(c);
    }

    cur.end = true;
  }

  static int countPress(String word) {

    Node cur = root;
    int press = 0;

    for (int i = 0; i < word.length(); i++) {

      char c = word.charAt(i);
      cur = cur.child.get(c);

      if (i == 0) {
        press++;
      } else if (cur.child.size() > 1 || cur.end) {
        press++;
      }
    }

    return press;
  }

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line;

    while ((line = br.readLine()) != null) {

      int N = Integer.parseInt(line);

      root = new Node();

      String[] words = new String[N];

      for (int i = 0; i < N; i++) {
        words[i] = br.readLine();
        insert(words[i]);
      }

      double total = 0;

      for (String w : words) {
        total += countPress(w);
      }

      System.out.printf("%.2f\n", total / N);
    }
  }
}
