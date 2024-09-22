package stringCaulator;

public class StringInputProvider implements InputProvider {

    private final String input;

    public StringInputProvider(String input) {
        this.input = input;
    }

    @Override
    public String getInput() {
        return input;
    }
}
