package baekjoon.step13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main1181 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    Set<String> set = new HashSet<>();

    for (int i = 0; i < N; i++) {
      set.add(br.readLine());
    }

    List<String> words = new ArrayList<>(set);

    words.sort(new Comparator<String>() {
      @Override
      public int compare(String a, String b) {
        if (a.length() == b.length()) {
          return a.compareTo(b);
        }
        return a.length() - b.length();
      }
    });

    StringBuilder sb = new StringBuilder();
    for (String word : words) {
      sb.append(word).append("\n");
    }
    System.out.print(sb);
  }
}
