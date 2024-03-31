package domain;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameBoard {

    private final Lines lines;
    private final Rewards rewards;

    public GameBoard(Lines lines, Rewards rewards) {
        this.lines = lines;
        this.rewards = rewards;
    }

    public Rewards rewardAll() {
        return new Rewards(IntStream.range(0, lines.count())
                .mapToObj(this::reward)
                .collect(Collectors.toList()));
    }

    public Reward reward(int column) {
        return rewards.findByIndex(lines.endPoint(column));
    }

    public void display(LadderVisitor visitor) {
        lines.display(visitor);
        rewards.display(visitor);
    }
}
