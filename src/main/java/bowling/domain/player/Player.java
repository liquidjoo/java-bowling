package bowling.domain.player;

import java.util.Objects;

public class Player {

    private String name;

    public Player(String name) {
        this.name = name;
        validate();
    }

    public String getName() {
        return name;
    }

    private void validate() {
        if (name.length() > 3) {
            throw new IllegalArgumentException("길이가 너무 깁니다.");
        }
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
}
