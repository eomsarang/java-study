package baekjoon.step18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main20920 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    Map<String, Integer> map = new HashMap<>();

    for (int i = 0; i < N; i++) {
      String word = br.readLine();
      if (word.length() < M) {
        continue;
      }
      map.put(word, map.getOrDefault(word, 0) + 1);
    }

    List<String> words = new ArrayList<>(map.keySet());

    words.sort((a, b) -> {
      int freqA = map.get(a);
      int freqB = map.get(b);

      if (freqA != freqB) {
        return freqB - freqA; // 빈도 높은 순
      } else if (a.length() != b.length()) {
        return b.length() - a.length();
      } else {
        return a.compareTo(b);
      }
    });

    StringBuilder sb = new StringBuilder();
    for (String w : words) {
      sb.append(w).append("\n");
    }
    System.out.print(sb);
  }
}
