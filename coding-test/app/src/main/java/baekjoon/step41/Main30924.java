import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Main30924 {

  static Random rnd = new Random();

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int A = -1;
    int B = -1;

    int limit = 19997;
    int used = 0;

    while (A == -1 && used < limit) {
      int x = rnd.nextInt(10000) + 1;

      System.out.println("? A " + x);
      System.out.flush();
      used++;

      int res = Integer.parseInt(br.readLine());
      if (res == 1) {
        A = x;
      }
    }

    while (B == -1 && used < limit) {
      int x = rnd.nextInt(10000) + 1;

      System.out.println("? B " + x);
      System.out.flush();
      used++;

      int res = Integer.parseInt(br.readLine());
      if (res == 1) {
        B = x;
      }
    }

    if (A == -1) {
      A = 1;
    }
    if (B == -1) {
      B = 1;
    }

    System.out.println("! " + (A + B));
    System.out.flush();
  }
}
