package baekjoon.step14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main1269 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int aSize = Integer.parseInt(st.nextToken());
    int bSize = Integer.parseInt(st.nextToken());

    HashSet<Integer> setA = new HashSet<>();
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < aSize; i++) {
      setA.add(Integer.parseInt(st.nextToken()));
    }

    int intersection = 0;
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < bSize; i++) {
      int num = Integer.parseInt(st.nextToken());
      if (setA.contains(num)) {
        intersection++;
      }
    }

    int result = (aSize + bSize) - (2 * intersection);
    System.out.println(result);
  }
}
