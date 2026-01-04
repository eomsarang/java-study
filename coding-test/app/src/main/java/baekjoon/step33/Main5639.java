package baekjoon.step33;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main5639 {

  static List<Integer> preorder = new ArrayList<>();
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String line;
    while ((line = br.readLine()) != null && !line.isEmpty()) {
      preorder.add(Integer.parseInt(line));
    }

    postOrder(0, preorder.size() - 1);

    System.out.print(sb.toString());
  }

  // preorder[start ~ end] 구간을 BST 후위 순회로 출력
  static void postOrder(int start, int end) {
    if (start > end) {
      return;
    }

    int root = preorder.get(start);

    int idx = start + 1;
    while (idx <= end && preorder.get(idx) < root) {
      idx++;
    }

    postOrder(start + 1, idx - 1);
    postOrder(idx, end);
    sb.append(root).append('\n');
  }
}
