package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayerTest {

    public static final Player P1 = new Player("pobi");
    public static final Player P2 = new Player("honux");
    public static final Player P3 = new Player("crong");
    public static final Player P4 = new Player("jk");

    @DisplayName("5글자 이하의 이름을 가진 플레이어를 생성한다.")
    @Test
    void test01() {
        Player player = new Player("pobia");
        assertThat(player).isNotNull();
    }

    @DisplayName("사람의 이름이 5글자를 초과할 경우 예외가 발생한다.")
    @Test
    void test02() {
        assertThatThrownBy(() -> new Player("Jackson"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 5글자를 초과할 수 없습니다.");
    }

    @DisplayName("이름이 빈 값일 경우 예외가 발생한다.")
    @Test
    void test03() {
        assertThatThrownBy(() -> new Player("   "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름이 빈 값입니다.");
    }

    @DisplayName("이름을 확인한다.")
    @Test
    void test04() {
        assertThat(PlayerTest.P1.isName("pobi")).isTrue();
    }
}
