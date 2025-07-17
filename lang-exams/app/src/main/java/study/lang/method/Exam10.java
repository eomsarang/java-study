// 메서드: Wrapper 클래스
package study.lang.method;

public class Exam10 {

  public static void main(String[] args) {
    String str = new String("Hello!");
    print(str);

    int i = 100; // i 변수는 객체 주소가 아니다. 그래서 레퍼런스 변수인 obj 에서 받을 수 없다.
    // 해결책? int 를 객체에 저장한 후 그 객체 주소를 obj에 넘긴다.
    java.lang.Integer obj = java.lang.Integer.valueOf(i); // Integer 객체를 만들어서 i 값을 담은 후에 그 주소를 리턴
    print(obj);

    // Primitive 타입의 값은 객체가 아니기 때문에 Object 레퍼런스에 넘길 수 없는 문제가 있다.
    // 이 문제를 해결하고자 Primitive 타입의 값을 객체로 담을 수 있도록 특별한 클래스를 추가하였다.
    // byte     ---> java.lang.Byte
    // short    ---> java.lang.Short
    // int      ---> java.lang.Integer
    // long     ---> java.lang.Long
    // float    ---> java.lang.Float
    // double   ---> java.lang.Double
    // boolean  ---> java.lang.Boolean
    // char     ---> java.lang.Short.Character
    // 이 클래스의 역할이 Primitive 값을 객체에 담는 일을 하기 때문에 "Wrapper 클래스"라 부른다.

    // Wrapper 클래스 사용법
    byte b = 100;
    Byte byteObj = Byte.valueOf(b); // Primitive 타입의 값을 객체에 저장
    byte bb = byteObj.byteValue(); // 객체에 저장된 Primitive 타입의 값을 꺼내기

    short s = 100;
    Short shortObj = Short.valueOf(s); // Primitive 타입의 값을 객체에 저장
    short ss = shortObj.shortValue(); // 객체에 저장된 Primitive 타입의 값을 꺼내기

    int i2 = 100;
    Integer intObj = Integer.valueOf(i2); // Primitive 타입의 값을 객체에 저장
    int ii = intObj.intValue(); // 객체에 저장된 Primitive 타입의 값을 꺼내기

    long l = 100L;
    Long longObj = Long.valueOf(l); // Primitive 타입의 값을 객체에 저장
    long ll = longObj.longValue(); // 객체에 저장된 Primitive 타입의 값을 꺼내기

    float f = 3.14f;
    Float floatObj = Float.valueOf(f); // Primitive 타입의 값을 객체에 저장
    float ff = floatObj.floatValue(); // 객체에 저장된 Primitive 타입의 값을 꺼내기

    double d = 3.14;
    Double doubleObj = Double.valueOf(d); // Primitive 타입의 값을 객체에 저장
    double dd = doubleObj.doubleValue(); // 객체에 저장된 Primitive 타입의 값을 꺼내기

    boolean bool = true;
    Boolean booleanObj = Boolean.valueOf(bool); // Primitive 타입의 값을 객체에 저장
    boolean bool2 = booleanObj.booleanValue(); // 객체에 저장된 Primitive 타입의 값을 꺼내기

    char c = 'A';
    Character charObj = Character.valueOf(c); // Primitive 타입의 값을 객체에 저장
    char cc = charObj.charValue(); // 객체에 저장된 Primitive 타입의 값을 꺼내기
  }

  static void print(Object obj) {
    System.out.println(obj);
  }
}
