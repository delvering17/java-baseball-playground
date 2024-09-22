package stringCaulator;

public class StringCalculator {

    private final InputProvider inputProvider;

    private final String INPUT_SEPARATOR = " ";

    public StringCalculator(InputProvider inputProvider) {
        this.inputProvider = inputProvider;
    }

    public int calculate() {
        String input = inputProvider.getInput();

        String[] strArr = splitInput(input);

        int result = Integer.parseInt(strArr[0]);

        for (int i = 1; i < strArr.length; i += 2) {
            String operation = strArr[i];
            int nextNum = Integer.parseInt(strArr[i + 1]);

            result = applyOperation(result, operation, nextNum);
        }

        return result;
    }

    private String[] splitInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }

        return input.split(INPUT_SEPARATOR);
    }

    private int applyOperation(int result, String operation, int nextNum) {
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