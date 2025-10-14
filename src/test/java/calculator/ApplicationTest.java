package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_다중_사용() {
        assertSimpleTest(() -> {
            run("//b\\n3,4,5b8b9//c\\n10c11");
            assertThat(output()).contains("결과 : 50");
        });
    }

    @Test
    void 커스텀_구분자_다중_연속_사용() {
        assertSimpleTest(() -> {
            run("//'\\n//|\\n3'6|7");
            assertThat(output()).contains("결과 : 16");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
