package domain;

import java.util.Objects;

public class Reward {

    private final String value;

    public Reward(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reward reward = (Reward) o;
        return Objects.equals(value, reward.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
