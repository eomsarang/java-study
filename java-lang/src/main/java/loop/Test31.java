package loop;

public class Test31 {
  public static void main(String[] args) {
    int sum = 0;
    // for (변수 선언 및 초기화; 조건; 증감문) {
    // 반복해서 실행할 문장
    // }
    for (int i = 1; i <= 100; i++) {
      sum += i;
    }

    System.out.println(sum);
  }
}
