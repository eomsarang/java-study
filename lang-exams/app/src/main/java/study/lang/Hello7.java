// 클래스 파일을 별도의 폴더로 분리하기
// - 개발이 끝난 후 배포하기 쉽도록 컴파일 할 때 .class 파일을 별도의 폴더로 생성시킨다.
// - $ java -d .class를둘폴더
//   예) $ java -d app/bin app/src/main/java/study/lang/Hello7.java
//   - app/bin 폴더가 없으면 자동 생성된다.
//   - 패키지에 해당되는 폴더가 자동 생성된다.
//   - 그런 후 컴파일된 .class 파일을 해당 폴더에 놓는다.
// - 실행
//   예) $ java -cp app/bin study.lang.Hello7

package study.lang;

public class Hello7 {
  public static void main(String[] args) {
    System.out.println("Hello7!");
  }
}


// 실무: 컴파일하는 과정이 복잡하기 때문에 빌드 도구를 사용해서 수행한다.
// - $ gradle compilejava
// - 단 빌드 도구를 사용하는 경우 모든 소스 파일을 컴파일 한다.
// - 그래서 한 개의 파일이라도 컴파일 오류가 있다면 빌드 오류가 발생한다.
