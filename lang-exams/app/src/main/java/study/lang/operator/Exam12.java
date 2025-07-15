// 논리 연산 II
// 표현식1 && 표현식2: 표현식1이 false이면 표현식2를 실행하지 않는다. 왜? 어차피 결과는 정해졌으니까!
// 표현식1 & 표현식2: 표현식1의 결과에 상관없이 표현식2를 반드시 실행한다.
// 표현식1 || 표현식2: 표현식1이 true이면 표현식2를 실행하지 않는다. 왜? 어차피 결과는 정해졌으니까!
// 표현식1 | 표현식2: 표현식1의 결과에 상관없이 표현식2를 반드시 실행한다.

package study.lang.operator;

public class Exam12 {

  public static void main(String[] args) {
    int i = 100;
    boolean a = false;
    boolean r = false;

    a = false;
    r = ((i >= 100) && (a = true));
    System.out.printf("a=%b, r=%b\n", a, r);

    a = false;
    r = ((i >= 100) & (a = true));
    System.out.printf("a=%b, r=%b\n", a, r);

    a = false;
    r = ((i < 100) && (a = true));
    System.out.printf("a=%b, r=%b\n", a, r);

    a = false;
    r = ((i < 100) & (a = true));
    System.out.printf("a=%b, r=%b\n", a, r);
    System.out.println("-----------------------------");

    a = false;
    r = ((i >= 100) || (a = true));
    System.out.printf("a=%b, r=%b\n", a, r);

    a = false;
    r = ((i >= 100) | (a = true));
    System.out.printf("a=%b, r=%b\n", a, r);

    a = false;
    r = ((i < 100) || (a = true));
    System.out.printf("a=%b, r=%b\n", a, r);

    a = false;
    r = ((i < 100) | (a = true));
    System.out.printf("a=%b, r=%b\n", a, r);
  }
}
