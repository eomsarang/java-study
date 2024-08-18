package literal;

public class Test53 {
  public static void main(String[] args) throws Exception {
    // 문자 리터럴(literal) - 문자집합 인코딩
    String str = "ABCabc012가각간똠똡똣똥"; // UTF-16BE

    printBytes(str, "ISO-8859-1");
    printBytes(str, "EUC-KR");
    printBytes(str, "MS949");
    printBytes(str, "UTF-16BE");
    printBytes(str, "UTF-8");
  }

  static void printBytes(String str, String charset) throws Exception {
    byte[] bytes = str.getBytes(charset);
    System.out.printf("%s => ", charset);
    for (byte b : bytes) {
      System.out.printf("%02x ", b);
    }
    System.out.println();
  }
}
