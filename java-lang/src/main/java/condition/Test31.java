package condition;

public class Test31 {
  public static void main(String[] args) {

    // switch ~ case 문
    // switch (int정수, 문자열, Enum 타입) {
    // case 상수, 리터럴:
    // ...
    // break;
    // ...
    // default:
    // }

    switch (90) {
      case 100:
        System.out.println("A");
        break;
      case 90:
        System.out.println("B");
        break;
      case 80:
        System.out.println("C");
        break;
      default:
        System.out.println("F");
    }
  }

}

