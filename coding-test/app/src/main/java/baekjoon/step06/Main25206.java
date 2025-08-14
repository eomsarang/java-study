package baekjoon.step06;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main25206 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    Map<String, Double> gradeMap = new HashMap<>();
    gradeMap.put("A+", 4.5);
    gradeMap.put("A0", 4.0);
    gradeMap.put("B+", 3.5);
    gradeMap.put("B0", 3.0);
    gradeMap.put("C+", 2.5);
    gradeMap.put("C0", 2.0);
    gradeMap.put("D+", 1.5);
    gradeMap.put("D0", 1.0);
    gradeMap.put("F", 0.0);

    double totalScore = 0.0;
    double totalCredit = 0.0;

    for (int i = 0; i < 20; i++) {
      String subject = sc.next();
      double credit = sc.nextDouble();
      String grade = sc.next();

      if (grade.equals("P")) {
        continue;
      }

      totalScore += credit * gradeMap.get(grade);
      totalCredit += credit;
    }

    double gpa = totalScore / totalCredit;
    System.out.println(gpa);
  }
}
