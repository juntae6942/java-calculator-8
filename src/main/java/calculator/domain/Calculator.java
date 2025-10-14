package calculator.domain;

import java.util.List;

/**
 * 입력받은 숫자의 총합을 계산하는 클래스
 */
public class Calculator {

    private int sum;

    public Calculator() {
        sum = 0;
    }

    public void sum(List<Integer> numbers) {
        for (Integer number : numbers) {
            sum += number;
        }
    }

    public int getSum() {
        return sum;
    }
}
