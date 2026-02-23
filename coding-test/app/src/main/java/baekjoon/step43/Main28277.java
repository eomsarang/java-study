package baekjoon.step43;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main28277 {

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int Q = Integer.parseInt(st.nextToken());

    HashSet<Integer>[] sets = new HashSet[N + 1];

    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      int sz = Integer.parseInt(st.nextToken());
      sets[i] = new HashSet<>(sz * 2);

      for (int j = 0; j < sz; j++) {
        sets[i].add(Integer.parseInt(st.nextToken()));
      }
    }

    StringBuilder sb = new StringBuilder();

    while (Q-- > 0) {

      st = new StringTokenizer(br.readLine());
      int type = Integer.parseInt(st.nextToken());

      if (type == 1) {
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        if (a == b) {
          continue;
        }

        if (sets[a].size() < sets[b].size()) {
          HashSet<Integer> tmp = sets[a];
          sets[a] = sets[b];
          sets[b] = tmp;
        }

        for (int x : sets[b]) {
          sets[a].add(x);
        }
        sets[b].clear();

      } else {
        int a = Integer.parseInt(st.nextToken());
        sb.append(sets[a].size()).append('\n');
      }
    }

    System.out.print(sb);
  }
}
