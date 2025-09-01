package baekjoon.step14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main10816 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());

    Map<Integer, Integer> cardMap = new HashMap<>();
    for (int i = 0; i < N; i++) {
      int num = Integer.parseInt(st.nextToken());
      cardMap.put(num, cardMap.getOrDefault(num, 0) + 1);
    }

    int M = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < M; i++) {
      int query = Integer.parseInt(st.nextToken());
      sb.append(cardMap.getOrDefault(query, 0)).append(" ");
    }

    System.out.println(sb.toString().trim());
  }
}
