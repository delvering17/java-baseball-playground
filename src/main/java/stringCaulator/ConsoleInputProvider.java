package stringCaulator;

import java.util.Scanner;

public class ConsoleInputProvider implements InputProvider {

    @Override
    public String getInput() {
        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine();
    }

}
