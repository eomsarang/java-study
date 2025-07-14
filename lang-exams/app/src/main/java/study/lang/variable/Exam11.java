// 배열 초기화
package study.lang.variable;

public class Exam11 {
  public static void main(String[] args){
    // 인스턴스(객체)는 항상 해당 타입의 기본 값으로 자동 초기화 된다.
    int[] scores1;
    // System.out.println(scores1); // 물론 로컬 변수는 자동초기화가 안된다. 그래서 초기화 없이 사용 불가!

    scores1= new int[3]; // 그런데 객체는 무조건 자동 초기화 된다. int인 경우 0으로 초기화 된다.
    System.out.printf("%d, %d, %d\n", scores1[0], scores1[1], scores1[2]);

    // 배열 객체를 만들 때 즉시 값을 초기화 시킬 수 있다.
    int[] scores2 = new int[] {100, 90, 80}; // 값을 담을 3개의 배열이 자동 생성된다.

    // 배열 객체를 생성하는 new 명령을 생략할 수 있다.
    int[] scores3 = {100, 90, 80}; // 값을 담을 3개의 배열이 자동 생성된다.

    // 레퍼런스를 선언한 후 배열 초기화 문법을 사용
    int[] scores4;
    scores4 = new int[] {100, 90, 80};

    // 레퍼런스를 선언한 후에 배열 초기화 문법을 사용할 때, new 명령 생략 불가!
    int[] scores5;
    // scores5 = {100, 90, 80};
  }
}
