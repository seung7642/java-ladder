package domain;

public class GameBoard {

    private final Lines lines;
    private final Rewards rewards;

    public GameBoard(Lines lines, Rewards rewards) {
        this.lines = lines;
        this.rewards = rewards;
    }

    public Reward reward(int column) {
        return rewards.findByIndex(lines.endPoint(column));
    }

    public void display(LadderVisitor visitor) {
        lines.display(visitor);
        rewards.display(visitor);
    }
}
