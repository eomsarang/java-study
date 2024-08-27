package condition;

public class Test35 {
  public static void main(String[] args) {
    // break 문을 생략할 경우
    String role = "경비";

    switch (role) {
      case "개발직":
        System.out.println("자격증");
      case "사무직":
        System.out.println("경력증명서");
      case "경비":
        System.out.println("이력서");
        break;
      default:
        System.out.println("해당 직무는 채용하지 않습니다.");
    }

  }
}

