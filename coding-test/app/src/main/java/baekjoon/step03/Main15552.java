package baekjoon.step03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main15552 {

  // BufferedReader, BufferedWriter를 사용할 때에는 반드시 throws 또는 try-catch를 통해 입출력 관련 예외처리를 해야한다.
  public static void main(String[] args) throws IOException {

    // for문 에서는 입출력 방식이 느리면 여러 줄을 입력받거나 출력할 때 시간초과가 날 수 있다.
    // Scanner 대신 BufferedReader를 사용해본다.
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // BufferedReader의 readLine()은 String 타입을 반환하므로 Integer의 parseInt()메서드를 사용해서 타입을 바꾼다.
    int t = Integer.parseInt(br.readLine());
    int[] arr = new int[t];

    if (1 <= t && t <= 1000000) {
      for (int i = 0; i < t; i++) {
        // 한 줄에 공백을 두고 두 변수를 입력받을때는 문자열로 읽게 된다.
        // 따라서 String[] 배열을 split() 메서드를 사용해 쪼갠 후 각각 저장한다.
        String[] input = br.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        arr[i] += a + b;
      }
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    for (int i = 0; i < t; i++) {
      // BufferedWriter의 write() 문자열을 그대로 출력하므로 줄바꿈을 수동으로 해주어야 한다.
      bw.write(arr[i] + "\n");
    }
    bw.flush();

  }
}
