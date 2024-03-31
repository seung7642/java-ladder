package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RewardsTest {

    @DisplayName("순서에 해당하는 Reward 객체를 출력한다.")
    @Test
    void test01() {
        Reward reward1 = new Reward("꽝");
        Reward reward2 = new Reward("5000");
        Reward reward3 = new Reward("10000");
        Rewards rewards = new Rewards(List.of(reward1, reward2, reward3));
        assertThat(rewards.findByIndex(1)).isEqualTo(reward2);
    }
}
