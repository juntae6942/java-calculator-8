package calculator.common;

public class NumberValidator {
    public static void validateNumbers(String[] values) {
        for (String value : values) {
            if (value.isEmpty()) continue;
            if (!value.matches("-?\\d+")) {
                throw new IllegalArgumentException("Invalid number: " + value);
            }
            int num = Integer.parseInt(value);
            if (num < 0) {
                throw new IllegalArgumentException("Negative number not allowed: " + num);
            }
        }
    }
}
