package baekjoon.step14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main1764 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    HashSet<String> unheard = new HashSet<>();
    for (int i = 0; i < N; i++) {
      unheard.add(br.readLine());
    }

    ArrayList<String> result = new ArrayList<>();
    for (int i = 0; i < M; i++) {
      String name = br.readLine();
      if (unheard.contains(name)) {
        result.add(name);
      }
    }

    Collections.sort(result);

    sb.append(result.size()).append("\n");
    for (String name : result) {
      sb.append(name).append("\n");
    }

    System.out.print(sb);
  }
}
