package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BridgesTest {

    @DisplayName("특정 높이의 bridge 를 생성하거나, 제거한다.")
    @TestFactory
    Collection<DynamicTest> test01() {
        Bridges bridges = new Bridges(5);
        int height = 1;
        return List.of(
                DynamicTest.dynamicTest("특정 높이에 다리를 생성한다.", () -> {
                    bridges.create(height);
                    assertThat(bridges.has(height)).isTrue();
                }),
                DynamicTest.dynamicTest("특정 높이에 다리를 제거한다.", () -> {
                    bridges.remove(height);
                    assertThat(bridges.has(height)).isFalse();
                })
        );
    }

    @DisplayName("여러 Bridge 객체를 기반으로 Bridges 일급 컬렉션을 생성한다.")
    @Test
    void test02() {
        Bridge first = Bridge.first(true);
        Bridge second = first.next(false);
        Bridge third = second.next(true);
        Bridges bridges = new Bridges(List.of(first, second, third));
        assertThat(bridges).isNotNull();
    }

    @DisplayName("특정 column 의 다리의 이동방향을 구한다.")
    @Test
    void test03() {
        Bridge first = Bridge.first(true);
        Bridge second = first.next(false);
        Bridge third = second.next(true);
        Bridges bridges = new Bridges(List.of(first, second, third));
        assertThat(bridges.move(0)).isEqualTo(Direction.RIGHT);
    }

    @DisplayName("전체 다리의 갯수를 구한다.")
    @Test
    void test04() {
        Bridge first = Bridge.first(true);
        Bridge second = first.next(false);
        Bridge third = second.next(true);
        Bridges bridges = new Bridges(List.of(first, second, third));
        assertThat(bridges.total()).isEqualTo(3);
    }

    @DisplayName("마지막 다리의 우측에는 다리를 놓을 수 없다.")
    @Test
    void test05() {
        Bridge first = Bridge.first(true);
        Bridge second = first.next(false);
        Bridge third = second.next(true);
        assertThatThrownBy(() -> new Bridges(List.of(first, second, third)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("마지막 다리의 우측에는 다리를 놓을 수 없습니다.");
    }
}
