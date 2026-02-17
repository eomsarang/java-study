package baekjoon.step41;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;


public class Main23435 {

  static BufferedReader br =
      new BufferedReader(new InputStreamReader(System.in));
  static PrintWriter out =
      new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

  static boolean less(int i, int j) throws Exception {
    out.println("? " + i + " " + j);
    out.flush();

    String res = br.readLine();
    return res.charAt(0) == '<';
  }

  public static void main(String[] args) throws Exception {

    int N = Integer.parseInt(br.readLine().trim());

    ArrayList<Integer>[] lost = new ArrayList[N];
    for (int i = 0; i < N; i++) {
      lost[i] = new ArrayList<>();
    }

    ArrayList<Integer> cur = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      cur.add(i);
    }

    while (cur.size() > 1) {
      ArrayList<Integer> next = new ArrayList<>();

      for (int i = 0; i + 1 < cur.size(); i += 2) {
        int a = cur.get(i);
        int b = cur.get(i + 1);

        if (less(a, b)) {
          lost[a].add(b);
          next.add(a);
        } else {
          lost[b].add(a);
          next.add(b);
        }
      }

      // 홀수 개면 마지막 자동 진출
      if (cur.size() % 2 == 1) {
        next.add(cur.get(cur.size() - 1));
      }

      cur = next;
    }

    int minIndex = cur.get(0);

    ArrayList<Integer> cand = lost[minIndex];

    int second = cand.get(0);
    for (int x : cand) {
      if (less(x, second)) {
        second = x;
      }
    }

    out.println("! " + second);
    out.flush();
  }
}
