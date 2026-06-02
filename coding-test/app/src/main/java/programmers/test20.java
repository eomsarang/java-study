package programmers;

import java.util.HashMap;
import java.util.Map;

public class test20 {

  static class Solution {

    public int[] solution(String[] keymap, String[] targets) {

      Map<Character, Integer> map = new HashMap<>();

      for (String key : keymap) {
        for (int i = 0; i < key.length(); i++) {
          char c = key.charAt(i);

          map.put(c,
              Math.min(map.getOrDefault(c, Integer.MAX_VALUE),
                  i + 1));
        }
      }

      int[] answer = new int[targets.length];

      for (int i = 0; i < targets.length; i++) {
        int sum = 0;
        boolean possible = true;

        for (char c : targets[i].toCharArray()) {

          if (!map.containsKey(c)) {
            possible = false;
            break;
          }

          sum += map.get(c);
        }

        answer[i] = possible ? sum : -1;
      }

      return answer;
    }
  }
}