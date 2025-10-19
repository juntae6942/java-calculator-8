package calculator.domain;

import calculator.common.NumberValidator;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 문자열에서 구분자를 파싱하고 숫자 목록을 추출하는 클래스. 기본 구분자(','와 ':')와 커스텀 구분자를 지원합니다.
 */
public class DelimiterParser {

    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.*?)\\\\n");
    private final Set<String> delimiters;

    public DelimiterParser() {
        delimiters = new HashSet<>(List.of(",", ":"));
    }

    /**
     * 입력 문자열을 파싱하여 숫자 목록을 반환합니다.
     *
     * @param input 파싱할 전체 문자열
     * @return 파싱된 숫자(Integer)의 리스트
     */
    public List<Integer> parse(String input) {
        addCustomDelimiter(input);
        String numbers = removeDelimiterDeclarations(input);
        String regex = String.join("|", delimiters);
        String[] tokens = numbers.split(regex);
        NumberValidator.validateNumbers(tokens);
        return Arrays.stream(tokens)
                .filter(s -> s != null && !s.isEmpty())
                .map(Integer::parseInt)
                .toList();
    }

    private void addCustomDelimiter(String input) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        while (matcher.find()) {
            delimiters.add(Pattern.quote(matcher.group(1)));
        }
    }

    private String removeDelimiterDeclarations(String input) {
        return input.replaceAll(CUSTOM_DELIMITER_PATTERN.pattern(), ",");
    }
}
