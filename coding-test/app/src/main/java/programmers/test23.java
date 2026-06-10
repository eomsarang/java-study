package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test23 {


  static class Solution {

    public int[] solution(String today, String[] terms, String[] privacies) {

      Map<String, Integer> map = new HashMap<>();

      for (String term : terms) {
        String[] t = term.split(" ");
        map.put(t[0], Integer.parseInt(t[1]));
      }

      int todayDay = convert(today);

      List<Integer> answer = new ArrayList<>();

      for (int i = 0; i < privacies.length; i++) {

        String[] p = privacies[i].split(" ");

        int startDay = convert(p[0]);
        int expireDay = startDay + map.get(p[1]) * 28;

        if (todayDay >= expireDay) {
          answer.add(i + 1);
        }
      }

      return answer.stream()
          .mapToInt(Integer::intValue)
          .toArray();
    }

    private int convert(String date) {
      String[] d = date.split("\\.");

      int year = Integer.parseInt(d[0]);
      int month = Integer.parseInt(d[1]);
      int day = Integer.parseInt(d[2]);

      return year * 12 * 28 + month * 28 + day;
    }
  }
}