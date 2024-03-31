package domain;

public class ConditionalMovement {

    private final Condition condition;
    private final MoveOperation moveOperation;

    public ConditionalMovement(Condition condition, MoveOperation moveOperation) {
        this.condition = condition;
        this.moveOperation = moveOperation;
    }

    public boolean condition(Line line, int curHeight, int column) {
        return condition.check(line, curHeight, column);
    }

    public int move(int column) {
        return moveOperation.move(column);
    }
}
