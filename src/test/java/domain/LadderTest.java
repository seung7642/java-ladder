package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    public static final Ladder L1;

    static {
        Bridge first = Bridge.firstOf(true);
        Bridge second = first.next(false);
        Bridge third = second.next(true);
        Bridge fourth = second.next(false);
        Bridges firstHeightBridges = new Bridges(List.of(first, second, third, fourth));

        Bridge first1 = Bridge.firstOf(false);
        Bridge second1 = first1.next(true);
        Bridge third1 = second1.next(false);
        Bridge fourth1 = second.next(false);
        Bridges secondHeightBridges = new Bridges(List.of(first1, second1, third1, fourth1));

        Bridge first2 = Bridge.firstOf(true);
        Bridge second2 = first2.next(false);
        Bridge third2 = second2.next(true);
        Bridge fourth2 = second.next(false);
        Bridges thirdHeightBridges = new Bridges(List.of(first2, second2, third2, fourth2));
        L1 = new Ladder(List.of(firstHeightBridges, secondHeightBridges, thirdHeightBridges));
    }

    @DisplayName("시작 column 을 입력받아 최종 column 을 출력한다.")
    @Test
    void test01() {
        Bridge first = Bridge.firstOf(true);
        Bridge second = first.next(false);
        Bridge third = second.next(true);
        Bridge fourth = second.next(false);
        Bridges firstHeightBridges = new Bridges(List.of(first, second, third, fourth));

        Bridge first1 = Bridge.firstOf(false);
        Bridge second1 = first1.next(true);
        Bridge third1 = second1.next(false);
        Bridge fourth1 = second.next(false);
        Bridges secondHeightBridges = new Bridges(List.of(first1, second1, third1, fourth1));

        Bridge first2 = Bridge.firstOf(true);
        Bridge second2 = first2.next(false);
        Bridge third2 = second2.next(true);
        Bridge fourth2 = second.next(false);
        Bridges thirdHeightBridges = new Bridges(List.of(first2, second2, third2, fourth2));
        Ladder ladder = new Ladder(List.of(firstHeightBridges, secondHeightBridges, thirdHeightBridges));
        assertThat(ladder.getEndColumn(0)).isEqualTo(3);
    }
}
