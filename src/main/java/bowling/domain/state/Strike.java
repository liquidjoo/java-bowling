package bowling.domain.state;

public class Strike implements State {

    @Override
    public State bowl(int pins) {
        return null;
    }

    @Override
    public boolean isFinish() {
        return true;
    }

    @Override
    public String display() {
        return null;
    }
}
