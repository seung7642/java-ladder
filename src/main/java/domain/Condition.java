package domain;

@FunctionalInterface
public interface Condition {

    boolean check(Line line, int curHeight, int column);
}
