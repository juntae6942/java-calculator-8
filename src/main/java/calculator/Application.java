package calculator;
import calculator.domain.Calculator;
import calculator.domain.DelimiterParser;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        DelimiterParser delimiterParser = new DelimiterParser();

        List<Integer> numbers = delimiterParser.parse(input);
        Calculator calculator = new Calculator();
        calculator.sum(numbers);
        System.out.println("결과 : " + calculator.getSum());
    }
}
