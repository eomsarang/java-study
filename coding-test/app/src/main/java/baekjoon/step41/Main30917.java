package baekjoon.step41;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main30917 {

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int A = 0, B = 0;

    for (int i = 1; i <= 9; i++) {
      System.out.println("? A " + i);
      System.out.flush();

      int res = Integer.parseInt(br.readLine());
      if (res == 1) {
        A = i;
        break;
      }
    }
    
    for (int i = 1; i <= 9; i++) {
      System.out.println("? B " + i);
      System.out.flush();

      int res = Integer.parseInt(br.readLine());
      if (res == 1) {
        B = i;
        break;
      }
    }

    System.out.println("! " + (A + B));
    System.out.flush();
  }
}
