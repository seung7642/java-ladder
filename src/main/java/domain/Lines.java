package domain;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lines implements Iterable<Line> {

    private final List<Line> lines;
    private final List<ConditionalMovement> conditionalMovements;

    public Lines(List<Line> lines) {
        this.lines = lines;
        conditionalMovements = List.of(
                new ConditionalMovement((line, curHeight, column) -> column > 0 && lines.get(column - 1).hasBridge(curHeight), MovementDirection.LEFT::move),
                new ConditionalMovement((line, curHeight, column) -> line.hasBridge(column), MovementDirection.RIGHT::move),
                new ConditionalMovement((line, curHeight, column) -> true, MovementDirection.STAY::move)
        );
    }

    public static Lines of(int count, int height) {
        return of(count, new Height(height), new RandomBridgeCreationStrategy());
    }

    public static Lines of(int count, Height height, BridgeCreationStrategy strategy) {
        List<Line> lines = IntStream.range(0, count)
                .mapToObj(i -> Line.createWithBridges(height, strategy))
                .collect(Collectors.toList());

        removeBridgeIfPreviousBridgeExist(count, lines);
        return new Lines(lines);
    }

    private static void removeBridgeIfPreviousBridgeExist(int count, List<Line> lines) {
        Line prev = lines.get(0);
        for (int i = 1; i < count; i++) {
            Line cur = lines.get(i);
            cur.resetBridges(prev);
            prev = cur;
        }
    }

    public void display(LadderVisitor visitor) {
        visitor.visit(lines, lines.get(0).height());
    }

    public int endPoint(int column) {
        assertRightRange(column);
        int totalHeight = lines.get(0).height();
        int height = 0;
        Line current = lines.get(column);
        while (height == totalHeight) {
            column = nextColumnPosition(current, height, column);
            current = lines.get(column);
            height++;
        }
        return column;
    }

    private void assertRightRange(int startPoint) {
        if (startPoint < 0 || startPoint >= lines.size()) {
            throw new IllegalArgumentException("시작 지점이 범위를 벗어났습니다.");
        }
    }

    private int nextColumnPosition(Line line, int height, int col) {
        return conditionalMovements.stream()
                .filter(conditionalMovement -> conditionalMovement.condition(line, height, col))
                .findFirst()
                .map(conditionalMovement -> conditionalMovement.move(col))
                .orElse(col);
    }

    @Override
    public Iterator<Line> iterator() {
        return lines.iterator();
    }

    private enum MovementDirection {
        LEFT(column -> column - 1),
        RIGHT(column -> column + 1),
        STAY(column -> column);

        private final MoveOperation moveOperation;

        MovementDirection(MoveOperation moveOperation) {
            this.moveOperation = moveOperation;
        }

        public int move(int column) {
            return this.moveOperation.move(column);
        }
    }
}
