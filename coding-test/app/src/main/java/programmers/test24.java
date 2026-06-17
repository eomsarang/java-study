package programmers;

public class test24 {

  static class Solution {

    public int solution(String t, String p) {
      int answer = 0;

      long target = Long.parseLong(p);
      int len = p.length();

      for (int i = 0; i <= t.length() - len; i++) {
        String sub = t.substring(i, i + len);

        if (Long.parseLong(sub) <= target) {
          answer++;
        }
      }

      return answer;
    }
  }
}