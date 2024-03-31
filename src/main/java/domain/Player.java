package domain;

import java.util.Objects;

public class Player {

    public static final int MAX_LENGTH = 5;

    private final String name;

    public Player(String name) {
        assertLessThenFiveLength(name);
        this.name = name;
    }

    private void assertLessThenFiveLength(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("이름은 5글자를 초과할 수 없습니다.");
        }
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public boolean isName(String name) {
        return this.name.equals(name);
    }
}
