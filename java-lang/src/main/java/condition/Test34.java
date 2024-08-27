package condition;

public class Test34 {
  public static void main(String[] args) {
    // break;
    String role = "경비";

    switch (role) {
      case "개발직":
        System.out.println("자격증");
        System.out.println("경력증명서");
        System.out.println("이력서");
        break;
      case "사무직":
        System.out.println("경력증명서");
        System.out.println("이력서");
        break;
      case "경비":
        System.out.println("이력서");
        break;
      default:
        System.out.println("해당 직무는 채용하지 않습니다.");
    }

  }
}

