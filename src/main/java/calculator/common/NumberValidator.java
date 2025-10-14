package calculator.common;

/**
 * 입력받은 배열 안의 값들이 숫자인지 검증하는 클래스
 */
public class NumberValidator {
    public static void validateNumbers(String[] values) {
        for (String value : values) {
            if (value.isEmpty()) {
                continue;
            }
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
