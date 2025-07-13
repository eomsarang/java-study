// 패키지에 소속된 클래스 실행
// - 클래스 이름을 지정할 때 반드시 패키지 이름까지 지정해야 한다.
//   예) $ java study.lang.Hello6

package study.lang;

public class Hello6 {
  public static void main(String[] args) {
    System.out.println("Hello6!");
  }
}

// 실무: 다른 폴더에서 클래스를 실행할 때
// - $ java -classpath 시작패키지가있는폴더 패키지명.패키지명.클래스명
// - $ java -cp 시작패키지가있는폴더 패키지명.패키지명.클래스명
// - 예) $ java -classpath app/src/main/java study.lang.Hello6
