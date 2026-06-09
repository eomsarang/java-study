package programmers;

public class test22 {

  static class Solution {

    public String solution(String s, String skip, int index) {
      StringBuilder alphabet = new StringBuilder();

      for (char c = 'a'; c <= 'z'; c++) {
        if (!skip.contains(String.valueOf(c))) {
          alphabet.append(c);
        }
      }

      StringBuilder answer = new StringBuilder();

      for (char c : s.toCharArray()) {
        int pos = alphabet.indexOf(String.valueOf(c));
        int next = (pos + index) % alphabet.length();
        answer.append(alphabet.charAt(next));
      }

      return answer.toString();
    }
  }
}