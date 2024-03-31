package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LinesTest {

    @DisplayName("갯수와 높이를 기반으로 Lines 객체를 생성한다.")
    @Test
    void test01() {
        Lines lines = Lines.of(4, 5);
        assertThat(lines).isNotNull();
    }

    @DisplayName("시작 지점을 입력받아 끝 지점을 출력한다.")
    @Test
    void test02() {
        Line line1 = Line.createWithBridges(new Height(3), () -> true);
        Line line2 = Line.createWithBridges(new Height(3), () -> false);
        Line line3 = Line.createWithBridges(new Height(3), () -> false);
        Lines lines = Lines.of(List.of(line1, line2, line3));
        int endPoint = lines.endPoint(0);

        assertThat(endPoint).isEqualTo(1);
    }
}
