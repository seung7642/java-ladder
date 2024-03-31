package domain;

import java.util.List;

public class Rewards {

    private final List<Reward> rewards;

    public Rewards(List<Reward> rewards) {
        this.rewards = rewards;
    }

    public Reward findByIndex(int index) {
        return rewards.get(index);
    }

    public void display(LadderVisitor visitor) {
        visitor.visitRewards(rewards);
    }
}
