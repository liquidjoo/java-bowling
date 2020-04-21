package bowling.application;

import bowling.ui.Request;
import bowling.ui.Response;
import bowling.view.InputView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Games {

    private static final int GAME_END = 1;
    private static final int GAME_FINAL_ROUND = 11;

    private List<Game> games;
    private List<Response> responses;
    private int currentFrameNumber = 1;

    public Games(List<Request> requests) {
        createGame(requests);
    }

    private void createGame(List<Request> requests) {
        games = new ArrayList<>();
        for (Request request : requests) {
            games.add(new Game(request));
        }
    }

    public void bowl() {
        if (currentFrameNumber <= 9) {
            normalRound();
            return;
        }
        finalRound();
    }

    private void normalRound() {
        for (Game game : games) {
            if (game.isSameByFrameNumber(currentFrameNumber)) {
                game.bowl();
                return;
            }
        }
        games.get(0).bowl();
        increaseNumber();
    }

    private void finalRound() {
        for (Game game : games) {
            if (!game.isEnd()) {
                game.bowl();
                return;
            }
        }
        end();
    }

    private void end() {
        int size = games.stream()
                .map(Game::isEnd)
                .collect(Collectors.toSet())
                .size();
        if (size == GAME_END) {
            throw new IllegalArgumentException("끝");
        }
    }

    private void increaseNumber() {
        this.currentFrameNumber = currentFrameNumber + 1;
    }

    public boolean isEnd() {
        return currentFrameNumber >= GAME_FINAL_ROUND;
    }

    public List<Response> getResponses() {
        responses = new ArrayList<>();
        for (Game game : games) {
            responses.add(game.getResponse());
        }
        return responses;
    }
}
