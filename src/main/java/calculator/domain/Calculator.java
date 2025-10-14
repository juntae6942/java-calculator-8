package calculator.domain;

import java.util.List;

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
