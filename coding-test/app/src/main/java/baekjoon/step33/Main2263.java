package baekjoon.step33;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2263 {

  static int n;
  static int[] inorder, postorder, index;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());

    inorder = new int[n];
    postorder = new int[n];
    index = new int[n + 1];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      inorder[i] = Integer.parseInt(st.nextToken());
      index[inorder[i]] = i;
    }

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      postorder[i] = Integer.parseInt(st.nextToken());
    }

    build(0, n - 1, 0, n - 1);

    System.out.println(sb.toString());
  }

  static void build(int inStart, int inEnd, int postStart, int postEnd) {
    if (inStart > inEnd || postStart > postEnd) {
      return;
    }

    int root = postorder[postEnd];
    sb.append(root).append(" ");

    int rootIdx = index[root];
    int leftSize = rootIdx - inStart;

    build(inStart, rootIdx - 1,
        postStart, postStart + leftSize - 1);

    build(rootIdx + 1, inEnd,
        postStart + leftSize, postEnd - 1);
  }
}
