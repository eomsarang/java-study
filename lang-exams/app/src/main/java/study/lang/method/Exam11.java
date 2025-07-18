// 메서드: Wrapper 클래스와 Auto-boxing/Auto-unboxing
package study.lang.method;

public class Exam11 {

  public static void main(String[] args) {
    // Auto-boxing
    // - primitive type의 값을 자동으로 Wrapper 객체로 만드는 것.
    // - 레퍼런스에 할당하는 경우 auto-boxing을 수행한다.
    // Auto-unboxing
    // - Wrapper 객체를 primitive type의 값으로 자동 변환하는 것.
    // - Wrapper 객체를 primitive type의 변수에 할당하는 경우 auto-unboxing을 수행한다.

    byte b = 100;
    short s = 100;
    int i = 100;
    long l = 100;
    float f = 100.0f;
    double d = 100.0;
    boolean bool = true;
    char c = 'A';

    Object obj;

    // 1) 할당문 실행 - auto-boxing / auto-unboxing
    obj = b; // auto-boxing: 컴파일러는 다음 문장으로 변환한다. ==> obj = Byte.valueOf(b)
    System.out.println(obj.getClass());
    byte bb = (byte) obj; // auto-unboxing: 컴파일러는 다음 문장으로 변환한다. bb = ((Byte) obj).byteValue();
    System.out.println(bb);

    System.out.println("------------------------");

    // 2) 메서드 호출 - auto-boxing / auto-unboxing
    info(b); // ==> info(Byte.valueOf(b))
    info(s); // ==> info(Short.valueOf(s))
    info(i); // ==> info(Integer.valueOf(i))
    info(l); // ==> info(Long.valueOf(l))
    info(f); // ==> info(Float.valueOf(f))
    info(d); // ==> info(Double.valueOf(d))
    info(bool); // ==> info(Boolean.valueOf(bool))
    info(c); // ==> info(Character.valueOf(c))
  }

  static void info(Object obj) {
    System.out.println(obj.getClass());
  }

}
