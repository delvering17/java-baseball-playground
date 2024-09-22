package stringCaulator;

import java.util.Scanner;

public class StringCalculator {

    public String input() {
        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine();
    }

    public int calculate(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }

        String[] strArr = str.split(" ");

        int result = Integer.parseInt(strArr[0]);

        for (int i = 1; i < strArr.length; i += 2) {
            int nextNum = Integer.parseInt(strArr[i + 1]);
            switch (strArr[i]) {
                case "+":
                    result += nextNum;
                    break;
                case "-":
                    result -= nextNum;
                    break;
                case "*":
                    result *= nextNum;
                    break;
                case "/":
                    result /= nextNum;
                    break;
                default:
                    throw new IllegalArgumentException("operation이 올바르지 않습니다.(+,-,*,/ 사용가능)");
            }
        }

        return result;
    }

}