package programmers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

  public int solution(String message, int[][] spoiler_ranges) {
    int n = message.length();

    boolean[] isSpo = new boolean[n];
    for (int[] r : spoiler_ranges) {
      for (int i = r[0]; i <= r[1]; i++) {
        isSpo[i] = true;
      }
    }

    List<String> words = new ArrayList<>();
    List<int[]> ranges = new ArrayList<>();

    int i = 0;
    while (i < n) {
      if (message.charAt(i) == ' ') {
        i++;
        continue;
      }
      int start = i;
      while (i < n && message.charAt(i) != ' ') {
        i++;
      }
      int end = i - 1;

      words.add(message.substring(start, i));
      ranges.add(new int[]{start, end});
    }

    int w = words.size();
    
    boolean[] isSpoWord = new boolean[w];
    Set<String> outsideSet = new HashSet<>();

    for (int j = 0; j < w; j++) {
      int s = ranges.get(j)[0];
      int e = ranges.get(j)[1];

      boolean hasSpo = false;
      boolean hasNonSpo = false;

      for (int k = s; k <= e; k++) {
        if (isSpo[k]) {
          hasSpo = true;
        } else {
          hasNonSpo = true;
        }
      }

      isSpoWord[j] = hasSpo;

      if (!hasSpo || hasNonSpo) {
        outsideSet.add(words.get(j));
      }
    }

    Set<String> used = new HashSet<>();
    int answer = 0;

    for (int[] r : spoiler_ranges) {
      int l = r[0];
      int rr = r[1];

      for (int j = 0; j < w; j++) {
        int s = ranges.get(j)[0];
        int e = ranges.get(j)[1];

        // 구간과 겹치는지
        if (e < l || s > rr) {
          continue;
        }

        String word = words.get(j);

        if (isSpoWord[j] &&
            !outsideSet.contains(word) &&
            !used.contains(word)) {

          answer++;
          used.add(word);
        }
      }
    }

    return answer;
  }
}