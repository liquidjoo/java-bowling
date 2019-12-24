package bowling.retry;

public class Pin {

    private static final int MIN_HIT_COUNT = 0;
    private static final int MAX_HIT_COUNT = 10;

    private int countOfHit;

    public Pin(int countOfHit) {
        this.countOfHit = countOfHit;
        validate();
    }

    private void validate() {
        if (countOfHit < MIN_HIT_COUNT) {
            throw new IllegalArgumentException("적중한 볼링핀의 갯수는 0 미만이 될 수 없습니다.");
        }

        if (countOfHit > MAX_HIT_COUNT) {
            throw new IllegalArgumentException("적중한 볼링핀의 갯수는 10 초과가 될 수 없습니다.");
        }
    }

    public int getCountOfHit() {
        return countOfHit;
    }
}
