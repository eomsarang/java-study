package baekjoon.step33;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1991 {

  static char[] left = new char[26];
  static char[] right = new char[26];

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      char node = st.nextToken().charAt(0);
      char l = st.nextToken().charAt(0);
      char r = st.nextToken().charAt(0);

      int idx = node - 'A';
      left[idx] = l;
      right[idx] = r;
    }

    preorder('A');
    System.out.println();
    inorder('A');
    System.out.println();
    postorder('A');
  }

  static void preorder(char node) {
    if (node == '.') {
      return;
    }
    System.out.print(node);
    preorder(left[node - 'A']);
    preorder(right[node - 'A']);
  }

  static void inorder(char node) {
    if (node == '.') {
      return;
    }
    inorder(left[node - 'A']);
    System.out.print(node);
    inorder(right[node - 'A']);
  }

  static void postorder(char node) {
    if (node == '.') {
      return;
    }
    postorder(left[node - 'A']);
    postorder(right[node - 'A']);
    System.out.print(node);
  }
}
