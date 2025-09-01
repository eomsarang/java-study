package baekjoon.step14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Main7785 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    HashSet<String> set = new HashSet<>();

    for (int i = 0; i < n; i++) {
      String[] log = br.readLine().split(" ");
      String name = log[0];
      String action = log[1];

      if (action.equals("enter")) {
        set.add(name);
      } else if (action.equals("leave")) {
        set.remove(name);
      }
    }

    List<String> result = new ArrayList<>(set);
    Collections.sort(result, Collections.reverseOrder());

    StringBuilder sb = new StringBuilder();
    for (String name : result) {
      sb.append(name).append("\n");
    }

    System.out.print(sb);
  }
}
