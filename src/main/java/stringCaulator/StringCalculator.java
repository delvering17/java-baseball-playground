package stringCaulator;

import java.util.Scanner;

public class StringCalculator {

    private final String INPUT_SEPARATOR = " ";

    public String input() {
        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine();
    }

    public int calculate(String input) {
        String[] strArr = splitInput(input);

        int firstNum = Integer.parseInt(strArr[0]);

        int result = firstNum;

        for (int i = 1; i < strArr.length; i += 2) {
            String operation = strArr[i];
            int nextNum = Integer.parseInt(strArr[i + 1]);

            result = getResult(result, operation, nextNum);
        }

        return result;
    }

    private String[] splitInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }

        return input.split(INPUT_SEPARATOR);
    }

    private int getResult(int result, String operation, int nextNum) {
        switch (operation) {
            case "+":
                return result + nextNum;
            case "-":
                return result - nextNum;
            case "*":
                return result * nextNum;
            case "/":
                return result / nextNum;
            default:
                throw new IllegalArgumentException("operation이 올바르지 않습니다.(+,-,*,/ 사용가능)");
        }
    }

}