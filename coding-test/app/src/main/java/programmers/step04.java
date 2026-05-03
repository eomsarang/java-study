package programmers;

public class step04 {

  static class Solution {

    public String solution(String video_len, String pos, String op_start, String op_end,
        String[] commands) {
      int video = toSec(video_len);
      int cur = toSec(pos);
      int start = toSec(op_start);
      int end = toSec(op_end);

      cur = skipOpening(cur, start, end);

      for (String cmd : commands) {
        if (cmd.equals("prev")) {
          cur = Math.max(0, cur - 10);
        } else {
          cur = Math.min(video, cur + 10);
        }

        cur = skipOpening(cur, start, end);
      }

      return toTime(cur);
    }

    private int skipOpening(int cur, int start, int end) {
      if (start <= cur && cur <= end) {
        return end;
      }
      return cur;
    }

    private int toSec(String s) {
      int m = Integer.parseInt(s.substring(0, 2));
      int sec = Integer.parseInt(s.substring(3, 5));
      return m * 60 + sec;
    }

    private String toTime(int sec) {
      int m = sec / 60;
      int s = sec % 60;
      return String.format("%02d:%02d", m, s);
    }
  }
}