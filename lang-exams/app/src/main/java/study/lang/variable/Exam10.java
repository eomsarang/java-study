// 배열 변수
// - new 연산자를 사용해서 배열을 생성한다.
// - 배열의 주소를 저장할 레퍼런스가 필요하다.
package study.lang.variable;

public class Exam10 {
  public static void main(String[] args){
    // 국, 수, 영 점수를 저장할 변수를 낱개로 선언
    int kor, math, eng;

    kor = 90;
    math = 90;
    eng = 90;

    // 같은 타입의 변수를 여러 개 만드는 쉬운 방법: 배열
    int[] scores; // 배열의 주소를 담을 레퍼런스 선언. 배열 레퍼런스로 부른다.
    scores = new int[3]; // int 타입의 변수를 3개 연속해서 만든다. 이것을 배열 객체 또는 배열 인스턴스로 부른다.

    // 배열의 각 변수에 접근하려면 배열 주소와 인덱스가 있어야 한다.
    // - 인덱스는 0부터 시작한다.
    scores[0] = 100;
    scores[1] = 100;
    scores[2] = 100;

    // 유효한 인덱스가 아닌 경우 실행할 때 예외가 발생한다.
    // scores[-1] = 100;
    // scores[3] = 100;

    // C 방식으로 레퍼런스를 선언할 수 있다.
    int scores2[] = new int[3];
  }
}
