package baekjoon.step08;

import java.util.Scanner;

public class Main11005 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int B = sc.nextInt();
    sc.close();

    StringBuilder sb = new StringBuilder();

    while (N > 0) {
      int remainder = N % B;
      if (remainder < 10) {
        sb.append(remainder);
      } else {
        sb.append((char) ('A' + (remainder - 10)));
      }
      N /= B;
    }
    
    System.out.println(sb.reverse());
  }
}
